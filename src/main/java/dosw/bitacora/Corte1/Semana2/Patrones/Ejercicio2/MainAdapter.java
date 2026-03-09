package dosw.bitacora.Semana2.Patrones.Ejercicio2;

public class MainAdapter {
    public static void main(String[] args) {

        Impresora impresora1 = new ImpresoraSimple();
        impresora1.imprimir("Hola mundo");

        Impresora impresora2 =
                new ImpresoraAdapter(new ImpresoraDetallada());

        impresora2.imprimir("Mensaje adaptado");
    }
}
