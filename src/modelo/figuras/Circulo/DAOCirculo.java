package modelo.figuras.Circulo;
import datos.Connector;

public class DAOCirculo {

    private static String statement;
    private static String query;

    public static String insertarCirculo(Circulo circuloInsertar) throws Exception {
        statement = "INSERT INTO t_circulos(radio) VALUES (" + circuloInsertar.getRadio() + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El círculo se registro correctamente en DB";
    }

}
