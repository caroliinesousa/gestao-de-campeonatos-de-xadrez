package Classes.Partidas;

import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
import java.util.Scanner;

/**
 * A classe {@code PartidaSingulares} representa uma partida de jogo entre dois
 * jogadores, com arbitragem.
 * <p>
 * A partida segue regras específicas, com possibilidade de registrar o
 * vencedor, tempo de duração e
 * outros detalhes relevantes. Implementa a interface {@code ControlePartida}.
 * </p>
 */
public class PartidaSingulares implements ControlePartida {
    /** O primeiro jogador da partida. */
    private Jogador jogador1;
    /** O segundo jogador da partida. */
    private Jogador jogador2;
    /** O árbitro responsável pela partida. */
    private Arbitro arbitro;
    /** O vencedor da partida (inicialmente "Ainda não definido"). */
    private String vencedor;
    /** O tempo de duração da partida em minutos. */
    private double tempo;
    /** O identificador único da partida. */
    private int id;
    /** O tipo da partida (ex.: "Amistoso", "Campeonato"). */
    private String tipo;

    /**
     * Construtor da classe {@code PartidaSingulares}.
     *
     * @param jogador1 o primeiro jogador
     * @param jogador2 o segundo jogador
     * @param arbitro  o árbitro responsável pela partida
     * @param tempo    o tempo de duração estimado para a partida
     * @param id       o identificador único da partida
     * @param tipo     o tipo da partida
     */
    public PartidaSingulares(Jogador jogador1, Jogador jogador2, Arbitro arbitro, double tempo, int id, String tipo) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.arbitro = arbitro;
        this.tempo = tempo;
        this.vencedor = "Ainda não definido";
        this.id = id;
        this.tipo = tipo;

    }

    /**
     * Retorna o tipo da partida.
     *
     * @return o tipo da partida
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da partida.
     *
     * @param tipo o tipo da partida
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Define o primeiro jogador da partida.
     *
     * @param jogador1 o primeiro jogador
     */
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    /**
     * Define o segundo jogador da partida.
     *
     * @param jogador2 o segundo jogador
     */
    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    /**
     * Define o árbitro da partida.
     *
     * @param arbitro o árbitro responsável
     */
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    /**
     * Define o vencedor da partida.
     *
     * @param vencedor o vencedor da partida
     */
    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    /**
     * Define o tempo de duração da partida.
     *
     * @param tempo o tempo em minutos
     */
    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    /**
     * Retorna o primeiro jogador da partida.
     *
     * @return o primeiro jogador
     */
    public Jogador getJogador1() {
        return jogador1;
    }

    /**
     * Retorna o segundo jogador da partida.
     *
     * @return o segundo jogador
     */
    public Jogador getJogador2() {
        return jogador2;
    }

    /**
     * Retorna o árbitro responsável pela partida.
     *
     * @return o árbitro da partida
     */
    public Arbitro getArbitro() {
        return arbitro;
    }

    /**
     * Retorna o identificador da partida.
     *
     * @return o ID da partida
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único da partida.
     *
     * @param id o identificador da partida
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o vencedor da partida.
     *
     * @return o vencedor da partida
     */
    public String getVencedor() {
        return vencedor;
    }

    /**
     * Retorna o tempo de duração da partida.
     *
     * @return o tempo da partida em minutos
     */
    public double getTempo() {
        return tempo;
    }

    /**
     * Aplica as regras da partida e retorna uma descrição das mesmas.
     *
     * @return uma descrição das regras da partida
     */
    public String aplicarRegras() {
        return "O objetivo do jogo é dar xeque-mate no rei adversário. É formado por uma pessoa em cada lado e o vencedor ganha 5 pontos. O xeque - mate acontece quando o rei está em uma posição na qual ele pode ser capturado (em xeque) e não pode escapar da captura. No começo da partida o tabuleiro é colocado de forma que cada jogador tem a casa branca (ou de cor clara) no canto inferior direito.";
    }

    /**
     * Solicita ao usuário o tempo da partida e atualiza o atributo {@code tempo}.
     *
     * @return o tempo informado pelo usuário
     */
    public double tempoPartida() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tempo da partida: ");
        tempo = scanner.nextDouble();
        return tempo;
    }

    /**
     * Realiza a partida entre os dois jogadores, seguindo as regras estabelecidas.
     */
    public void realizarPartida() {
        System.out.println("Partida entre " + jogador1.getNome() + " e " + jogador2.getNome());
        System.out.println("Arbitrada por: " + arbitro.getNome());
        System.out.println(aplicarRegras());

        tempoPartida();
        determinarVencedor(jogador1, jogador2);

        jogador1.incrementarPartidas();
        jogador2.incrementarPartidas();
    }

    /**
     * Determina o vencedor da partida com base na entrada do usuário.
     *
     * @param jogador1 o primeiro jogador
     * @param jogador2 o segundo jogador
     * @return o jogador vencedor ou {@code null} se inválido
     */
    public Jogador determinarVencedor(Jogador jogador1, Jogador jogador2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o vencedor da partida: ");
        vencedor = scanner.nextLine();

        if (vencedor == "O jogador 1 foi o vencedor!") {
            jogador1.adicionarPontos(5);
            return jogador1;
        } else if (vencedor == "O jogador 2 foi o vencedor!") {
            jogador2.adicionarPontos(5);
            return jogador2;

        } else {
            System.out.println("Vencedor inválido!");
            return null;
        }

    }
}