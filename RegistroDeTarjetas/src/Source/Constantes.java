/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

/**
 *
 * @author bryan
 */
public class Constantes {
 
    public static final double PORCENTAJE_LIMITE_CREDITO = 0.6;
    
    public static final int LIMITE_TARJETA_NACIONAL = 2000;
    public static final int LIMITE_TARJETA_INTERNACIONAL = 12000;
    public static final int LIMITE_TARJETA_REGIONAL = 5000;
    
    public static final String NACIONAL = "Nacional";
    public static final String INTERNACIONAL = "Internacional";
    public static final String REGIONAL = "REGIONAL";
    public static final String NUMERO_REGIONAL = "4256-3102-6590-";
    public static final String NUMERO_NACIONAL = "4256-3102-6585-";
    public static final String NUMERO_INTERNACIONAL = "4256-3102-6595-";
    public static final String ARCHIVO_NUMERO_REGIONAL = "numeroRegionalCorriente.txt";
    public static final String ARCHIVO_NUMERO_NACIONAL = "numeroNacionalCorriente.txt";
    public static final String ARCHIVO_NUMERO_INTERNACIONAL = "numeroInternacionalCorriente.txt";
    public static final String ARCHIVO_NOMBRE_REPORTES = "Reportes.html";
    public static final String ENCABEZADO_HTML_LISTA_TARJETAS = 
            "<table style=\"border-collapse: collapse;\">\n"
            + "<h3>Listado de Tarjetas<h3>" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "           <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +               
            "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
            "	  </tr>";
    public static final String ENCABEZADO_HTML_LISTA_SOLICITUDES = 
            "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
            "	  <tr>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE SOLICITUD</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">FECHA DE SOLICITUD</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "           <th style=\"border: 1px solid #000000;\">FECHA APROV/RECH</th>\n" +               
            "	    <th style=\"border: 1px solid #000000;\">ESTADO SOLICITUD</th>\n" +
            "	  </tr>";
}
