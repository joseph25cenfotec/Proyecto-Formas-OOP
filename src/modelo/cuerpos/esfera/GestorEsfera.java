package modelo.cuerpos.esfera;

public class GestorEsfera {

    public static String agregarEsfera(double radio) throws Exception {
        return DAOEsfera.insertarEsfera(radio);
    }
}