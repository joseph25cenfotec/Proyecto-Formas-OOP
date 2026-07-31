package modelo.cuerpos.tetraedro;
import datos.Connector;

public class DAOTetraedro {
    private static String statement;

    public static String insertarTetraedro(double altura, int idCaraEquilatero) throws Exception {
        statement = "INSERT INTO t_tetraedro(altura, id_cara) VALUES ("
                + altura + ", " + idCaraEquilatero + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El tetraedro se registró correctamente en DB";
    }
}
