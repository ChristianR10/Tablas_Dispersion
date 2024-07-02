/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Andrés
 */
public class Nodo {

    private String info;
    private String key;
    private Nodo pNext;
    
    public Nodo(String info, String key){
        this.info = info;
        this.key = key;
        this.pNext = null;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
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
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
}
