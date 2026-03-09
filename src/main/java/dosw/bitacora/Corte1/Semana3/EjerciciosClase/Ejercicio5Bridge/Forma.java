package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio5Bridge;

public abstract class Forma {
    protected Color color;

    public Forma(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}
