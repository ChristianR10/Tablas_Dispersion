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
            this.Titulo = titulo[0].split("\r\n")[0];
            String [] autores = titulo[1].split("Resumen");
            this.Autores = autores[0].split("\r\n");
            String [] resumen = autores[1].split("Palabras claves: ");
            this.Cuerpo = resumen [0];
            this.Palabras_Claves = resumen [1].split(", ");
            this.Palabras_Claves[Palabras_Claves.length-1]=Palabras_Claves[Palabras_Claves.length-1].split("\r\n")[0];
        }
    }
    
    public int contarFrecuenciaPalabra (String palabra){
        int frecuencias = 0;
        String aux = this.Cuerpo.toLowerCase();
        String textoPartido [] = aux.split(palabra.toLowerCase());
        frecuencias = textoPartido.length - 1;    
        return frecuencias;
    }

    public String getTexto() {
        String ParsedText;
        ParsedText = this.Titulo + "\n\n";
        for(int i = 1; i < this.Autores.length; i++){
            if(i == this.Autores.length - 1){
                ParsedText = ParsedText + this.Autores[i] + ".";
            } else{
                ParsedText = ParsedText + this.Autores[i] + ", ";
            }
        }
        ParsedText = ParsedText + "\n\n";
        String[] AllWords = this.Cuerpo.split(" ");
        int Counter = 15;
        for(int i = 0; i < AllWords.length; i++){
            if(Counter >= 15){
                ParsedText = ParsedText + "\n" + AllWords[i];
                Counter = 0;
            } else{
                ParsedText = ParsedText + " " + AllWords[i];
                Counter++;
            }
        }
        return ParsedText;
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
