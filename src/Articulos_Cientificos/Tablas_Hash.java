package Articulos_Cientificos;

import Clases_Auxiliares.BaseDatos;
import Clases_Auxiliares.Hashing;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author cgrc1
 */
public class Tablas_Hash {
    private Hashing tablaTitulo;
    private Hashing tablaAutores;
    private Hashing tablaPalabrasClaves;
    private String allText;
    private String [] listaTitulos;
    private int numTit;
    private String [] listaAutores;
    private int numAut;
    private String [] listaPalabras_Claves;
    private int numPal;
    private boolean BDcargada;

    public Tablas_Hash(int sizeTit, int sizeAut, int sizePal) {
        this.tablaTitulo = new Hashing (sizeTit);
        this.tablaAutores = new Hashing (sizeAut);
        this.tablaPalabrasClaves = new Hashing (sizePal);
        this.allText = "";
        this.numAut = this.numPal = this.numTit = 0;
        this.listaAutores = new String [sizeAut];
        this.listaTitulos = new String [sizeTit];
        this.listaPalabras_Claves = new String [sizePal];
        this.BDcargada = false;
    }
    
    public void LeerBaseDato (){
        BaseDatos BD = new BaseDatos ();
        this.allText = BD.leerBaseDatos();
        String listaGuardados [] = this.allText.split("NuevoResumenGuardado");
        for (String listaGuardado : listaGuardados) {
            AgregarResumen(listaGuardado);
        }
        this.BDcargada = true;
    }
    
    public void GuardarBaseDato (){
        BaseDatos BD = new BaseDatos ();
        BD.guardarBaseDatos(this.allText);
    }
    
    public void AgregarResumen (String TxT){
        if (!TxT.equals("")){
            Resumen resumen = new Resumen (TxT);
            if (!tablaTitulo.claveRepetida(resumen.getTitulo())){
                tablaTitulo.add(resumen.getTitulo(), resumen);
                listaTitulos[numTit] = resumen.getTitulo();
                numTit ++;
                for (String autore : resumen.getAutores()) {
                    autore = autore.trim();
                    if (!autore.equals("")) {
                        if (!tablaAutores.claveRepetida(autore)){
                            listaAutores[numAut] = autore;
                            numAut ++;
                        }
                        tablaAutores.add(autore, resumen);
                    }
                }
                for (String palabras_Clave : resumen.getPalabras_Claves()) {
                    if (!palabras_Clave.equals("")) {
                        if (!tablaPalabrasClaves.claveRepetida(palabras_Clave)){
                            listaPalabras_Claves[numPal] = palabras_Clave;
                            numPal ++;
                        }
                        tablaPalabrasClaves.add(palabras_Clave, resumen);
                    }
                }
                this.allText += "NuevoResumenGuardado" + TxT;
                ordenarArray (this.listaAutores);
                ordenarArray (this.listaPalabras_Claves);
                ordenarArray (this.listaTitulos);
                if (this.BDcargada) {JOptionPane.showMessageDialog (null, "Resumen agregado con exito");}

            }
            else {
                JOptionPane.showMessageDialog (null, "El resumen insertado ya existe");
            }
        }
    }
    
    public String [] buscarKey (Hashing tabla, String key){
        String lista [] = tabla.buscarKey(key);
        ordenarArray (lista);
        return lista;
    }
    
    public void imprimirResumen (String key, int seleccion){
        Resumen resumen = null;
        switch (seleccion){
            case 0 -> { resumen = this.tablaTitulo.buscarResumen(key);}
            case 1 -> { resumen = this.tablaAutores.buscarResumen(key);}
            case 2 -> { resumen = this.tablaPalabrasClaves.buscarResumen(key);}
        }
        JOptionPane.showMessageDialog(null, resumen.getTexto());
    }
    
    
    public void ordenarArray (String [] array){
        Arrays.sort(array, (var o1, var o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        });
    }

    public Hashing getTablaTitulo() {
        return tablaTitulo;
    }

    public Hashing getTablaAutores() {
        return tablaAutores;
    }

    public Hashing getTablaPalabrasClaves() {
        return tablaPalabrasClaves;
    }

    public String[] getListaTitulos() {
        return listaTitulos;
    }

    public String[] getListaAutores() {
        return listaAutores;
    }

    public String[] getListaPalabras_Claves() {
        return listaPalabras_Claves;
    }

    
    
}
