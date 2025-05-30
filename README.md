# 💱 Conversor de Monedas en Java

Una aplicación de consola en Java que permite convertir valores entre diferentes monedas en tiempo real, utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/). Además, guarda un historial de conversiones realizadas en un archivo `.txt`.

---

## 📦 Funcionalidades

- Conversión en tiempo real entre:
  - USD ↔ DOP (Peso Dominicano)
  - USD ↔ ARS (Peso Argentino)
  - USD ↔ COP (Peso Colombiano)
- Historial de conversiones almacenado en un archivo de texto.
- Opción para visualizar el historial desde el menú.
- Validación de entrada para evitar errores.

---

## 🔧 Requisitos

- Java 11 o superior
- Conexión a internet
- Biblioteca [Gson](https://github.com/google/gson) para parsear JSON  
  (puedes agregarla como `.jar` o usar Maven/Gradle)

---

## 🚀 Cómo usar

1. Clona o descarga el repositorio.
2. Asegúrate de tener la API key configurada en la clase `ConversorAPI.java`.
3. Compila todos los archivos:

   ```bash
   javac Principal.java ConversorAPI.java HistorialConversion.java
   ```

4. Ejecuta la app:

   ```bash
   java Principal
   ```

---

## 📂 Estructura del Proyecto

```
ConversorMonedas/
├── Principal.java              // Clase principal con el menú
├── ConversorAPI.java           // Llama a la API y obtiene tasas de cambio
├── HistorialConversion.java    // Guarda y lee historial en archivo .txt
├── historial_conversiones.txt  // Archivo generado automáticamente
```

---

## 📘 Ejemplo de uso

```
************************************************
|    Bienvenido a su conversor de monedas      |
************************************************

Ingresa el número para elegir la conversión deseada:

(1) [USD] Dólar --> [DOP] Peso Dominicano
(2) [DOP] Peso Dominicano --> [USD] Dólar
(3) [USD] Dólar --> [ARS] Peso Argentino
(4) [ARS] Peso Argentino --> [USD] Dólar
(5) [USD] Dólar --> [COP] Peso Colombiano
(6) [COP] Peso Colombiano --> [USD] Dólar
(7) Salir
(8) Ver historial de conversiones
```

---

## 📒 Historial

El historial se guarda en el archivo `historial_conversiones.txt` con formato:

```
[2025-05-29 16:05:32] 100.00 USD --> 5890.00 DOP
[2025-05-29 16:10:15] 50.00 DOP --> 0.85 USD
```

---

## 🛠 Créditos

- Desarrollado en Java puro.
- API utilizada: [ExchangeRate-API](https://www.exchangerate-api.com/)
- Parseo de JSON: [Gson](https://github.com/google/gson)

---

## 📃 Licencia

Este proyecto es de uso libre para fines educativos y personales.