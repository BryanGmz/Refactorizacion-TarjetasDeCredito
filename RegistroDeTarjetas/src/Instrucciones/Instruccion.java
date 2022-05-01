package Instrucciones;

import Factory.InstruccionFactory;
import Objetos.Proceso;
import java.io.IOException;
import java.io.Serializable;

public class Instruccion implements Serializable {
    
    public void evaluarLinea(String line) throws IOException, ClassNotFoundException{
        Proceso accion = InstruccionFactory.getInstruccionFactory().getInstruccion(line);
        accion.evaluarLinea(line);
    }
}
