package Clases_Auxiliares;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Clase Base Datos
 * Incluye lo referente a la lectura y escritura de la base de datos del proyecto en un archivo txt 
 * @author Christian Ramos
 * @version 1.0
 */
public class BaseDatos {

    /**
     * Constructor de la clase. No recibe parametros de entrada
     */
    public BaseDatos() {
    }
    
    /**
     * Funcion que lee el archivo txt para generar la Base de Datos 
     * @return string que indica todo lo leido en el archivo txt
     */
    public String leerBaseDatos (){
        String cadena = "";
        try{
            FileReader fr = new FileReader("BaseDatos.txt");
            int valor = fr.read();
            while (valor != -1){
                cadena += (char) valor;
                valor = fr.read();
            }
        }
        catch (IOException E){}
        return cadena;
    }
    
    /**
     * Funcion que sobreescribe el txt en base a la base de datos
     * @param cadena string que indica la informacion que se va a guardar en el archivo de texto
     */
    public void guardarBaseDatos (String cadena){
        try {
            FileWriter fw = new FileWriter ("BaseDatos.txt",false);
            try (BufferedWriter bw = new BufferedWriter (fw)) {
                bw.write(cadena);
            }
        }
        catch (IOException E){}
    }
}
