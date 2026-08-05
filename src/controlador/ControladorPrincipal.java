package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.cuerpos.Cuerpo;
import modelo.cuerpos.cilindro.GestorCilindro;
import modelo.cuerpos.cubo.GestorCubo;
import modelo.cuerpos.esfera.GestorEsfera;
import modelo.cuerpos.tetraedro.GestorTetraedro;
import modelo.figuras.Figura;
import modelo.figuras.circulo.GestorCirculo;
import modelo.figuras.cuadrado.GestorCuadrado;
import modelo.figuras.rectangulo.GestorRectangulo;
import modelo.figuras.rombo.GestorRombo;
import modelo.figuras.triangulos.GestorTriangulo;
import vista.Menu;
import modelo.Coleccion;

public class ControladorPrincipal {
    private final Menu menu;
    private final Coleccion coleccion;
    private final Scanner scanner;
    private final ControladorFigura controladorFigura;
    private final ControladorCuerpo controladorCuerpo;

    public ControladorPrincipal(Menu menu, Coleccion coleccion) {
        this.menu = menu;
        this.coleccion = coleccion;
        this.scanner = new Scanner(System.in);

        this.controladorFigura = new ControladorFigura(
                this.menu,
                this.coleccion,
                this.scanner
        );

        this.controladorCuerpo = new ControladorCuerpo(
                this.menu,
                this.coleccion,
                this.scanner
        );
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = menu.menuInicio(scanner);

            switch (opcion) {
                case 1:
                    controladorFigura.crearFigura();
                    break;

                case 2:
                    controladorCuerpo.crearCuerpo();
                    break;

                case 3:
                    menu.mostrarMensaje("LISTA DE FIGURAS:");
                    menu.mostrarLista(coleccion.listarFiguras());
                    break;

                case 4:
                    menu.mostrarMensaje("LISTA DE CUERPOS:");
                    menu.mostrarLista(coleccion.listarCuerpos());
                    break;

                case 5:
                    menu.mostrarMensaje("Área total: " + calcularAreaTotal());
                    break;

                case 6:
                    menu.mostrarMensaje("Perímetro total: " + coleccion.calcularPerimetroTotal());
                    break;

                case 7:
                    menu.mostrarMensaje("Volumen total: " + coleccion.calcularVolumenTotal());
                    break;

                case 8:
                    salir = true;
                    break;

                default:
                    menu.mostrarMensaje("Opción inválida.");
                    break;
            }
        }

        scanner.close();
    }

    public static double calcularAreaTotal() throws Exception {
        // Figuras
        ArrayList<Figura> listaFiguras = new ArrayList<>();
        GestorCirculo.listarCirculos(listaFiguras);
        GestorCuadrado.listarCuadrados(listaFiguras);
        GestorRectangulo.listarRectangulos(listaFiguras);
        GestorRombo.listarRombos(listaFiguras);
        GestorTriangulo.listarTriangulos(listaFiguras);

        // Cuerpos
        ArrayList<Cuerpo> listaCuerpos = new ArrayList<>();
        GestorCilindro.listarCilindros(listaCuerpos);
        GestorCubo.listarCubos(listaCuerpos);
        GestorEsfera.listarEsfera(listaCuerpos);
        GestorTetraedro.listarTetraedros(listaCuerpos);

        double areaAcumulada = 0;
        for (Figura figuraTemp : listaFiguras) {
            areaAcumulada += figuraTemp.calcularArea();
        }
        for (Cuerpo cuerpoTemp : listaCuerpos) {
            areaAcumulada += cuerpoTemp.calcularArea();
        }

        return areaAcumulada;
    }

    public static double calcularPerimetroTotal() throws Exception {
        // Figuras
        ArrayList<Figura> listaFiguras = new ArrayList<>();
        GestorCirculo.listarCirculos(listaFiguras);
        GestorCuadrado.listarCuadrados(listaFiguras);
        GestorRectangulo.listarRectangulos(listaFiguras);
        GestorRombo.listarRombos(listaFiguras);
        GestorTriangulo.listarTriangulos(listaFiguras);

        // Cuerpos
        ArrayList<Cuerpo> listaCuerpos = new ArrayList<>();
        GestorCilindro.listarCilindros(listaCuerpos);
        GestorCubo.listarCubos(listaCuerpos);
        GestorEsfera.listarEsfera(listaCuerpos);
        GestorTetraedro.listarTetraedros(listaCuerpos);

        double perimetroAcumulado = 0;

        for (Figura figuraTemp : listaFiguras) {
            perimetroAcumulado += figuraTemp.calcularPerimetro();
        }
        for (Cuerpo cuerpoTemp : listaCuerpos) {
            perimetroAcumulado += cuerpoTemp.calcularPerimetro();
        }

        return perimetroAcumulado;
    }
}