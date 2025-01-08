package Classes.Partidas;
import Classes.Pessoas.Jogador;

public class Equipe {
    private int ranking;
    private int pontos;
    private int quantidadePartidas;
    private Jogador jogador1;
    private Jogador jogador2;
    
    public Equipe(int ranking, int pontos, int quantidadePartidas, Jogador jogador1, Jogador jogador2) {
        this.ranking = ranking;
        this.pontos = pontos;
        this.quantidadePartidas = quantidadePartidas;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPontos() {
        return this.pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getQuantidadePartidas() {
        return this.quantidadePartidas;
    }

    public void setQuantidadePartidas(int quantidadePartidas) {
        this.quantidadePartidas = quantidadePartidas;
    }

    public Jogador getJogador1() {
        return this.jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return this.jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public void adicionarPontos(int pontos){
        this.pontos += pontos;
    }
    public void incrementarPartidas() { 
        quantidadePartidas++; 
    }



    
    
}
