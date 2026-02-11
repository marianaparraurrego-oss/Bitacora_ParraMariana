package dosw.bitacora.Semana2.Patrones.Ejercicio1;

public class MainFactory {
    public static void main(String[] args) {

        Notificacion notificacion = NotificacionFactory.crearNotificacion("email");
        notificacion.enviar("Hola Andrea");
    }
}
