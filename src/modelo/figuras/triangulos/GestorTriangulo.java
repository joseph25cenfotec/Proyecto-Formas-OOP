package modelo.figuras.triangulos;

import modelo.figuras.Figura;
import utils.Utils;

import java.util.ArrayList;

public class GestorTriangulo {

    public static String agregarTriangulo(double lado1, double lado2, double lado3) throws Exception {

        if (!Utils.esTrianguloValido(lado1, lado2, lado3)) {
            throw new Exception("Los lados no forman un triángulo válido.");
        }

        Triangulo nuevoTriangulo;

        if (lado1 == lado2 && lado2 == lado3) {
            // Equilátero: los tres son iguales, no importa el orden
            nuevoTriangulo = new Equilatero(lado1);

        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            // Isósceles: normalizamos para que el constructor reciba
            // siempre (ladoIgual, ladoIgual, ladoDistinto)
            double ladoIgual;
            double ladoDistinto;

            if (lado1 == lado2) {
                ladoIgual = lado1;
                ladoDistinto = lado3;
            } else if (lado1 == lado3) {
                ladoIgual = lado1;
                ladoDistinto = lado2;
            } else { // lado2 == lado3
                ladoIgual = lado2;
                ladoDistinto = lado1;
            }

            nuevoTriangulo = new Isosceles(ladoIgual, ladoIgual, ladoDistinto);

        } else {
            // Escaleno: los tres son distintos, el orden no afecta
            nuevoTriangulo = new Escaleno(lado1, lado2, lado3);
        }

        // Delegamos la persistencia al DAO
        return DAOTriangulo.insertarTriangulo(nuevoTriangulo);
    }

    public static void listarTriangulos(ArrayList<Figura> listaFiguras) throws Exception {
        // Escalenos
        ArrayList<Escaleno> listaEscalenos = DAOTriangulo.listarEscalenos();
        if (listaEscalenos != null) {
            listaFiguras.addAll(listaEscalenos);
        }

        // Equilateros
        ArrayList<Equilatero> listaEquilateros = DAOTriangulo.listarEquilateros();
        if (listaEquilateros != null) {
            listaFiguras.addAll(listaEquilateros);
        }

        // Isosceles
        ArrayList<Isosceles> listaIsosceles = DAOTriangulo.listarIsosceles();
        if (listaIsosceles != null) {
            listaFiguras.addAll(listaIsosceles);
        }
    }
}
