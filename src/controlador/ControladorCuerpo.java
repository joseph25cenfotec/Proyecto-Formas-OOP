package controlador;

import modelo.Coleccion;
import modelo.cuerpos.cilindro.GestorCilindro;
import modelo.cuerpos.cubo.GestorCubo;
import modelo.cuerpos.esfera.GestorEsfera;
import modelo.cuerpos.tetraedro.GestorTetraedro;
import vista.Menu;

import java.util.Scanner;

public class ControladorCuerpo {
    private Menu menu;
    private Coleccion coleccion;
    private Scanner scanner;

    public ControladorCuerpo(Menu menu, Coleccion coleccion, Scanner scanner) {
        this.menu = menu;
        this.coleccion = coleccion;
        this.scanner = scanner;
    }

    public void crearCuerpo() {
        int opcionCuerpo = menu.menuCrearCuerpo(scanner);

        switch (opcionCuerpo) {
            case 1:
                crearCilindro();
                break;
            case 2:
                crearCubo();
                break;
            case 3:
                crearEsfera();
                break;
            case 4:
                crearTetraedro();
                break;
            default:
                menu.mostrarMensaje("Opción inválida.");
                break;
        }
    }

    private void crearCilindro() {
        try {
            double radio = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del radio:");
            double altura = menu.pedirNumeroPositivo(scanner, "Introduzca la medida de la altura:");

            String respuesta = GestorCilindro.agregarCilindro(radio, altura);
            menu.mostrarMensaje(respuesta);
            menu.mostrarMensaje("# Cilindro creado #");
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es un número válido.");
        } catch (Exception e) {
            menu.mostrarMensaje("Error al crear Cilindro: " + e.getMessage());
        }
    }

    private void crearCubo() {
        try {
            double lado = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del lado:");

            String respuesta = GestorCubo.agregarCubo(lado);
            menu.mostrarMensaje(respuesta);
            menu.mostrarMensaje("# Cubo creado #");
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es un número válido.");
        } catch (Exception e) {
            menu.mostrarMensaje("Error al crear Cubo: " + e.getMessage());
        }
    }

    private void crearEsfera() {
        try {
            double radio = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del radio:");

            String respuesta = GestorEsfera.agregarEsfera(radio);
            menu.mostrarMensaje(respuesta);
            menu.mostrarMensaje("# Esfera creada #");
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es un número válido.");
        } catch (Exception e) {
            menu.mostrarMensaje("Error al crear Esfera: " + e.getMessage());
        }
    }

    private void crearTetraedro() {
        try {
            double lado = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del lado de la cara equilátera:");
            double altura = menu.pedirNumeroPositivo(scanner, "Introduzca la altura del tetraedro:");

            String respuesta = GestorTetraedro.agregarTetraedro(lado, altura);
            menu.mostrarMensaje(respuesta);
            menu.mostrarMensaje("# Tetraedro creado #");
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es un número válido.");
        } catch (Exception e) {
            menu.mostrarMensaje("Error al crear Tetraedro: " + e.getMessage());
        }
    }
}