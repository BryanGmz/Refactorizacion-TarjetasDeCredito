/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Manejadores.GeneradorNumeroDeTarjeta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class ArchivoTarjeta implements Serializable, NumeroTarjetaDeCredito {
    
    private String archivoTXT;
    private String numeroTarjeta;
    private Archivo archivo;
    private int numero;

    public ArchivoTarjeta(String archivoTXT, String numeroTarjeta, Archivo archivo, int numero) {
        this.archivoTXT = archivoTXT;
        this.numeroTarjeta = numeroTarjeta;
        this.archivo = archivo;
        this.numero = numero;
    }
    
    public String getArchivoTXT() {
        return archivoTXT;
    }

    public void setArchivoTXT(String archivoTXT) {
        this.archivoTXT = archivoTXT;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    @Override
    public void actualizarArchivo(int numero) throws IOException {
        archivo.guardarArchivoTxt(numero, archivoTXT);
    }
    
    @Override
    public String leerYAsingarNumeroEnArchivo() throws FileNotFoundException, IOException {
        int numeroObtenido = Integer.parseInt(archivo.leerArchivoTxt(archivoTXT));
        String numeroDeTarjetaGenerada = GeneradorNumeroDeTarjeta.getGeneradorNumeroDeTarjeta().getNuevoNumeroDeTarjeta(numeroTarjeta, numeroObtenido);
        numero = numeroObtenido + 1;
        actualizarArchivo(numero);
        return numeroDeTarjetaGenerada;
    }
}
