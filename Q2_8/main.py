import pyspark
sc = pyspark.SparkContext()
lines = sc.textFile('hdfs://127.0.0.1:9000/Q28/isd.txt')


def mapper(line):
    try:
        assert type(int(line[0])) is int
        usaf = line[0:6].strip()
        name = line[13:13 + 29].strip()
        fips = line[43:43 + 2].strip()
        elev = line[74:74 + 7].strip()
        print('{},{},{},{}'.format(usaf, name, fips, elev))
        return [usaf, name, fips, elev]

    except:
        pass

lines.map(mapper).saveAsTextFile('out')