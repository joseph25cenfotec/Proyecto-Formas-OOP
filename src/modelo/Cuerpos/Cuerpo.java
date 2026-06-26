package modelo.Cuerpos;

import modelo.Forma;

public abstract class Cuerpo implements Forma {

    public Cuerpo() {
    }

    public abstract double calcularVolumen();

}