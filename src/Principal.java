import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        double montoAConvertir;

        System.out.println("Ingrese moneda de origen: ");
        String monedaDeOrigen = teclado.next();
        System.out.println("Ingrese moneda de destino: ");
        String monedaDeDestino = teclado.next();

        System.out.println("Ingrese el monto a convertir: ");

        montoAConvertir = teclado.nextDouble();

        DatosDeApi datos = consulta.mostrarDatos(monedaDeOrigen, monedaDeDestino);

        double valorConvertido = montoAConvertir * datos.conversion_rate();

        System.out.printf("La conversión del valor %.2f desde %s a %s, es de: %.2f",
                montoAConvertir, monedaDeOrigen, monedaDeDestino, valorConvertido);

    }
}
