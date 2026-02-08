package dosw.bitacora.Semana1;

import java.util.List;

public class Streams {
   public static void ejercicio1NumerosPares(){
       List<Integer> numeros = List.of(4, 8, 10, 12, 15, 20, 3, 18);
       List<Integer> resultado = numeros.stream()
               .filter(n -> n % 2 == 0)
               .filter(n -> n > 10)
               .toList();

       System.out.println("Pares mayores a 10: "+ resultado);
   }

   public static void ejercicio2Palabras(){
       List<String> palabras = List.of("java", "streams", "codigo", "api", "lambda");

       long cantidad = palabras.stream()
               .filter(p -> p.length() > 4)
               .map(String::toUpperCase)
               .sorted()
               .count();
       System.out.println("Cantidad de palabras resultantes: " + cantidad);
   }

   public static void ejercicio3UsuariosActivos(){
       List<Usuario> usuarios = List.of(
               new Usuario(1, "Ana", 20, true),
               new Usuario(2, "Luis", 17, false),
               new Usuario(3, "Carlos", 30, true),
               new Usuario(4, "Maria", 25, true)
       );

       List<String> nombres = usuarios.stream()
               .filter(u -> u.active)
               .map(u -> u.name.toUpperCase())
               .sorted()
               .toList();
       System.out.println("Usuarios activos" + nombres);
   }

   public static void ejercicio4UsuariosMayores(){
       List<Usuario> usuarios = List.of(
               new Usuario(1, "Ana", 20, true),
               new Usuario(2, "Luis", 17, false),
               new Usuario(3, "Carlos", 30, true)
       );

       List<String> mayores = usuarios.stream()
               .filter(u -> u.age >=18)
               .map(u -> u.name).
               toList();
       System.out.println("Usuarios mayores de edad: "+ mayores);
   }

   public static void ejercicio5Transacciones(){
       List<Transaction> transacciones = List.of(
               new Transaction("T1", 500, true),
               new Transaction("T2", 1200, true),
               new Transaction("T3", 300, false)
       );
       boolean loteValido = transacciones.stream()
               .peek(t -> System.out.println("Procesando"+ t))
               .noneMatch(t -> !t.approved);
       System.out.println("¿Lote de transacciones valido?"+ loteValido);
   }

    public static void main(String[] args) {
        ejercicio1NumerosPares();
        ejercicio2Palabras();
        ejercicio3UsuariosActivos();
        ejercicio4UsuariosMayores();
        ejercicio5Transacciones();
    }
}
