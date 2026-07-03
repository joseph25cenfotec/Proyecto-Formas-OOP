package modelo.cuerpos;

import modelo.figuras.Circulo;

public class Cilindro extends Cuerpo {

    private Circulo base;
    private double altura;

    public Cilindro(Circulo base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Circulo getBase() {
        return base;
    }

    public void setBase(Circulo base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (2 * base.calcularArea()) +
                (base.calcularPerimetro() * altura);
    }

    @Override
    public double calcularPerimetro() {
        return (2 * base.calcularPerimetro());
    }

    @Override
    public double calcularVolumen() {
        return base.calcularArea() * altura;
    }

    @Override
    public void imprimirInformacion() {
        System.out.println("Cilindro");
        System.out.println("Radio: " + base.getRadio());
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
        System.out.println("Volumen: " + calcularVolumen());
    }

    @Override
    public String toString() {
        return "Cilindro{" +
                "radio=" + base.getRadio() +
                ", altura=" + altura +
                '}';
    }

}