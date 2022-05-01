package Instrucciones;

import Manejadores.GeneradorNumeroDeTarjeta;
import Objetos.Proceso;
import registrodetarjetas.ControladorDeArchivos;
import Objetos.TarjetaDeCredito;
import Source.AccionesEnum;
import Source.Constantes;
import java.io.IOException;


public class Autorizacion_Tarjeta extends Proceso {
        
    @Override
    public void evaluarLinea(String line) throws IOException, ClassNotFoundException{
        try {
            /*
            Las siguientes lineas sirven para capturar el numero de solicitud
            */
            int numeroDeSolicitud = Integer.valueOf(line
                    .replaceAll("AUTORIZACION_TARJETA", "")
                    .replace("(", "")
                    .replace(")", ""));
            Solicitud solicitudActual = (Solicitud) ControladorDeArchivos.getControladorArchivos().leerAccionBin(AccionesEnum.SOLICITUD, "Solicitud" + numeroDeSolicitud + ".sol");
            //Se capturan los atributos de nuestra solicitud
            String numeroDeSiguienteTarjeta = getSiguienteNumeroDeTarjeta(solicitudActual);
            //Ahora si ya tenemos luz verde vamos a instanciar un objeto TarjetaDeCredito para que ya pueda ser utilizada.
            if (numeroDeSiguienteTarjeta == null){
                System.out.println("No se pudo autorizar su tarjeta, porque no cumple con los requisitos.");
            } else {
                TarjetaDeCredito tarjetaDeCredito = crearTarjetaDeCredito(solicitudActual);
                ControladorDeArchivos.getControladorArchivos().guardarArchivoBin("Tarjeta" + numeroDeSiguienteTarjeta + ".tacre", tarjetaDeCredito);
            }
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage()+"No puede autorizar una solicitud que no exista");
        }
    }
    
    public TarjetaDeCredito crearTarjetaDeCredito(Solicitud solicitud) throws IOException {
        int salario = solicitud.getSalario();
        return new TarjetaDeCredito(
                GeneradorNumeroDeTarjeta.getGeneradorNumeroDeTarjeta().asignarNumeroDeTarjetas(getLimiteTarjeta(salario), solicitud.getTipo()), 
                solicitud.getTipo(), 
                getLimiteTarjeta(salario), 
                solicitud.getNombre(), 
                solicitud.getDireccion(), 
                0, 
                true);
    }
    
    public String getSiguienteNumeroDeTarjeta(Solicitud solicitud) throws IOException {
        return GeneradorNumeroDeTarjeta.getGeneradorNumeroDeTarjeta().asignarNumeroDeTarjetas(getLimiteTarjeta(solicitud.getSalario()), solicitud.getTipo());
    }
    
    public int getLimiteTarjeta(int salario) {
        return (int) (salario * Constantes.PORCENTAJE_LIMITE_CREDITO);
    }
    
}
