/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrodetarjetas;
import Objetos.Archivo;

/**
 *
 * @author kevin
 */
public class ControladorDeArchivos extends Archivo {
    
    private static ControladorDeArchivos controladorDeArchivos = null;
    
    private ControladorDeArchivos() {}
    
    public static ControladorDeArchivos getControladorArchivos() {
        if (controladorDeArchivos == null) {
            controladorDeArchivos = new ControladorDeArchivos();
        } return controladorDeArchivos;
    }
}



