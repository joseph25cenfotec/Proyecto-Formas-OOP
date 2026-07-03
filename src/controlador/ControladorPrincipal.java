package controlador;

import java.util.Scanner;

import vista.Menu;
import modelo.Coleccion;


public class ControladorPrincipal {
    private Menu menu;
    private Coleccion coleccion;
    private Scanner scanner;

    ControladorFigura controladorFigura = new ControladorFigura(menu, coleccion, scanner);
    ControladorCuerpo controladorCuerpo = new ControladorCuerpo(menu, coleccion, scanner);

    public ControladorPrincipal(Menu menu, Coleccion coleccion) {
        this.menu = menu;
        this.coleccion = coleccion;
        this.scanner = new Scanner(System.in);
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
                    menu.mostrarMensaje("Área total: " + coleccion.calcularAreaTotal());
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
    }
}