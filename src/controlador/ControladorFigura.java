package controlador;

import modelo.Coleccion;
import modelo.figuras.Circulo;
import modelo.figuras.Cuadrado;
import modelo.figuras.Rectangulo;
import modelo.figuras.Rombo;
import modelo.figuras.Triangulos.Equilatero;
import modelo.figuras.Triangulos.Escaleno;
import modelo.figuras.Triangulos.Isosceles;
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
        int lado = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del lado:");
        coleccion.agregarFigura(new Cuadrado(lado));
        menu.mostrarMensaje("# Cuadrado creado #");
    }

    private void crearCirculo() {
        int radio = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del radio:");
        coleccion.agregarFigura(new Circulo(radio));
        menu.mostrarMensaje("# Círculo creado #");
    }

    private void crearRectangulo() {
        int base = menu.pedirEnteroPositivo(scanner, "Introduzca la medida de la base:");
        int altura = menu.pedirEnteroPositivo(scanner, "Introduzca la medida de la altura:");

        coleccion.agregarFigura(new Rectangulo(base, altura));
        menu.mostrarMensaje("# Rectángulo creado #");
    }

    private void crearRombo() {
        while (true) {
            int lado = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del lado:");
            int diagonalMayor = menu.pedirEnteroPositivo(scanner, "Introduzca la medida de la diagonal mayor:");
            int diagonalMenor = menu.pedirEnteroPositivo(scanner, "Introduzca la medida de la diagonal menor:");

            if (diagonalMayor > diagonalMenor) {
                coleccion.agregarFigura(new Rombo(lado, diagonalMayor, diagonalMenor));
                menu.mostrarMensaje("# Rombo creado #");
                break;
            }

            menu.mostrarMensaje("La diagonal mayor debe ser más grande que la diagonal menor.");
        }
    }

    private void crearTriangulo() {
        while (true) {
            int lado1 = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del primer lado:");
            int lado2 = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del segundo lado:");
            int lado3 = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del tercer lado:");

            if (!esTrianguloValido(lado1, lado2, lado3)) {
                menu.mostrarMensaje("Los lados no forman un triángulo válido.");
                continue;
            }

            if (lado1 == lado2 && lado2 == lado3) {
                coleccion.agregarFigura(new Equilatero(lado1, lado2, lado3));
                menu.mostrarMensaje("# Triángulo Equilátero creado #");
                break;
            }

            if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                coleccion.agregarFigura(new Isosceles(lado1, lado2, lado3));
                menu.mostrarMensaje("# Triángulo Isósceles creado #");
                break;
            }

            coleccion.agregarFigura(new Escaleno(lado1, lado2, lado3));
            menu.mostrarMensaje("# Triángulo Escaleno creado #");
            break;
        }
    }

    private boolean esTrianguloValido(int lado1, int lado2, int lado3) {
        return lado1 + lado2 > lado3 &&
                lado1 + lado3 > lado2 &&
                lado2 + lado3 > lado1;
    }
}
