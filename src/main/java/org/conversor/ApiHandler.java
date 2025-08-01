package org.conversor;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiHandler {
    private final String apiKey = " ";

    public ApiResponse getConversion(String baseCurrency, String targetCurrency, double amount) {
        // Monta o endereço da requisição da API
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                baseCurrency + "/" + targetCurrency + "/" + amount);

        // Cria o cliente HTTP e a requisição
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            // Envia a requisição e obtém a resposta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica se a requisição foi bem-sucedida
            if (response.statusCode() != 200) {
                throw new RuntimeException("Falha ao se comunicar com a API. Código: " + response.statusCode());
            }

            // Usa GSON para converter a resposta JSON em um objeto Java (ApiResponse)
            return new Gson().fromJson(response.body(), ApiResponse.class);

        } catch (IOException | InterruptedException e) {
            // Captura exceções de rede ou interrupção e as relança como uma exceção de runtime
            throw new RuntimeException("Não foi possível realizar a conversão: " + e.getMessage());
        }
    }
}
