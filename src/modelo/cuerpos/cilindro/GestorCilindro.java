package modelo.cuerpos.cilindro;

import modelo.figuras.circulo.GestorCirculo;
import modelo.figuras.rectangulo.GestorRectangulo;

public class GestorCilindro {

    public static String agregarCilindro(double radio, double altura) throws Exception {
        double perimetroBase = 2 * Math.PI * radio;

        GestorCirculo.agregarCirculo(radio);
        GestorRectangulo.agregarRectangulo(perimetroBase, altura);

        return DAOCilindro.insertarCilindro(altura, 1, 1);
    }
}