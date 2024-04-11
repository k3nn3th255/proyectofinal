
package proyectofinal;

import javax.swing.JOptionPane;
 
public class Contacto {
    private String nombre;
    private String numeroTelefono;
 
    public Contacto(String nombre, String numeroTelefono) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }
 
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
 
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
 
    // Método para mostrar un mensaje en JOptionPane
    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}