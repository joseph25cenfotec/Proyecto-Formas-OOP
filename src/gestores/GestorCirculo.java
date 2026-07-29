package gestores;

import modelo.figuras.Circulo.Circulo;
import modelo.figuras.Circulo.DAOCirculo;

public class GestorCirculo {
    public static String agregarCirculo(double radio) throws Exception {
        Circulo nuevoCirculo = new Circulo(radio);
        return DAOCirculo.insertarCirculo(nuevoCirculo);
    }
}
