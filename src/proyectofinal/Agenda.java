
package proyectofinal;

import java.util.ArrayList;
import java.util.List;
 
public class Agenda {
    private List<Contacto> contactos;
 
    public Agenda() {
        this.contactos = new ArrayList<>();
    }
 
    // Método para agregar un contacto a la agenda
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }
 
    // Método para eliminar un contacto de la agenda
    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }
 
    // Método para obtener todos los contactos de la agenda
    public List<Contacto> obtenerContactos() {
        return contactos;
    }
 
    // Método para buscar un contacto por número de teléfono
    public Contacto buscarContacto(String numeroTelefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNumeroTelefono().equals(numeroTelefono)) {
                return contacto;
            }
        }
        return null; // Devuelve null si no se encuentra el contacto
    }
}