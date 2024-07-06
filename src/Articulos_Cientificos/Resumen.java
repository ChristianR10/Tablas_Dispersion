/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos_Cientificos;

import javax.swing.JOptionPane;

/**
 *
 * @author cgrc1
 */
public final class Resumen {
    private String Texto;
    private String Autores [];
    private String Titulo;
    private String Cuerpo;
    private String Palabras_Claves [];

    public Resumen(String TxT) {
        this.armarResumen (TxT);
    }
    
    public void armarResumen (String TxT){
        if (!TxT.equals("")){
            this.Texto = TxT;
            String [] titulo = TxT.split("Autores");
            this.Titulo = titulo[0];
            String [] autores = titulo[1].split("Resumen");
            this.Autores = autores[0].split("\n");
            String [] resumen = autores[1].split("Palabras claves: ");
            this.Cuerpo = resumen [0];
            this.Palabras_Claves = resumen [1].split(", ");       
        }
    }
    
    public int contarFrecuenciaPalabra (String palabra){
        int frecuencias = 0;
        String textoPartido [] = this.Cuerpo.split(palabra);
        frecuencias = textoPartido.length - 1;    
        return frecuencias;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public String[] getAutores() {
        return Autores;
    }

    public void setAutores(String[] Autores) {
        this.Autores = Autores;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String[] getPalabras_Claves() {
        return Palabras_Claves;
    }

    public void setPalabras_Claves(String[] Palabras_Claves) {
        this.Palabras_Claves = Palabras_Claves;
    }

    
    
    
}
