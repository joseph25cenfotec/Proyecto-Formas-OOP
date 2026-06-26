package modelo.Figuras;

public class Rombo extends Figura {

    private double lado;
    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double lado, double diagonalMayor, double diagonalMenor) {
        this.lado = lado;
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public void setDiagonalMayor(double diagonalMayor) {
        this.diagonalMayor = diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    public void setDiagonalMenor(double diagonalMenor) {
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public void imprimirInformacion() {
        System.out.println("Rombo");
        System.out.println("Lado: " + lado);
        System.out.println("Diagonal mayor: " + diagonalMayor);
        System.out.println("Diagonal menor: " + diagonalMenor);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }

    @Override
    public String toString() {
        return "Rombo{" +
                "lado=" + lado +
                ", diagonalMayor=" + diagonalMayor +
                ", diagonalMenor=" + diagonalMenor +
                '}';
    }

}