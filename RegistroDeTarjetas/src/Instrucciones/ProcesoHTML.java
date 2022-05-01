/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instrucciones;

import Objetos.AccionInterface;
import Objetos.Proceso;

/**
 *
 * @author bryan
 */
public abstract class ProcesoHTML extends Proceso {
    
    protected String reporteHTML;
    
    public abstract void setReporteHTML(String reporteHTML);
    public abstract String getReporteHTML();
    public abstract String getCabecera();
    public abstract String getFila(AccionInterface proceso);
    
}
