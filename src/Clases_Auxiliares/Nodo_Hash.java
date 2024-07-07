package Clases_Auxiliares;

import Articulos_Cientificos.Resumen;

/**
 * Clase Nodo_Hash
 * Incluye lo referente a la construcción de los nodos usados en la clase Lista_Hash
 * @author Andres Rojas
 * @version 1.0
 */

public class Nodo_Hash {
    /**
     * @param resumen apuntador a resumen
     * @param key variable de tipo string que guarda la clave del nodo
     * @param pNext apuntador a otro nodo
     */
    private Resumen resumen;
    private String key;
    private Nodo_Hash pNext;
    
    /**
     * constructor de la clase Nodo_Hash
     * @param resumen resumen que se desee guardar en el nodo
     * @param key variable de tipo string que indica la clave del nodo
     */
    public Nodo_Hash(Resumen resumen, String key){
        this.resumen = resumen;
        this.key = key;
        this.pNext = null;
    }

    /**
     * 
     * @return interna Resumen
     */
    public Resumen getResumen() {
        return resumen;
    }

    /**
     * @return interna key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return interna pNext
     */
    public Nodo_Hash getpNext() {
        return pNext;
    }

    /**
     * @param pNext nuevo apuntador a nodo
     */
    public void setpNext(Nodo_Hash pNext) {
        this.pNext = pNext;
    }
    
}
