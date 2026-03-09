package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio4Adapter;

public class MainGasolineria {

        public static void main(String[] args) {

            FuelService gasolinePump = new GasPump();

            FuelService fastElectricPump =
                    new FastChargerAdapter(new FastElectricCharger());

            FuelService slowElectricPump =
                    new SlowChargerAdapter(new SlowElectricCharger());

            gasolinePump.supply(30);
            fastElectricPump.supply(30);
            slowElectricPump.supply(30);
        }
}
