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
public class Lista_Hash {
    private Nodo_Hash pFirst;
    private int size;
    
    public Lista_Hash(){
        this.pFirst = null;
        this.size = 0;
    }
    
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
    
    public boolean nodoExist (String key){
        boolean existe = false;
        Nodo_Hash aux = pFirst;
        while (aux!=null){
            if (aux.getResumen().getTitulo().equals(key)){
                existe = true;
                break;
            }
            aux = aux.getpNext();
        }      
        return existe;
    }
    
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
    
    public void remove(Resumen info){
        if(this.pFirst.getResumen() == info){
            this.pFirst = this.pFirst.getpNext();
        }
        else{
            Nodo_Hash current = this.pFirst.getpNext();
            while(current!=null){
                if(current.getpNext().getResumen()==info){
                    current.setpNext(current.getpNext().getpNext());
                    this.size--;
                    break;
                }
                current = current.getpNext();
            }
        }
    }
    public boolean isEmpty(){
        return size==0;
    }
    /**
     * @return the pFirst
     */
    public Nodo_Hash getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo_Hash pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
