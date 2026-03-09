package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio5Bridge;

public class Circulo extends Forma{
    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando círculo con ");
        color.aplicarColor();
    }
}
