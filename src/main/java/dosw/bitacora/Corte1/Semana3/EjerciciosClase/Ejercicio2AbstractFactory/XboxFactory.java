package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio2AbstractFactory;

public class XboxFactory implements ConsoleFactory{
    @Override
    public Controller createController() {
        return new XboxController();
    }

    @Override
    public Game createGame() {
        return new XboxGame();
    }

    @Override
    public GraphicInterface createGraphicInterface() {
        return new XboxGraphicInterface();
    }
}
