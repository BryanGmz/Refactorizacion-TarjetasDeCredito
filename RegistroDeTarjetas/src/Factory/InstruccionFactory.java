/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Instrucciones.Autorizacion_Tarjeta;
import Instrucciones.Cancelacion_Tarjeta;
import Instrucciones.Listado_Solicitudes;
import Instrucciones.Listado_Tarjetas;
import Instrucciones.Movimiento;
import Instrucciones.Solicitud;
import Objetos.Proceso;

/**
 *
 * @author bryan
 */
public class InstruccionFactory {
    
    private static InstruccionFactory instruccionFactory = null;
    
    private InstruccionFactory() {}
    
    public static InstruccionFactory getInstruccionFactory() {
        if (instruccionFactory == null) {
            instruccionFactory = new InstruccionFactory();
        } return instruccionFactory;
    }
    
    public Proceso getInstruccion(String line) {
        if(line.startsWith("SOLICITUD")){
             return new Solicitud();
        }
        if(line.startsWith("MOVIMIENTO")){
            return new Movimiento();
        }
        if(line.startsWith("AUTORIZACION_TARJETA")){
            return new Autorizacion_Tarjeta();
        }
        if(line.startsWith("CANCELACION_TARJETA")){
            return new Cancelacion_Tarjeta();
        }
        if(line.startsWith("CONSULTAR_TARJETA")){
            return new Cancelacion_Tarjeta();
        }
        if(line.startsWith("LISTADO_TARJETAS")){
            return new Listado_Tarjetas();
        }
        if(line.startsWith("LISTADO_SOLICITUDES")){
            return new Listado_Solicitudes();
        }
        return null;
    }
    
}
