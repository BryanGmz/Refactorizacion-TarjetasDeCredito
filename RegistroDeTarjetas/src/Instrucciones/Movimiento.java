package Instrucciones;

import Objetos.Proceso;
import java.util.Calendar;
import java.util.StringTokenizer;
import registrodetarjetas.ControladorDeArchivos;
import Objetos.TarjetaDeCredito;
import Source.AccionesEnum;
import java.io.IOException;

public class Movimiento extends Proceso {
    
    private String fecha;
    private String descripcion;
    private String numeroDeTarjeta;
    private String establecimiento;
    private String tipoDeMovimiento;
    private double monto;

    public Movimiento() { }

    public Movimiento(String fecha, String descripcion, String numeroDeTarjeta, String establecimiento, String tipoDeMovimiento, double monto) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.establecimiento = establecimiento;
        this.tipoDeMovimiento = tipoDeMovimiento;
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    @Override
    public void evaluarLinea(String line) throws IOException, ClassNotFoundException {
        StringTokenizer token = new StringTokenizer(line,","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
        //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
        String temp = token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token que en este caso es Movimiento(
        numeroDeTarjeta = temp.replaceAll("MOVIMIENTO", "");//Luego aca se le se quita la palabra movimiento a la variable numero de tarjeta y se convierte a entero
        fecha = token.nextToken().replaceAll("\"",""); //mediante esta instruccion se quitan las comillas a la fecha 
        tipoDeMovimiento = (token.nextToken().replace("\"", ""));
        descripcion = (token.nextToken().replace("\"", ""));
        establecimiento = (token.nextToken().replace("\"", ""));
        monto = Double.parseDouble(token.nextToken().replaceAll("\"", "").replace(")", ""));
        generarMovimiento("Tarjeta" + numeroDeTarjeta + ".tacre", monto);
        Calendar tiempo = Calendar.getInstance();
        String nombreDelNuevoMovimiento="Movimiento" + String.valueOf(tiempo.getTimeInMillis()) + ".mvito";
        ControladorDeArchivos.getControladorArchivos().guardarArchivoBin(nombreDelNuevoMovimiento, this);
    }
    
    public void generarMovimiento(String noTarjeta, double montoMovimiento) throws IOException, ClassNotFoundException {
        TarjetaDeCredito tarjeta = (TarjetaDeCredito) ControladorDeArchivos.getControladorArchivos().leerAccionBin(AccionesEnum.TARJETA_DE_CREDITO, noTarjeta);
        tarjeta.setCredito(tarjeta.getCreditoDeTarjeta() + montoMovimiento);
        ControladorDeArchivos.getControladorArchivos().guardarArchivoBin(noTarjeta, tarjeta);
    }
}
