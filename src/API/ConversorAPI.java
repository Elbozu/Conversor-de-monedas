package API;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {
    private static final String API_KEY = "5600d6d5bf1ba1d2d398f220";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final Gson gson = new Gson();

    public static double obtenerTasaCambio(String base, String objetivo) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/" + base;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        JsonObject json = gson.fromJson(respuesta.body(), JsonObject.class);

        if (!json.get("result").getAsString().equals("success")) {
            throw new IOException("Respuesta inválida de la API: " + json.get("error-type").getAsString());
        }

        JsonObject tasas = json.getAsJsonObject("conversion_rates");

        if (!tasas.has(objetivo)) {
            throw new IOException("La moneda " + objetivo + " no está disponible.");
        }

        return tasas.get(objetivo).getAsDouble();
    }
}


