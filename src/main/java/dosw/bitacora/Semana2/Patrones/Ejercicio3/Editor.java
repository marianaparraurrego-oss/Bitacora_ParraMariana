package dosw.bitacora.Semana2.Patrones.Ejercicio3;

public class Editor {
    private String texto;

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public Memento guardar() {
        return new Memento(texto);
    }

    public void restaurar(Memento memento) {
        this.texto = memento.getEstado();
    }
}