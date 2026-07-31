package modelo.cuerpos.esfera;
import datos.Connector;

public class DAOEsfera {
    private static String statement;

    public static String insertarEsfera(double radio) throws Exception {
        statement = "INSERT INTO t_esferas(radio) VALUES (" + radio + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "La esfera se registró correctamente en DB";
    }
}
