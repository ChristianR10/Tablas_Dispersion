package Clases_Auxiliares;

import Articulos_Cientificos.Resumen;
import static java.lang.Math.abs;

/**
 * Clase Hashing
 * Indica todo lo referente a la las tablas hash, asi como sus funciones
 * @author Andrés Rojas
 * @version 1.0
 */
public class Hashing {
    /**
     * @param Table Array de tipo Lista_Hash que sirve como estructura para la tabla hash
     * @param size variable de tipo entera que indica el tamaño de la tabla hash
     */
    private Lista_Hash[] Table;
    private int size;
    
    /**
     * constructor de la clase hashing
     * @param size variable de tipo entera que indica el tamaño que se desea que posea la tabla hash
     */
    public Hashing(int size){
        this.Table = new Lista_Hash[size];
        this.size = size;
    }
    
    /**
     * metodo que agrega un nuevo resumen en la tabla hash
     * @param key variable de tipo string que indica la llave en base a la que se desea hacer el hasheo para obtener el indice
     * @param info variable de tipo resumen que indica el resumen que se desea guardar
     */
    public void add(String key, Resumen info){
        int index = abs(key.hashCode() % size);
        Nodo_Hash node = new Nodo_Hash(info, key);
        if (Table[index] == null){Table[index] = new Lista_Hash();}
        Table[index].add(node);
    } 
    
    /**
     * funcion booleana que indica si ya existe un nodo que posea la misma key
     * @param key variable de tipo string que indica la llave en base a la que se desea hacer el hasheo para obtener el indice
     * @return true si ya existe un nodo con esa clave, false en caso contrario
     */
    public boolean claveRepetida (String key){
        int index = abs(key.hashCode() % size); 
        boolean claveRepetida = false;
        if (Table[index]!=null) {claveRepetida = Table[index].keyExist(key);}
        return claveRepetida;
    }
    
    /**
     * funcion que busca el titulo de todos los resumenes que posean la misma clave
     * @param key variable de tipo string que indica la llave en base a la que se desea hacer el hasheo para obtener el indice
     * @return array de string de todos los titulos
     */
    public String [] buscarKey (String key){
        int index = abs(key.hashCode() % size);
        if(this.Table[index] == null){
            String lista [] = new String [1];
            return lista;
        }
        String lista [] = new String [this.Table[index].getSize()];
        Nodo_Hash aux = this.Table[index].getpFirst();
        for (int i =0 ; i< this.Table[index].getSize();i++){
            if (aux.getKey().equals(key)){
                lista [i] = aux.getResumen().getTitulo();
            }
            aux = aux.getpNext();
        }
        return lista;
    }
    
    /**
     * funcion que busca un resumen especifico en la tabla hash
     * @param key variable de tipo string que indica la llave en base a la que se desea hacer el hasheo para obtener el indice
     * @return resumen solicitado
     */
    public Resumen buscarResumen (String key){
        int index = abs(key.hashCode() % size);
        Resumen resumen = null;
        Nodo_Hash aux = this.Table[index].getpFirst();
        while (aux != null){
            if (aux.getKey().equals(key)){
                resumen = aux.getResumen();
                break;
            }
            aux = aux.getpNext();
        }
        return resumen;
    }
}
