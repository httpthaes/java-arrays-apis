package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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

        /*
        Em Java, todas as classes herdam de Object
        Por isso uma lista do tipo Object aceita qualquer tipo de objeto.

        **Apenas para fins didáticos, não é boa prática criar lista com Object
        */
        ArrayList<Object> programasFiccaoCientifica = new ArrayList<>();

        Filme filmeFiccaoCientifica = new Filme("Alien, O Oitavo Passageiro", 1979);
        Serie serieFiccaoCientifica = new Serie("Black Mirror", 2011);

        programasFiccaoCientifica.add(filmeFiccaoCientifica);
        programasFiccaoCientifica.add(serieFiccaoCientifica);
        programasFiccaoCientifica.add("Dark(2017)");
        programasFiccaoCientifica.add(533);

        System.out.println(programasFiccaoCientifica);

        //Boa prática: usar uma superclasse comum entre as classes que deseja adicionar a lista.
        //Nesse caso a lista aceita apenas instâncias de Titulo.
        ArrayList<Titulo> lista = new ArrayList<>();

        Filme filmeAnime = new Filme("Chainsaw Man: Reze Arc", 2025);
        filmeAnime.avalia(8);
        Serie serieAnime = new Serie("Naruto", 2002);
        serieAnime.avalia(9.5);

        lista.add(filmeAnime);
        lista.add(serieAnime);
        //lista.add("Demon Slayer"); não aceita objetos que não sejam Titulo.

        for (Titulo item : lista) {
            System.out.println(item);
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Nota " + filme.getClassificacao());
            }
        }

        //Ordenando listas
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Michael B. Jordan");
        buscaPorArtista.add("Bob Odenkirk");
        buscaPorArtista.add("Rhea Seehorn");
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(listaDeFilmes);
        System.out.println("Ordenando por nome: " + listaDeFilmes);
        listaDeFilmes.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano: " + listaDeFilmes);
    }
}