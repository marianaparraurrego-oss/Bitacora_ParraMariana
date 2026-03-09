package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio8ChainOf;

public class PasaporteControl extends ControlMigratorio{
    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isPasaporteValido()) {
            System.out.println("Ingreso rechazado.");
            return;
        }

        System.out.println("Pasaporte aprobado.");
        pasarAlSiguiente(request);
    }
}
