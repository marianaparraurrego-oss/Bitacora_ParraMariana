package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio7Decorator;

public class BarcoBase implements Barco{
    @Override
    public String getDescripcion() {
        return "Barco Base";
    }

    @Override
    public int poderAtaque() {
        return 50;
    }

    @Override
    public int defensa() {
        return 50;
    }
}
