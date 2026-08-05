package modelo.figuras.triangulos;

public class Equilatero extends Triangulo {
    public Equilatero(double lado) {
        super(lado, lado, lado);
    }

    @Override
    protected String getTipo() {
        return "Escaleno";
    }
}
