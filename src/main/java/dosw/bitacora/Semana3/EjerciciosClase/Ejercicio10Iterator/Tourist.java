package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio10Iterator;

public class Tourist {

        public void exploreTour(Aggregate<Place> route) {
            Iterator<Place> iterator = route.createIterator();

            while (iterator.hasNext()) {
                Place p = iterator.next();
                System.out.println("Visiting " + p.getName());

            }
        }
}
