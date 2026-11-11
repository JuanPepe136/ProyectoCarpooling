package epn.edu.ec;


public class Ruta {
    private Vehiculo vehiculo;
    private String horaSalida;
    private double tarifa;
    private int asientosDisponibles;

    private static int creados = 0;
    public static final double DESCUENTO_ESTUDIANTE = 0.10;

    public Ruta(Vehiculo vehiculo, String horaSalida, double tarifa) {
        if (tarifa > 0 && vehiculo != null) {
            this.vehiculo = vehiculo;
            this.horaSalida = horaSalida;
            this.tarifa = tarifa;
            this.asientosDisponibles = vehiculo.getCapacidadMaxima();
            creados++;
        } else {
            this.vehiculo = new Vehiculo("SIN-PLACA", "Estándar", 1);
            this.horaSalida = "07:00 AM";
            this.tarifa = 1.00;
            this.asientosDisponibles = 1;
            creados++;
        }
    }

    public Ruta(Vehiculo vehiculo, String horaSalida) {
        this(vehiculo, horaSalida, 1.25);
    }

    public boolean reservar(int cantidad) {
        if (cantidad > 0 && asientosDisponibles >= cantidad) {
            this.asientosDisponibles -= cantidad;
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(int cantidad) {
        if (cantidad > 0 && (asientosDisponibles + cantidad) <= vehiculo.getCapacidadMaxima()) {
            this.asientosDisponibles += cantidad;
            return true;
        }
        return false;
    }

    public boolean setTarifa(double tarifa) {
        if (tarifa > 0) {
            this.tarifa = tarifa;
            return true;
        }
        return false;
    }

    public double calcularSubtotal(int cantidad) {
        return tarifa * cantidad;
    }

    public boolean isAvailable() {
        if (this.asientosDisponibles > 0) {
            return true;
        } else {
            return false;
        }
    }

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
