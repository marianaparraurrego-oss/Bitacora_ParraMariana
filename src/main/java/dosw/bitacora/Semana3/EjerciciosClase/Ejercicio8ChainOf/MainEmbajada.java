package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio8ChainOf;

public class MainEmbajada {

        public static void main(String[] args) {

            ControlMigratorio pasaporte = new PasaporteControl();
            ControlMigratorio antecedentes = new AntecedentesControl();
            ControlMigratorio motivo = new MotivoViajeControl();
            ControlMigratorio aprobacion = new AprobacionFinalControl();

            pasaporte.setSiguiente(antecedentes);
            antecedentes.setSiguiente(motivo);
            motivo.setSiguiente(aprobacion);

            IngresoRequest persona = new IngresoRequest(
                    true,
                    true,
                    false
            );
            pasaporte.procesar(persona);
        }
}
