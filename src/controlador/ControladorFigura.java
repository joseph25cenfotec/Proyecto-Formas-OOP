package controlador;

import modelo.Coleccion;

import modelo.figuras.Figura;
import modelo.figuras.circulo.GestorCirculo;
import modelo.figuras.cuadrado.GestorCuadrado;
import modelo.figuras.rectangulo.GestorRectangulo;
import modelo.figuras.rombo.GestorRombo;
import modelo.figuras.triangulos.GestorTriangulo;

import utils.Utils;
import vista.Menu;

import java.util.ArrayList;
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

    public void crearTriangulo() {
        int opcionTriangulo = menu.menuCrearTriangulo(scanner);

        switch (opcionTriangulo) {
            case 1:
                crearEquilatero();
                break;

            case 2:
                crearEscaleno();
                break;

            case 3:
                crearIsosceles();
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

    private void crearEquilatero() {
        while (true) {
            try {
                double lado = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del lado:");

                double lado1 = lado;
                double lado2 = lado;
                double lado3 = lado;

                if (!Utils.esTrianguloValido(lado1, lado2, lado3)) {
                    menu.mostrarMensaje("Los lados no forman un triángulo válido.");
                    continue;
                }

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

    private void crearEscaleno() {
        while (true) {
            try {
                double lado1 = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del primer lado:");
                double lado2 = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del segundo lado:");
                double lado3 = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del tercer lado:");

                if (!Utils.esTrianguloValido(lado1, lado2, lado3)) {
                    menu.mostrarMensaje("Los lados no forman un triángulo válido.");
                    continue;
                }

                if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                    menu.mostrarMensaje("Los lados ingresados no forman un triángulo escaleno.");
                    continue;
                }

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

    private void crearIsosceles() {
        while (true) {
            try {
                double ladoIgual = menu.pedirNumeroPositivo(scanner, "Introduzca la medida de los dos lados iguales:");
                double ladoDistinto = menu.pedirNumeroPositivo(scanner, "Introduzca la medida del lado distinto:");

                double lado1 = ladoIgual;
                double lado2 = ladoIgual;
                double lado3 = ladoDistinto;

                if (!Utils.esTrianguloValido(lado1, lado2, lado3)) {
                    menu.mostrarMensaje("Los lados no forman un triángulo válido.");
                    continue;
                }

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

    public void listarFiguras() throws Exception{
        ArrayList<Figura> listaFiguras = new ArrayList<>();
        GestorCirculo.listarCirculos(listaFiguras);
        GestorCuadrado.listarCuadrados(listaFiguras);
        GestorRectangulo.listarRectangulos(listaFiguras);
        GestorRombo.listarRombos(listaFiguras);
        GestorTriangulo.listarTriangulos(listaFiguras);

        for (Figura figuraTemp : listaFiguras) {
            System.out.println(figuraTemp);
        }
    }
}
