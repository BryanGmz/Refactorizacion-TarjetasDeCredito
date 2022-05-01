/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import NumerosDeTarjeta.Internacional;
import NumerosDeTarjeta.Nacional;
import NumerosDeTarjeta.Regional;
import Objetos.Archivo;
import Objetos.ArchivoTarjeta;
import Source.TiposDeTarjetaEnum;

/**
 *
 * @author bryan
 */
public class NumeroDeTarjetaFactory {
    
    private static NumeroDeTarjetaFactory numeroDeTarjetaFactory;
    
    private NumeroDeTarjetaFactory() {}
    
    public static NumeroDeTarjetaFactory getNoTarjetaFactory() {
        if (numeroDeTarjetaFactory == null) {
            numeroDeTarjetaFactory = new NumeroDeTarjetaFactory();
        } return numeroDeTarjetaFactory;
    }
    
    public ArchivoTarjeta getTarjeta(TiposDeTarjetaEnum tarjetaEnum) {
        Archivo archivo = new Archivo();
        switch(tarjetaEnum) {
            case INTERNACIONAL: 
                return new Internacional(archivo);
            case NACIONAL:
                return new Nacional(archivo);
            case REGIONAL:
                return new Regional(archivo);
            default: 
                return null;
        }
    }
    
}
