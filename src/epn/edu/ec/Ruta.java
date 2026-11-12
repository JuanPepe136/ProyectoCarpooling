package epn.edu.ec;
// representa un viaje, administra sus asientos y permite realizar reservas.

public class Ruta {
    private Vehiculo vehiculo; //Utilizamos la clase vEHICULO
    private String horaSalida;
    private double tarifa;
    private int asientosDisponibles;

    private static int creados = 0; // Pertenete a la clase en general
    public static final double DESCUENTO_ESTUDIANTE = 0.10; // Descuento 

    
    // Constructores
    public Ruta(Vehiculo vehiculo, String horaSalida, double tarifa) {
        if (tarifa > 0 && vehiculo != null) {
            this.vehiculo = vehiculo;
            this.horaSalida = horaSalida;
            this.tarifa = tarifa;
            this.asientosDisponibles = vehiculo.getCapacidadMaxima();
            creados++; //comntador
        } else {
            this.vehiculo = new Vehiculo("SIN-PLACA", "Estándar", 1);
            this.horaSalida = "07:00 AM";
            this.tarifa = 1.00;
            this.asientosDisponibles = 1;
            creados++; //contador 
        }
    }

     // Sobrecarga del constructor, sin especificar la tarifa.
    public Ruta(Vehiculo vehiculo, String horaSalida) {
        this(vehiculo, horaSalida, 1.25);
    }

    // Metodo Reservar
    public boolean reservar(int cantidad) {
        if (cantidad > 0 && asientosDisponibles >= cantidad) {
            this.asientosDisponibles -= cantidad; // Resta los ascientos reservados
            return true;
        }
        return false;
    }
// Metodo Cancelar Reserva tiene que devolver asceintos
    // Comprueba que no se supere la cantidad de ascientos
    public boolean cancelarReserva(int cantidad) {
        if (cantidad > 0 && (asientosDisponibles + cantidad) <= vehiculo.getCapacidadMaxima()) // Tiene que comprobar que al devolver no supere la cantidad e ascientos
        {
            this.asientosDisponibles += cantidad;
            return true;
        }
        return false;
    }

    // Metodo Tarifa
    //Modificacion del precio del viaje
    public boolean setTarifa(double tarifa) {
        if (tarifa > 0) { // Control tarifas negativas
            this.tarifa = tarifa;
            return true;
        }
        return false;
    }
// Metodo Subtotal
    public double calcularSubtotal(int cantidad) {
        return tarifa * cantidad;
    }
// Mtedo Comprobacion de Ascientos disponibles
    public boolean isAvailable() {
        if (this.asientosDisponibles > 0) {
            return true;
        } else {
            return false;
        }
    }
   // Metodo consultar rutas creadas
    public static int getNumberOfRoutes() {
        return creados;
    }

    // Getters
    public double getTarifa() {
        return tarifa;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
