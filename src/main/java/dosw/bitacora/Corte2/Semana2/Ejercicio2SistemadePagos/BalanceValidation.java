package dosw.bitacora.Corte2.Semana2.Ejercicio2SistemadePagos;

public class BalanceValidation extends ValidationHandler{
    public boolean validate(double amount) {
        System.out.println("Validando saldo...");
        if (amount > 1000) return false;
        return next == null || next.validate(amount);
    }
}
