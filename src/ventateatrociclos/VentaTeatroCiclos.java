package ventateatrociclos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
        

public class VentaTeatroCiclos {
    
    //Variabless de estancia y estaticas//
    
    static List<String> ventasAsientos = new ArrayList<>();
    static List<Integer> ventasPrecios = new ArrayList<>();
    static List<Integer> ventasEdadCliente = new ArrayList<>() ;
    static List<Integer> ventasDescuentos = new ArrayList<>();
    
    
 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // esto es lo que permite leer//
        //Declaramos la variable que obtendra la opción del menu//
        int seleccionMenu = 0;
        int tipoEntrada;
        int tipoTarifa;
        int tarifaBase = 0;
        String numeroAsiento = "";
        int edad = 0;
        int precioFinal = 0;
        int descuentoPorEdad = 0;
        
        //Variables locales para mllevar el control de venta// 
        List<String> ventasLocalesAsientos = new ArrayList<>();
        List<Integer> ventasLocalesPrecios = new ArrayList<>();
        List<Integer> ventasLocalesEdadCliente = new ArrayList<>();
        
        
        //DO-WHILE
        
        int totalAsientos = 20;
        
        String[] asientos = new String[totalAsientos]; // Arreglo con 20 posiciones (asientos)
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
                asientos[s] = zonas[j] + ( x + 1 );
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
            seleccionMenu = sc.nextInt();
            
            if (seleccionMenu == 5) {
                System.out.println("HASTA PRONTO!");
                break;
            }
            if (seleccionMenu == 4) {
                System.out.println("DEBE REALIZAR LA COMPRA");
            }

            if (seleccionMenu == 2) {
                // Lógica de reserva de asiento//
                System.out.println("Ingrese la zona y el numero de asiento a reservar (ejemplo: A1): ");
                numeroAsiento = sc.next();
                boolean reservado = false;
                for (int i = 0; i < asientos.length; i++) {
                    if (asientos[i].equals(numeroAsiento)) {
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
                continue; // me muestra  el menú después de reservar//
            }

            if (seleccionMenu == 3) {
                // Lógica para modificar una venta
                System.out.println("Ingrese el número de asiento que desea modificar: ");
                numeroAsiento = sc.next();
                boolean encontrado = false;
                for (int i = 0; i < asientos.length; i++) {
                    if (asientos[i].equals(numeroAsiento)) {
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
            for (int i = 0; i < asientos.length; i++ ){
                if (asientos[i].equals(numeroAsiento) ){
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
            edad = sc.nextInt();

            // Estudiante// //VARIABLES//
            int vipE = 20000;
            int pBajaE = 10000;
            int pAltaE = 9000;
            int palcoE = 6500;

            // General//
            int vipG = 30000;
            int pBajaG = 15000;
            int pAltaG = 18000;
            int palcoG = 13000;

            // Si la entrada es VIP y Tipo Tarifa es estudiante//
            if (tipoEntrada == 1 && tipoTarifa == 1) {
               //AQUI SE DEBE CALCULAR EL PRECIO BASE QUE ES TIPO DE ENTRADA - TIPO DE TARIFA//
                tarifaBase = vipE;
                if (edad >= 18 && edad < 60) {
                    descuentoPorEdad = 2000;
                    precioFinal = tarifaBase - descuentoPorEdad;
                } else if (edad >= 60) {
                    descuentoPorEdad = 3000;
                    precioFinal = tarifaBase - descuentoPorEdad;
                }
            } // Si la entrada es VIP y Tarifa es Publico general//
            else if (tipoEntrada == 1 && tipoTarifa == 2) {
                
                tarifaBase = vipG;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 3000;
                    descuentoPorEdad = 3000;
                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 4500;
                    descuentoPorEdad = 4500;
                }
            } 
            
            ventasAsientos.add(numeroAsiento);
            ventasPrecios.add(precioFinal);
            ventasEdadCliente.add(edad);
            
            ventasLocalesAsientos.add(numeroAsiento);
            ventasLocalesPrecios.add(precioFinal);
            ventasLocalesEdadCliente.add(edad);
            ventasDescuentos.add(descuentoPorEdad); 
            
            
            
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
            
        } while (seleccionMenu < 4);
        
        //RESUEM FINAL DE LAS VENTAS//
         System.out.println(" ACA SE ENCUENTRA EL RESUMEN DE VENTAS ------");
        for (int i = 0; i < ventasAsientos.size(); i++) {
            System.out.println("Asiento: " + ventasAsientos.get(i) +
                               " | Precio Final: $" + ventasPrecios.get(i) +
                               " | Descuento Aplicado: $" + ventasDescuentos.get(i));
        }
        System.out.println("Gracias por su visita el teatro moro");
    }
}   
   
