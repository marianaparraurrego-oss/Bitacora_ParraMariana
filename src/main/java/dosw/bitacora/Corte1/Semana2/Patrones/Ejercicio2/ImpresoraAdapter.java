package dosw.bitacora.Semana2.Patrones.Ejercicio2;

import java.time.LocalDate;

public class ImpresoraAdapter implements Impresora{

    private ImpresoraDetallada impresoraDetallada;
    public ImpresoraAdapter(ImpresoraDetallada impresoraDetallada) {
        this.impresoraDetallada = impresoraDetallada;
    }
    @Override
    public void imprimir(String mensaje){
        impresoraDetallada.imprimirDetalle(mensaje, "sistema", LocalDate.now());
    }
}
