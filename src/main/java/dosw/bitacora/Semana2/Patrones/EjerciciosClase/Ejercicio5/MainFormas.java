package dosw.bitacora.Semana2.Patrones.EjerciciosClase.Ejercicio5;

public class MainFormas {

        public static void main(String[] args) {

            Forma circuloRojo = new Circulo(new Rojo());
            Forma cuadradoRojo = new Cuadrado(new Rojo());

            Forma circuloAzul = new Circulo(new Azul());
            Forma cuadradoAzul = new Cuadrado(new Azul()) ;

            circuloRojo.dibujar();
            cuadradoRojo.dibujar();
            circuloAzul.dibujar();
            cuadradoAzul.dibujar();

        }

}
