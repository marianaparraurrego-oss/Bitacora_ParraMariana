package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio6Composite;
import java.util.ArrayList;
import java.util.List;

public class Box implements Item{
    private String name;
    private List<Item> items = new ArrayList<>();

    public Box(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice(); // recursivo si es otra caja
        }
        return total;
    }
}
