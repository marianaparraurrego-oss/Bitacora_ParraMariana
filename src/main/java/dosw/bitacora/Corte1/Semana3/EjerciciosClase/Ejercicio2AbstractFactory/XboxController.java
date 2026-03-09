package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio2AbstractFactory;

public class XboxController implements Controller{
    @Override
    public void connect() {
        System.out.println("Control de Xbox conectado");
    }
}
