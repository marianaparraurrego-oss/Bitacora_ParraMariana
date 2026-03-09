package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio4Adapter;

public class FastChargerAdapter implements FuelService{
    private FastElectricCharger charger;

    public FastChargerAdapter(FastElectricCharger charger) {
        this.charger = charger;
    }

    @Override
    public void supply(double liters) {
        double kwh = liters * 8.0;
        charger.chargeFast(kwh);
    }
}
