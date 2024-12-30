package com.alura.literalura.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumoApi {

    public String obtenerDatos(String url) {
        // Crea una instancia de HttpClient para realizar solicitudes HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construye una solicitud HTTP GET con la URL proporcionada
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Envía la solicitud HTTP y obtiene la respuesta
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Lanza una RuntimeException si ocurre un error de E/S
            throw new RuntimeException("Error de E/S al obtener datos de la API", e);
        } catch (InterruptedException e) {
            // Lanza una RuntimeException si la solicitud es interrumpida
            throw new RuntimeException("La solicitud fue interrumpida", e);
        }

        // Obtiene el cuerpo de la respuesta en formato de cadena de texto
        String json = response.body();
        return json;
    }
}
