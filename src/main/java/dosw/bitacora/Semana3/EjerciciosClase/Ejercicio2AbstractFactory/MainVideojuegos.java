package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio2AbstractFactory;

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
