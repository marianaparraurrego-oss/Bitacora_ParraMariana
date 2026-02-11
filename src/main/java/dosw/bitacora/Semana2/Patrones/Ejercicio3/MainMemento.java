package dosw.bitacora.Semana2.Patrones.Ejercicio3;

public class MainMemento {
    public static void main(String[] args) {

        Editor editor = new Editor();
        Historial historial = new Historial();

        editor.setTexto("Primera versión");
        historial.guardar(editor.guardar());

        editor.setTexto("Segunda versión");
        historial.guardar(editor.guardar());

        editor.restaurar(historial.obtener(0));

        System.out.println(editor.getTexto());
    }
}
