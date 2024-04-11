
package proyectofinal;

import javax.swing.JOptionPane;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Mensajeria {
    private PriorityQueue<Mensaje> colaMensajes;
    private List<Mensaje> mensajesEnviados;
    private List<Mensaje> mensajesRecibidos;

    public Mensajeria() {
        this.colaMensajes = new PriorityQueue<>((m1, m2) -> m1.getPrioridad().compareTo(m2.getPrioridad()));
        this.mensajesEnviados = new ArrayList<>();
        this.mensajesRecibidos = new ArrayList<>();
    }

    public void enviarMensaje(Mensaje mensaje) {
        colaMensajes.offer(mensaje);
        mensajesEnviados.add(mensaje); // Guardar el mensaje como enviado
    }

    public void recibirMensaje(Mensaje mensaje) {
        mensajesRecibidos.add(mensaje); // Guardar el mensaje como recibido
    }

    public void enviarMensajes() {
        while (!colaMensajes.isEmpty()) {
            Mensaje mensaje = colaMensajes.poll();
            Usuario.mostrarMensaje("Mensaje enviado a: " + mensaje.getDestinatario() + "\nContenido: " + mensaje.getContenido());
            // Simulación de envío de mensaje (espera de 2 segundos)
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public PriorityQueue<Mensaje> obtenerMensajesPendientes() {
        return colaMensajes;
    }

    public List<Mensaje> obtenerMensajesEnviados() {
        return mensajesEnviados;
    }

    public List<Mensaje> obtenerMensajesRecibidos(String numeroTelefono) {
        List<Mensaje> mensajesFiltrados = new ArrayList<>();
        for (Mensaje mensaje : mensajesRecibidos) {
            if (mensaje.getDestinatario().equals(numeroTelefono)) {
                mensajesFiltrados.add(mensaje);
            }
        }
        return mensajesFiltrados;
    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

