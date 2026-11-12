
package epn.edu.ec;

public class PruebaCarpooling {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CARPOOLING EPN ===");

        // 1. Creación de Objetos (Estado inicial)
        Vehiculo v1 = new Vehiculo("PCC-1234", "Kia Picanto", 4);
        Vehiculo v2 = new Vehiculo("XYZ-9999", "Mazda 3", 3);

        Ruta r1 = new Ruta(v1, "07:00 AM", 1.50);
        Ruta r2 = new Ruta(v2, "12:00 PM", 2.00);

        System.out.println("Ruta registrada: " + r1.getHoraSalida() + " | Vehículo: " + r1.getVehiculo().getPlaca());
        System.out.println("Tarifa inicial: $" + r1.getTarifa() + " | Asientos iniciales: " + r1.getAsientosDisponibles());

        System.out.println("\n--- 1. PRUEBA DE TARIFA (ENCAPSULAMIENTO) ---");
        System.out.println("Intento cambiar la tarifa a un valor negativo (-$1.00)...");
        
        boolean cambioTarifa = r1.setTarifa(-1.0);
        if (cambioTarifa == false) {
            System.out.println("CORRECTO: El metodo setTarifa devolvio false.");
            System.out.println("La tarifa se protegio y se mantiene en: $" + r1.getTarifa());
        }

        System.out.println("\n--- 2. PRUEBA DE RESERVA Y SOBRECUPO ---");
        System.out.println("Intento reservar 10 asientos (el auto solo tiene 4)...");
        
        boolean reservaFalsa = r1.reservar(10);
        if (reservaFalsa == false) {
            System.out.println("CORRECTO: El metodo reservar devolvio false.");
            System.out.println("Los asientos disponibles se mantienen en: " + r1.getAsientosDisponibles());
        }

        System.out.println("\nIntento reservar 2 asientos (Reserva valida)...");
        boolean reservaOk = r1.reservar(2);
        if (reservaOk == true) {
            System.out.println("CORRECTO: Reserva exitosa.");
            System.out.println("Los asientos disponibles bajaron a: " + r1.getAsientosDisponibles());
            System.out.println("El subtotal a cobrar es: $" + r1.calcularSubtotal(2));
        }

        System.out.println("\n--- 3. PRUEBA DEL GESTOR Y ARREGLO ESTATICO ---");
        // Creamos un sistema que solo soporta 2 rutas máximo
        SistemaCarpooling sis = new SistemaCarpooling(2); 

        System.out.println("Agregando Ruta 1... Exito: " + sis.agregarRuta(r1));
        System.out.println("Agregando Ruta 2... Exito: " + sis.agregarRuta(r2));
        
        System.out.println("\nEl sistema ya esta lleno (2 de 2). Intento agregar una Ruta 3...");
        Ruta r3 = new Ruta(v1, "17:00 PM", 1.25);
        boolean agrego3 = sis.agregarRuta(r3);
        
        if (agrego3 == false) {
            System.out.println("CORRECTO: El gestor detecto que el arreglo esta lleno.");
            System.out.println("Se evito el error ArrayIndexOutOfBoundsException.");
        }

        System.out.println("\nTotal de rutas instanciadas usando static: " + Ruta.getNumberOfRoutes());
    }
}
