package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio3Builder;

public class ClassicDollBuilder implements DollBuilder{
    private ToyDoll doll;

    public ClassicDollBuilder() {
        doll = new ToyDoll();
    }

    @Override
    public void buildHead() {
        doll.setHead("Cabeza con cabello largo");
    }

    @Override
    public void buildBody() {
        doll.setBody("Cuerpo elegante clásico");
    }

    @Override
    public void buildArms() {
        doll.setArms("Brazos delicados");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Piernas estilizadas");
    }
    @Override
    public void buildAccessories() {
        doll.setAccessories("Bolso y sombrero");
    }

    @Override
    public ToyDoll getResult() {
        return doll;
    }
}
