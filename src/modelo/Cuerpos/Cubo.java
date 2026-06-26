package modelo.Cuerpos;

import modelo.Figuras.Cuadrado;

public class Cubo extends Cuerpo {

    private Cuadrado cara;

    public Cubo(Cuadrado cara) {
        this.cara = cara;
    }

    public Cuadrado getCara() {
        return cara;
    }

    public void setCara(Cuadrado cara) {
        this.cara = cara;
    }

    @Override
    public double calcularPerimetro() {
        return 6 * cara.calcularPerimetro();
    }

    @Override
    public double calcularArea() {
        return 6 * cara.calcularArea();
    }

    @Override
    public double calcularVolumen() {
        double lado = cara.getLado();
        return lado * lado * lado;
    }

    @Override
    public void imprimirInformacion() {
        System.out.println("Cubo");
        System.out.println("Lado: " + cara.getLado());
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
        System.out.println("Volumen: " + calcularVolumen());
    }

    @Override
    public String toString() {
        return "Cubo{" +
                "lado=" + cara.getLado() +
                '}';
    }
}