package modelo.cuerpos.cilindro;
import datos.Connector;
import modelo.figuras.circulo.Circulo;
import modelo.figuras.rectangulo.Rectangulo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOCilindro {
    private static String statement;

    public static String insertarCilindro(double altura, int idTapa, int idCostado) throws Exception {
        statement = "INSERT INTO t_cilindros(altura, id_tapa, id_costado) VALUES ("
                + altura + ", " + idTapa + ", " + idCostado + ")";
        Connector.getConnection().ejecutarStatement(statement);
        return "El cilindro se registró correctamente en DB";
    }

    public static ArrayList<Cilindro> listarCilindros() throws Exception {
        ArrayList<Cilindro> listaCilindros = new ArrayList<>();

        String query = "SELECT * FROM t_cilindros;";
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        if (!resultado.next()) {
            return null;
        }

        do {
            int idTapa = resultado.getInt("id_tapa");
            int idCostado = resultado.getInt("id_costado");

            query = "SELECT * FROM t_circulos WHERE id = ?;";
            ResultSet resultadoCirculo = Connector.getConnection().ejecutarQuery(query, idTapa);
            Circulo tapaTemp = null;
            if (resultadoCirculo.next()) {
                tapaTemp = new Circulo(resultadoCirculo.getDouble("radio"));
            }

            query = "SELECT * FROM t_rectangulos WHERE id = ?;";
            ResultSet resultadoRectangulo = Connector.getConnection().ejecutarQuery(query, idCostado);
            Rectangulo costadoTemp = null;
            if (resultadoRectangulo.next()) {
                costadoTemp = new Rectangulo(
                        resultadoRectangulo.getDouble("largo"),
                        resultadoRectangulo.getDouble("ancho")
                );
            }

            if (tapaTemp != null && costadoTemp != null) {
                Cilindro cilindroTemp = new Cilindro(tapaTemp, costadoTemp.getBase());
                listaCilindros.add(cilindroTemp);
            }

        } while (resultado.next());

        return listaCilindros;
    }
}