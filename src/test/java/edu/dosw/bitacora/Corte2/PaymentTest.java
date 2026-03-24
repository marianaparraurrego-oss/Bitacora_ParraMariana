package edu.dosw.bitacora.Corte2;

import dosw.bitacora.Corte2.Semana2.Ejercicio2SistemadePagos.*;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    @Test
    void testPayment() {

        ValidationHandler balance = new BalanceValidation();
        ValidationHandler fraud = new FraudValidation();

        balance.setNext(fraud);

        PaymentService service = new PaymentService(balance);

        service.pay(new PayPalAdapter(), 500);
    }
}
