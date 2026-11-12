package epn.edu.ec;



public class SistemaCarpooling {
    private final Ruta[] rutas;
    private int contadorRutas;

    public SistemaCarpooling(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            this.rutas = new Ruta[5];
        } else {
            this.rutas = new Ruta[capacidadMaxima];
        }
        this.contadorRutas = 0;
    }

    public boolean agregarRuta(Ruta nuevaRuta) {
        if (nuevaRuta == null || contadorRutas >= rutas.length) {
            return false;
        }
        rutas[contadorRutas] = nuevaRuta;
        contadorRutas++;
        return true;
    }

    public int getContadorRutas() {
        return contadorRutas;
    }

    public Ruta getRuta(int indice) {
        if (indice < 0 || indice >= contadorRutas) {
            return null;
        }
        return rutas[indice];
    }
}