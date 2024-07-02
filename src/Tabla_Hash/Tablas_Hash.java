/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabla_Hash;

/**
 *
 * @author cgrc1
 */
public class Tablas_Hash {
    private NodoHash tablaTitulo [];
    private NodoHash tablaAutores [];
    private NodoHash tablaPalabrasClaves [];

    public Tablas_Hash(int sizeTit, int sizeAut, int sizePal) {
        this.tablaTitulo = new NodoHash [sizeTit];
        this.tablaTitulo = new NodoHash [sizeTit];
        this.tablaTitulo = new NodoHash [sizeTit];
    }
    
    //funcion de generar claves
    public int generarClave (String texto){
        int Clave = 0;
        return Clave;
    }
    
    public void AgregarResumen (String TxT){
        Resumen resumen = new Resumen (TxT);
        int clave;
        clave = generarClave (resumen.getTitulo());
        if (EsNuevoResumen (clave, resumen)){
            NodoHash nuevoNodo = new NodoHash (resumen);
            InsertarTablas (nuevoNodo);
        }
    }
    
    public void InsertarTablas (NodoHash nuevoNodo){
        int clave;
        //insertar en tabla Titulo
        clave = generarClave (nuevoNodo.getResumen().getTitulo());
        if (this.tablaTitulo[clave] == null){
            this.tablaTitulo[clave] = nuevoNodo;
        }
        else {
            NodoHash aux = tablaTitulo[clave]; 
            while (aux.getpNextAut() != null) {
                aux = aux.getpNextTit();
            }
            aux.setpNextTit (nuevoNodo);  
        }
        //insertar en tabla Autor
        String autores [] = nuevoNodo.getResumen().getAutores().split("\n"); 
        for (int i = 0; i<autores.length; i++){
            if (!"".equals(autores[i])){
                clave = generarClave (autores[i]);
                if (this.tablaAutores[clave] == null){
                    this.tablaAutores[clave] = nuevoNodo;
                }
                else {
                    NodoHash aux = tablaAutores[clave]; 
                    while (true) {
                        if (aux.getAutor().equals(autores[i])){
                            NodoHash autorRepetido = aux.getListaAutores();
                            while (autorRepetido.getListaAutores() != null){
                                autorRepetido = autorRepetido.getListaAutores();
                            }
                            autorRepetido.setListaAutores(nuevoNodo);
                            break;
                        }
                        else if (aux.getpNextAut()==null){
                            aux.setpNextAut (nuevoNodo);
                            break;
                        }
                        aux = aux.getpNextAut();
                    }       
                } 
            }
        }
        //insertar en tabla Palabra
        String palabras [] = nuevoNodo.getResumen().getPalabras_Claves().split(", "); 
        for (int i = 0; i<palabras.length; i++){
            if (!"".equals(palabras[i])){
                clave = generarClave (palabras[i]);
                if (this.tablaPalabrasClaves[clave] == null){
                    this.tablaPalabrasClaves[clave] = nuevoNodo;
                }
                else {
                    NodoHash aux = tablaPalabrasClaves[clave]; 
                    while (true) {
                        if (aux.getPalabra_Clave().equals(palabras[i])){
                            NodoHash palabraRepetida = aux.getListaPalabras();
                            while (palabraRepetida.getListaPalabras() != null){
                                palabraRepetida = palabraRepetida.getListaPalabras();
                            }
                            palabraRepetida.setListaPalabras(nuevoNodo);
                            break;
                        }
                        else if (aux.getpNextPalabra()==null){
                            aux.setpNextAut (nuevoNodo);
                            break;
                        }
                        aux = aux.getpNextPalabra();
                    }       
                } 
            }
        }
    }
    
    public boolean EsNuevoResumen (int clave, Resumen resumen){
        return true;
    }
}
