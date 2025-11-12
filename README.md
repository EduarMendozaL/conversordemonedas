# 💱 Conversor de Monedas en Java

Este proyecto es una aplicación de consola escrita en **Java**, que permite realizar conversiones entre distintas monedas utilizando tasas de cambio en tiempo real obtenidas desde la **ExchangeRate API**.

---

## 🚀 Funcionalidades

El conversor permite convertir entre las siguientes monedas:

1. 🇨🇱 Peso chileno → 🇺🇸 Dólar estadounidense  
2. 🇺🇸 Dólar estadounidense → 🇨🇱 Peso chileno  
3. 🇨🇱 Peso chileno → 🇦🇷 Peso argentino  
4. 🇦🇷 Peso argentino → 🇨🇱 Peso chileno  
5. 🇨🇱 Peso chileno → 🇧🇷 Real brasileño  
6. 🇧🇷 Real brasileño → 🇨🇱 Peso chileno  

---

## 🧩 Estructura del Proyecto

El proyecto está compuesto por tres clases principales:

### 📄 `DatosDeApi.java`
<!-- ```java
public record DatosDeApi(double conversion_rate) { }
``` -->
Representa el modelo de datos que recibe la tasa de conversión desde la API.  
Usa un **record**, una estructura inmutable ideal para almacenar datos simples.

---

### 🌐 `ConsultaApi.java`
<!-- ```java
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public DatosDeApi mostrarDatos(String monedaOrigen, String monedaDestino) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3648582df9c167275a625f39/pair/" +
                monedaOrigen + "/" + monedaDestino);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DatosDeApi.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
``` -->

Se encarga de conectarse a la API, realizar la solicitud HTTP y convertir la respuesta JSON en un objeto `DatosDeApi` usando la librería **Gson**.

---

### 💻 `Principal.java`
<!-- ```java
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
                    4) Peso argentino ==> Peso chileno
                    5) Peso chileno ==> Real brasileño
                    6) Real brasileño ==> Peso chileno
                    7) Salir
                    *******************************************************************
                    """);
            try {
                System.out.print("Elija una opción: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> convertirMoneda("CLP", "USD", "Peso chileno", "Dólar");
                    case 2 -> convertirMoneda("USD", "CLP", "Dólar", "Peso chileno");
                    case 3 -> convertirMoneda("CLP", "ARS", "Peso chileno", "Peso argentino");
                    case 4 -> convertirMoneda("ARS", "CLP", "Peso argentino", "Peso chileno");
                    case 5 -> convertirMoneda("CLP", "BRL", "Peso chileno", "Real brasileño");
                    case 6 -> convertirMoneda("BRL", "CLP", "Real brasileño", "Peso chileno");
                    case 7 -> System.out.println("Finalizando. Hasta luego!");
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: La opción ingresada no es válida.");
                teclado.nextLine();
            }
        }
    }

    private static void convertirMoneda(String origen, String destino, String nombreOrigen, String nombreDestino) {
        try {
            System.out.print("Ingrese el monto a convertir: ");
            double montoAConvertir = teclado.nextDouble();

            DatosDeApi datos = consulta.mostrarDatos(origen, destino);
            double valorConvertido = montoAConvertir * datos.conversion_rate();

            System.out.printf("La conversión de %.2f %s a %s es: %.2f\n",
                    montoAConvertir, nombreOrigen, nombreDestino, valorConvertido);
        } catch (Exception e) {
            System.out.println("Error: Problemas con la conexión o datos no válidos.");
            teclado.nextLine();
        }
    }
}
``` -->

Esta clase gestiona el **menú**, recibe las entradas del usuario y muestra el resultado de la conversión.

---

## 🧠 Conceptos Aplicados

- **Encapsulamiento:** cada clase tiene una función específica.  
- **Composición:** la clase `Principal` utiliza `ConsultaApi` para obtener datos.  
- **Records:** simplifican la creación de clases inmutables para datos.  
- **POO (Programación Orientada a Objetos):** aplicación modular, limpia y mantenible.  
- **Manejo de excepciones:** evita errores de ejecución y mejora la experiencia del usuario.  
- **Consumo de API:** conexión HTTP con manejo de JSON mediante **Gson**.  

---

## 🧰 Requisitos del Proyecto

- **Java 17** o superior  
- **Librería Gson** para procesar JSON  

Puedes agregar Gson de varias formas:

### 🔹 Opción 1: Maven
Agrega en tu `pom.xml`:
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

### 🔹 Opción 2: Manual
Descarga el `.jar` desde  
👉 [https://github.com/google/gson](https://github.com/google/gson)  
y ejecútalo con:
```bash
javac -cp gson-2.10.1.jar *.java
java -cp .;gson-2.10.1.jar Principal
```

*(En Linux o macOS usa “:” en lugar de “;” para separar rutas).*

---

## ⚙️ Ejecución

1. Clona o descarga el proyecto.  
2. Compila los archivos:
   ```bash
   javac -cp gson-2.10.1.jar *.java
   ```
3. Ejecuta el programa:
   ```bash
   java -cp .;gson-2.10.1.jar Principal
   ```
4. Selecciona la opción del menú e ingresa el monto a convertir.

---

## 🌍 Fuente de Datos

Los tipos de cambio son proporcionados por  
[**ExchangeRate API**](https://www.exchangerate-api.com/)

---

## 📄 Licencia

Este proyecto se distribuye con fines educativos.  
Puedes usarlo y modificarlo libremente.

---

## ✨ Autor

Desarrollado por **Eduardo**, como práctica de Programación Orientada a Objetos en Java y uso de APIs externas.
