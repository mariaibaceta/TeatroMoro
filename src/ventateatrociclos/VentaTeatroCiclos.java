package ventateatrociclos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class VentaTeatroCiclos {

    //Variables Estaticas y de estancias para las ventas//
    
    static List<String> ventasAsientos = new ArrayList<>();
    static List<Integer> ventasPrecios = new ArrayList<>();
    public List<Integer> ventasDescuentos = new ArrayList<>() ;
    
    public static void main(String[] args) {
        
        VentaTeatroCiclos instancia = new VentaTeatroCiclos(); //Va de la mano con la variable de instancia//

        Scanner sc = new Scanner(System.in); // esto es lo que permite leer//
        
        //Declaramos la VARIABLES LOCALES que obtendra la opción del menu//
        int seleccionMenu = 0;
        int tipoEntrada;
        int tipoTarifa;
        int tarifaBase = 0;
        String numeroAsiento = "";
        int edad = 0;
        int precioFinal = 0;
        int descuentoPorEdad = 0;
        //DO-WHILE
        
        int totalAsientos = 20;
        
        LinkedList<String> asientos = new LinkedList<>(); // Arreglo con 20 posiciones (asientos)
        Boolean[] reservados = new Boolean[totalAsientos];
        String[] zonas = {"A","B","C","D"}; // Arreglo con zonas
        int cantXZona = 5;                  // Cantidad de asientos por Zona
        
        int s = 0; // Variable indice para arreglo asientos  //     
        
        //  bucle de zonas//
        for( int j = 0; j < zonas.length; j++ ){
            
            // bucle por cantidad de asientos//
            int x = 0;
            while ( x < cantXZona ){
                // Inserta asiento en arreglo 
                reservados[s] = false;
                asientos.add(zonas[j] + (x + 1));
                // asiento[0] = A1
                // asiento[1] = A2
                // asiento[2] = A3
                s++; 
                x++;
            }   
        }
        
        do {

            System.out.println("..........................");
            System.out.println("   Entradas Teatro Moro   ");
            System.out.println("..........................");
            System.out.println("Seleccione las opciones a realizar: ");
            System.out.println("1.- COMPRAR ENTRADA");
            System.out.println("2.- RESERVAR ENTRADA");
            System.out.println("3.- MODIFICAR VENTA");
            System.out.println("4.- IMPRIMIR BOLETA");
            System.out.println("5.- SALIR");
            System.out.println("6.- ELIMINAR VENTA");
            
            // validacion de entrada//
             while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido:");
                sc.next();
            }
            seleccionMenu = sc.nextInt();
            
            if (seleccionMenu < 1 || seleccionMenu > 6) { // Si ingresa un numero no indicado en el menu///
                System.out.println("Opcion no valida, Intente nuevamente."); 
                continue;
            }
            
            if (seleccionMenu == 5) {
                System.out.println("HASTA PRONTO!");
                break;
            }
            if (seleccionMenu == 4) {
                System.out.println("DEBE REALIZAR LA COMPRA");
            }
            if (seleccionMenu == 6) {
                System.out.println("Ingrese el número de asiento eliminar: ");
                numeroAsiento = sc.next();
                int indexEliminar = ventasAsientos.indexOf(numeroAsiento);

                if (indexEliminar != -1) {
                    ventasAsientos.remove(indexEliminar); 
                    ventasPrecios.remove(indexEliminar); 
                    instancia.ventasDescuentos.remove(indexEliminar);

                    System.out.println("Venta eliminada correctamente."); 
                } else { 
                    System.out.println("El asiento no tiene una venta registrada."); 
                } 

                continue; 
            } 

            if (seleccionMenu == 2) {
                // Lógica de reserva de asiento//
                System.out.println("Ingrese la zona y el numero de asiento a reservar - ejemplo: A1- : ");
                numeroAsiento = sc.next();
                boolean reservado = false;
                for (int i = 0; i < asientos.size(); i++) {
                    if (asientos.get(i).equals(numeroAsiento)) {
                        if (!reservados[i]) {
                            reservados[i] = true;
                            System.out.println("El asiento " + numeroAsiento + " ha sido reservado con éxito.");
                            reservado = true;
                            break;
                        } else {
                            System.out.println("El asiento " + numeroAsiento + " ya está reservado.");
                            reservado = true;
                            break;
                        }
                    }
                }
                if (!reservado) {
                    System.out.println("Asiento no válido.");
                }
                continue; // me muestra   el menú después de reservar//
            }

            if (seleccionMenu == 3) {
                // Lógica para modificar una venta
                System.out.println("Ingrese el número de asiento que desea modificar: ");
                numeroAsiento = sc.next();
                boolean encontrado = false;
                for (int i = 0; i < asientos.size(); i++) {
                    if (asientos.get(i).equals(numeroAsiento)) {
                        if (reservados[i]) {
                            System.out.println("Modificando venta para el asiento " + numeroAsiento);
                            reservados[i] = false; // Libera el asiento
                            System.out.println("El asiento " + numeroAsiento + " ha sido liberado. Puede realizar una nueva compra o reserva.");
                        } else {
                            System.out.println("El asiento " + numeroAsiento + " no ha sido reservado.");
                        }
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Asiento no encontrado.");
                }
                continue; // me muestra el menu despues de queerer modificar//
            }
            
            System.out.println("Tipos de Entrada: ");
            System.out.println("1.- VIP");
            System.out.println("2.- Platea baja");
            System.out.println("3.- Platea alta");
            System.out.println("4.- Palco");
            System.out.println("");
            System.out.println("Ingrese el numero del tipo de entrada: ");
            tipoEntrada = sc.nextInt();
            
            if (tipoEntrada > 4){
                System.out.println("Debe Elegir una opcion valida en tipo de entrada");
                break;
            }

            System.out.println("");
            System.out.println("Tipo de Tarifa: ");
            System.out.println("1.- Estudiante");
            System.out.println("2.- Publico General");
            System.out.println("");
            System.out.println("Ingrese el numero de su tipo de tarifa: ");
            System.out.println("");
            tipoTarifa = sc.nextInt();

            // Valida opcion ingresada anteriormente77
            if (tipoTarifa > 2 ){
                System.out.println("Ingrese opción válida");
                break;
            }

            
            //SELECCIONAR EL ASIENTO EL USUARIO//
            System.out.println("--------------------------------------------");
            System.out.println("----------- ESCENARIO TEATRO----------------");
            System.out.println("--------------------------------------------");
            System.out.println("Zona A VIP - Zona B Baja - Zona C Alta - Zona D Palco");
            System.out.println("-ZONA A      | ZONA B      | ZONA C      |ZONA D");
            System.out.println("-A1-A2-A3-A4 | B1-B2-B3-B4 | C1-C2-C3-C4 | D1-D2-D3-D4");
            System.out.println("-----------------------------------------------------");
            //lEER EL NUMERO DE ASIENTO//

            System.out.println("Ingrese la zona y el numero de asiento en mayuscula ");
            System.out.println("");
            numeroAsiento = sc.next();
            
            // INICIO VALIDACION ASIENTOS//
            boolean existe = false;
            boolean noDisponible = false;
                                  //0    1     2    3    4    5  //               
            //String[] asientos = {"A1","A2","A3","A4","A5"};
            // Validar que asiento ingresado este en arreglo Asientos//
            for (int i = 0; i < asientos.size(); i++) {
                if (asientos.get(i).equals(numeroAsiento)) {
                    existe = true;
                    
                    if ( reservados[i] == false ) {
                        reservados[i] = true;
                    } else {
                        noDisponible = true;
                    }
                    
                    break;
                }
            }
            
            if ( existe == false ) {
                System.out.println("Asiento ingresado no existe");
                continue;
            }
            
            if ( noDisponible == true ){
                System.out.println("Asiento no está disponible");
                continue;
            }
            // AQUI TERMINA LA VALIDACION ASIENTOS//

            System.out.println("Ingrese su edad ");
            System.out.println("");
            
            //validacion de entrada por edad//
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese una edad válida - Numero entero :");
                sc.next();
            }
            edad = sc.nextInt();

            // Tabla de precios //VARIABLES//
            
            int[][] precios = {
            //Estudiante-General//
                {20000, 30000},  // VIP
                {10000, 15000},  // Platea baja
                { 9000, 18000},  // Platea alta
                { 6500, 13000}   // Palco
            };

            tarifaBase = precios[tipoEntrada - 1][tipoTarifa - 1];

            if (edad >= 18 && edad < 60) {
                descuentoPorEdad = (int)(tarifaBase * 0.10); // 10%
            } else if (edad >= 60) {
                descuentoPorEdad = (int)(tarifaBase * 0.15); // 15%
            }

            precioFinal = tarifaBase - descuentoPorEdad;
            
            // LISTAS DE VENTA / Almacena datos de la venta/
            ventasAsientos.add(numeroAsiento);       
            ventasPrecios.add(precioFinal);           
            instancia.ventasDescuentos.add(descuentoPorEdad);  
            
            // Imprimir entrada//
            System.out.println("..........................");
            System.out.println("   Boleta de Entrada Teatro Moro   ");
            System.out.println("..........................");
            System.out.println("Ubicación del asiento " + (numeroAsiento));
            System.out.println("Precio base de la entrada " + (tarifaBase));
            System.out.println("Descuento aplicado  " + (descuentoPorEdad));
            System.out.println("Precio final a pagar  " + (precioFinal));
            System.out.println("..........................");
            
            System.out.println("¿Desea realizar otra compra? Favor seleccione la opcion a continuacion");
            
         } while (seleccionMenu < 7); // Con esto dejo que vuelva al menu despues de eliminar un asiento vendido//
            
    }
}
         //YAPROFE UTILICE Y/O REEMPLACE EL UN ARRAY LIST POR LINKEDLIST //
         