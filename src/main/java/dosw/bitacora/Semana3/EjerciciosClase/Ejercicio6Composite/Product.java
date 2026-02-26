package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio6Composite;

public class Product implements Item{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
