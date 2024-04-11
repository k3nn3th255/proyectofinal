
package proyectofinal;
import javax.swing.JOptionPane;
/**
 *
 * @author jorge
 */
public class Usuario {
    private String numeroTelefono;
    private String contrasena;
    static Usuario usuarioActual;
    public Usuario (){
        
    }
    
    public Usuario(String numeroTelefono,String contrasena){
        this.numeroTelefono=numeroTelefono;
        this.contrasena=contrasena;
        
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public static void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    
    public static void setUsuarioActual(Usuario usuarioActual) {
        Usuario.usuarioActual = usuarioActual;
    }

    
    
}
