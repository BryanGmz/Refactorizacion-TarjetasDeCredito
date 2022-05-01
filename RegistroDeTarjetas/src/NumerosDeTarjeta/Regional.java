package NumerosDeTarjeta;

import Objetos.Archivo;
import Objetos.NumeroTarjetaDeCredito;
import Objetos.ArchivoTarjeta;
import Source.Constantes;


public class Regional extends ArchivoTarjeta implements NumeroTarjetaDeCredito {

    // Regional tenia el numero 0
    public Regional(Archivo archivo) {
        super(Constantes.ARCHIVO_NUMERO_REGIONAL, Constantes.NUMERO_REGIONAL, archivo, 0);
    }
   
}

