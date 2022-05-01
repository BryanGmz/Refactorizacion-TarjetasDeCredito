package Instrucciones;

import Objetos.Proceso;
import registrodetarjetas.ControladorDeArchivos;
import Objetos.TarjetaDeCredito;
import Source.AccionesEnum;
import java.io.IOException;

public class Cancelacion_Tarjeta extends Proceso {
    
    @Override
    public void evaluarLinea(String line) throws IOException, ClassNotFoundException {
        try {
            String numeroDeTarjeta=line
                .replaceAll("CANCELACION_TARJETA","")
                .replace("(", "")
                .replace(")", "");
            String nombreDelArchivo = "Tarjeta" + numeroDeTarjeta + ".tacre";
            TarjetaDeCredito tarjeta = (TarjetaDeCredito) ControladorDeArchivos.getControladorArchivos().leerAccionBin(AccionesEnum.TARJETA_DE_CREDITO, nombreDelArchivo);
            if(tarjeta.getCreditoDeTarjeta() < 0) {
                tarjeta.setEstaActiva(false);
            } else {
                System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. ");
            }
        }
        catch(NullPointerException e){
            System.out.println("No puede autorizar solicitudes que no existan ");
        }
    }
    
}
