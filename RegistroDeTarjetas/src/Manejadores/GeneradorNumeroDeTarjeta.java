/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manejadores;

import Factory.NumeroDeTarjetaFactory;
import Objetos.Archivo;
import Source.Constantes;
import Source.TiposDeTarjetaEnum;
import java.io.IOException;

/**
 *
 * @author bryan
 */
public class GeneradorNumeroDeTarjeta {
 
    private static GeneradorNumeroDeTarjeta instancia = null;
    
    private GeneradorNumeroDeTarjeta() {}
    
    public static GeneradorNumeroDeTarjeta getGeneradorNumeroDeTarjeta() {
        if (instancia == null) {
            instancia  = new GeneradorNumeroDeTarjeta();
        } return instancia;
    }
    
    public String getNuevoNumeroDeTarjeta (String base, int valor) {
        String numeroDeTarjeta = null;
        if(valor >= 1 & valor < 10){
            numeroDeTarjeta = base + "000 " + valor;
        }
        if(valor >= 10 & valor < 100){
            numeroDeTarjeta = base + "00" + valor;
        }
        if(valor >= 100 & valor < 10000){
            numeroDeTarjeta = base + "0" + valor;
        }
        return numeroDeTarjeta; //ESTE RETORNO ES DEL FORMATO XXXX-XXXX-XXXX-XXXX
    }
    
    public String asignarNumeroDeTarjetas(int limiteDeCredito, int tipo) throws IOException{
        String valorActual = null;
        if(tipo == 1 & limiteDeCredito >= Constantes.LIMITE_TARJETA_NACIONAL){ //se evalua si es del tipo 1 y si tiene un salario suficiente para la aprovacion de la tarjeta 
            valorActual = NumeroDeTarjetaFactory.getNoTarjetaFactory().getTarjeta(TiposDeTarjetaEnum.NACIONAL).leerYAsingarNumeroEnArchivo();
        }
        if(tipo==2 & limiteDeCredito >= Constantes.LIMITE_TARJETA_REGIONAL){ //se evalua si es del tipo 2 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual = NumeroDeTarjetaFactory.getNoTarjetaFactory().getTarjeta(TiposDeTarjetaEnum.REGIONAL).leerYAsingarNumeroEnArchivo();
        }
        if(tipo==3 & limiteDeCredito >= Constantes.LIMITE_TARJETA_INTERNACIONAL){ //se evalua si es del tipo 3 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual= NumeroDeTarjetaFactory.getNoTarjetaFactory().getTarjeta(TiposDeTarjetaEnum.INTERNACIONAL).leerYAsingarNumeroEnArchivo();
            System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        if (valorActual != null) {
             System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        return valorActual;
    }
}
