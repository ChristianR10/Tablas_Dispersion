package Clases_Auxiliares;

import Articulos_Cientificos.Resumen;

/**
 * Clase Lista_Hash
 * Indica todo lo referente a las lista enlazadas de nodos hash usandos en la tabla hash 
 * Depende de la clase Nodo_Hash
 * @author Andrés Rojas
 * @version 1.0
 */
public class Lista_Hash {
    /**
     * @param pFirst apuntador al primer nodo de la lista
     * @param size indica el tamaño de la lista
     */
    private Nodo_Hash pFirst;
    private int size;
    
    /**
     * constructor de la clase Lista_Hash
     */
    public Lista_Hash(){
        this.pFirst = null;
        this.size = 0;
    }
    
    /**
     * Metodo que agrega un nuevo nodo a la lista enlazada
     * @param node variable de tipo Nodo_Hash que indica el nuevo nodo que se desea agregar
     */
    public void add(Nodo_Hash node){
        if(this.pFirst==null){
            this.pFirst = node;
        }
        else{
            Nodo_Hash current = this.pFirst;
            while(current.getpNext()!=null){
                current = current.getpNext();
            }
            current.setpNext(node);
        }
        this.size++;
    }
    
    /**
     * funcion booleana que indica si ya existe un nodo en la lista con la clave especificada
     * @param key variable de tipo string que indica la clave que se desea buscar
     * @return true si existe un nodo con la clave deseada, false en caso contrario
     */
    public boolean keyExist (String key){
        boolean existe = false;
        Nodo_Hash aux = pFirst;
        while (aux!=null){
            if (aux.getKey().equals(key)){
                existe = true;
                break;
            }
            aux = aux.getpNext();
        }      
        return existe;
    }
    
    
    /**
     * @return variable interna pFirst
     */
    public Nodo_Hash getpFirst() {
        return pFirst;
    }

    

    /**
     * @return variable interna size
     */
    public int getSize() {
        return size;
    }
}
