package dosw.bitacora.Corte2.Semana2.Ejercicio1Notificaciones;

public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotification(NotificationStrategy strategy, String message) {
        strategy.send(message);
    }
}
