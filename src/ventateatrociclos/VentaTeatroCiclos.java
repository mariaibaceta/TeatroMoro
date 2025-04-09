package ventateatrociclos;

import java.util.Scanner;

public class VentaTeatroCiclos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // esto es lo que permite leer//
        //Declaramos la variable que obtendra la opción del menu//
        int seleccionMenu=0;
        int tipoEntrada;
        int tipoTarifa;
        int tarifaBase = 0;
        String numeroAsiento = "";
        int edad = 0;
        int precioFinal = 0;
        int descuentoPorEdad = 0;
        //DO-WHILE
        do {

            System.out.println("..........................");
            System.out.println("   Entradas Teatro Moro   ");
            System.out.println("..........................");
            System.out.println("Seleccione las opciones a realizar: ");
            System.out.println("1.- COMPRAR ENTRADA");
            System.out.println("2.- SALIR");
            seleccionMenu = sc.nextInt();

            System.out.println("Tipos de Entrada: ");
            System.out.println("1.- VIP");
            System.out.println("2.- Platea baja");
            System.out.println("3.- Platea alta");
            System.out.println("4.- Palco");
            System.out.println("");
            System.out.println("Ingrese el numero del tipo de entrada: ");
            tipoEntrada = sc.nextInt();
            
            if (tipoEntrada>4){
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

            //SELECCIONAR EL ASIENTO
            System.out.println("--------------------------------------------");
            System.out.println("----------- ESCENARIO TEATRO----------------");
            System.out.println("--------------------------------------------");
            System.out.println("Zona A VIP - Zona B Baja - Zona C Alta - Zona D Palco");
            System.out.println("-ZONA A      | ZONA B      | ZONA C      |ZONA D");
            System.out.println("-A1-A2-A3-A4 | B1-B2-B3-B4 | C1-C2-C3-C4 | D1-D2-D3-D4");
            System.out.println("-A5-A6-A7-A8 | B5-B6-B7-B8 | C5-C6-C7-C8 | D5-D6-D7-D8");
            System.out.println("-----------------------------------------------------");
            //lEER EL NUMERO DE ASIENTO

            System.out.println("Ingrese la zona y el numero de asiento ");
            System.out.println("");
            numeroAsiento = sc.next();

            System.out.println("Ingrese su edad ");
            System.out.println("");
            edad = sc.nextInt();

            //Estudiante// //VARIABLES//
            int vipE = 20000;
            int pBajaE = 10000;
            int pAltaE = 9000;
            int palcoE = 6500;

            //General//
            int vipG = 30000;
            int pBajaG = 15000;
            int pAltaG = 18000;
            int palcoG = 13000;

            //Si la entrada es VIP y Tipo Tarifa es estudiante//
            if (tipoEntrada == 1 && tipoTarifa == 1) {
                //Calculos
                //AQUI SE DEBE CALCULAR EL PRECIO BASE QUE ES TIPO DE ENTRADA - TIPO DE TARIFA//
                tarifaBase = vipE;
                if (edad >= 18 && edad < 60) {
                    descuentoPorEdad= 2000;
                    precioFinal = tarifaBase - 2000;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 3000;
                    descuentoPorEdad= 3000;
                }
            } // Si la entrada es VIP y Tarifa es Publico general//
            else if (tipoEntrada == 1 && tipoTarifa == 2) {
                
                tarifaBase = vipG;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 3000;
                    descuentoPorEdad= 3000;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 4500;
                    descuentoPorEdad= 4500;}
         //--------------------------------------------------------//       
            } else if (tipoEntrada == 2 && tipoTarifa == 1) {
                tarifaBase = pBajaE;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 1000;
                    descuentoPorEdad= 1000;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 1500;
                    descuentoPorEdad= 1500;}
                
          //-------------------------------------------------------//

            } else if (tipoEntrada == 2 && tipoTarifa == 2) {
                tarifaBase = pBajaG;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 1500;
                    descuentoPorEdad= 1500;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 2250;
                    descuentoPorEdad= 2250;}
               
           //-------------------------------------------------------//
                
            } else if (tipoEntrada == 3 && tipoTarifa == 1) {
                tarifaBase = pAltaE;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 900;
                    descuentoPorEdad= 900;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 1350;
                    descuentoPorEdad= 1350;}
                
            //-------------------------------------------------------//
            
            } else if (tipoEntrada == 3 && tipoTarifa == 2) {
                tarifaBase = pAltaG;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 1800;
                    descuentoPorEdad= 1800;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 2700;
                    descuentoPorEdad= 2700;}
                
             //-------------------------------------------------------//
            

            } else if (tipoEntrada == 4 && tipoTarifa == 1) {
                tarifaBase = palcoE;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 650;
                    descuentoPorEdad= 650;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 975;
                    descuentoPorEdad= 975;}

             //-------------------------------------------------------//    
                
            } else if (tipoEntrada == 4 && tipoTarifa == 2) {
                tarifaBase = palcoG;
                if (edad >= 18 && edad < 60) {
                    precioFinal = tarifaBase - 1300;
                    descuentoPorEdad= 1300;

                } else if (edad >= 60) {
                    precioFinal = tarifaBase - 1950;
                    descuentoPorEdad= 1950;}
                
            } 
            
            //Imprimir entrada
            //teatro moro
            System.out.println("..........................");
            System.out.println("   Boleta de Entrada Teatro Moro   ");
            System.out.println("..........................");
            System.out.println("Ubicación del asiento " + (numeroAsiento));
            System.out.println("Precio base de la entrada " + (tarifaBase));
            System.out.println("Descuento aplicado  " + (descuentoPorEdad));
            System.out.println("Precio final a pagar  " + (precioFinal));
            System.out.println("..........................");
            
            System.out.println("¿Desea realizar otra compra? Favor seleccione la opcion a continuacion");
            
        } while (seleccionMenu< 2);
            
    }
}
