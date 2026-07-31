package modelo.cuerpos.cilindro;
import datos.Connector;

public class DAOCilindro {
    private static String statement;

    public static String insertarCilindro(double altura, int idTapa, int idCostado) throws Exception {
        statement = "INSERT INTO t_cilindros(altura, id_tapa, id_costado) VALUES ("
                + altura + ", " + idTapa + ", " + idCostado + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El cilindro se registró correctamente en DB";
    }
}