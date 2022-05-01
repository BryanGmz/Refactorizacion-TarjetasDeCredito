package NumerosDeTarjeta;

import Objetos.Archivo;
import Objetos.ArchivoTarjeta;
import Source.Constantes;

public class Nacional  extends ArchivoTarjeta {

    // Nacional tenia el numero 1
    public Nacional(Archivo archivo) {
        super(Constantes.ARCHIVO_NUMERO_NACIONAL, Constantes.NUMERO_NACIONAL, archivo, 1);
    }
    
}
