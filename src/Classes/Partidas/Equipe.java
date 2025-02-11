package Classes.Partidas;
import Classes.Pessoas.Jogador;
/**
 * A classe {@code Equipe} representa uma equipe composta por dois jogadores.
 * <p>
 * Cada equipe possui informações sobre ranking, pontos acumulados, quantidade de partidas jogadas
 * e os dois jogadores que a compõem.
 * </p>
 */
public class Equipe {
    /** O ranking da equipe. */
    private int ranking;
    /** Os pontos acumulados pela equipe. */
    private int pontos;
    /** A quantidade de partidas jogadas pela equipe. */
    private int quantidadePartidas;
     /** O primeiro jogador da equipe. */
    private Jogador jogador1;
    /** O segundo jogador da equipe. */
    private Jogador jogador2;
     /**
     * Construtor da classe {@code Equipe}.
     *
     * @param ranking            o ranking da equipe
     * @param pontos             os pontos acumulados pela equipe
     * @param quantidadePartidas a quantidade de partidas jogadas pela equipe
     * @param jogador1           o primeiro jogador da equipe
     * @param jogador2           o segundo jogador da equipe
     */
    public Equipe(int ranking, int pontos, int quantidadePartidas, Jogador jogador1, Jogador jogador2) {
        this.ranking = ranking;
        this.pontos = pontos;
        this.quantidadePartidas = quantidadePartidas;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }
    /**
     * Retorna o ranking da equipe.
     *
     * @return o ranking da equipe
     */
    public int getRanking() {
        return this.ranking;
    }
    /**
     * Define o ranking da equipe.
     *
     * @param ranking o novo ranking da equipe
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
     /**
     * Retorna os pontos acumulados pela equipe.
     *
     * @return os pontos da equipe
     */
    public int getPontos() {
        return this.pontos;
    }
    /**
     * Define os pontos acumulados pela equipe.
     *
     * @param pontos os novos pontos da equipe
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    /**
     * Retorna a quantidade de partidas jogadas pela equipe.
     *
     * @return a quantidade de partidas jogadas
     */
    public int getQuantidadePartidas() {
        return this.quantidadePartidas;
    }
    /**
     * Define a quantidade de partidas jogadas pela equipe.
     *
     * @param quantidadePartidas a nova quantidade de partidas jogadas
     */
    public void setQuantidadePartidas(int quantidadePartidas) {
        this.quantidadePartidas = quantidadePartidas;
    }
    /**
     * Retorna o primeiro jogador da equipe.
     *
     * @return o primeiro jogador
     */
    public Jogador getJogador1() {
        return this.jogador1;
    }
    /**
     * Define o primeiro jogador da equipe.
     *
     * @param jogador1 o novo primeiro jogador
     */
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }
     /**
     * Retorna o segundo jogador da equipe.
     *
     * @return o segundo jogador
     */
    public Jogador getJogador2() {
        return this.jogador2;
    }
     /**
     * Define o segundo jogador da equipe.
     *
     * @param jogador2 o novo segundo jogador
     */
    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }
    /**
     * Adiciona uma quantidade de pontos à equipe.
     *
     * @param pontos a quantidade de pontos a ser adicionada
     */
    public void adicionarPontos(int pontos){
        this.pontos += pontos;
    }
    /**
     * Incrementa o número de partidas jogadas pela equipe em 1.
     */
    public void incrementarPartidas() { 
        quantidadePartidas++; 
    }



    
    
}
