package modelo.cuerpos.cubo;

import modelo.figuras.cuadrado.GestorCuadrado;

public class GestorCubo {
    public static String agregarCubo(double lado) throws Exception {
        GestorCuadrado.agregarCuadrado(lado);
        return DAOCubo.insertarCubo(1); // Se envía el id de la cara cuadrada
    }
}