package modelo.figuras.triangulos;

import datos.Connector;

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
}