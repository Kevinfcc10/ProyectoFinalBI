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

#colocamos la ruta donde tenemos la informacion ya filtrada.
with open('C:\\Users\\HP\\Desktop\\archivosFinales2\\gye.txt') as lineas:
    for linea in lineas:
	#recorremos el archivo linea por linea y cuando encuentre las palabras clave aumentara a su respectivo contador
        if ', NO' in linea:
            cneg = cneg + 1
        if ', SI' in linea:
            cpos = cpos + 1

print(cneg)
print(cpos)

#utilizamos la libreria matplotlib para generar los graficos 
plt.figure()
#Agregamos nuestras clases como labels
labels = ['SI', 'NO']
#Agregamos nuestros contadores para realizar la grafica con exactitud
sizes = [cpos,cneg]
#damos los colores para cada resultado
colors= ['yellow','red']
explode =(0.1,0)

#mandamos a hacer una grafica de tipo pie con los parametros  de labels, sizes, colores
plt.pie(sizes, explode=explode,labels=labels, autopct='%.2f', shadow=True ,startangle=140, colors=colors)
#Colocamos un titulo a la grafica
plt.title('Ciudad: Guayaquil')
plt.show()


