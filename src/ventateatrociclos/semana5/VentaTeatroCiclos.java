package ventateatrociclos;

import java.util.Scanner;

public class VentaTeatroCiclos {
    
    //no usar array ni listas// 

    static class Entrada {
        String numero;
        String ubicacion;
        String tipoCliente;
        int edad;
        int precioBase;
        int descuento;
        int precioFinal;

        public Entrada(String numero, String ubicacion, String tipoCliente, int edad, int precioBase, int descuento, int precioFinal) {
            this.numero = numero;
            this.ubicacion = ubicacion;
            this.tipoCliente = tipoCliente;
            this.edad = edad;
            this.precioBase = precioBase;
            this.descuento = descuento;
            this.precioFinal = precioFinal;
        }
    }
//consdiderare un total de 100 entradas segun profe reemplazo//
    static Entrada[] entradasVendidas = new Entrada[100];
    static int totalEntradas = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("---- Menú Principal ---");
            System.out.println("-----------------------");
            System.out.println("1 Venta de entradas");
            System.out.println("2 Mostrar promociones");
            System.out.println("3 Buscar entradas");
            System.out.println("4 Eliminar entrada");
            System.out.println("5 Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> venderEntrada();
                case 2 -> mostrarPromociones();
                case 3 -> buscarEntradas();
                case 4 -> eliminarEntrada();
                case 5 -> System.out.println("Hasta Pronto!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    static void venderEntrada() {
        if (totalEntradas >= entradasVendidas.length) {
            System.out.println("No se pueden registrar más entradas.");
            return;
        }

        sc.nextLine(); 
        System.out.println("Ingrese ubicación (VIP, PLATEA BAJA, PLATEA ALTA - PALCO - GENERAL): ");
        String ubicacion = sc.nextLine();

        System.out.println("Ingrese tipo de cliente (Estudiante, TerceraEdad, General): ");
        String tipoCliente = sc.nextLine();

        System.out.println("Ingrese edad: ");
        int edad = sc.nextInt();

        System.out.println("Ingrese número de entrada: ");
        String numero = sc.next();

        int precioBase = switch (ubicacion.toLowerCase()) {
            case "vip" -> 30000;
            case "platea" -> 20000;
            default -> 15000;
        };

        int descuento = 0;
        if (tipoCliente.equalsIgnoreCase("Estudiante")) {
            descuento += precioBase * 0.10;
        }
        if (tipoCliente.equalsIgnoreCase("TerceraEdad") || edad >= 60) {
            descuento += precioBase * 0.15;
        }

        int precioFinal = precioBase - descuento;

        entradasVendidas[totalEntradas] = new Entrada(numero, ubicacion, tipoCliente, edad, precioBase, descuento, precioFinal);
        totalEntradas++;

        System.out.println("Su precio final a pagar es: $" + precioFinal);
    }

    static void mostrarPromociones() {
        System.out.println("Promociones Disponibles:");
        System.out.println("- 10% de descuento para estudiantes");
        System.out.println("- 15% de descuento para personas de la tercera edad (60+ años)");
        System.out.println("- Descuentos acumulables si se cumplen ambas condiciones");
    }

    static void buscarEntradas() {
        sc.nextLine();
        System.out.println("Buscar por: 1) Número 2) Ubicación 3) Tipo de cliente");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese criterio de búsqueda: ");
        String criterio = sc.nextLine();

        System.out.println("Resultados de la búsqueda:");
        for (int i = 0; i < totalEntradas; i++) {
            Entrada e = entradasVendidas[i];
            if ((tipo == 1 && e.numero.equalsIgnoreCase(criterio)) ||
                (tipo == 2 && e.ubicacion.equalsIgnoreCase(criterio)) ||
                (tipo == 3 && e.tipoCliente.equalsIgnoreCase(criterio))) {
                System.out.println("Entrada: " + e.numero + " | Ubicación: " + e.ubicacion + " | Tipo: " + e.tipoCliente +
                        " | Edad: " + e.edad + " | Precio final: $" + e.precioFinal);
            }
        }
    }

    static void eliminarEntrada() {
        sc.nextLine();
        System.out.print("Ingrese número de entrada a eliminar: ");
        String numero = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < totalEntradas; i++) {
            if (entradasVendidas[i].numero.equalsIgnoreCase(numero)) {
                for (int j = i; j < totalEntradas - 1; j++) {
                    entradasVendidas[j] = entradasVendidas[j + 1];
                }
                entradasVendidas[totalEntradas - 1] = null;
                totalEntradas--;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Entrada eliminada Ccorrectamente.");
        } else {
            System.out.println("Entrada no encontrada!.");
        }
    }
}

