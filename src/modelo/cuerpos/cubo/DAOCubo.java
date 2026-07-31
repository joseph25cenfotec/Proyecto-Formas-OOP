package modelo.cuerpos.cubo;
import datos.Connector;

public class DAOCubo {
    private static String statement;

    public static String insertarCubo(int idCara) throws Exception {
        statement = "INSERT INTO t_cubos(id_cara) VALUES (" + idCara + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El cubo se registró correctamente en DB";
    }
}