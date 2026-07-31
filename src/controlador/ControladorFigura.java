package controlador;

import modelo.Coleccion;

import modelo.figuras.circulo.GestorCirculo;
import modelo.figuras.cuadrado.GestorCuadrado;
import modelo.figuras.rectangulo.GestorRectangulo;
import modelo.figuras.rombo.GestorRombo;
import modelo.figuras.triangulos.GestorTriangulo;

import utils.Utils;
import vista.Menu;

import java.util.Scanner;

public class ControladorFigura {
    private Menu menu;
    private Coleccion coleccion;
    private Scanner scanner;

    public ControladorFigura(Menu menu, Coleccion coleccion, Scanner scanner) {
        this.menu = menu;
        this.coleccion = coleccion;
        this.scanner = scanner;
    }

    public void crearFigura() {
        int opcionFigura = menu.menuCrearFigura(scanner);

        switch (opcionFigura) {
            case 1:
                crearCuadrado();
                break;

            case 2:
                crearCirculo();
                break;

            case 3:
                crearRectangulo();
                break;

            case 4:
                crearRombo();
                break;

            case 5:
                crearTriangulo();
                break;

            default:
                menu.mostrarMensaje("Opción inválida.");
                break;
        }
    }

    private void crearCuadrado() {
        try {
            double lado = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del lado:");
            System.out.println(GestorCuadrado.agregarCuadrado(lado));
            menu.mostrarMensaje("# Cuadrado creado #");
        } catch (NumberFormatException e){
            System.out.println("El dato ingresado no es un número válido");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void crearCirculo() {
        try {
            double radio = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del radio:");
            System.out.println(GestorCirculo.agregarCirculo(radio));
            menu.mostrarMensaje("# Círculo creado #");
        } catch (NumberFormatException e){
            System.out.println("El dato ingresado no es un número válido");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void crearRectangulo() {
        try {
            double base = menu.pedirNumeroPositivo(scanner, "Introduzca la medida de la base:");
            double altura = menu.pedirNumeroPositivo(scanner, "Introduzca la medida de la altura:");
            System.out.println(GestorRectangulo.agregarRectangulo(base, altura));
            menu.mostrarMensaje("# Rectángulo creado #");
        } catch (NumberFormatException e){
            System.out.println("El dato ingresado no es un número válido");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void crearRombo() {
        try {
            double lado = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del lado:");
            double diagonalMayor = menu.pedirNumeroPositivo(scanner, "Introduzca la medida de la diagonal mayor:");
            double diagonalMenor = menu.pedirNumeroPositivo(scanner, "Introduzca la medida de la diagonal menor:");

            if (diagonalMayor > diagonalMenor) {
                System.out.println(GestorRombo.agregarRombo(lado, diagonalMayor, diagonalMenor));
                menu.mostrarMensaje("# Rombo creado #");
            } else {
                System.out.println("Las Diagonales son inválidas, la Diagonal Mayor no puede ser menor que la Diagonal menor");
            }

            menu.mostrarMensaje("La diagonal mayor debe ser más grande que la diagonal menor.");
        } catch (NumberFormatException e){
            System.out.println("El dato ingresado no es un número válido");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void crearTriangulo() {
        while (true) {
            try {
                double lado1 = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del primer lado:");
                double lado2 = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del segundo lado:");
                double lado3 = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del tercer lado:");

                if (!Utils.esTrianguloValido(lado1, lado2, lado3)) {
                    menu.mostrarMensaje("Los lados no forman un triángulo válido.");
                    continue;
                }

                // Llamada directa al Gestor enviando únicamente los 3 lados
                String respuesta = GestorTriangulo.agregarTriangulo(lado1, lado2, lado3);
                menu.mostrarMensaje(respuesta);
                break;

            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es un número válido.");
            } catch (Exception e) {
                menu.mostrarMensaje("Error al guardar el triángulo: " + e.getMessage());
                break;
            }
        }
    }
}
