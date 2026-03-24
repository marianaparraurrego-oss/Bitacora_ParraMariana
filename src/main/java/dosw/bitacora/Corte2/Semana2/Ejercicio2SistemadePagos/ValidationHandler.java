package dosw.bitacora.Corte2.Semana2.Ejercicio2SistemadePagos;

public abstract class ValidationHandler {
    protected ValidationHandler next;

    public void setNext(ValidationHandler next) {
        this.next = next;
    }

    public abstract boolean validate(double amount);
}
