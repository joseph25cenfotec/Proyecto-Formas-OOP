package modelo.Figuras;

public class Cuadrado extends Rectangulo {

    public Cuadrado(double lado) {
        super(lado, lado);
    }

    public double getLado() {
        return getBase();
    }

    public void setLado(double lado) {
        setBase(lado);
        setAltura(lado);
    }

    @Override
    public void imprimirInformacion() {
        System.out.println("Cuadrado");
        System.out.println("Lado: " + getLado());
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }

    @Override
    public String toString() {
        return "Cuadrado: " +
                "lado=" + getLado();
    }
}