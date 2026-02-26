package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio8ChainOf;

public class MotivoViajeControl extends ControlMigratorio{
    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isMotivoValido()) {
            System.out.println("Ingreso rechazado.");
            return;
        }

        System.out.println("Motivo aprobado.");
        pasarAlSiguiente(request);
    }
}
