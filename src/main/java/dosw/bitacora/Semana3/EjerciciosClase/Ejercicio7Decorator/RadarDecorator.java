package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio7Decorator;

public class RadarDecorator extends BarcoDecorator{
    public RadarDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Radar Avanzado";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 10;
    }
}
