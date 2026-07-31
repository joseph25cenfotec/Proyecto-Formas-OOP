package modelo.figuras.cuadrado;

public class GestorCuadrado {
    public static String agregarCuadrado(double radio) throws Exception {
        Cuadrado nuevoCuadrado = new Cuadrado(radio);
        return DAOCuadrado.insertarCuadrado(nuevoCuadrado);
    }
}
