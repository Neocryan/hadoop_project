
---
title:  Big Data Algorithm Project

author: 

Xiaoyu Tian (B00717090)
	
Tailai Zhang
	
Dongxue Shao

date: 06/02/2018
_________
![Big Data Algorithm Project](https://lh3.googleusercontent.com/12taJ9hE8ROoMCX_CRkfqvuBa_uGgYiGhVoS_SmwV-FKb1WNo36JdANRQePZOTTAP07YMl0HwCiBJw)

# Big Data Algorithm Project

## Displaying csv using hadoop streaming and java

### Executed files

|method|path|
|:---:|---|
|Hadoop streaming| ./run.sh	|
|Java 			|./tree.java|

__________________

### Output(Using Hadoop Streaming)

	`./output`
---

	Ailanthe	['']	['35.0']
	
	Arbre aux pochettes	['1906']	['12.0']
	
	Arbre aux quarante écus	['1879', '1895', '1865', '1913', '1893']	['22.0', '25.0', '25.0', '33.0', '18.0']
	
	Arbre à gutta-percha	['']	['12.0']
	
	Aulne glutineux	['1933']	['16.0']
	
	Catalpa commun	['']	['15.0']
	
	Chicot du Canada	['']	['10.0']
	
	Chêne liège	['1895']	['10.0']
	
	Chêne rouve	['1815']	['31.0']
	
	Chêne rouvre	['1784']	['30.0']
	
	Chêne vert	['1860']	['15.0']
	
	Cyprés chauve	['1862', '1859', '1930']	['35.0', '30.0', '20.0']
	
	Cèdre bleu de l'Atlas	['1939']	['25.0']
	
	Cèdre bleu de l'Atlas ple	['']	['6.0']
	
	Cèdre du Liban	['1829', '1862']	['30.0', '30.0']
	
	Cèdre à encens	['1854']	['20.0']

	..............

## Displaying the content of a compact file

### Executed files

	spark: ./main.py
	hadoop: ./java/src/cs/bigdata/Q28/DisplayContent.java
	
________

### Output(Using Spark)


	['007026', 'WXPOD 7026', 'AF', '+7026.0']

	['007070', 'WXPOD 7070', 'AF', '+7070.0']

	['008403', 'XM10', '', '']

	['008411', 'XM20', '', '']

	['008414', 'XM18', '', '']

	['008415', 'XM21', '', '']

	['008416', 'XM22', '', '']

	['008418', 'XM24', '', '']

	['008421', 'XM26', '', '']

	['010000', 'BOGUS NORWAY', 'NO', '']

	['010010', 'JAN MAYEN(NOR-NAVY)', 'NO', '+0009.0']

	['010013', 'ROST', 'NO', '']

	['010014', 'SORSTOKKEN', 'NO', '+0048.8']

	['010015', 'BRINGELAND', 'NO', '+0327.0']

	['010016', 'RORVIK/RYUM', 'NO', '+0014.0']

	['010017', 'FRIGG', 'NO', '+0048.0']

	..............
----------

## tf-idf using spark

### Executed file
    main.py
    with the text file on hdfs: /Q51
_____________________________________________
### Output
  __top 20__:
___________________________________________________


|word|doc|TF-IDF|
| ----|----|-----|
|buck| call wild| 0.0017849479420739538|
|myself| defoe robinson| 0.0016651910513916757|
|friday| defoe robinson| 0.0010207849253394178|
|dogs| call wild| 0.00063870341697214964|
|thoughts| defoe robinson| 0.0006330007078920412|
|thornton| call wild| 0.00046191943548878678|
|board| defoe robinson| 0.000404892344687702|
|viz| defoe robinson| 0.00038208150836726808|
|towards| defoe robinson| 0.00038208150836726808|
|corn| defoe robinson| 0.00034786525388661723|
|spitz| call wild| 0.00034216254480650868|
|cave| defoe robinson| 0.00034216254480650868|
|sled| call wild| 0.00034216254480650868|
|voyage| defoe robinson| 0.0003364598357264003|
|afterwards| defoe robinson| 0.0003364598357264003|
|providence| defoe robinson| 0.00030794629032585783|
|labor| defoe robinson| 0.0002965408721656409|
|powder| defoe robinson| 0.0002965408721656409|
|francois| call wild| 0.0002965408721656409|
|believe| defoe robinson| 0.00026802732676509849|

## Pagerank using spark

### Executing file
    main.py
    with the text file on hdfs: /Q52
_______________________
### Output

    File in output_30 or output_100, from part_00000 to part_00003

#### Updating 30 times (Already converged)
|node|pangrank|
|---:|---:|
|'18'| 312.9355520338185|
|'4415'| 144.14703769619314|
|'737'| 133.42269871965237|
|'790'| 116.03602201059905|
|'1753'| 114.63997163346554|
|'143'| 114.12885559942856|
|'1719'| 113.59237762549031|
|'136'| 99.75254092814383|
|'751'| 99.36994537940292|
|'118'| 86.051814303979|
|'1621'| 85.23020229133245|
|'791'| 79.58908716162343|
|'4969'| 74.54358697060559|
|'1619'| 70.07476505699493|
|'1029'| 68.6895531520662|
|'18955'| 67.96825796164752|
|'1179'| 67.90624454801302|
|'390'| 66.21619964302661|
|'849'| 64.28787024136169|
|'64'| 64.15540000954913|

_________

## The trees of Paris Using Hadoop
______________

### Executed file
	
	/src/driver/Tree_Driver.java
_______
### Output

	/output
	
#### Compute the number of trees by type

|tree|count|
|:---:|---:|
|Acer|3|
|Aesculus|3|
|Ailanthus|1|
|Alnus|1|
|Araucaria|1|
|Broussonetia|1|
|Calocedrus|1|
|Catalpa|1|
|Cedrus|4|
|Celtis|1|
|Corylus|3|
|Davidia|1|
|Diospyros|4|
|Eucommia|1|
|Fagus|8|
|Fraxinus|1|
|Ginkgo|5|
|Gymnocladus|1|
|Juglans|1|
|Liriodendron|2|
|Maclura|1|
|Magnolia|1|
|Paulownia|1|
|Pinus|5|
|Platanus|19|
|Pterocarya|3|
|Quercus|4|
|Robinia|1|
|Sequoia|1|
|Sequoiadendron|5|
|Styphnolobium|1|
|Taxodium|3|
|Taxus|2|
|Tilia|1|
|Ulmus|1|
|Zelkova|4|

______________


#### Compute the height of the highest tree of each type

|tree|height|
|:---:|---:|
|Acer|16.0|
|Aesculus|30.0|
|Ailanthus|35.0|
|Alnus|16.0|
|Araucaria|9.0|
|Broussonetia|12.0|
|Calocedrus|20.0|
|Catalpa|15.0|
|Cedrus|30.0|
|Celtis|16.0|
|Corylus|20.0|
|Davidia|12.0|
|Diospyros|14.0|
|Eucommia|12.0|
|Fagus|30.0|
|Fraxinus|30.0|
|Ginkgo|33.0|
|Gymnocladus|10.0|
|Juglans|28.0|
|Liriodendron|35.0|
|Maclura|13.0|
|Magnolia|12.0|
|Paulownia|20.0|
|Pinus|30.0|
|Platanus|45.0|
|Pterocarya|30.0|
|Quercus|31.0|
|Robinia|11.0|
|Sequoia|30.0|
|Sequoiadendron|35.0|
|Styphnolobium|10.0|
|Taxodium|35.0|
|Taxus|13.0|
|Tilia|20.0|
|Ulmus|15.0|
|Zelkova|30.0|


________________

#### District per tree grouped by year

	the oldest tree is in district 5

|year|district|
|---|---|
|1601|5|
|1772|16|
|1782|16|
|1784|12|
|1814|8,7|
|1815|12|
|1829|12|
|1833|20|
|1840|17,14|
|1843|16|
|1845|12|
|1847|16|
|1850|8,16,16|
|1852|16,16|
|1854|8|
|1857|16,18|
|1859|16,16|
|1860|12,12,12,12|
|1862|9,16,19,12,16|
|1863|16|
|1865|12,12|
|1868|16|
|1870|12,12,12|
|1871|12|
|1872|12,16,16|
|1873|19|
|1875|12|
|1879|11,8|
|1880|20|
|1882|16,3,16|
|1893|16|
|1894|13|
|1895|16,12,16|
|1896|16|
|1897|16|
|1900|12,8|
|1905|5,16|
|1906|16,12|
|1907|16|
|1913|19|
|1918|12|
|1930|12,12|
|1933|15|
|1935|4,12,14,7|
|1939|13|
|1945|19|
