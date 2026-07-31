package modelo.figuras.rectangulo;
import datos.Connector;

public class DAORectangulo {
    private static String statement;
    private static String query;

    public static String insertarRectangulo(Rectangulo rectanguloInsertar) throws Exception {
        statement = "INSERT INTO t_rectangulos(base, altura) VALUES (" + rectanguloInsertar.getBase() + ", " + rectanguloInsertar.getAltura() + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El rectangulo se registro correctamente en DB";
    }
}
