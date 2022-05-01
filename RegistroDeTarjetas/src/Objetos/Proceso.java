/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public abstract class Proceso implements Serializable {
    
    public abstract void evaluarLinea(String line) throws IOException, ClassNotFoundException;
   
}