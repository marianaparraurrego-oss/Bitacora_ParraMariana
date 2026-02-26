package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio3Builder;

public class ToyDoll {
    private String head;
    private String body;
    private String arms;
    private String legs;
    private String accessories;

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }
    public void showInfo() {
        System.out.println("Muñeco:");
        System.out.println("Cabeza: " + head);
        System.out.println("Cuerpo: " + body);
        System.out.println("Brazos: " + arms);
        System.out.println("Piernas: " + legs);
        System.out.println("Accesorios: " + accessories);
        System.out.println("------------");
    }
}
