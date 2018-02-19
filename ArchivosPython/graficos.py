import couchdb
import sys
import urllib2
import json
import re

from numpy.core import shape_base
from textblob import  TextBlob
import json
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

cpos = 0
cneg = 0

#arc = open('C:\\Users\\HP\\Desktop\\archivosFinales2\\consultaQuito.txt', 'r')

ocurrencias = []
with open('C:\\Users\\HP\\Desktop\\archivosFinales2\\gye.txt') as lineas:
    for linea in lineas:
        if ', NO' in linea:
            #ocurrencias.append(linea)
            cneg = cneg + 1
        if ', SI' in linea:
            cpos = cpos + 1
print ocurrencias

print(cneg)
print(cpos)

plt.figure()
labels = ['SI', 'NO']
sizes = [cpos,cneg]
colors= ['red','blue']
explode =(0.1,0)


plt.pie(sizes, explode=explode,labels=labels, autopct='%.2f', shadow=True ,startangle=140, colors=colors)
plt.show()
#plt.pie(sizes,explode=explode,labels=labels,colors=colors, autopct='%.2f',shadow=True,startangle=140)
#plt.axis('equal')
#plt.show()

'''
for x in d['rows']:
    a = x['value']['text']
    text = ''
    for letra in a:
        if re.match('([A-Za-z0-9.#\s])', letra):
            text += letra
    
    blob=TextBlob(text)
    a=blob.sentiment.polarity
    sentiment=''

    if a > 0.0:
        test = 'pos'
        cpos = 1 + cpos
    elif a == 0.0:
        test = 'neutro'
        cneu = 1 + cneu
    elif a < 0.0:
        test = 'neg'
        cneg = 1 + cneg
    
    f.write("\n\t")
    data = {}
    #data['label'] = test
    cadena = 'text'+''+str(valor)
    data[cadena] = text
    valor = valor + 1
    json_data = json.dumps(data)
    f.write(json_data)
    f.write(',')
f.write("\n")
f.write(']')
f.close

labels = 'Positivo', 'Neutro', 'Negativo'
sizes = [cpos,cneu,cneg]
colors= ['yellow','blue','red']
explode =(0.1,0,0)

plt.pie(sizes,explode=explode,labels=labels,colors=colors,autopct='%1.1f%%',shadow=True,startangle=140)
plt.axis('equal')
plt.show()
    
'''