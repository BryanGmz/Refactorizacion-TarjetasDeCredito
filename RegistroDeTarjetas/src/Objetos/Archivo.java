/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Source.AccionesEnum;
import Source.Constantes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Archivo implements Escritura, Lectura, Serializable {
    
    @Override
    public void guardarArchivoTxt(int numero, String nombreDeArchivo) throws IOException {
        try (DataOutputStream fileOut = new DataOutputStream (
                new FileOutputStream(nombreDeArchivo, false))) {
            fileOut.writeInt(numero);
        }        
    }

    @Override
    public void guardarArchivoBin(String nombreDelArchivo, Object objeto) throws IOException {
        try (ObjectOutputStream fileOut = new ObjectOutputStream(
                new FileOutputStream(nombreDelArchivo))) {
            fileOut.writeObject(objeto);                              
        } 
    }
    
    @Override
    public void guradarArchivoHTML(String textoEntrante) throws IOException {
        File archivo = new File(Constantes.ARCHIVO_NOMBRE_REPORTES);
        try (FileOutputStream salida = new FileOutputStream(archivo, true)) {
            salida.write(textoEntrante.getBytes());
        }
    }
    
    @Override
    public String leerArchivoTxt(String nombreDeArchivo) throws FileNotFoundException, IOException {
        DataInputStream fileIn = new DataInputStream (
                new FileInputStream(nombreDeArchivo));
        return fileIn.readUTF();
    }

    @Override
    public AccionInterface leerAccionBin(AccionesEnum accionesEnum, String archivoEntrante) throws IOException, ClassNotFoundException {
        AccionInterface accion;
        try (ObjectInputStream fileIn = new ObjectInputStream (
                new FileInputStream(archivoEntrante))) {
            accion = (AccionInterface) fileIn.readObject();
        } 
        return accion;
    }
    
}
