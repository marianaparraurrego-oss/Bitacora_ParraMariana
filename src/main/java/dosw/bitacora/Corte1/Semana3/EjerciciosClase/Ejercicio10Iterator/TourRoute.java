package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio10Iterator;

public class TourRoute implements Aggregate<Place> {
    private final Place[] places;

    public TourRoute() {
        places = new Place[]{
                new Place("Colosseum"),
                new Place("Roman Forum"),
                new Place("Trevi Fountain"),
                new Place("Pantheon"),
                new Place("Spanish Steps")
        };
    }

    @Override
    public Iterator<Place> createIterator() {
        return new RomeIterator(places);
    }
}
