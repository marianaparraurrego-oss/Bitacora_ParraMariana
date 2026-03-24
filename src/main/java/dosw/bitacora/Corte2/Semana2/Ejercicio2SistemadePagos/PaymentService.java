package dosw.bitacora.Corte2.Semana2.Ejercicio2SistemadePagos;

public class PaymentService {
    private ValidationHandler chain;

    public PaymentService(ValidationHandler chain) {
        this.chain = chain;
    }

    public void pay(PaymentProcessor processor, double amount) {
        if (chain.validate(amount)) {
            processor.processPayment(amount);
        } else {
            System.out.println("Pago rechazado");
        }
    }
}

