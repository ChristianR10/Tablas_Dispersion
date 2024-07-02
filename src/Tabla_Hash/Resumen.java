/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabla_Hash;

import javax.swing.JOptionPane;

/**
 *
 * @author cgrc1
 */
public class Resumen {
    private String Texto;
    private String Autores;
    private String Titulo;
    private String Palabras_Claves;

    public Resumen(String TxT) {
        this.armarResumen (TxT);
    }
    
    public void armarResumen (String TxT){
        this.Texto = TxT;
        String [] titulo = TxT.split("Autores");
        this.Titulo = titulo[0];
        String [] autores = titulo[1].split("Resumen");
        this.Autores = autores[0];
        String [] resumen = autores[1].split("Palabras claves: ");
        this.Palabras_Claves = resumen [1];       
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public String getAutores() {
        return Autores;
    }

    public void setAutores(String Autores) {
        this.Autores = Autores;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getPalabras_Claves() {
        return Palabras_Claves;
    }

    public void setPalabras_Claves(String Palabras_Claves) {
        this.Palabras_Claves = Palabras_Claves;
    }
    
    
}
