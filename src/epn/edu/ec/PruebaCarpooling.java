package epn.edu.ec;



public class PruebaCarpooling {

    static int ok = 0;
    static int fallas = 0;

    // Método auxiliar simple: si la condición es verdadera imprime OK, si no, FALLA
    static void verificar(String caso, boolean condicion) {
        if (condicion) {
            ok++;
            System.out.println("OK     " + caso);
        } else {
            fallas++;
            System.out.println("FALLA  " + caso);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 1. PRUEBAS DE REGLAS DE NEGOCIO (OK / FALLA) ===");

        Vehiculo v1 = new Vehiculo("PCC-1234", "Kia Rio", 4);
        Ruta r1 = new Ruta(v1, "07:00 AM", 1.50);

        // Evaluamos cambios de tarifa
        verificar("1. setTarifa(-1.0) devuelve false", !r1.setTarifa(-1.0));
        verificar("2. tarifa se mantiene en 1.50", r1.getTarifa() == 1.50);
        verificar("3. setTarifa(2.00) devuelve true", r1.setTarifa(2.00));

        // Evaluamos reservas
        verificar("4. reservar(10) sobrecupo devuelve false", !r1.reservar(10));
        verificar("5. reservar(2) devuelve true", r1.reservar(2));
        verificar("6. asientos bajan a 2", r1.getAsientosDisponibles() == 2);

        // Evaluamos el sistema gestor
        SistemaCarpooling sis = new SistemaCarpooling(2);
        verificar("7. agregarRuta(r1) devuelve true", sis.agregarRuta(r1));
        verificar("8. agregarRuta(null) devuelve false", !sis.agregarRuta(null));

        Vehiculo v2 = new Vehiculo("XYZ-9999", "Mazda 3", 3);
        Ruta r2 = new Ruta(v2, "12:00 PM", 2.00);
        sis.agregarRuta(r2); // Sistema lleno (2 de 2)

        Ruta r3 = new Ruta(v1, "17:00 PM", 1.25);
        verificar("9. agregar a sistema lleno devuelve false", !sis.agregarRuta(r3));
        verificar("10. contador del sistema se queda en 2", sis.getContadorRutas() == 2);

        System.out.println("\nResultado final: " + ok + " OK · " + fallas + " FALLA");

        System.out.println("\n=== 2. IMPRESIÓN SECUENCIAL (ESTILO TIENDA.JAVA) ===");
        System.out.println("Vehículo registrado: " + v1.getPlaca() + " (" + v1.getModelo() + ")");
        System.out.println("Ruta registrada: " + r1.getHoraSalida() + " | Tarifa: $" + r1.getTarifa());
        System.out.println("Subtotal por 2 pasajes: $" + r1.calcularSubtotal(2));
        System.out.println("Stock de asientos disponibles: " + r1.getAsientosDisponibles());
        System.out.println("¿La ruta esta disponible?: " + r1.isAvailable());
        System.out.println("Total de rutas creadas en memoria: " + Ruta.getNumberOfRoutes());
    }
}