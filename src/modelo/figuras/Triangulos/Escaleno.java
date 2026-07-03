package modelo.figuras.Triangulos;

public class Escaleno extends Triangulo {

    public Escaleno(double lado1, double lado2, double lado3) {
        super(lado1, lado2, lado3);
    }

    @Override
    protected String getTipo() {
        return "Escaleno";
    }
}