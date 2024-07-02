/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Andrés
 */
public class HashTable {
    private LinkedList[] Table;
    private int size;
    
    public HashTable(int size){
        Table = new LinkedList[size];
    }
    
    public void add(String key, String info){
        int index = key.hashCode() % size;
        Nodo node = new Nodo(key, info);
        Table[index].add(node);
    }
    
    public LinkedList get(String key){
        LinkedList results = new LinkedList();
        int index = key.hashCode() % size;
        Nodo current = Table[index].getpFirst();
        
        while(current!=null){
            if(current.getKey().equals(key)){
                results.add(current);
                current = current.getpNext();
            }
        }
        return results;
    }
}
