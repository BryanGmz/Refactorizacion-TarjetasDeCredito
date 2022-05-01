package Instrucciones;

import Objetos.AccionInterface;
import Objetos.Proceso;
import registrodetarjetas.ControladorDeArchivos;
import Objetos.TarjetaDeCredito;
import Source.AccionesEnum;
import Source.Constantes;
import java.io.IOException;

public class Consultar_Tarjeta extends ProcesoHTML {
    
    @Override
    public String getReporteHTML() {
        return reporteHTML; 
    }

    @Override
    public void setReporteHTML(String reporteHTML) {
       this.reporteHTML = reporteHTML;
    }
    
    @Override
    public void evaluarLinea(String line) throws IOException, ClassNotFoundException{
        String numeroDeTarjeta = line
                .replaceAll("CONSULTAR_TARJETA","")
                .replace("(","")
                .replace(")","");
        
        TarjetaDeCredito tarjeta = (TarjetaDeCredito) ControladorDeArchivos.getControladorArchivos().leerAccionBin(AccionesEnum.TARJETA_DE_CREDITO, "Tarjeta" + numeroDeTarjeta + ".tacre");
        tarjeta.setNumeroDeTarjeta(numeroDeTarjeta);
        reporteHTML = getFila(tarjeta);
        ControladorDeArchivos.getControladorArchivos().guradarArchivoHTML(reporteHTML);
    }
    
    @Override
    public String getCabecera() {
        return Constantes.ENCABEZADO_HTML_LISTA_TARJETAS;
    }

    @Override
    public String getFila(AccionInterface proceso) {
        TarjetaDeCredito tarjetaDeCredito = (TarjetaDeCredito) proceso;
        return 
                "<h3>Consulta de Tarjeta: " + tarjetaDeCredito.getNumeroDeTarjeta() +"</h3>" +
                "	<table style=\"border-collapse: collapse;\">\n" +
                "	  <tr>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
                "	  </tr>\n" +
                "	  <tr>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getNumeroDeTarjeta() +"</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getTipoStr() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getLimiteTarjeta() + ".00"+"</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getnombreDelCliente() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getDireccionDelCliente() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getEstadoStr() + "</td>\n" +
                "	  </tr>\n" +
                "	</table>";
    }
}
