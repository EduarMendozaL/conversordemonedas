public class Principal {
    public static void main(String[] args) {
        ConsultaApi consulta = new ConsultaApi();
        DatosDeApi datos = consulta.mostrarDatos("USD", "CLP");
        System.out.println(datos);
    }
}
