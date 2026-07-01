package vista;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public int menuInicio(Scanner scanner) {
        System.out.println("---Formas y Cuerpos Geométricos----");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear y Añadir una nueva figura geométrica");
        System.out.println("2. Crear y Añadir un nuevo cuerpo geométrico");
        System.out.println("3. Listar Todas las figuras creadas");
        System.out.println("4. Listar Todos los cuerpos creados");
        System.out.println("5. Calcular Área total de la colección");
        System.out.println("6. Calcular Perímetro total de la colección");
        System.out.println("7. Calcular Volumen total de la colección");
        System.out.println("8. Salir");
        System.out.println("Ingrese una opción:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuCrearFigura(Scanner scanner) {
        System.out.println("Seleccione una figura para crear:");
        System.out.println("1. Cuadrado");
        System.out.println("2. Circulo");
        System.out.println("3. Rectángulo");
        System.out.println("4. Rombo");
        System.out.println("5. Triángulo");
        System.out.println("Ingrese una opción:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuCrearCuerpo(Scanner scanner) {
        System.out.println("Seleccione una cuerpo para crear:");
        System.out.println("1. Cilindro");
        System.out.println("2. Cubo");
        System.out.println("3. Esfera");
        System.out.println("4. Tetraedro");
        System.out.println("Ingrese una opción:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int pedirEnteroPositivo(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                int numero = Integer.parseInt(scanner.nextLine());

                if (numero > 0) {
                    return numero;
                }

                System.out.println("El número debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarLista(ArrayList<?> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay elementos registrados.");
            return;
        }

        for (Object elemento : lista) {
            System.out.println(elemento);
        }
    }
}