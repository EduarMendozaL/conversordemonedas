import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        double montoAConvertir, valorConvertido;
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

            System.out.println("Elija una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el monto a convertir: ");
                    montoAConvertir = teclado.nextDouble();
                    DatosDeApi datos = consulta.mostrarDatos("CLP", "USD");
                    valorConvertido = montoAConvertir * datos.conversion_rate();
                    System.out.printf("La conversión del valor %.2f en Peso chileno a Dólar, es de: %.2f\n",
                            montoAConvertir, valorConvertido);
                    break;

                case 2:
                    System.out.println("Ingrese el monto a convertir: ");
                    montoAConvertir = teclado.nextDouble();
                    datos = consulta.mostrarDatos("USD", "CLP");
                    valorConvertido = montoAConvertir * datos.conversion_rate();
                    System.out.printf("La conversión del valor %.2f en Dólar a Peso chileno, es de: %.2f\n",
                            montoAConvertir, valorConvertido);
                    break;

                case 3:
                    System.out.println("Ingrese el monto a convertir: ");
                    montoAConvertir = teclado.nextDouble();
                    datos = consulta.mostrarDatos("CLP", "ARS");
                    valorConvertido = montoAConvertir * datos.conversion_rate();
                    System.out.printf("La conversión del valor %.2f en Peso chileno a Peso argentino, es de: %.2f\n",
                            montoAConvertir, valorConvertido);
                    break;

                case 4:
                    System.out.println("Ingrese el monto a convertir: ");
                    montoAConvertir = teclado.nextDouble();
                    datos = consulta.mostrarDatos("ARS", "CLP");
                    valorConvertido = montoAConvertir * datos.conversion_rate();
                    System.out.printf("La conversión del valor %.2f en Peso argentino a Peso chileno, es de: %.2f\n",
                            montoAConvertir, valorConvertido);
                    break;

                case 5:
                    System.out.println("Ingrese el monto a convertir: ");
                    montoAConvertir = teclado.nextDouble();
                    datos = consulta.mostrarDatos("CLP", "BRL");
                    valorConvertido = montoAConvertir * datos.conversion_rate();
                    System.out.printf("La conversión del valor %.2f en Peso chileno a Real brasileño, es de: %.2f\n",
                            montoAConvertir, valorConvertido);
                    break;

                case 6:
                    System.out.println("Ingrese el monto a convertir: ");
                    montoAConvertir = teclado.nextDouble();
                    datos = consulta.mostrarDatos("BRL", "CLP");
                    valorConvertido = montoAConvertir * datos.conversion_rate();
                    System.out.printf("La conversión del valor %.2f en Real brasileño a Peso chileno, es de: %.2f\n",
                            montoAConvertir, valorConvertido);
                    break;

                case 7:
                    System.out.println("Finalizando. Hasta luego");
                    break;

                default:
                    System.out.println("Opción no válida!!. Intente otra opción");
                    break;
            }
        }

    }
}
