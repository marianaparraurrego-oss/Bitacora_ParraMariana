package dosw.bitacora.Semana2.Patrones.Ejercicio1;

public class SmsNotificacion implements Notificacion{
    @Override
    public void enviar(String mensaje){
        System.out.println("Enviando SMS: "+ mensaje);
    }
}
