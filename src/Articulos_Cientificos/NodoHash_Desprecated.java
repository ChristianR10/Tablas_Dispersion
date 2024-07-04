/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos_Cientificos;

/**
 *
 * @author cgrc1
 */
public class NodoHash_Desprecated {
    private NodoHash_Desprecated pNextTit;
    private NodoHash_Desprecated pNextAut;
    private NodoHash_Desprecated pNextPalabra;
    private Resumen resumen;
    private NodoHash_Desprecated ListaAutores;
    private NodoHash_Desprecated ListaPalabras;
    private String Autor;
    private String Palabra_Clave;

    public NodoHash_Desprecated(Resumen TxT) {
        this.pNextTit = null;
        this.pNextAut = null;
        this.pNextPalabra = null;
        this.resumen = TxT;
        this.ListaAutores = null;
        this.ListaPalabras = null;
        this.Autor = "";
        this.Palabra_Clave = "";
    }


    public NodoHash_Desprecated getpNextTit() {
        return pNextTit;
    }

    public void setpNextTit(NodoHash_Desprecated pNextTit) {
        this.pNextTit = pNextTit;
    }

    public NodoHash_Desprecated getpNextAut() {
        return pNextAut;
    }

    public void setpNextAut(NodoHash_Desprecated pNextAut) {
        this.pNextAut = pNextAut;
    }

    public NodoHash_Desprecated getpNextPalabra() {
        return pNextPalabra;
    }

    public void setpNextPalabra(NodoHash_Desprecated pNextPalabra) {
        this.pNextPalabra = pNextPalabra;
    }

    public Resumen getResumen() {
        return resumen;
    }

    public void setResumen(Resumen resumen) {
        this.resumen = resumen;
    }

    public NodoHash_Desprecated getListaAutores() {
        return ListaAutores;
    }

    public void setListaAutores(NodoHash_Desprecated ListaAutores) {
        this.ListaAutores = ListaAutores;
    }

    public NodoHash_Desprecated getListaPalabras() {
        return ListaPalabras;
    }

    public void setListaPalabras(NodoHash_Desprecated ListaPalabras) {
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
