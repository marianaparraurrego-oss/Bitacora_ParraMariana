package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio7Decorator;

public class BlindajeDecorator extends BarcoDecorator{
    public BlindajeDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Blindaje Reforzado";
    }

    @Override
    public int defensa() {
        return barco.defensa() + 30;
    }
}
