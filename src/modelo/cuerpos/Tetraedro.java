package modelo.cuerpos;

import modelo.figuras.Triangulos.Triangulo;

public class Tetraedro extends Cuerpo {

    private Triangulo cara;

    private double altura;

    public Tetraedro(Triangulo cara, double altura) {
        this.cara = cara;
        this.altura = altura;
    }

    public Triangulo getCara() {
        return cara;
    }

    public void setCara(Triangulo cara) {
        this.cara = cara;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return (cara.calcularArea() * altura) / 3;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * cara.calcularPerimetro();
    }

    @Override
    public double calcularArea() {
        return 4 * cara.calcularArea();
    }

    @Override
    public void imprimirInformacion() {
        System.out.println("Tetraedro");
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
        System.out.println("Volumen: " + calcularVolumen());
    }
}