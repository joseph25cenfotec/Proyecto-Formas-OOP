package modelo.figuras.circulo;

public class GestorCirculo {
    public static String agregarCirculo(double radio) throws Exception {
        Circulo nuevoCirculo = new Circulo(radio);
        return DAOCirculo.insertarCirculo(nuevoCirculo);
    }
}
