/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos;

import java.io.IOException;

/**
 *
 * @author bryan
 */
public interface Escritura {
 
    public void guardarArchivoTxt(int numero, String nombreDeArchivo) throws IOException;

    public void guardarArchivoBin(String nombreDelArchivo, Object objeto) throws IOException;

    public void guradarArchivoHTML(String textoEntrante) throws IOException;
    
}
