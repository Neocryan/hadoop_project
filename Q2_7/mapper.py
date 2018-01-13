import sys

for line in sys.stdin:
    data = line.strip().split(';')
    print('{}\t{},{}'.format(data[9],data[5],data[6]))