package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio3Builder;

public interface DollBuilder {
    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    void buildAccessories();

    ToyDoll getResult();
}
