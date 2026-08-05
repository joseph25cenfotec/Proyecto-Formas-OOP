package modelo.figuras.rectangulo;

public class GestorRectangulo {
    public static String agregarRectangulo(double base, double altura) throws Exception {
        Rectangulo nuevoRectangulo = new Rectangulo(base, altura);
        return DAORectangulo.insertarRectangulo(nuevoRectangulo);
    }

    public static void listarRectangulos() throws Exception {
        System.out.println("TODO");
    }
}
