package Instrucciones;

import Objetos.AccionInterface;
import Source.AccionesEnum;
import Source.Constantes;
import java.io.File;
import java.io.IOException;
import registrodetarjetas.ControladorDeArchivos;

public class Listado_Solicitudes extends ProcesoHTML {
    
    @Override
    public String getReporteHTML() {
        return reporteHTML; 
    }

    @Override
    public void setReporteHTML(String reporteHTML) {
       this.reporteHTML = reporteHTML;
    }
    
    @Override
    public void evaluarLinea(String line) throws IOException, ClassNotFoundException {
        File carpeta = new File(
                new File(".").getAbsolutePath());
        File[] files = carpeta.listFiles((dir1, name) -> name.endsWith(".sol"));
        reporteHTML = getCabecera();
        for(File file: files){
            Solicitud solicitud = (Solicitud) ControladorDeArchivos.getControladorArchivos().leerAccionBin(AccionesEnum.SOLICITUD, file.getPath());
            reporteHTML += "\n" + getFila(solicitud);
        }
        reporteHTML += "\n</table>";
        ControladorDeArchivos.getControladorArchivos().guradarArchivoHTML(reporteHTML);
           
    }

    @Override
    public String getCabecera() {
        return Constantes.ENCABEZADO_HTML_LISTA_SOLICITUDES;
    }

    @Override
    public String getFila(AccionInterface proceso) {
        Solicitud solicitud = (Solicitud) proceso;
        return 
                "<tr>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getNumeroDeSolicitud() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getFecha() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getTipoStr() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getNombre() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + 0 + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getDireccion() + "</td>\n" +
                "           <td style=\"border: 1px solid #000000;\">" + "" + "</td>\n" +               
                "	    <td style=\"border: 1px solid #000000;\">" + "" + "</td>\n" +
                "	  </tr>";
    }

    
    
}
