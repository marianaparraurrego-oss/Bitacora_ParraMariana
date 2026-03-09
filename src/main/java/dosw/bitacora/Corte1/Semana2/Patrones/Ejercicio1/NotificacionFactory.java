package dosw.bitacora.Semana2.Patrones.Ejercicio1;

public class NotificacionFactory {

    public static Notificacion crearNotificacion(String tipo){
        if(tipo.equalsIgnoreCase("email")){
            return new EmailNotificacion();
        }

        if(tipo.equalsIgnoreCase("sms")){
            return new SmsNotificacion();
        }

        if(tipo.equalsIgnoreCase("push")){
            return new PushNotificacion();
        }
        throw new IllegalArgumentException("Tipo no soportado");
    }
}
