package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio8ChainOf;

public abstract class ControlMigratorio {
    protected ControlMigratorio siguiente;

    public void setSiguiente(ControlMigratorio siguiente) {
        this.siguiente = siguiente;
    }

    public abstract void procesar(IngresoRequest request);

    protected void pasarAlSiguiente(IngresoRequest request) {
        if (siguiente != null) {
            siguiente.procesar(request);
        } else {
            System.out.println("Proceso terminado.");
        }
    }
}
