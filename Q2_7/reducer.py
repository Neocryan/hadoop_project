import sys

last_name = ''


class Tree:
    def __init__(self):
        self.name = ''
        self.year = []
        self.height = []

    def update(self, name, year, height):
        self.name = name
        self.year.append(year)
        self.height.append(height)


def make_name(a):
    c = ''.join(x for x in a if x != ' ')
    return c


for line in sys.stdin:
    data = line.strip()
    name = data.split('\t')[0]
    year = data.split('\t')[1].split(',')[0]
    height = data.split('\t')[1].split(',')[1]
    if name == 'NOM COMMUN' and year == 'ANNEE PLANTATION':
        pass
    else:
        if name == last_name:
            globals()[make_name(name)].update(name, year, height)
        else:
            globals()[make_name(name)] = Tree()
            globals()[make_name(name)].update(name, year, height)
            if last_name != '':
                print('{}\t{}\t{}'.format(globals()[make_name(last_name)].name, globals()[make_name(last_name)].year,
                                          globals()[make_name(last_name)].height))
            last_name = name

if last_name == name:
    print('{}\t{}\t{}'.format(globals()[make_name(name)].name, globals()[make_name(name)].year,
                              globals()[make_name(name)].height))
