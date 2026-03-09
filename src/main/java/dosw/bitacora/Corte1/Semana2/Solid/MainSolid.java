package dosw.bitacora.Semana2.Solid;

public class MainSolid {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        Operacion suma = new Suma();
        Operacion division = new Division();

        System.out.println("Suma");
        System.out.println(calc.ejecutarOperacion(suma, 5, 3));
        System.out.println("--------------");
        System.out.println("Division");
        System.out.println(calc.ejecutarOperacion(division, 10, 2));
    }
}
