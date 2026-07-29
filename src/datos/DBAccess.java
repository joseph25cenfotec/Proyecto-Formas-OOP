package datos;

import java.sql.*;

public class DBAccess {
    // Atributos
    private final Connection connection;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    // Métodos
    // Constructor
    public DBAccess(String direccion, String usuario, String contrasenia) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(direccion, usuario, contrasenia);
    }

    // Rutina que recibe un String que contiene una sentencia de MySQL y la ejecuta utilizando
    // una rutina de un objeto de la clase Connection.
    public void ejecutarStatement(String pStatement) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(pStatement);
    }
}
