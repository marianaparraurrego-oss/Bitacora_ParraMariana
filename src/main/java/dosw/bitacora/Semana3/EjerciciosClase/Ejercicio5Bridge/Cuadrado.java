package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio5Bridge;

public class Cuadrado extends Forma{
    public Cuadrado(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando cuadrado con ");
        color.aplicarColor();
    }
}
