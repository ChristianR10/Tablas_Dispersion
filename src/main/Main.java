/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Articulos_Cientificos.Tablas_Hash;
import Interfaz.InterfazPrincipal;

/**
 *
 * @author cgrc1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tablas_Hash Proyecto = new Tablas_Hash (100, 100, 100);
        Proyecto.LeerBaseDato();
        InterfazPrincipal GUI = new InterfazPrincipal (Proyecto);
        GUI.setVisible(true);
    }
    
}
