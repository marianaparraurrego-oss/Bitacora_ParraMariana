package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio1FactoryMethod;

public class PaypalProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Pago con PayPal por $" + amount);
    }
}
