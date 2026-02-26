package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio2AbstractFactory;

public interface ConsoleFactory {
    Controller createController();
    Game createGame();
    GraphicInterface createGraphicInterface();
}
