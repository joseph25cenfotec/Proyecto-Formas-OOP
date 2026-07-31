package modelo.figuras.cuadrado;
import datos.Connector;

public class DAOCuadrado {
    private static String statement;
    private static String query;

    public static String insertarCuadrado(Cuadrado cuadradoInsertar) throws Exception {
        statement = "INSERT INTO t_cuadrados(lado) VALUES (" + cuadradoInsertar.getLado() + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El cuadrado se registro correctamente en DB";
    }
}
