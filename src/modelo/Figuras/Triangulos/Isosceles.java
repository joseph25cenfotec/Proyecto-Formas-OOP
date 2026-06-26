package modelo.Figuras.Triangulos;

public class Isosceles extends Triangulo{
    public Isosceles(double lado1, double lado2, double lado3) {
        super(lado1, lado2, lado3);
    }

    @Override
    protected String getTipo() {
        return "Isosceles";
    }
}
