import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static Scanner teclado = new Scanner(System.in);
    static ConsultaApi consulta = new ConsultaApi();

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 7) {

                System.out.println("""
                        
                        *******************************************************************
                        
                        Bienvenido(a) al Conversor de Moneda
                        
                        1) Peso chileno ==> Dólar
                        2) Dólar ==> Peso chileno
                        3) Peso chileno ==> Peso argentino
                        4) Peso argentino  ==> Peso chileno
                        5) Peso chileno ==> Real brasileño
                        6) Real brasileño ==> Peso chileno
                        7) Salir
                        
                        *******************************************************************
                        """);
            try {
                System.out.println("Elija una opción: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        convertirMoneda("CLP", "USD", "Peso chileno", "Dólar");
                        break;

                    case 2:
                        convertirMoneda("USD", "CLP", "Dólar", "Peso chileno");
                        break;

                    case 3:
                        convertirMoneda("CLP", "ARS", "Peso chileno", "Peso argentino");
                        break;

                    case 4:
                        convertirMoneda("ARS", "CLP", "Peso argentino", "Peso chileno");
                        break;

                    case 5:
                        convertirMoneda("CLP", "BRL", "Peso chileno", "Real brasileño");
                        break;

                    case 6:
                        convertirMoneda("BRL", "CLP", "Real brasileño", "Peso chileno");
                        break;

                    case 7:
                        System.out.println("Finalizando. Hasta luego");
                        break;

                    default:
                        System.out.println("Opción no válida!!. Intente otra opción");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error!, la opción ingresada no es válida.");
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                teclado.nextLine();
            }
        }
    }

    private static void convertirMoneda(String origen, String destino, String nombreOrigen, String nombreDestino) {
        double montoAConvertir, valorConvertido;
        try {
            System.out.println("Ingrese el monto a convertir: ");
            montoAConvertir = teclado.nextDouble();

            DatosDeApi datos = consulta.mostrarDatos(origen, destino);
            valorConvertido = montoAConvertir * datos.conversion_rate();

            System.out.printf("La conversión del valor %.2f en %s a %s, es de: %.2f\n",
                    montoAConvertir, nombreOrigen, nombreDestino, valorConvertido);
        } catch (Exception e) {
            System.out.println("Error!, problemas con la conexión o datos no válidos");
            teclado.nextLine();
        }
    }
}
