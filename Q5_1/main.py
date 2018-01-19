import pyspark
import string
import numpy as np
from operator import add

sc = pyspark.SparkContext()
sc.stop()
sc = pyspark.SparkContext()
cw = sc.textFile('hdfs://127.0.0.1:9000/Q51/cw')
dr = sc.textFile('hdfs://127.0.0.1:9000/Q51/dr')
punc = string.punctuation


def word_count(line, id):
    line_1 = ''.join(x.lower() for x in line.strip() if x not in punc)
    return '{},{}'.format(id, line_1), 1


cw_wc = cw.flatMap(lambda x: x.split()).map(lambda x: word_count(x, 1)).reduceByKey(lambda a, b: a + b)
dr_wc = dr.flatMap(lambda x: x.split()).map(lambda x: word_count(x, 2)).reduceByKey(lambda a, b: a + b)


def fun2(line):
    a = line[0].split(',')[0]
    b = line[1]
    return a, b


cw_total = cw_wc.map(fun2).reduceByKey(add).collect()[0][1]
dr_total = dr_wc.map(fun2).reduceByKey(add).collect()[0][1]


def same_word(x):
    word = x[0].split(',')[1]
    doc_id = x[0].split(',')[0]
    count = x[1]

    return word, '{},{}'.format(doc_id, count)


def reduce1(x, y):
    a = int(x.split(',')[0]) + int(y.split(',')[0])
    b = [x] + [y]
    if a == 3:
        return '{docperword},{wordcount}'.format(docperword=2, wordcount=b)
    else:
        return '{docperword},{wordcount}'.format(docperword=1, wordcount=[x])


total = cw_wc + dr_wc


def flat2(x):
    if '[' in x[1]:
        conut1 = eval(x[1])[1][0].split(',')[1]

        count2 = eval(x[1])[1][1].split(',')[1]

        a = [((x[0], 1), '{count},{dw},{wd}'.format(count=conut1, dw=2, wd=cw_total)),
             ((x[0], 2), '{count},{dw},{wd}'.format(count=count2, dw=2, wd=dr_total))]

        return a
    else:
        b = x[1].split(',')[0]
        if b == 1:
            return ((x[0], b), '{},1,{}'.format(x[1].split(',')[1], cw_total)), None
        else:
            return ((x[0], b), '{},1,{}'.format(x[1].split(',')[1], dr_total)), None


def tfidf(x):
    if x is not None:
        wordId = x[0]
        xx = x[1].split(',')
        term1 = float(xx[0]) / float(xx[-1])
        term2 = np.log(2 / float(xx[1]))
        return wordId, term1 * term2
    else:
        pass


total.map(same_word).reduceByKey(reduce1).flatMap(flat2).map(tfidf).filter(lambda x: x is not None).saveAsTextFile('out')

sc.stop()
