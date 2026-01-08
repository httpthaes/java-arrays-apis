import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import java.util.ArrayList;

public class Principal {
    static void main(String[] args) {
        //filmes
        Filme filme1 = new Filme("Sinners", 2025);

        Filme filme2 = new Filme("Titanic", 1997);

        Filme filme3 = new Filme("Homem-Aranha", 2002);

        //Lista de filmes com ArrayList
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);

        //Lista das classes Filme e Serie utilizando Object
        ArrayList<Object> programasFiccaoCientifica = new ArrayList<>();

        Filme filmeFiccaoCientifica = new Filme("Alien, O Oitavo Passageiro", 1979);
        Serie serieFiccaoCientifica = new Serie("Black Mirror", 2011);

        programasFiccaoCientifica.add(filmeFiccaoCientifica);
        programasFiccaoCientifica.add(serieFiccaoCientifica);

        System.out.println(programasFiccaoCientifica);
    }
}