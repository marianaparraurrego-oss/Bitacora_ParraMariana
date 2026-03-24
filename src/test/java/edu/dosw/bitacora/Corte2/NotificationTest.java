package edu.dosw.bitacora.Corte2;

import dosw.bitacora.Corte2.Semana2.Ejercicio1Notificaciones.EmailNotification;
import dosw.bitacora.Corte2.Semana2.Ejercicio1Notificaciones.NotificationService;
import dosw.bitacora.Corte2.Semana2.Ejercicio1Notificaciones.SMSNotification;
import org.junit.jupiter.api.Test;
public class NotificationTest {
    @Test
    void testEmailNotification() {
        NotificationService service = NotificationService.getInstance();
        service.sendNotification(new EmailNotification(), "Hola Email");
    }

    @Test
    void testSMSNotification() {
        NotificationService service = NotificationService.getInstance();
        service.sendNotification(new SMSNotification(), "Hola SMS");
    }
}
