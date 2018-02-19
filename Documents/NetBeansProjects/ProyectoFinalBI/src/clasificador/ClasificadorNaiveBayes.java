/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificador;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.Evaluation;
import java.util.Random;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.converters.ArffLoader.ArffReader;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Prediction;
import weka.classifiers.misc.SerializedClassifier;

/**
 * This class implements a simple text learner in Java using WEKA. It loads a
 * text dataset written in ARFF format, evaluates a classifier on it, and saves
 * the learnt model for further use.
 *
 * @author Jose Maria Gomez Hidalgo - http://www.esp.uem.es/jmgomez
 * @see MyFilteredClassifier
 */
public class ClasificadorNaiveBayes {

    Instances datosEntrenamiento;
    StringToWordVector filtro;
    FilteredClassifier clasificador;

    public void cargarDataset(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArffReader arff = new ArffReader(reader);
            datosEntrenamiento = arff.getData();
            System.out.println("===== Cargando Dataset: " + fileName + " =====");
            reader.close();
        } catch (IOException e) {
            System.out.println("Error en carga de Dataset: " + fileName);
        }
    }

    /**
     * This method evaluates the classifier. As recommended by WEKA
     * documentation, the classifier is defined but not trained yet. Evaluation
     * of previously trained classifiers can lead to unexpected results.
     */
    public void prediccion() {

        FileReader predReader;
        try {
            predReader = new FileReader("src/archivosFinales/Prediccion.arff");
            Instances pred = new Instances(predReader);
            System.out.println("===== Instancia creada en referencia al dataset =====");
            System.out.println(pred);
            pred.setClassIndex(pred.numAttributes() - 1);
            //evaluacion de la prediccion
            Evaluation evalPred = new Evaluation(pred);
            Classifier mlp = this.clasificador; //obtengo el modelo y lo igualo 
            evalPred.evaluateModel(mlp, pred);
            System.out.println("\n \n ===========Prediccion==================");
            ArrayList<Prediction> predicciones = evalPred.predictions();
            for (int i = 0; i < predicciones.size(); i++) {
                Prediction p = predicciones.get(i);
                if (p.predicted() == 0.0) {
                    System.out.println("Se clasifica como: SI");
                } else {
                    System.out.println("Se clasifica como: NO");
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClasificadorNaiveBayes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClasificadorNaiveBayes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClasificadorNaiveBayes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void evualuar() {
        try {
            datosEntrenamiento.setClassIndex(1); //se define la clase {si, no}
            filtro = new StringToWordVector(); //declaracion del filtro a utilizar
            filtro.setAttributeIndices("first");
            clasificador = new FilteredClassifier();
            clasificador.setFilter(filtro);
            clasificador.setClassifier(new NaiveBayes());
            //evualuar el entrenamiento
            Evaluation eval = new Evaluation(datosEntrenamiento);
            //evaluacion realizada por valores default excepto por el numero de capas que se establece como 10
            eval.crossValidateModel(clasificador, datosEntrenamiento, 10, new Random(2));            
            System.out.println(eval.toSummaryString());
            System.out.println(eval.toClassDetailsString());
            System.out.println(eval.toMatrixString());
            System.out.println("===== Evaluacion en base al filtro (training) del dataset terminado =====");
        } catch (Exception e) {
            System.out.println("Problem found when evaluating");
        }
    }

    /**
     * This method trains the classifier on the loaded dataset.
     */
    public void aprender() {
        try {
            datosEntrenamiento.setClassIndex(1); //definir la posicion de la clase
            filtro = new StringToWordVector();
            filtro.setAttributeIndices("first"); //filtro
            clasificador = new FilteredClassifier();
            clasificador.setFilter(filtro);
            clasificador.setClassifier(new NaiveBayes());
            clasificador.buildClassifier(datosEntrenamiento);
            System.out.println("===== Training on filtered (training) dataset done =====");
        } catch (Exception e) {
            System.out.println("Problem found when training");
        }
    }

    /**
     * This method saves the trained model into a file. This is done by simple
     * serialization of the classifier object.
     *
     * @param fileName The name of the file that will store the trained model.
     */
    public void guardarModelo(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(clasificador);
            out.close();
            System.out.println("===== Saved model: " + fileName + " =====");
        } catch (IOException e) {
            System.out.println("Problem found when writing: " + fileName);
        }
    }
}
