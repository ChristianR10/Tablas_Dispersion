/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_Auxiliares;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.*;


/**
 *
 * @author cgrc1
 */
public class BaseDatos {

    public BaseDatos() {
    }
    
    
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
