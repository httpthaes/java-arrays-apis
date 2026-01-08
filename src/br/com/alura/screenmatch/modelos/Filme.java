package br.com.alura.screenmatch.modelos;
import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int ano) {
        this.setNome(nome);
        this.setAnoDeLancamento(ano);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void exibirInformacoes() {
        System.out.println("Diretor: " + diretor);
    }

    @Override
    public int getClassificacao() {
        return (int) (mediaAvaliacoes() / 2);
    }

    //sobrescrevendo o metodo toString() para retornar o nome do filme na array
    @Override
    public String toString() {
        return this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}