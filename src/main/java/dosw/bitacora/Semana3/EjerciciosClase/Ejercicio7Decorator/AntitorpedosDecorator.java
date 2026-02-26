package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio7Decorator;

public class AntitorpedosDecorator extends BarcoDecorator{
    public AntitorpedosDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Sistema Antitorpedos";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 20;
    }
}
