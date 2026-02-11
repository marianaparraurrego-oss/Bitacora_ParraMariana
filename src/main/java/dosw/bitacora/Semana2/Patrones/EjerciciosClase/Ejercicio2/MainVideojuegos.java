package dosw.bitacora.Semana2.Patrones.EjerciciosClase.Ejercicio2;

public class MainVideojuegos {
        public static void main(String[] args) {

            ConsoleFactory factory;

            factory = new PlayStationFactory();
            GameEngine psEngine = new GameEngine(factory);
            psEngine.run();

            System.out.println(" ---- ");

            factory = new XboxFactory();
            GameEngine xboxEngine = new GameEngine(factory);
            xboxEngine.run();

        }
}
