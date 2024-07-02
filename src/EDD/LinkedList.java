/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Andrés
 */
public class LinkedList {
    private Nodo pFirst;
    private int size;
    
    public LinkedList(){
        this.pFirst = null;
        this.size = 0;
    }
    
    public void add(Nodo node){
        if(this.pFirst==null){
            this.pFirst = node;
        }
        else{
            Nodo current = this.pFirst;
            while(current.getpNext()!=null){
                current = current.getpNext();
            }
            current.setpNext(node);
        }
        this.size++;
    }
    
    public void remove(String info){
        if(this.pFirst.getInfo().equals(info)){
            this.pFirst = this.pFirst.getpNext();
        }
        else{
            Nodo current = this.pFirst.getpNext();
            while(current!=null){
                if(current.getpNext().getInfo().equals(info)){
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
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
