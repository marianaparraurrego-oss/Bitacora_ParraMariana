package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio7Decorator;

public abstract class BarcoDecorator implements Barco{

    protected Barco barco;

    public BarcoDecorator(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion();
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque();
    }

    @Override
    public int defensa() {
        return barco.defensa();
    }
}
