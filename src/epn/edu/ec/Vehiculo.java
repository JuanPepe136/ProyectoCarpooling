package epn.edu.ec;

// representa un vehículo y almacena sus características.
public class Vehiculo {
    private String placa;
    private String modelo;
    private int capacidadMaxima;

    public Vehiculo(String placa, String modelo, int capacidadMaxima) {
        if (placa != null && !placa.isEmpty() && capacidadMaxima > 0) { // Validacion comprueba que la placa no sea nula ni esta vacia y la capacida sea mayor a 0 
            this.placa = placa;
            this.modelo = modelo;
            this.capacidadMaxima = capacidadMaxima;
        } else {
            this.placa = "SIN-PLACA";
            this.modelo = "Estándar";
            this.capacidadMaxima = 1;
        }
    }

    // Sobrecarga de constructor this()
    public Vehiculo(String placa, String modelo) {
        this(placa, modelo, 4);
    }

    //Metodos
    
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
