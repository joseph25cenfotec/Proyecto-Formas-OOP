package controlador;

import java.util.Scanner;
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

        scanner.close();
    }
}