
package proyectofinal;

public class Mensaje {

   private String contenido;
    private String prioridad;
    private String destinatario;
    private String remitente;

    public Mensaje(String contenido, String prioridad, String destinatario) {
        this.contenido = contenido;
        this.prioridad = prioridad;
        this.destinatario = destinatario;
        this.remitente = remitente;

    }
 
    // Getters y setters

    public String getContenido() {

        return contenido;

    }
 
    public void setContenido(String contenido) {

        this.contenido = contenido;

    }
 
    public String getPrioridad() {

        return prioridad;

    }
 
    public void setPrioridad(String prioridad) {

        this.prioridad = prioridad;

    }
 
    public String getDestinatario() {

        return destinatario;

    }
 
    public void setDestinatario(String destinatario) {

        this.destinatario = destinatario;

    }
    
    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

}

