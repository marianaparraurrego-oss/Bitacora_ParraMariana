package dosw.bitacora.Corte2.Semana2.Ejercicio2SistemadePagos;

public class PayPalAdapter implements PaymentProcessor{
    private PayPalAPI api = new PayPalAPI();

    public void processPayment(double amount) {
        api.makePayment(amount);
    }
}
