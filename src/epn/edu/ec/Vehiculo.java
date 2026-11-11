package epn.edu.ec;


public class Vehiculo {
    private String placa;
    private String modelo;
    private int capacidadMaxima;

    public Vehiculo(String placa, String modelo, int capacidadMaxima) {
        if (placa != null && !placa.isEmpty() && capacidadMaxima > 0) {
            this.placa = placa;
            this.modelo = modelo;
            this.capacidadMaxima = capacidadMaxima;
        } else {
            this.placa = "SIN-PLACA";
            this.modelo = "Estándar";
            this.capacidadMaxima = 1;
        }
    }

    // Sobrecarga de constructor con this(...)
    public Vehiculo(String placa, String modelo) {
        this(placa, modelo, 4);
    }

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
