package epn.edu.ec;

// Administrador de rutas guardar rutas

public class SistemaCarpooling {
    private final Ruta[] rutas; //Clase Rutas arreglo de onjetos no se puede cambiar la rferencia
    private int contadorRutas; // Para saber el numero de rutas que se han agregado

    
    //Constructor Cunatas rutas puede almacenar 
    public SistemaCarpooling(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            this.rutas = new Ruta[5];//  creal un arreglo de 5 posiciones
        } else {
            this.rutas = new Ruta[capacidadMaxima];// crea el areeglo de capacida max
        }
        this.contadorRutas = 0;// el sistema no contiene rutas aumenta cada vez que se agrega
    }

    // Agregar Ruta
    public boolean agregarRuta(Ruta nuevaRuta) {
        if (nuevaRuta == null || contadorRutas >= rutas.length) // comprobacion de que no este lleno el arreglo
        {
            return false;
        }
        rutas[contadorRutas] = nuevaRuta;// Guardar el Objeto en la posicion indicada
        contadorRutas++;
        return true;
    }

    public int getContadorRutas() {
        return contadorRutas;
    }
    
    //Metoto obtener ruta especifica del arreglo

    public Ruta getRuta(int indice) {
        if (indice < 0 || indice >= contadorRutas) {
            return null;
        }
        return rutas[indice];
    }
}
