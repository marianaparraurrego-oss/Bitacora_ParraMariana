package dosw.bitacora.Corte2.Semana2.Ejercicio2SistemadePagos;

public class FraudValidation extends ValidationHandler{
    public boolean validate(double amount) {
        System.out.println("Validando fraude...");
        return next == null || next.validate(amount);
    }
}
