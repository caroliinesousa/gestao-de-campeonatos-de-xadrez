package Classes.Pessoas;

/**
 * A classe {@code Jogador} representa um jogador no sistema, que é uma
 * especialização
 * da classe {@code Pessoa}. Contém informações adicionais específicas do
 * jogador,
 * como ranking, partidas jogadas e pontos acumulados.
 */
public class Jogador extends Pessoa {
    /**
     * Ranking atual do jogador.
     */
    private int ranking;
    /**
     * Número de partidas jogadas pelo jogador.
     */
    private int partidasJogadas;
    /**
     * Pontos acumulados pelo jogador.
     */
    private int pontos;

    /**
     * Construtor que inicializa um jogador com nome, idade e gênero, configurando
     * os atributos adicionais com valores padrão (ranking 0, partidas jogadas 0,
     * pontos 0).
     *
     * @param nome   o nome do jogador
     * @param idade  a idade do jogador
     * @param genero o gênero do jogador
     */
    public Jogador(String nome, int idade, char genero) {
        super(nome, idade, genero);
        this.ranking = 0;
        this.partidasJogadas = 0;
        this.pontos = 0;
    }

    /**
     * Construtor que inicializa um jogador com todos os atributos fornecidos.
     *
     * @param nome            o nome do jogador
     * @param idade           a idade do jogador
     * @param genero          o gênero do jogador
     * @param ranking         a posição no ranking do jogador
     * @param partidasJogadas o número de partidas jogadas pelo jogador
     * @param pontos          os pontos acumulados pelo jogador
     */

    public Jogador(String nome, int idade, char genero, int ranking, int partidasJogadas, int pontos) {
        super(nome, idade, genero);
        this.ranking = ranking;
        this.partidasJogadas = partidasJogadas;
        this.pontos = pontos;
    }

    /**
     * Retorna o ranking atual do jogador.
     *
     * @return a posição no ranking do jogador
     */
    public int getRanking() {
        return this.ranking;
    }

    /**
     * Retorna o número de partidas jogadas pelo jogador.
     *
     * @return o número de partidas jogadas
     */
    public int getPartidasJogadas() {
        return this.partidasJogadas;
    }

    /**
     * Define o número de partidas jogadas pelo jogador.
     *
     * @param partidasJogadas o número de partidas jogadas
     */
    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    /**
     * Define a posição no ranking do jogador.
     *
     * @param ranking o novo ranking do jogador
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    /**
     * Retorna os pontos acumulados pelo jogador.
     *
     * @return os pontos do jogador
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Define os pontos acumulados pelo jogador.
     *
     * @param pontos os novos pontos do jogador
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * Incrementa o número de partidas jogadas pelo jogador em 1.
     */
    public void incrementarPartidas() {
        partidasJogadas++;
    }

    /**
     * Adiciona uma quantidade de pontos ao total do jogador.
     *
     * @param pontos os pontos a serem adicionados
     */
    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    /**
     * Exibe as informações detalhadas do jogador no console.
     * Inclui nome, idade, gênero, ranking, partidas jogadas e pontos acumulados.
     */
    @Override
    public void exibirInformacoes() {
        System.out.println("Nome" + getNome() + ", Idade: " + getIdade() + ", Gênero: " + getGenero());
        System.out.println("Posição no Ranking: " + this.ranking + ", Partidas Jogadas: " + this.partidasJogadas);

    }
}
