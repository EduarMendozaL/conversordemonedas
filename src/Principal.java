import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();

        System.out.println("Ingrese moneda de origen: ");
        String monedaDeOrigen = teclado.next();
        System.out.println("Ingrese moneda de destino: ");
        String monedaDeDestino = teclado.next();

        System.out.println("Ingrese el monto a convertir: ");
        Double montoAConvertir = teclado.nextDouble();

        DatosDeApi datos = consulta.mostrarDatos(monedaDeOrigen, monedaDeDestino);

        Double valorConvertido = montoAConvertir * datos.conversion_rate();

        System.out.println("La conversión del valor " + montoAConvertir + " desde " + monedaDeOrigen + " a " +
                monedaDeDestino + ", es de: " + valorConvertido);
        System.out.printf("La conversión del valor %.2f desde %s a %s, es de: %.2f", montoAConvertir, monedaDeOrigen, monedaDeDestino, valorConvertido);

    }
}
