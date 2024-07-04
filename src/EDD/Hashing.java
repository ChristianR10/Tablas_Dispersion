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
public class Hashing {
    private Lista_Hash[] Table;
    private int size;
    
    public Hashing(int size){
        Table = new Lista_Hash[size];
    }
    
    public void add(String key, Resumen info){
        int index = key.hashCode() % size;
        Nodo_Hash node = new Nodo_Hash(info, key);
        Table[index].add(node);
    }
    
    public boolean newNode (String key){
        int index = key.hashCode() % size;
        boolean New;        
        New = Table[index].nodoExist(key);
        return New;
    }
    
    public boolean claveRepetida (String key){
        int index = key.hashCode() % size; 
        boolean claveRepetida = Table[index].keyExist(key);
        return claveRepetida;
    }
    
    public Lista_Hash get(String key){
        Lista_Hash results = new Lista_Hash();
        int index = key.hashCode() % size;
        Nodo_Hash current = Table[index].getpFirst();
        
        while(current!=null){
            if(current.getKey().equals(key)){
                results.add(current);
                current = current.getpNext();
            }
        }
        return results;
    }
}
