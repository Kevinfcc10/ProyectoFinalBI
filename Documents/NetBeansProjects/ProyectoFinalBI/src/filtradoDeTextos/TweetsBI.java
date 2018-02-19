/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtradoDeTextos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class TweetsBI {

    /**
     * @param args the command line arguments
     */
    public void quitarURL() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("src\\ciudades\\tweetsQuito.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("src\\ciudades\\tweetsCuenca.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("src\\ciudades\\tweetsGuayaquil.txt"));
            String s1, s2 = "";
            StringTokenizer st = new StringTokenizer(br.readLine());
            String linea;
            String linea2 = "";
            while ((linea = br.readLine()) != null) {
                String texto[] = linea.split(" ");
                for (String palabra : texto) {
                    if (palabra.contains("https")) {
                        s2 = palabra.replace(palabra, " ");
                        linea2 = linea2 + s2;
                    } else {
                        //System.out.print(" " +palabra );
                        linea2 = linea2 + palabra + " ";
                    }

                }
                linea2 = linea2 + "\n";
                escribir(linea2);

                //System.out.println(); 
            }
        } catch (Exception e) {
            System.out.println("Excepcion leyendo fichero " + e);
        }
    }

    public void escribir(String a) throws IOException {
        //String ruta = "src/filtradoDeTextos/quitoViewLimpio.txt";
        //String ruta = "src/filtradoDeTextos/cuencaViewLimpio.txt";
        String ruta = "src/filtradoDeTextos/guayaquilViewLimpio.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(a);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(a);
        }
        bw.close();
    }

    public void escribir2(String a) throws IOException {
        //String ruta = "src/archivosFiltrados/quito.txt";
        String ruta = "src/archivosFiltrados/cuenca.txt";
        //String ruta = "src/archivosFiltrados/gye.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(a);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(a);
        }
        bw.close();
    }

    public boolean detectarNo(String linea) {

        if ((linea) != null) {
            if (linea.contains("#EcuadorDiceNO")        || linea.contains("#DilesNO")               || linea.contains("#TodoNO") 
                || linea.contains("#Todono")            || linea.contains("Nooo")                   || linea.contains("7 veces n")
                || linea.contains("#YoVotoNO")          || linea.contains("#7VecesNO")              || linea.contains("#PorLaPatriaDilesNO")
                || linea.contains("#YoVotNO")           || linea.contains("vota no")                || linea.contains("MoreNO")
                || linea.contains("#PichinchaDiceN")    || linea.contains("#PichinchaConElNo")      || linea.contains("NON")
                || linea.contains("#DilesN")            || linea.contains("#SieteVecesN")           || linea.contains("NoN") 
                || linea.contains("#ConsultaMentirosa") || linea.contains("Todito N")               || linea.contains("Todo N")
                || linea.contains("#NoALaConsultaMa")   || linea.contains("#ElPuebloContigoRafael") || linea.contains("#GuayasDiceN")
                || linea.contains("traidor"))
            {
                return true;
            }
        }

        return false;
    }

    public void buscar() {
        try {

            int valor = 0;
            //BufferedReader br = new BufferedReader(new FileReader("src/textosLimpios/quitoViewLimpio.txt"));
            BufferedReader br = new BufferedReader(new FileReader("src/textosLimpios/cuencaViewLimpio.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("src/textosLimpios/guayaquilViewLimpio.txt"));
            
            String linea = "";
            int puntaje = 0, p = 0;
            Boolean estado = false;
            String linea2 = "";
            while ((linea = br.readLine()) != null) {

                //Cadenas que contienen hashtag en favor del No
                if (linea.contains("#EcuadorDiceNO")        || linea.contains("#DilesNO")               || linea.contains("#TodoNO") 
                    || linea.contains("#Todono")            || linea.contains("Nooo")                   || linea.contains("7 veces n")
                    || linea.contains("#YoVotoNO")          || linea.contains("#7VecesNO")              || linea.contains("#PorLaPatriaDilesNO")
                    || linea.contains("#YoVotNO")           || linea.contains("vota no")                || linea.contains("MoreNO")
                    || linea.contains("#PichinchaDiceN")    || linea.contains("#PichinchaConElNo")      || linea.contains("NON")
                    || linea.contains("#DilesN")            || linea.contains("#SieteVecesN")           || linea.contains("NoN") 
                    || linea.contains("#ConsultaMentirosa") || linea.contains("Todito N")               || linea.contains("Todo N")
                    || linea.contains("#NoALaConsultaMa")   || linea.contains("#ElPuebloContigoRafael") || linea.contains("#GuayasDiceN")
                    || linea.contains("traidor")   ) 
                {
                    //valor = (int) (Math.random() * (15 - 10) + 10);
                    linea2 = linea2 + "'" + linea + "', NO";
                    estado = true;
                } else {
                    //Hashtags referente a la consulta de pero no estan a favor del si ni del no
                    if (linea.contains("#ConsultaPopular2018")      || linea.contains("#ReferendumConsultaPopular2018febrero04")
                            || linea.contains("@Lenin")             || linea.contains("#VotacionesEcuador") 
                            || linea.contains("##consulta2018")     || linea.contains("#votonacional")
                            || linea.contains("#votaciones")        || linea.contains("@MashiRafael") 
                            || linea.contains("#GuayasDiceN")       || linea.contains("#PichinchaDiceN") 
                            || linea.contains("#PichinchaConElNo")  || linea.contains("#votaconresponsabilidad") 
                            || linea.contains("#votaconconciencia") || linea.contains("#EcuadorSaleAVotar")) {

                        if (detectarNo(linea) == true) {
                            //valor = (int) (Math.random() * (15 - 10) + 10);
                            linea2 = linea2 + "'" + linea +"', NO";
                            estado = true;
                        } else {
                            if (detectarSi(linea) == true) {
                                //valor = (int) (Math.random() * (21 - 17) + 17);
                                linea2 = linea2 + "'" + linea +"', SI" ;
                                estado = true;
                            } 
                            else{
                                estado = false;
                            }
                            /*else {
                                //valor = (int) (Math.random() * (9 - 4) + 4);
                                linea2 = linea2 + "'" + linea + "', 0" +", NEUTRO" ;
                                estado = false;
                            }*/
                        }
                    } else {
                        if ((linea.contains("#7VecesS")             || linea.contains("7VecesS") 
                                || linea.contains("#VotaS")         || linea.contains("#votaciones2018S")
                                || linea.contains("#Votar")         || linea.contains("#votoreflexivo") 
                                || linea.contains("#EcuadorDiceSi") || linea.contains("#TerceraVaECUADOR")
                                || linea.contains("#SíRotundo")     || linea.contains("#EcuadorVotaS")
                                || linea.contains("#Vota7vecesS.")  || linea.contains("#TerceraVa") 
                                || linea.contains("#VotoEnCasa")    || linea.contains("#votaciones2018SI")
                                || linea.contains("#VotaTodoS")     || linea.contains("#votaciones2018s")
                                || linea.contains("##consulta2018") || linea.contains("#VotaTodoSi") 
                                || linea.contains("#VotaNulo")      || linea.contains("#ATuFuturoDileSi")
                                || linea.contains("#EcuadorDiceS")  || linea.contains("#GuayasDiceS")
                                || linea.contains("#TodoSi")        || linea.contains("#TodoSI") 
                                || linea.contains("#TodoS")         || linea.contains("#Si")
                                || linea.contains("#NOALaViolencia")|| linea.contains("#JuntosPorElS") 
                                || linea.contains("#ObvioQueS")     || linea.contains("vota si")
                                || linea.contains("7 veces s")      || linea.contains("#NoBotesTuVoto") 
                                || linea.contains("#PichinchaDiceS")|| linea.contains("Todito S"))
                                && (!linea.contains("#SiSePuede")) && (!linea.contains("#Sismo")) && (!linea.contains("#Sin"))) {

                            //valor = (int) (Math.random() * (21 - 17) + 17);
                            linea2 = linea2 + "'" + linea + "', SI" ;
                            estado = true;

                        } else {
                            estado = false;
                        }
                    }
                }

                if (estado) {
                    linea2 = linea2 + "\n";
                    escribir2(linea2);
                    System.out.println(linea);
                } else {
                    //System.out.println(linea+" "+ 10);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TweetsBI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TweetsBI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean detectarSi(String linea) {
        if ((linea) != null) {
            if ((linea.contains("#7VecesS")             || linea.contains("#7VecesSi") 
                    || linea.contains("#VotaS")         || linea.contains("#votaciones2018S")
                    || linea.contains("#Votar")         || linea.contains("#votoreflexivo") 
                    || linea.contains("#EcuadorDiceSi") || linea.contains("#TerceraVaECUADOR")
                    || linea.contains("#SíRotundo")     || linea.contains("#EcuadorVotaSí")
                    || linea.contains("#Vota7vecesS.")  || linea.contains("#TerceraVa") 
                    || linea.contains("#VotoEnCasa")    || linea.contains("#votaciones2018SI")
                    || linea.contains("#VotaTodoS")     || linea.contains("#votaciones2018s")
                    || linea.contains("##consulta2018") || linea.contains("#VotaTodoSi") 
                    || linea.contains("#VotaNulo")      || linea.contains("#ATuFuturoDileSi")
                    || linea.contains("#EcuadorDiceS")  || linea.contains("#GuayasDiceS")
                    || linea.contains("#TodoSi")        || linea.contains("#TodoSI") 
                    || linea.contains("#TodoS")         || linea.contains("#Si")
                    || linea.contains("#NOALaViolencia")|| linea.contains("#JuntosPorElS") 
                    || linea.contains("#ObvioQueS")     || linea.contains("vota si")
                    || linea.contains("7 veces s")      || linea.contains("#NoBotesTuVoto") 
                    || linea.contains("#PichinchaDiceS")|| linea.contains("Todito S"))
                    && (!linea.contains("#SiSePuede")) && (!linea.contains("#Sismo")) && (!linea.contains("#Sin"))) {
                return true;
            }
        }

        return false;
    }
}
