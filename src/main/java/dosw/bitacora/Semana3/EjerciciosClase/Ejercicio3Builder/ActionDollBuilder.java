package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio3Builder;

public class ActionDollBuilder implements DollBuilder{
    private ToyDoll doll;

    public ActionDollBuilder() {
        doll = new ToyDoll();
    }

    @Override
    public void buildHead() {
        doll.setHead("Cabeza con casco táctico");
    }

    @Override
    public void buildBody() {
        doll.setBody("Cuerpo musculoso articulado");
    }

    @Override
    public void buildArms() {
        doll.setArms("Brazos articulados fuertes");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Piernas resistentes de combate");
    }
    @Override
    public void buildAccessories() {
        doll.setAccessories("Arma y escudo");
    }

    @Override
    public ToyDoll getResult() {
        return doll;
    }
}
