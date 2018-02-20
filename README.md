# ProyectoFinalBI

ANÁLISIS DE TWEETS DE LA CONSULTA POPULAR

Integrantes:

Carolina Calderón

Kevin Cárate

DESCRIPCIÓN

Durante el proyecto se trabajó con las herramientas CouchDB, IDE Netbeans y el IDE Pycharm.
CouchDB se utilizó para almacenar y filtrar los tweets.

Pycharm se utilizó para filtrar los textos de los tweets recolectados y para hacer los gráficos de los resultados.

Netbeans se utilizó para limpiar las urls de los textos filtrados en Pycharm y también para filtrar los textos
correspondientes a la consulta popular realizada el 4 de Febrero de 2018.

USO DE LAS HERRAMIENTAS

1. Ejecutar el script harvester_uio.py para recolectar los tweets, para eso deben colocar sus credenciales de Twitter 
  y cambiar las coordenadas de la ciudad a recolectar los tweets.
  
2. Ejecutar el archivo conn_couch_up.py para extraer los datos de CouchDB. En este punto se deben cambiar las rutas 
  para almacenar los archivos correspondientes.

3. Una vez extraídos los datos es necesario utilizar el proyecto realizado en netbeans, cambiar los archivos existentes
   en la aplicación en caso de ser necesario.

4. Ejecutar el script ProyectoFinalBi.java

ANÁLISIS - FUNCIONAMIENTO

El algoritmo para filtrar los tweets de la consulta, funciona en base a la búsqueda de palabras en el texto, estas
palabras son los hashtags que se utilizaron en la consulta popular.

Para el entrenamiento y test se utilzaron los archivos creados con el mismo programa en Netbeans y utilizando el 
algoritmo de nayve bayes.

RESULTADOS

1.  En la ciudad de Quito el 63.62% de las personas se inclinó por el SI y solamente un 36.38% se inclinó por el NO.
2.  En la cuidad de Guayaquil el 63.08% de la población se inclinó por el SI, por otro lado, el 36.92% de los
    guayaquileños estuvieron a favor del NO.
3.  En la cuidad de Cuenca el 84.51% de la población se inclinó por el SI y solamente un 15.49% se inclinó por el NO.



