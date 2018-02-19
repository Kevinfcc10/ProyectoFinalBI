/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalbi;

import clasificador.ClasificadorNaiveBayes;
import filtradoDeTextos.TweetsBI;

/**
 *
 * @author Kevin
 */
public class ProyectoFinalBI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TweetsBI tbi = new TweetsBI();
        //tbi.quitarURL();
        //tbi.buscar();
        
        ClasificadorNaiveBayes learner;
        learner = new ClasificadorNaiveBayes();
        learner.cargarDataset("src/archivosFinales/QuitoFinal.arff");
        learner.evualuar();
        learner.aprender();
        learner.guardarModelo("src/archivosFinales/ModeloQuito.dat");
        learner.prediccion();
        
    }
    
}
