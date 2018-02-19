# -*- coding: utf-8 -*-
__author__ = 'elikary'

'''
 QUITO
==============
'''
import couchdb
import sys
import urllib2
import json
import re
from textblob import  TextBlob
import json
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

URL = 'localhost'
db_name = 'dbconsulta'

'''========couchdb'=========='''
server = couchdb.Server('http://'+URL+':5984/')  #('http://245.106.43.184:5984/') poner la url de su base de datos
try:
    print db_name
    db = server[db_name]
    print 'success'
except:
    sys.stderr.write("Error: DB not found. Closing...\n")
    sys.exit()


#url = 'http://localhost:5984/dbfinal/_design/vistaEcFinal/_view/vistaEcFinal?limit=49001'
url = 'http://localhost:5984/dbconsulta/_design/vistaQuito/_view/vistaQuito'
req = urllib2.Request(url)
f = urllib2.urlopen(req)
d = json.loads(f.read())

f=open('C:\\Users\HP\\Downloads\\tweetsQuito.txt','w')
for x in d['rows']:
    a = x['value']['text']
    text = ''
    for letra in a:
        if re.match('([A-Za-z0-9 .#:@])', letra):
            if re.match('([\n])', letra):
                text += ''
            text += letra
    data = text
    f.write(data)
    f.write(',')
    f.write("\n")
f.close


#url2 = 'http://localhost:5984/dbfinal/_design/vistaEcFinal/_view/vistaEcFinal?limit=30000&skip=49002'
url2 = 'http://localhost:5984/dbconsulta/_design/vistaGuayaqui/_view/vistaGuayaquil'
req2 = urllib2.Request(url2)
f2 = urllib2.urlopen(req2)
d2 = json.loads(f2.read())

f2=open('C:\\Users\HP\\Downloads\\tweetsGuayaquil.txt','w')
for x in d2['rows']:
    a = x['value']['text']
    text = ''
    for letra in a:
        if re.match('([A-Za-z0-9 .#:@])', letra):
            text += letra
    data2 = text
    f2.write(data2)
    f2.write(',')
    f2.write("\n")
f2.close



#url3 = 'http://localhost:5984/dbfinal/_design/vistaEcFinal/_view/vistaEcFinal?limit=5580&skip=79003'
url3 = 'http://localhost:5984/dbconsulta/_design/vistaCuenca/_view/vistaCuenca'
req3 = urllib2.Request(url3)
f3 = urllib2.urlopen(req3)
d3 = json.loads(f3.read())
count=0
f3=open('C:\\Users\HP\\Downloads\\tweetsCuenca.txt','w')
for x in d3['rows']:
    a = x['value']['text']
    text = ''
    for letra in a:
        if re.match('([A-Za-z0-9 .#:@])', letra):
            text += letra
    #count=count+1
    #print(count)
    data3 = text
    f3.write(data3)
    f3.write(',')
    f3.write("\n")
f3.close



cpos = 0
cneu = 0

#labels = 'Positivo', 'Neutro', 'Negativo'
#sizes = [cpos,cneu,cneg]
#colors= ['yellow','blue','red']
#explode =(0.1,0,0)

#plt.pie(sizes,explode=explode,labels=labels,colors=colors,autopct='%1.1f%%',shadow=True,startangle=140)
#plt.axis('equal')
#plt.show()



