package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = System.getenv("API_KEY");

        if (apiKey == null) {
            throw new RuntimeException("API_KEY inválida.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para buscar: ");
        var busca = scanner.nextLine();
        busca = URLEncoder.encode(busca, StandardCharsets.UTF_8);

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + apiKey;

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);

            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter string em number, verifique o formato da string.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de argumento na busca, verifique o endereço.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
