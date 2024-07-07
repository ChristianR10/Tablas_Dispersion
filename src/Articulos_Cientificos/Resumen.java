package Articulos_Cientificos;

/**
 * Clase Resumen
 * Incluye lo referente a la construcción de resumenes asi como sus principales funciones
 * @author Christian Ramos y Andres Rojas
 * @version 1.0
 */

public final class Resumen {
    /**
     * @param Texto variable de tipo string que almacena toda la informacion leida del txt
     * @param Titulo variable de tipo string que almacena el titulo del resumen
     * @param Autores array de tipo string que guarda los distintos autores del resumen
     * @param Palabras_Claves array de tipo string que guarda las distintas palabras clave del resumen
     * @param Cuerpo variable de tipo string que guarda todo el cuerpo del resumen
     */
    private String Texto;
    private String Autores [];
    private String Titulo;
    private String Cuerpo;
    private String Palabras_Claves [];

    /**
     * constructor clase resumen
     * @param TxT variable de tipo string que guarda toda la informacion leida del archivo txt
     */
    public Resumen(String TxT) {
        this.armarResumen (TxT);
    }
    
    /**
     * funcion que lee el txt y lo disecciona en las distintas variables internas de la clase
     * @param TxT variable de tipo string que guarda toda la informacion leida del archivo txt
     * @author Christian Ramos
     */
    public void armarResumen (String TxT){
        if (!TxT.equals("")){
            this.Texto = TxT;
            String [] titulo = TxT.split("Autores");
            this.Titulo = titulo[0].split("\r\n")[0];
            String [] autores = titulo[1].split("Resumen");
            this.Autores = autores[0].split("\r\n");
            String [] resumen;
            if(autores[1].contains("Palabras claves: ")){
                resumen = autores[1].split("Palabras claves: ");
            } else if(autores[1].contains("Palabras Claves: ")){
                resumen = autores[1].split("Palabras Claves: ");
            } else{
                resumen = autores[1].split("palabras claves: ");
            }
            this.Cuerpo = resumen[0];
            this.Palabras_Claves = resumen[1].split(", ");
            this.Palabras_Claves[Palabras_Claves.length-1]=Palabras_Claves[Palabras_Claves.length-1].split("\r\n")[0];
        }
    }
    
    /**
     * funcion que cuenta la cantidad de veces que una palabra ingresada por el usuario aparece en el cuerpo del resumen
     * @param palabra variable de tipo string que indica la palabra que se desea conocer la frecuencia
     * @return variable de tipo entera que indica la cantidad de veces que aparece la palabra solicitada
     * @author Christian Ramos
     */
    public int contarFrecuenciaPalabra (String palabra){
        int frecuencias = 0;
        String aux = this.Cuerpo.toLowerCase();
        String textoPartido [] = aux.split(palabra.toLowerCase());
        frecuencias = textoPartido.length - 1;    
        return frecuencias;
    }

    /**
     * funcion que en base a los parametros internos, prepara un string para imprimir en pantalla
     * @return string con toda la informacion del resumen
     * @author Andres Rojas
     */
    public String getTexto() {
        String ParsedText;
        ParsedText = this.Titulo + "\n\n Autores: ";
        for(int i = 1; i < this.Autores.length; i++){
            if(i == this.Autores.length - 1){
                ParsedText = ParsedText + this.Autores[i] + ".";
            } else{
                ParsedText = ParsedText + this.Autores[i] + ", ";
            }
        }
        ParsedText = ParsedText + "\n\n";
        String[] AllWords = this.Cuerpo.split(" ");
        int Counter = 15;
        for(int i = 0; i < AllWords.length; i++){
            if(Counter >= 15){
                ParsedText = ParsedText + "\n" + AllWords[i];
                Counter = 0;
            } else{
                ParsedText = ParsedText + " " + AllWords[i];
                Counter++;
            }
        }
        ParsedText = ParsedText + "\n\n Palabras Clave: ";
        for(int i = 0; i < this.Palabras_Claves.length; i++){
            if(i == this.Autores.length - 1){
                ParsedText = ParsedText + this.Palabras_Claves[i] + ".";
            } else{
                ParsedText = ParsedText + this.Palabras_Claves[i] + ", ";
            }
        }
        
        return ParsedText;
    }
    
    
    /**
     * @return variable interna autores
     */
    public String[] getAutores() {
        return Autores;
    }

    /**
     * @return variable interna titulo
     */
    public String getTitulo() {
        return Titulo;
    }

    /**
     * @return variable interna cuerpo
     */
    public String getCuerpo() {
        return Cuerpo;
    }

    /**
     * @return variable interna palabras_claves
     */
    public String[] getPalabras_Claves() {
        return Palabras_Claves;
    }

    
}
