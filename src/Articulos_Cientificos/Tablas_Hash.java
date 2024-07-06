/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos_Cientificos;

import Clases_Auxiliares.BaseDatos;
import Clases_Auxiliares.Hashing;
import java.util.Arrays;
import java.util.Comparator;
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

    public Tablas_Hash(int sizeTit, int sizeAut, int sizePal) {
        this.tablaTitulo = new Hashing (sizeTit);
        this.tablaAutores = new Hashing (sizeAut);
        this.tablaPalabrasClaves = new Hashing (sizePal);
        this.allText = "";
        this.numAut = this.numPal = this.numTit = 0;
    }
    
    public void LeerBaseDato (){
        BaseDatos BD = new BaseDatos ();
        this.allText = BD.leerBaseDatos();
        String listaGuardados [] = this.allText.split("NuevoResumenGuardado");
        for (String listaGuardado : listaGuardados) {
            AgregarResumen(listaGuardado);
        }
    }
    
    public void GuardarBaseDato (){
        BaseDatos BD = new BaseDatos ();
        BD.guardarBaseDatos(this.allText);
    }
    
    public void AgregarResumen (String TxT){
        if (!TxT.equals("")){
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
                ordenarArray (this.listaAutores);
                ordenarArray (this.listaPalabras_Claves);
                ordenarArray (this.listaTitulos);
                
            }
            else {
                JOptionPane.showMessageDialog (null, "El resumen insertado ya existe");
            }
        }
    }
    
    public String [] buscarKey (Hashing tabla, String key){
        String lista [] = tabla.buscarKey(key);
        ordenarArray (lista);
        return lista;
    }
    
    public void imprimirResumen (String key, int seleccion){
        Resumen resumen = null;
        switch (seleccion){
            case 0 -> { resumen = this.tablaTitulo.buscarResumen(key);}
            case 1 -> { resumen = this.tablaAutores.buscarResumen(key);}
            case 2 -> { resumen = this.tablaPalabrasClaves.buscarResumen(key);}
        }
        JOptionPane.showMessageDialog(null, resumen.getTexto());
    }
    
    
    public void ordenarArray (String [] array){
        Arrays.sort(array, (var o1, var o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        });
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

    public String[] getListaTitulos() {
        return listaTitulos;
    }

    public void setListaTitulos(String[] listaTitulos) {
        this.listaTitulos = listaTitulos;
    }

    public String[] getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(String[] listaAutores) {
        this.listaAutores = listaAutores;
    }

    public String[] getListaPalabras_Claves() {
        return listaPalabras_Claves;
    }

    public void setListaPalabras_Claves(String[] listaPalabras_Claves) {
        this.listaPalabras_Claves = listaPalabras_Claves;
    }
    
}
