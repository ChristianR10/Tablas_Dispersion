/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Articulos_Cientificos.Resumen;

/**
 *
 * @author Andrés
 */
public class Nodo_Hash {

    private Resumen resumen;
    private String key;
    private Nodo_Hash pNext;
    
    public Nodo_Hash(Resumen resumen, String key){
        this.resumen = resumen;
        this.key = key;
        this.pNext = null;
    }

    /**
     * 
     * @return the info
     */
    public Resumen getResumen() {
        return resumen;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the pNext
     */
    public Nodo_Hash getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo_Hash pNext) {
        this.pNext = pNext;
    }
    
}
