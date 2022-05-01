/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author bryan
 */
public interface NumeroTarjetaDeCredito {
    
    public void actualizarArchivo(int numero) throws IOException;
    public String leerYAsingarNumeroEnArchivo() throws FileNotFoundException, IOException;
    
}
