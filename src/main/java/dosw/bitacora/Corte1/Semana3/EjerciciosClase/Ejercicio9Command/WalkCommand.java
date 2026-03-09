package dosw.bitacora.Semana3.EjerciciosClase.Ejercicio9Command;

public class WalkCommand implements Command{
    private GameCharacter character;

    public WalkCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.walk();
    }
}
