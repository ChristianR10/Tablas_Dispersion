/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_Auxiliares;

import javax.swing.JOptionPane;

/**
 *
 * @author Massi
 */
public class ValidacionesTXT {
    int IntanceOfTitulo = 0;
    int InstanceOfAutores= 0;
    int InstanceOfResumen = 0; 
    int InstanceOfKeys = 0;
    String txtFromTitulo;
    String txtFromAutores; 
    String txtFromResumen; 
    String txtFromKeys; 
    InstanceOfAutores = txt.indexOf("Autores");
    InstanceOfResumen = txt.indexOf("Resumen");
    InstanceOfKeys = txt.indexOf("Palabras clave");
    
    if (InstanceOfAutores == -1 || InstanceOfResumen == -1 || InstanceOfKeys == -1){
        
        if (InstanceOfAutores == -1){
            JOptionPane.showMessageDialog(null, "No se encuentran los Autores");
        }
        if (InstanceOfResumen == -1){
            JOptionPane.showMessageDialog(null, "No se encuentra el Resumen");
        }
        if (InstanceOfKeys == -1) {
            JOptionPane.showMessageDialog(null, "No se encuentran las Palabras clave");
        }
        return "";
}   else {
            txtFromAutores = txt.substring(InstanceOfAutores + 4);
            txtFromResumen = txt.substring(InstanceOfResumen + );
            txtFromKeys = txt.substring(InstanceOfKeys + 2);
            
            InstanceOfAutores = txtFromAutores.indexOf("Resumen");
            InstanceOfResumen = txtFromResumen.indexOf("Palabras Clave");
            InstanceOfKeys = txtFromKeys.indexOf(""/n);
            if(InstanceOfAutores == -1 || InstanceOfResumen == -1 || InstanceOfKeys == -1){
                if(InstanceOfAutores == -1){
                    JOptionPane.showMessageDialog(null, "Documento invalido");
                }
                if(InstanceOfResumen == -1){
                    JOptionPane.showMessageDialog(null, "Documento invalido");
                }
                if(InstanceOfKeys == -1){
                    JOptionPane.showMessageDialog(null, "Documento invalido");
                }
                return "";
                }
            }
            txtFromAutores = txtFromAutores.subtring(0, InstanceOfAutores);
            txtFromResumen = txtFromResumen.substring(0, InstanceOfResumen);
            txtFromKeys = txtFromKeys.substring(0, InstanceOfKeys);    
}

