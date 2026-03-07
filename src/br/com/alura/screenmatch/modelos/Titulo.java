package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
//    @SerializedName("Title")
//    private String nome;
//    @SerializedName("Year")
//    private int anoDeLancamento;
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;
    private String genero;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        String ano = meuTituloOmdb.year().replaceAll("[^0-9]", "");
        if (ano.length() >= 4) {
            this.anoDeLancamento = Integer.valueOf(ano.substring(0, 4));
        }

        String runtime = meuTituloOmdb.runtime().replaceAll("[^0-9]", "");
        if (!runtime.isEmpty()) {
            this.duracaoEmMinutos = Integer.valueOf(runtime);
        }
    }

    //getters
    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    //metodos
    public void exibeFichaTecnica() {
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
        System.out.println("Gênero: " + genero);
        System.out.println("Total de Avaliações: " + getTotalDeAvaliacoes());
        System.out.println("Nota: " + mediaAvaliacoes());
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double mediaAvaliacoes() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | " +
                "Ano: " + anoDeLancamento + " | " +
                "Duração: " + duracaoEmMinutos + " min";
    }
}