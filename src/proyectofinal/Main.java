package proyectofinal;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    private static Usuario usuarioActual;
    private static Agenda agenda;
    private static Mensajeria mensajeria;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        iniciarSistema();
        Usuario usuario = new Usuario();
        mostrarMenuPrincipal();

    }

    private static void iniciarSistema() {
        // Inicializar el sistema con algunos datos de prueba:Juan, 12345678;Maria, 87654321
        agenda = new Agenda();
        agenda.agregarContacto(new Contacto("Juan", "12345678"));
        agenda.agregarContacto(new Contacto("Maria", "87654321"));
        agenda.agregarContacto(new Contacto("Jorge", "88340114"));

        mensajeria = new Mensajeria();
    }

    private static void mostrarMenuPrincipal() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú Principal\n"
                    + "1. Ingresar al Sistema\n"
                    + "2. Crear Cuenta\n"
                    + "3. Salir"
            );

            switch (opcion) {
                case "1":
                    ingresarAlSistema();
                    break;
                case "2":
                    crearCuenta();
                    break;
                case "3":
                    System.exit(0);
                default:
                    Usuario.mostrarMensaje("Opción inválida, por favor seleccione una opción válida.");
            }
        }
    }

    private static void mostrarMenuSecundario() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú Secundario\n"
                    + "1. Administrar Contactos\n"
                    + "2. Leer Mensajes\n"
                    + "3. Crear Mensaje\n"
                    + "4. Enviar Mensajes\n"
                    + "5. Ver Mensajes Enviados\n"
                    + "6. Ver Mensajes Pendientes\n"
                    + "7. Salir"
            );

            switch (opcion) {
                case "1":
                    administrarContactos();
                    break;
                case "2":
                    leerMensajes();
                    break;
                case "3":
                    crearMensaje();
                    break;
                case "4":
                    enviarMensajes();
                    break;
                case "5":
                    verMensajesEnviados();
                    break;
                case "6":
                    verMensajesPendientes();
                    break;
                case "7":
                    System.exit(0);
                default:
                    Usuario.mostrarMensaje("Opción inválida, por favor seleccione una opción válida.");
            }
        }
    }

    private static void ingresarAlSistema() {
        String numeroTelefono = JOptionPane.showInputDialog("Ingrese su número de teléfono:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

        // Lógica para verificar la cuenta del usuario
        // En este ejemplo, simplemente comparamos con un usuario de prueba
        if (numeroTelefono.equals("12345678") && contrasena.equals("password")) {
            Usuario.mostrarMensaje("Bienvenido al sistema!");
            usuarioActual = new Usuario(numeroTelefono, contrasena);
            mostrarMenuSecundario();
        } else if (numeroTelefono.equals("87654321") && contrasena.equals("password")) {

            Usuario.mostrarMensaje("Bienvenido al sistema!");
            usuarioActual = new Usuario(numeroTelefono, contrasena);
            mostrarMenuSecundario();
        } else if (numeroTelefono.equals("88340114") && contrasena.equals("password")) {
            Usuario.mostrarMensaje("Bienvenido al sistema!");
            usuarioActual = new Usuario(numeroTelefono, contrasena);
            mostrarMenuSecundario();
        } else {
            Usuario.mostrarMensaje("Número de teléfono o contraseña incorrectos.");
        }
    }

    private static void crearCuenta() {
        String numeroTelefono = JOptionPane.showInputDialog("Ingrese un nuevo número de teléfono:");
        String contrasena = JOptionPane.showInputDialog("Ingrese una contraseña para la cuenta:");

        // Creamos una nueva instancia de Usuario con los datos proporcionados
        Usuario nuevoUsuario = new Usuario(numeroTelefono, contrasena);

        // Agregamos el nuevo usuario a la lista de usuarios
        usuarios.add(nuevoUsuario);

        // Mostramos un mensaje de éxito
        nuevoUsuario.mostrarMensaje("Cuenta creada exitosamente!");

        // Establecer la nueva cuenta como el usuario actual
        Usuario.usuarioActual = nuevoUsuario;

    }

    private static void administrarContactos() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Administrar Contactos\n"
                    + "1. Agregar Contacto\n"
                    + "2. Ver Contactos\n"
                    + "3. Eliminar Contacto\n"
                    + "4. Volver"
            );

            switch (opcion) {
                case "1":
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
                    String numeroTelefono = JOptionPane.showInputDialog("Ingrese el número de teléfono del contacto:");
                    Contacto nuevoContacto = new Contacto(nombre, numeroTelefono);
                    agenda.agregarContacto(nuevoContacto);
                    Usuario.mostrarMensaje("Contacto agregado correctamente.");
                    break;
                case "2":
                    List<Contacto> contactos = agenda.obtenerContactos();
                    StringBuilder listaContactos = new StringBuilder("Contactos:\n");
                    for (Contacto contacto : contactos) {
                        listaContactos.append(contacto.getNombre()).append(" - ").append(contacto.getNumeroTelefono()).append("\n");
                    }
                    Usuario.mostrarMensaje(listaContactos.toString());
                    break;
                case "3":
                    String telefonoEliminar = JOptionPane.showInputDialog("Ingrese el número de teléfono del contacto a eliminar:");
                    Contacto contactoEliminar = agenda.buscarContacto(telefonoEliminar);
                    if (contactoEliminar != null) {
                        agenda.eliminarContacto(contactoEliminar);
                        Usuario.mostrarMensaje("Contacto eliminado correctamente.");
                    } else {
                        Usuario.mostrarMensaje("El contacto no existe.");
                    }
                    break;
                case "4":
                    return;
                default:
                    Usuario.mostrarMensaje("Opción inválida, por favor seleccione una opción válida.");
            }
        }
    }

    private static void leerMensajes() {
    // Obtener mensajes recibidos por el usuario actual
    List<Mensaje> mensajesRecibidos = mensajeria.obtenerMensajesRecibidos(usuarioActual.getNumeroTelefono());

    // Mostrar los mensajes en una ventana de diálogo
    StringBuilder mensajesTexto = new StringBuilder("Mensajes Recibidos:\n");
    for (Mensaje mensaje : mensajesRecibidos) {
        mensajesTexto.append("De: ").append(mensaje.getRemitente()).append("\n");
        mensajesTexto.append("Contenido: ").append(mensaje.getContenido()).append("\n\n");
    }
    Mensajeria.mostrarMensaje(mensajesTexto.toString());
}


    private static List<Mensaje> obtenerMensajesRecibidos(String numeroTelefono) {
        // Aquí deberías implementar la lógica para obtener los mensajes recibidos por el usuario actual
        // Por ejemplo, consultar una base de datos o alguna estructura de datos en memoria
        // Por ahora, devolveremos una lista vacía
        return new ArrayList<>();
    }

    private static void crearMensaje() {
        // Obtener la lista de contactos del usuario actual
        List<Contacto> contactos = agenda.obtenerContactos();

        // Crear un array de strings para mostrar los nombres de los contactos en el diálogo
        String[] nombresContactos = new String[contactos.size()];
        for (int i = 0; i < contactos.size(); i++) {
            nombresContactos[i] = contactos.get(i).getNombre();
        }

        // Mostrar un diálogo para que el usuario elija un contacto
        String destinatario = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el destinatario:",
                "Crear Mensaje",
                JOptionPane.PLAIN_MESSAGE,
                null,
                nombresContactos,
                nombresContactos[0]
        );

        // Obtener el contenido del mensaje
        String contenido = JOptionPane.showInputDialog("Ingrese el contenido del mensaje:");

        // Obtener la prioridad del mensaje
        String[] prioridades = {"Urgente", "Medio Urgente", "Sin Urgencia"};
        String prioridad = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la prioridad del mensaje:",
                "Crear Mensaje",
                JOptionPane.PLAIN_MESSAGE,
                null,
                prioridades,
                prioridades[0]
        );

        // Crear el mensaje
        Mensaje mensaje = new Mensaje(contenido, prioridad, destinatario);

        // Agregar el mensaje a la cola de mensajes
        mensajeria.enviarMensaje(mensaje);

        Usuario.mostrarMensaje("Mensaje creado y agregado a la cola de mensajes correctamente.");
    }

    private static void enviarMensajes() {
        // Enviar los mensajes en la cola de mensajes
        mensajeria.enviarMensajes();
    }

    private static void verMensajesEnviados() {
        // Obtener los mensajes enviados por el usuario actual
        List<Mensaje> mensajesEnviados = mensajeria.obtenerMensajesEnviados();

        // Mostrar los mensajes en una ventana de diálogo
        StringBuilder mensajesTexto = new StringBuilder("Mensajes Enviados:\n");
        for (Mensaje mensaje : mensajesEnviados) {
            mensajesTexto.append("Para: ").append(mensaje.getDestinatario()).append("\n");
            mensajesTexto.append("Contenido: ").append(mensaje.getContenido()).append("\n\n");
        }
        Usuario.mostrarMensaje(mensajesTexto.toString());
    }

    private static List<Mensaje> obtenerMensajesEnviados(String numeroTelefono) {
    // Crear una lista para almacenar los mensajes enviados por el usuario actual
    List<Mensaje> mensajesEnviados = new ArrayList<>();

    // Recorrer todos los mensajes en la lista de mensajes enviados
    for (Mensaje mensaje : mensajeria.obtenerMensajesEnviados()) {
        // Verificar si el remitente del mensaje coincide con el número de teléfono del usuario actual
        if (mensaje.getRemitente().equals(numeroTelefono)) {
            // Agregar el mensaje a la lista de mensajes enviados por el usuario actual
            mensajesEnviados.add(mensaje);
        }
    }

    // Devolver la lista de mensajes enviados por el usuario actual
    return mensajesEnviados;
}


    private static void verMensajesPendientes() {
        // Obtener los mensajes pendientes de envío
        PriorityQueue<Mensaje> mensajesPendientes = mensajeria.obtenerMensajesPendientes();

        // Mostrar los mensajes pendientes en una ventana de diálogo
        StringBuilder mensajesTexto = new StringBuilder("Mensajes Pendientes:\n");
        for (Mensaje mensaje : mensajesPendientes) {
            mensajesTexto.append("Destinatario: ").append(mensaje.getDestinatario()).append("\n");
            mensajesTexto.append("Contenido: ").append(mensaje.getContenido()).append("\n");
            mensajesTexto.append("Prioridad: ").append(mensaje.getPrioridad()).append("\n\n");
        }
        Usuario.mostrarMensaje(mensajesTexto.toString());
    }
}
