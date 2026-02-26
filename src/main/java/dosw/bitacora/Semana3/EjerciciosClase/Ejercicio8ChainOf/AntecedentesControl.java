package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio8ChainOf;

public class AntecedentesControl extends ControlMigratorio{

    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isSinAntecedentes()) {
            System.out.println("Ingreso rechazado.");
            return;
        }

        System.out.println("Antecedentes aprobados.");
        pasarAlSiguiente(request);
    }
}
