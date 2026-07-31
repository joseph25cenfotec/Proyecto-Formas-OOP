package modelo.figuras.triangulos;

public class GestorTriangulo {

    public static String agregarTriangulo(double lado1, double lado2, double lado3) throws Exception {
        Triangulo nuevoTriangulo = null;

        // Identificamos el tipo de triángulo con la misma lógica del Controller
        if (lado1 == lado2 && lado2 == lado3) {
            nuevoTriangulo = new Equilatero(lado1, lado2, lado3);
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            nuevoTriangulo = new Isosceles(lado1, lado2, lado3);
        } else {
            nuevoTriangulo = new Escaleno(lado1, lado2, lado3);
        }

        // Delegamos la persistencia al DAO
        return DAOTriangulo.insertarTriangulo(nuevoTriangulo);
    }
}
