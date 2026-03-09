package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio11Strategy;

public class MainAppNavegacion {
        public static void main(String[] args) {

            NavigationApp app = new NavigationApp(new FastestRoute());
            app.startNavigation();

            app.setRouteStrategy(new ScenicRoute());
            app.startNavigation();

            app.setRouteStrategy(new CheapestRoute());
            app.startNavigation();
        }
}
