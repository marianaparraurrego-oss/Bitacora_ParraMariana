package dosw.bitacora.Semana2.Patrones.Ejercicio1;

public class PushNotificacion implements Notificacion{
    @Override
    public void enviar(String mensaje){
        System.out.println("Enviando PUSH: " + mensaje);
    }
}
