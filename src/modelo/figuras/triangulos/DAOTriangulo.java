package modelo.figuras.triangulos;

import datos.Connector;
import modelo.figuras.Figura;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOTriangulo {
    private static String statement;

    public static String insertarTriangulo(Triangulo trianguloInsertar) throws Exception {

        if (trianguloInsertar instanceof Equilatero) {
            // Inserta en t_equilateros solo la medida de un lado
            statement = "INSERT INTO t_equilateros(lado) VALUES ("
                    + trianguloInsertar.getLado1() + ")";
            Connector.getConnection().ejecutarStatement(statement);
            return "El triángulo equilátero se registró correctamente en DB";

        } else if (trianguloInsertar instanceof Isosceles) {
            // Obtenemos los lados para separar el lado igual del diferente
            double l1 = trianguloInsertar.getLado1();
            double l2 = trianguloInsertar.getLado2();
            double l3 = trianguloInsertar.getLado3();

            double ladoIgual = (l1 == l2 || l1 == l3) ? l1 : l2;
            double ladoDiferente = (l1 != l2 && l1 != l3) ? l1 : ((l2 != l1 && l2 != l3) ? l2 : l3);

            statement = "INSERT INTO t_isosceles(lado_igual, lado_diferente) VALUES ("
                    + ladoIgual + ", " + ladoDiferente + ")";
            Connector.getConnection().ejecutarStatement(statement);
            return "El triángulo isósceles se registró correctamente en DB";

        } else if (trianguloInsertar instanceof Escaleno) {
            // Inserta los 3 lados en t_escalenos
            statement = "INSERT INTO t_escalenos(lado_1, lado_2, lado_3) VALUES ("
                    + trianguloInsertar.getLado1() + ", "
                    + trianguloInsertar.getLado2() + ", "
                    + trianguloInsertar.getLado3() + ")";
            Connector.getConnection().ejecutarStatement(statement);
            return "El triángulo escaleno se registró correctamente en DB";
        }

        return "No se pudo identificar el tipo de triángulo";
    }

    public static ArrayList<Equilatero> listarEquilateros() throws Exception {
        ArrayList<Equilatero> listaEquilateros = new ArrayList<>();

        String query = "SELECT * FROM t_equilateros";
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        if (!resultado.next()) {
            return null;
        }

        do {
            Equilatero equilateroTemp = new Equilatero(
                    resultado.getDouble("lado")
            );
            listaEquilateros.add(equilateroTemp);
        } while (resultado.next());

        return listaEquilateros;
    }

    public static ArrayList<Escaleno> listarEscalenos() throws Exception {
        ArrayList<Escaleno> listaEscalenos = new ArrayList<>();

        String query = "SELECT * FROM t_escalenos";
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        if (!resultado.next()) {
            return null;
        }

        do {
            Escaleno escalenoTemp = new Escaleno(
                    resultado.getDouble("lado_1"),
                    resultado.getDouble("lado_2"),
                    resultado.getDouble("lado_3")
            );
            listaEscalenos.add(escalenoTemp);
        } while (resultado.next());

        return listaEscalenos;
    }

    public static ArrayList<Isosceles> listarIsosceles() throws Exception {
        ArrayList<Isosceles> listaIsosceles = new ArrayList<>();

        String query = "SELECT * FROM t_isosceles";
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        if (!resultado.next()) {
            return null;
        }

        do {
            Isosceles isoscelesTemp = new Isosceles(
                    resultado.getDouble("lado_1"),
                    resultado.getDouble("lado_2"),
                    resultado.getDouble("lado_3")
            );
            listaIsosceles.add(isoscelesTemp);
        } while (resultado.next());

        return listaIsosceles;
    }
}