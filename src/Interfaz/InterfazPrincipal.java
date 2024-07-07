package Interfaz;

import Articulos_Cientificos.Resumen;
import Articulos_Cientificos.Tablas_Hash;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Interfaz grafica del proyecto
 * @author Christian Ramos
 * @version 1.0
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    /**
     * @param tablaHash objeto de tipo Tablas_Hash que hace referencia a las distintas tablas hash usandas en el proyecto
     */
    Tablas_Hash tablaHash;
    /**
     * Constructor de la interfaz. Recibe como entrada un objeto de tipo Tablas_Hash
     */
    public InterfazPrincipal(Tablas_Hash tablaHash) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.tablaHash = tablaHash;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        agregar = new javax.swing.JToggleButton();
        salir = new javax.swing.JToggleButton();
        analizar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setText("MetroMendeley");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buscar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        buscar.setText("BUSCAR");
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 130, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Base de Datos de Resumenes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        agregar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        agregar.setText("AGREGAR");
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 70));

        salir.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        salir.setText("SALIR");
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 130, 70));

        analizar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        analizar.setText("ANALIZAR");
        analizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarActionPerformed(evt);
            }
        });
        jPanel1.add(analizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton con el que se agregan nuevos resumenes a la base de datos. De ingresar un resumen repetido, se avisa por una emergente
     */
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        try{
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("archivos de texto", "txt");
            fc.setFileFilter(filter);
            int selection = fc.showOpenDialog(this);

            if (selection == JFileChooser.APPROVE_OPTION){
                File fichero = fc.getSelectedFile();

                try (FileReader fr = new FileReader(fichero)){
                    String cadena = "";
                    int valor = fr.read();
                    while (valor != -1){
                        cadena += (char) valor;
                        valor = fr.read();
                    }

                    tablaHash.AgregarResumen(cadena);

                }
                catch (IOException el){JOptionPane.showMessageDialog(null, "El resumen insertado no es válido");}
            }
        }
        catch (Exception e){}

    }//GEN-LAST:event_agregarActionPerformed

    /**
     * boton para buscar un resumen en la base de datos usando distntos filtros
     */
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try{
            String entrada []={"","Titulo","Autores", "Palabras Claves"};
            String key = (String) JOptionPane.showInputDialog(null, "Elija el filtro de busqueda","",JOptionPane.DEFAULT_OPTION, null, entrada, entrada [0]);
            String titulos [];
            switch (key){
                case "Titulo" -> {
                    key = (String) JOptionPane.showInputDialog(null, "Elija un titulo","",JOptionPane.DEFAULT_OPTION, null, this.tablaHash.getListaTitulos(), this.tablaHash.getListaTitulos()[0]);
                    this.tablaHash.imprimirResumen(key,0);
                }
                case "Autores" -> {
                    key = (String) JOptionPane.showInputDialog(null, "Elija un autor","",JOptionPane.DEFAULT_OPTION, null, this.tablaHash.getListaAutores(), this.tablaHash.getListaAutores()[0]);
                    titulos = this.tablaHash.buscarKey(this.tablaHash.getTablaAutores(), key);
                    key = (String) JOptionPane.showInputDialog(null, "Elija un titulo","",JOptionPane.DEFAULT_OPTION, null, titulos, titulos[0]);
                    this.tablaHash.imprimirResumen(key,0);

                }
                case "Palabras Claves" -> {
                    key = (String) JOptionPane.showInputDialog("Ingrese su palabra clave.");
                    titulos = this.tablaHash.buscarKey(this.tablaHash.getTablaPalabrasClaves(), key);
                    if (titulos [0] != null){
                        key = (String) JOptionPane.showInputDialog(null, "Elija un titulo","",JOptionPane.DEFAULT_OPTION, null, titulos, titulos[0]);
                        this.tablaHash.imprimirResumen(key,0);
                    }
                    else {
                        JOptionPane.showMessageDialog (null, "No se encontró ningún resumen con esa palabra clave");
                    }
                } 
            }
        }
        catch (Exception e){}
    }//GEN-LAST:event_buscarActionPerformed

    /**
     * boton para elegir un resumen de la base de datos y ver sus estadisticas
     */
    private void analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarActionPerformed
        try{
            String key = (String) JOptionPane.showInputDialog(null, "Elija un titulo","",JOptionPane.DEFAULT_OPTION, null, this.tablaHash.getListaTitulos(), this.tablaHash.getListaTitulos()[0]);
            Resumen resumen = this.tablaHash.getTablaTitulo().buscarResumen(key);
            String cadena = "Nombre del Trabajo: \n" + resumen.getTitulo() + "\n\nAutores:\n";
            for (int i = 0; i<resumen.getAutores().length;i++){
                if (!resumen.getAutores()[i].equals("")){
                cadena += " - " + resumen.getAutores()[i] + "\n";
            }}
            cadena += "\nPalabras Claves:\n";
            for (int i = 0; i<resumen.getPalabras_Claves().length;i++){
                if (!resumen.getPalabras_Claves()[i].equals("")){
                cadena += " - " + resumen.getPalabras_Claves()[i]+": " + resumen.contarFrecuenciaPalabra(resumen.getPalabras_Claves()[i]) + "\n";
            }}   
            JOptionPane.showMessageDialog(null, cadena);
        }
        catch (Exception e){}
    }//GEN-LAST:event_analizarActionPerformed

    /**
     * boton para salir del sistema y guardar en txt la info de la base de datos
     */
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        tablaHash.GuardarBaseDato();
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton agregar;
    private javax.swing.JToggleButton analizar;
    private javax.swing.JToggleButton buscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton salir;
    // End of variables declaration//GEN-END:variables
}
