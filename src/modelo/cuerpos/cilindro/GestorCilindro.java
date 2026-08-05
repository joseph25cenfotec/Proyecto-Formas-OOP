package modelo.cuerpos.cilindro;

import modelo.cuerpos.Cuerpo;
import modelo.figuras.Figura;
import modelo.figuras.circulo.GestorCirculo;
import modelo.figuras.rectangulo.GestorRectangulo;
import modelo.figuras.triangulos.DAOTriangulo;
import modelo.figuras.triangulos.Escaleno;

import java.util.ArrayList;

public class GestorCilindro {

    public static String agregarCilindro(double radio, double altura) throws Exception {
        double perimetroBase = 2 * Math.PI * radio;

        GestorCirculo.agregarCirculo(radio);
        GestorRectangulo.agregarRectangulo(perimetroBase, altura);

        return DAOCilindro.insertarCilindro(altura, 1, 1);
    }

    public static void listarCilindros(ArrayList<Cuerpo> listaCuerpos) throws Exception {
        // Escalenos
        ArrayList<Cilindro> listaCilindros = DAOCilindro.listarCilindros();
        if (listaCilindros != null) {
            listaCuerpos.addAll(listaCilindros);
        }
    }
}