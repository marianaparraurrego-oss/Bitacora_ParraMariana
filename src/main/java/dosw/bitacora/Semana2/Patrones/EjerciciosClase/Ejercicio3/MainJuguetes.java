package dosw.bitacora.Semana2.Patrones.EjerciciosClase.Ejercicio3;

public class MainJuguetes {
        public static void main(String[] args) {

            ToyFactory factory = new ToyFactory();

            ActionDollBuilder actionBuilder = new ActionDollBuilder();
            factory.constructDoll(actionBuilder);
            ToyDoll actionDoll = actionBuilder.getResult ();

            ClassicDollBuilder classicBuilder = new ClassicDollBuilder();
            factory.constructDoll(classicBuilder);
            ToyDoll classicDoll = classicBuilder.getResult();

            actionDoll. showInfo();
            classicDoll. showInfo();

        }
}
