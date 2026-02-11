package dosw.bitacora.Semana2.Patrones.Ejercicio3;
import java.util.ArrayList;
import java.util.List;
public class Historial {
    private List<Memento> estados = new ArrayList<>();

    public void guardar(Memento m) {
        estados.add(m);
    }

    public Memento obtener(int index) {
        return estados.get(index);
    }
}
