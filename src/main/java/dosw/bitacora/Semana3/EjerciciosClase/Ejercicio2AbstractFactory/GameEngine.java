package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio2AbstractFactory;

public class GameEngine {
    private Controller controller;
    private Game game;
    private GraphicInterface graphicInterface;

    public GameEngine(ConsoleFactory factory) {
        controller = factory.createController();
        game = factory.createGame();
        graphicInterface = factory.createGraphicInterface();
    }

    public void run() {
        controller.connect();
        game.start();
        graphicInterface.render();
    }
}
