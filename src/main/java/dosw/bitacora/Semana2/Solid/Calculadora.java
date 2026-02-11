package dosw.bitacora.Semana2.Solid;

public class Calculadora {
    public double ejecutarOperacion(Operacion operacion, double a, double b){
        return operacion.calcular(a,b);
    }
}
