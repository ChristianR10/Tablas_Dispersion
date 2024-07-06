/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_Auxiliares;

import Articulos_Cientificos.Resumen;

/**
 *
 * @author Andrés
 */
public class Hashing {
    private Lista_Hash[] Table;
    private int size;
    
    public Hashing(int size){
        this.Table = new Lista_Hash[size];
        this.size = size;
    }
    
    public void add(String key, Resumen info){
        int index = key.hashCode() % size;
        Nodo_Hash node = new Nodo_Hash(info, key);
        Table[index].add(node);
    }
    
    public boolean newNode (String key){
        int index = key.hashCode() % size;
        boolean New = true;        
        if (Table[index] != null) {New = Table[index].nodoExist(key);}
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
    
    public String [] buscarKey (String key){
        int index = key.hashCode() % size;
        String lista [] = new String [this.Table[index].getSize()];
        Nodo_Hash aux = this.Table[index].getpFirst();
        for (int i =0 ; i< this.Table[index].getSize();i++){
            if (aux.getKey().equals(key)){
                lista [i] = aux.getResumen().getTitulo();
                break;
            }
            aux = aux.getpNext();
        }
        return lista;
    }
    
    public Resumen buscarResumen (String key){
        int index = key.hashCode() % size;
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
