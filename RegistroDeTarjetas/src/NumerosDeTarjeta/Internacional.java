package NumerosDeTarjeta;

import Objetos.Archivo;
import Objetos.ArchivoTarjeta;
import Source.Constantes;

public class Internacional extends ArchivoTarjeta {

    // Nacional tenia el numero 0
    public Internacional(Archivo archivo) {
        super(Constantes.ARCHIVO_NUMERO_INTERNACIONAL, Constantes.NUMERO_INTERNACIONAL, archivo, 0);
    }
    
}
