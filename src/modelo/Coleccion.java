package modelo;

import modelo.Cuerpos.Cuerpo;
import modelo.Figuras.Figura;

import java.util.ArrayList;

public class Coleccion {

    private ArrayList<Figura> figuras;
    private ArrayList<Cuerpo> cuerpos;

    public Coleccion() {
        figuras = new ArrayList<>();
        cuerpos = new ArrayList<>();
    }

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
    }

    public void agregarCuerpo(Cuerpo cuerpo) {
        cuerpos.add(cuerpo);
    }

    public ArrayList<Figura> listarFiguras() {
        return figuras;
    }

    public ArrayList<Cuerpo> listarCuerpos() {
        return cuerpos;
    }

    public double calcularAreaTotal() {
        double total = 0;

        for (Figura figura : figuras) {
            total += figura.calcularArea();
        }

        for (Cuerpo cuerpo : cuerpos) {
            total += cuerpo.calcularArea();
        }

        return total;
    }

    public double calcularPerimetroTotal() {
        double total = 0;

        for (Figura figura : figuras) {
            total += figura.calcularPerimetro();
        }

        for (Cuerpo cuerpo : cuerpos) {
            total += cuerpo.calcularPerimetro();
        }

        return total;
    }

    public double calcularVolumenTotal() {
        double total = 0;

        for (Cuerpo cuerpo : cuerpos) {
            total += cuerpo.calcularVolumen();
        }

        return total;
    }
}