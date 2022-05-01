package Instrucciones;

import Objetos.AccionInterface;
import Objetos.Proceso;
import java.io.File;
import registrodetarjetas.ControladorDeArchivos;
import Objetos.TarjetaDeCredito;
import Source.AccionesEnum;
import Source.Constantes;
import java.io.IOException;

public class Listado_Tarjetas extends ProcesoHTML {
    
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
        File carpeta = new File(
                new File (".").getAbsolutePath());
        File[] files = carpeta.listFiles((dir1, name) -> name.endsWith(".tacre"));
        reporteHTML = getCabecera();
        for(File file: files){
            TarjetaDeCredito tarjetaDeCredito = (TarjetaDeCredito) ControladorDeArchivos.getControladorArchivos().leerAccionBin(AccionesEnum.TARJETA_DE_CREDITO, file.getPath());
            reporteHTML += "\n" + getFila(tarjetaDeCredito);
        }
        reporteHTML="\n</table>";
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
                "<tr>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getNumeroDeTarjeta() + "</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getTipoStr() + "</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getLimiteTarjeta() + "</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getnombreDelCliente() + "</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getDireccionDelCliente() + "</th>\n" +
                "           <td style=\"border: 1px solid #000000;\">" + "" + "</th>\n" +               
                "	    <td style=\"border: 1px solid #000000;\">" + tarjetaDeCredito.getEstadoStr() + "</th>\n" +
                "	  </tr>";
    }
}
