package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio2AbstractFactory;

public class PlayStationFactory implements ConsoleFactory{
    @Override
    public Controller createController() {
        return new PlayStationController();
    }

    @Override
    public Game createGame() {
        return new PlayStationGame();
    }

    @Override
    public GraphicInterface createGraphicInterface() {
        return new PlayStationGraphicInterface();
    }
}
