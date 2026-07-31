package modelo.cuerpos.tetraedro;

import modelo.figuras.triangulos.GestorTriangulo;

public class GestorTetraedro {

    public static String agregarTetraedro(double lado, double altura) throws Exception {
        // Al ser un Tetraedro según la BD, la base DEBE ser Equilátera (3 lados iguales)
        GestorTriangulo.agregarTriangulo(lado, lado, lado);
        return DAOTetraedro.insertarTetraedro(altura, 1);
    }
}