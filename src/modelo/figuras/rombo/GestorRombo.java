package modelo.figuras.rombo;

public class GestorRombo {
    public static String agregarRombo(double lado, double diagonalMayor, double diagonalMenor) throws Exception {
        Rombo nuevoRombo = new Rombo(lado, diagonalMayor, diagonalMenor);
        return DAORombo.insertarRombo(nuevoRombo);
    }

    public static void listarRombos() throws Exception {
        System.out.println("TODO");
    }
}
