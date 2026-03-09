package dosw.bitacora.Semana2.Patrones.Ejercicio2;

import java.time.LocalDate;

public class ImpresoraDetallada {
    public void imprimirDetalle(String mensaje, String autor, LocalDate fecha){
        System.out.println("Mensaje: "+ mensaje);
        System.out.println("Autor: "+ autor);
        System.out.println("Fecha: "+ fecha);
    }
}
