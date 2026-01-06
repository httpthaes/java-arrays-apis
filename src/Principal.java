import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import java.util.ArrayList;

public class Principal {
    static void main(String[] args) {
        //filmes
        Filme filme1 = new Filme();
        filme1.setNome("Sinners");
        filme1.setAnoDeLancamento(2025);

        Filme filme2 = new Filme();
        filme2.setNome("Titanic");
        filme2.setAnoDeLancamento(1997);

        Filme filme3 = new Filme();
        filme3.setNome("Homem-Aranha");
        filme3.setAnoDeLancamento(2002);

        //Lista de filmes com ArrayList
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}