package controlador;

import modelo.Coleccion;
import modelo.cuerpos.Cubo;
import modelo.cuerpos.Esfera;
import modelo.cuerpos.Tetraedro;
import modelo.figuras.Cuadrado;
import modelo.figuras.Triangulos.Equilatero;
import modelo.figuras.Triangulos.Escaleno;
import modelo.figuras.Triangulos.Isosceles;
import modelo.figuras.Triangulos.Triangulo;
import vista.Menu;
import modelo.cuerpos.Cilindro;
import modelo.figuras.Circulo;

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
        int radio = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del radio:");
        int altura = menu.pedirEnteroPositivo(scanner, "Introduzca la medida de la altura:");

        Circulo base = new Circulo(radio);
        coleccion.agregarCuerpo(new Cilindro(base, altura));

        menu.mostrarMensaje("# Cilindro creado #");
    }

    private void crearCubo() {
        int lado = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del lado:");

        Cuadrado cara = new Cuadrado(lado);
        coleccion.agregarCuerpo(new Cubo(cara));

        menu.mostrarMensaje("# Cubo creado #");
    }

    private void crearEsfera() {
        int radio = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del radio:");

        coleccion.agregarCuerpo(new Esfera(radio));

        menu.mostrarMensaje("# Esfera creada #");
    }

    private void crearTetraedro() {
        while (true) {
            int lado1 = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del primer lado:");
            int lado2 = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del segundo lado:");
            int lado3 = menu.pedirEnteroPositivo(scanner, "Introduzca la medida del tercer lado:");

            if (!esTrianguloValido(lado1, lado2, lado3)) {
                menu.mostrarMensaje("Los lados no forman un triángulo válido.");
                continue;
            }

            int altura = menu.pedirEnteroPositivo(scanner, "Introduzca la altura del tetraedro:");

            Triangulo cara;

            if (lado1 == lado2 && lado2 == lado3) {
                cara = new Equilatero(lado1, lado2, lado3);
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                cara = new Isosceles(lado1, lado2, lado3);
            } else {
                cara = new Escaleno(lado1, lado2, lado3);
            }

            coleccion.agregarCuerpo(new Tetraedro(cara, altura));
            menu.mostrarMensaje("# Tetraedro creado #");
            break;
        }
    }

    private boolean esTrianguloValido(int lado1, int lado2, int lado3) {
        return lado1 + lado2 > lado3 &&
                lado1 + lado3 > lado2 &&
                lado2 + lado3 > lado1;
    }
}


