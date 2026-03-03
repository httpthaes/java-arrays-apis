package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalAPI {
    static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = System.getenv("API_KEY");

        if (apiKey == null) {
            throw new RuntimeException("API_KEY inválida.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para buscar: ");
        var busca = scanner.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println(response.body());
    }
}
