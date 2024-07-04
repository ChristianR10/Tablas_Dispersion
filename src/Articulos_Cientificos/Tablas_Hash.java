/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos_Cientificos;

import EDD.Hashing;
import javax.swing.JOptionPane;

/**
 *
 * @author cgrc1
 */
public class Tablas_Hash {
    private Hashing tablaTitulo;
    private Hashing tablaAutores;
    private Hashing tablaPalabrasClaves;
    private String allText;
    private String [] listaTitulos;
    private int numTit;
    private String [] listaAutores;
    private int numAut;
    private String [] listaPalabras_Claves;
    private int numPal;

    public Tablas_Hash(int sizeTit, int sizeAut, int sizePal, String allText) {
        this.tablaTitulo = new Hashing (sizeTit);
        this.tablaAutores = new Hashing (sizeAut);
        this.tablaPalabrasClaves = new Hashing (sizePal);
        this.allText = allText;
        this.numAut = this.numPal = this.numTit = 0;
    }
    
    public void LeerBaseDato (){
        String listaGuardados [] = this.allText.split("NuevoResumenGuardado");
        for (String listaGuardado : listaGuardados) {
            AgregarResumen(listaGuardado);
        }
    }
    
    public void AgregarResumen (String TxT){
        Resumen resumen = new Resumen (TxT);
        if (!tablaTitulo.newNode(resumen.getTitulo())){
            tablaTitulo.add(resumen.getTitulo(), resumen);
            listaTitulos[numTit] = resumen.getTitulo();
            numTit ++;
            for (String autore : resumen.getAutores()) {
                if (!autore.equals("")) {
                    tablaAutores.add(autore, resumen);
                    if (!tablaAutores.claveRepetida(autore)){
                        listaAutores[numAut] = autore;
                        numAut ++;
                    }
                }
            }
            for (String palabras_Clave : resumen.getPalabras_Claves()) {
                if (!palabras_Clave.equals("")) {
                    tablaPalabrasClaves.add(palabras_Clave, resumen);
                    if (!tablaPalabrasClaves.claveRepetida(palabras_Clave)){
                        listaPalabras_Claves[numPal] = palabras_Clave;
                        numPal ++;
                    }
                }
            }
            this.allText += "NuevoResumenGuardado" + TxT; 
        }
        else {
            JOptionPane.showMessageDialog (null, "El resumen insertado ya existe");
        }
    }
    
    

    public Hashing getTablaTitulo() {
        return tablaTitulo;
    }

    public void setTablaTitulo(Hashing tablaTitulo) {
        this.tablaTitulo = tablaTitulo;
    }

    public Hashing getTablaAutores() {
        return tablaAutores;
    }

    public void setTablaAutores(Hashing tablaAutores) {
        this.tablaAutores = tablaAutores;
    }

    public Hashing getTablaPalabrasClaves() {
        return tablaPalabrasClaves;
    }

    public void setTablaPalabrasClaves(Hashing tablaPalabrasClaves) {
        this.tablaPalabrasClaves = tablaPalabrasClaves;
    }
}
