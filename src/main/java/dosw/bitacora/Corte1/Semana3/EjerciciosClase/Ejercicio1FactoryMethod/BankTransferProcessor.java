package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio1FactoryMethod;

public class BankTransferProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Pago con Transferencia Bancaria por $" + amount);
    }
}
