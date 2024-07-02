/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabla_Hash;

import EED.Lista;

/**
 *
 * @author cgrc1
 */
public class NodoHash {
    private NodoHash pNextTit;
    private NodoHash pNextAut;
    private NodoHash pNextPalabra;
    private Resumen resumen;
    private NodoHash ListaAutores;
    private NodoHash ListaPalabras;
    private String Autor;
    private String Palabra_Clave;

    public NodoHash(Resumen TxT) {
        this.pNextTit = null;
        this.pNextAut = null;
        this.pNextPalabra = null;
        this.resumen = TxT;
        this.ListaAutores = null;
        this.ListaPalabras = null;
        this.Autor = "";
        this.Palabra_Clave = "";
    }


    public NodoHash getpNextTit() {
        return pNextTit;
    }

    public void setpNextTit(NodoHash pNextTit) {
        this.pNextTit = pNextTit;
    }

    public NodoHash getpNextAut() {
        return pNextAut;
    }

    public void setpNextAut(NodoHash pNextAut) {
        this.pNextAut = pNextAut;
    }

    public NodoHash getpNextPalabra() {
        return pNextPalabra;
    }

    public void setpNextPalabra(NodoHash pNextPalabra) {
        this.pNextPalabra = pNextPalabra;
    }

    public Resumen getResumen() {
        return resumen;
    }

    public void setResumen(Resumen resumen) {
        this.resumen = resumen;
    }

    public NodoHash getListaAutores() {
        return ListaAutores;
    }

    public void setListaAutores(NodoHash ListaAutores) {
        this.ListaAutores = ListaAutores;
    }

    public NodoHash getListaPalabras() {
        return ListaPalabras;
    }

    public void setListaPalabras(NodoHash ListaPalabras) {
        this.ListaPalabras = ListaPalabras;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getPalabra_Clave() {
        return Palabra_Clave;
    }

    public void setPalabra_Clave(String Palabra_Clave) {
        this.Palabra_Clave = Palabra_Clave;
    }
    
     
    
}
