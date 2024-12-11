# DesafioConversorDeMonedas
En este repositorio estará contenido el desafio de conversor de monedas en Java

Proyecto: Conversor de Monedas

Este proyecto es una aplicación en Java que permite realizar conversiones de monedas utilizando una API externa. La aplicación solicita al usuario los datos necesarios, como la moneda base, la moneda objetivo y el monto a convertir, realiza la conversión y almacena un historial de las conversiones realizadas. Además, incluye funcionalidades interactivas como la opción de finalizar el programa escribiendo "salir".

Características Principales

- Conversión de Monedas: Realiza conversiones entre distintas monedas utilizando una API de tipo cambio.
- Interfaz Interactiva: Solicita al usuario las monedas y los valores a convertir.
- Historial de Conversiones: Registra y muestra todas las conversiones realizadas al finalizar la ejecución.
- Uso de Records: Implementa la clase Moneda como un record para representar las conversiones de manera inmutable y legible.


Estructura del Proyecto

Clases Principales

1. ConsultaMoneda

   Realiza la comunicación con la API para obtener la tasa de conversión y calcular el resultado.
   Genera objetos de tipo Moneda con los datos obtenidos de la API.

2. Moneda (Record)

   Representa una conversión con los siguientes campos:

      - baseCode: Moneda base (e.g., USD).
      - targetCode: Moneda objetivo (e.g., COP).
      - conversionRate: Tasa de conversión entre las monedas.
      - conversionResult: Resultado de la conversión.
      - Sobrescribe el método toString() para mostrar los resultados de manera organizada.

3. HistorialConversiones

      - Almacena un listado de objetos Moneda.
      - Permite agregar nuevas conversiones al historial y mostrar todas las conversiones al usuario al final de la ejecución.

4. Principal

      - Controla el flujo principal de la aplicación.
      - Solicita los datos al usuario, gestiona las interacciones y muestra el historial al finalizar.

Requisitos del Sistema

  - Java 17 o superior: Se utiliza la funcionalidad de record introducida en Java 16.
  - Librería Gson: Para manejar el JSON devuelto por la API. Puedes incluirla en tu proyecto mediante Maven o descargándola manualmente.

Configuración de la API

  La aplicación utiliza la API de ExchangeRate-API para obtener las tasas de conversión. Deberás obtener una clave API gratuita y 
  reemplazarla en la URL del código:

URI direccion = URI.create("https://v6.exchangerate-api.com/v6/TU_CLAVE_API/pair/" +
        monedaBase + "/" + monedaObjetivo + "/" + valorDeLaConversion);

Ejecución del Proyecto

  - Clona este repositorio.
  - Configura tu entorno para utilizar Java 17 o superior.
  - Asegúrate de que la librería Gson esté disponible en el proyecto.
  - Compila y ejecuta la clase Principal.
  - Sigue las instrucciones en la consola para realizar conversiones de monedas.

Ejemplo de Uso

Ingrese la moneda base (por ejemplo, USD): USD
Ingrese la moneda objetivo (por ejemplo, COP): COP
Ingrese el valor a convertir (número decimal o 'salir' para terminar): 100
Conversión de Moneda:
- Moneda Base: USD
- Moneda Objetivo: COP
- Tasa de Conversión: 4123.5678
- Resultado de la Conversión: 412356.78

Ingrese el valor a convertir (número decimal o 'salir' para terminar): salir
Saliendo del programa...

Historial de Conversiones:
Conversión 1:
Conversión de Moneda:
- Moneda Base: USD
- Moneda Objetivo: COP
- Tasa de Conversión: 4123.5678
- Resultado de la Conversión: 412356.78

Puedes consultar el listado de monedas soportadas de la API en https://www.exchangerate-api.com/docs/supported-currencies, tenieno en cuenta Codigo de la moneda, nombre de la moneda y Pais de origen




