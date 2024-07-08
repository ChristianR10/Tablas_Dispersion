package Articulos_Cientificos;

import Clases_Auxiliares.BaseDatos;
import Clases_Auxiliares.Hashing;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Clase Resumen
 * Incluye lo referente a la construcción de resumenes asi como sus principales funciones
 * @author Christian Ramos
 * @version 1.0
 */

public class Tablas_Hash {
    /**
     * @param tablaTitulo objeto de tipo Hashing que indica la tabla hash de titulos
     * @param tablaAutores objeto de tipo Hashing que indica la tabla hash de autores
     * @param tablaPalabrasClaves objeto de tipo Hashing que indica la tabla hash de palabras claves
     * @param listaTitulos array de tipo string que almacena los distintos titulos ingresados
     * @param listaAutores array de tipo string que almacena los distintos autores ingresados
     * @param listaPalabrasClaves array de tipo string que almacena los distintas palabras claves ingresadas
     * @param numTit variable de tipo entera que indica la cantidad de titulos ingresados
     * @param numAut variable de tipo entera que indica la cantidad de autores ingresados
     * @param numPal variable de tipo entera que indica la cantidad de palabras claves ingresadas
     * @param allText variable de tipo string que guarda una concatenacion de todos los resumenes ingresados
     * @param BDcargada variable de tipo boolean que indica si la base de datos ya fue cargada
     */
    private Hashing tablaTitulo;
    private Hashing tablaAutores;
    private Hashing tablaPalabrasClaves;
    private String [] listaTitulos;
    private String [] listaAutores;
    private String [] listaPalabras_Claves;
    private int numTit;
    private int numAut;
    private int numPal;
    private String allText;
    private boolean BDcargada;

    /**
     * constructor de la clase Tablas_Hash
     * @param sizeTit variable de tipo entero que indica el tamaño que se desea que posea la tabla hash de titulos
     * @param sizeAut variable de tipo entero que indica el tamaño que se desea que posea la tabla hash de autores
     * @param sizePal variable de tipo entero que indica el tamaño que se desea que posea la tabla hash de palabras claves
     */
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
    
    /**
     * metodo que lee la base de datos del sistema y carga los resumenes guardados
     */
    public void LeerBaseDato (){
        BaseDatos BD = new BaseDatos ();
        this.allText = BD.leerBaseDatos();
        String listaGuardados [] = this.allText.split("NuevoResumenGuardado");
        for (String listaGuardado : listaGuardados) {
            AgregarResumen(listaGuardado);
        }
        this.BDcargada = true;
    }
    
    /**
     * metodo que escribe la base de datos en base a los nuevos resumenes
     */
    public void GuardarBaseDato (){
        BaseDatos BD = new BaseDatos ();
        BD.guardarBaseDatos(this.allText);
    }
    
    /**
     * funcion que agrega un nuevo resumen a las distintas tablas hash
     * @param TxT variable de tipo string que indica toda la informacion que posee el resumen
     */
    public void AgregarResumen (String TxT){
        if (!TxT.equals("")){
            Resumen resumen = new Resumen (TxT);
            if (!tablaTitulo.claveRepetida(resumen.getTitulo())){
                tablaTitulo.add(resumen.getTitulo(), resumen);
                listaTitulos[numTit] = resumen.getTitulo();
                numTit ++;
                for (String autore : resumen.getAutores()) {
                    autore = autore.trim();
                    String[] names = autore.split((" "));
                    String author = "";
                    for(int i = 0; i < names.length; i++){
                        String[] IndNames = names[i].split("-");
                        for(int j = 0; j < IndNames.length; j++){
                            author = author + IndNames[j] + " ";
                        }
                    }
                    author = author.trim();
                    if (!author.equals("")) {
                        if (!tablaAutores.claveRepetida(author)){
                            listaAutores[numAut] = author;
                            numAut ++;
                        }
                        tablaAutores.add(author, resumen);
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
                if (this.BDcargada){JOptionPane.showMessageDialog (null, "Resumen agregado con exito");}

            }
            else {
                if (this.BDcargada){JOptionPane.showMessageDialog (null, "El resumen ingresado ya existe");}
            }
        }
    }
    
    /**
     * funcion que busca en el tabla hash seleccionada todos los resumenes que tengan una clave en comun
     * @param tabla variable de tipo hashing que indica la tabla hash en la que se desea hacer la busqueda
     * @param key variable de tipo string que indica la clave que se desea buscar
     * @return array con todas las coincidencias
     */
    public String [] buscarKey (Hashing tabla, String key){
        String lista [] = tabla.buscarKey(key);
        ordenarArray (lista);
        return lista;
    }
    
    /**
     * metodo que imprime en pantalla un resumen especifico
     * @param key variable de tipo string que indica la clave del resumen solicitado
     * @param seleccion variable de tipo entera que indica en que tabla hash se va a realizar la busqueda (0-Titulos, 1-autores, 2-palabras_claves)
     */
    public void imprimirResumen (String key, int seleccion){
        Resumen resumen = null;
        switch (seleccion){
            case 0 -> { resumen = this.tablaTitulo.buscarResumen(key);}
            case 1 -> { resumen = this.tablaAutores.buscarResumen(key);}
            case 2 -> { resumen = this.tablaPalabrasClaves.buscarResumen(key);}
        }
        JOptionPane.showMessageDialog(null, resumen.getTexto());
    }
    
    /**
     * metodo que ordena de forma alfabetica un array ingresado
     * @param array array de string que se desea ordenar
     */
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

    /**
     * @return variable interna TablaTitulo
     */
    public Hashing getTablaTitulo() {
        return tablaTitulo;
    }

    /**
     * @return variable interna TablaAutores
     */
    public Hashing getTablaAutores() {
        return tablaAutores;
    }

    /**
     * @return variable interna TablaPalabrasClaves
     */
    public Hashing getTablaPalabrasClaves() {
        return tablaPalabrasClaves;
    }

    /**
     * @return variable interna ListaTitulos
     */
    public String[] getListaTitulos() {
        return listaTitulos;
    }

    /**
     * @return variable interna ListaAutores
     */
    public String[] getListaAutores() {
        return listaAutores;
    }

    /**
     * @return variable interna ListaPalabras_Claves
     */
    public String[] getListaPalabras_Claves() {
        return listaPalabras_Claves;
    }

    
}
