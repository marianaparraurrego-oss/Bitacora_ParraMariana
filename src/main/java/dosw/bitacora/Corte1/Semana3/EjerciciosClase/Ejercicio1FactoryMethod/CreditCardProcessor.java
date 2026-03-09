package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio1FactoryMethod;

public class CreditCardProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Pago con Tarjeta de Crédito por $" + amount);
    }
}
