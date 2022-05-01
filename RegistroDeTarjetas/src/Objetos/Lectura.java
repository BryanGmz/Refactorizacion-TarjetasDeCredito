/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos;

import Source.AccionesEnum;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author bryan
 */
public interface Lectura {
 
    public String leerArchivoTxt(String nombreDeArchivo) throws FileNotFoundException, IOException;

    public AccionInterface leerAccionBin(AccionesEnum accionesEnum, String archivoEntrada) throws IOException, ClassNotFoundException;

}
