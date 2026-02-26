package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio10Iterator;

public class RomeIterator implements Iterator<Place> {
    private final Place[] places;
    private int currentIndex = 0;

    public RomeIterator(Place[] places) {
        this.places = places;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < places.length;
    }

    @Override
    public Place next() {
        return places[currentIndex++];
    }
}
