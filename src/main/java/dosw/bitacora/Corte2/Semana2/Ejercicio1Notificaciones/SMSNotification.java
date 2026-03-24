package dosw.bitacora.Corte2.Semana2.Ejercicio1Notificaciones;

public class SMSNotification implements NotificationStrategy {
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
