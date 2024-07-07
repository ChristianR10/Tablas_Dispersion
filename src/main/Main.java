package main;

import Articulos_Cientificos.Tablas_Hash;
import Interfaz.InterfazPrincipal;

/**
 * Clase main
 * Inicializa el proyecto y abre la interfaz gráfica
 * @author Christian Ramos
 * @version 1.0
 */

public class Main {
    /**
     *Funcion principal que inicia el proyecto y abre la interfaz grafica
     * @param args necesario para que se inicie el main
     */
    public static void main(String[] args) {
        Tablas_Hash Proyecto = new Tablas_Hash (100, 100, 100);
        Proyecto.LeerBaseDato();
        InterfazPrincipal GUI = new InterfazPrincipal (Proyecto);
        GUI.setVisible(true);
    }
    
}
