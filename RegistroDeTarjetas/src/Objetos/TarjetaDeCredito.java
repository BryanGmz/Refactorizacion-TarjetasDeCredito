package Objetos;

import Source.Constantes;
import java.io.Serializable;

public class TarjetaDeCredito implements Serializable, AccionInterface {
    
    private int tipo;
    private int limite;
    private double credito;
    private boolean estaActiva;
    private String numeroDeTarjeta;
    private String nombreDelCliente;
    private String direccionDelCliente;
    
    //Constructor de la tarjeta de credito
    
    public TarjetaDeCredito() {}
    
    public TarjetaDeCredito(String  numeroDeTarjeta, int tipo, int limite, String nombreDelCliente, String direccionDelCliente, double credito, boolean estaActiva){
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.tipo = tipo;
        this.limite = limite;
        this.nombreDelCliente = nombreDelCliente;
        this.direccionDelCliente = direccionDelCliente;
        this.credito = credito;
        this.estaActiva = estaActiva;
    }
    
    public String getNumeroDeTarjeta(){
        return this.numeroDeTarjeta;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public int getLimite(){
        return this.limite;
    }
    
    public String getnombreDelCliente(){
        return this.nombreDelCliente;
    }
    
    public String getDireccionDelCliente(){
        return this.direccionDelCliente;
    }
    
    public double getCreditoDeTarjeta(){
        return this.credito;
    }
    
    public boolean getEstaActiva(){
        return this.estaActiva;
    }
    
    public void setEstaActiva(boolean valor) {
        this.estaActiva = valor;
    }
    
    public void setCredito(double valor) {
        this.credito = valor;
    }
    
    public String getEstadoStr(){
        return this.estaActiva ? "ACTIVA" : "CANCELADA";
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public void setDireccionDelCliente(String direccionDelCliente) {
        this.direccionDelCliente = direccionDelCliente;
    }
    
    public String getTipoStr(){
        switch (this.tipo) {
            case 1: return Constantes.NACIONAL;
            case 2: return Constantes.REGIONAL;
            case 3: return Constantes.INTERNACIONAL;
            default: return "";
        }
    }
    
    public int getLimiteTarjeta() {
        switch (this.tipo) {
            case 1: return Constantes.LIMITE_TARJETA_NACIONAL;
            case 2: return Constantes.LIMITE_TARJETA_REGIONAL;
            case 3: return Constantes.LIMITE_TARJETA_INTERNACIONAL;
            default: return 0;
        }
    }
}
