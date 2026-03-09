package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio7Decorator;

public class MisilesDecorator extends BarcoDecorator{
    public MisilesDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Misiles";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 40;
    }
}
