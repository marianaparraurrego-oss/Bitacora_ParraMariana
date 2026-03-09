package dosw.bitacora.Semana2.Solid;

public class Division implements Operacion{
    @Override
    public double calcular(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}
