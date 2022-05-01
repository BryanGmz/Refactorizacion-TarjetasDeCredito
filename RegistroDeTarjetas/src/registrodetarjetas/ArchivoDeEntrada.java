package registrodetarjetas;

import Instrucciones.Instruccion;
import Source.Constantes;
import java.util.Scanner;
import java.io.*;

public class ArchivoDeEntrada implements Serializable {
    
    /*
        Este procedimiento sirve para leer el archivo de entrada 
        que contiene todas las instrucciones a ingresar al sistema.
    */
    protected void asignarArchivo(String path, Disenio frame) throws IOException, ClassNotFoundException { 
        try (Scanner archivoDeEntrada = new Scanner(new FileReader(path))) {
            String line;
            Instruccion instruccion = new Instruccion();
            ControladorDeArchivos.getControladorArchivos().guardarArchivoTxt(1, Constantes.ARCHIVO_NUMERO_NACIONAL);
            ControladorDeArchivos.getControladorArchivos().guardarArchivoTxt(1, Constantes.ARCHIVO_NUMERO_REGIONAL);
            ControladorDeArchivos.getControladorArchivos().guardarArchivoTxt(1, Constantes.ARCHIVO_NUMERO_INTERNACIONAL);
            while (archivoDeEntrada.hasNextLine()){
                line = archivoDeEntrada.nextLine();
                System.out.println(line);
                frame.setAreaInstrucciones(String.valueOf(line)); //Las lineas que se van leyendo se almacenan en line
                instruccion.evaluarLinea(line);
            }
        }
        
    } //cerramos el procedimiento asignarArchivo
    
} //cerramos la clase ArchivoDeEntrada. 
