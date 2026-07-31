package modelo.figuras.rombo;
import datos.Connector;

public class DAORombo {
    private static String statement;
    private static String query;

    public static String insertarRombo(Rombo romboInsertar) throws Exception {
        statement = "INSERT INTO t_rombos(lado, diagonal_mayor, diagonal_menor) VALUES (" + romboInsertar.getLado() + ", " + romboInsertar.getDiagonalMayor() + ", " + romboInsertar.getDiagonalMenor() + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El rombo se registro correctamente en DB";
    }
}
