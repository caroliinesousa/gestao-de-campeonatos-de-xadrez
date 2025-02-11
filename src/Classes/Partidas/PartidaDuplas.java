package Classes.Partidas;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
import java.util.Scanner;
/**
 * A classe {@code PartidaDuplas} representa uma partida de xadrez em duplas, com duas equipes e um árbitro responsável.
 * <p>
 * A classe gerencia jogadores, regras da partida, tempo de duração, resultado e o vencedor.
 * Implementa a interface {@code ControlePartida}.
 * </p>
 */
public class PartidaDuplas implements ControlePartida {
    /** Primeiro jogador da equipe 1. */
    private Jogador jogador1Equipe1;
    /** Segundo jogador da equipe 1. */
    private Jogador jogador2Equipe1;
    /** Primeiro jogador da equipe 2. */
    private Jogador jogador1Equipe2;
    /** Segundo jogador da equipe 2. */
    private Jogador jogador2Equipe2;
    /** Árbitro responsável pela partida. */
    private Arbitro arbitro;
    /** Resultado ou vencedor da partida (ex.: "Equipe 1"). */
    private String vencedor;
     /** Tempo de duração da partida em minutos. */
    private double tempo;
    /** Identificador único da partida. */
    private int id;
    /**
     * Construtor da classe {@code PartidaDuplas}.
     *
     * @param jogador1Equipe1 primeiro jogador da equipe 1
     * @param jogador2Equipe1 segundo jogador da equipe 1
     * @param jogador1Equipe2 primeiro jogador da equipe 2
     * @param jogador2Equipe2 segundo jogador da equipe 2
     * @param arbitro         árbitro responsável pela partida
     * @param vencedor        resultado ou vencedor da partida
     * @param tempo           tempo estimado da partida
     * @param id              identificador único da partida
     */
    public PartidaDuplas(Jogador jogador1Equipe12, Jogador jogador1Equipe1, Jogador jogador2Equipe1, Jogador jogador1Equipe2, Jogador jogador2Equipe2, Arbitro arbitro, String vencedor,double tempo, int id) {
        this.jogador1Equipe1 = jogador1Equipe1;
        this.jogador2Equipe1 = jogador2Equipe1;
        this.jogador1Equipe2 = jogador1Equipe2;
        this.jogador2Equipe2 = jogador2Equipe2;
        this.arbitro = arbitro;
        this.vencedor = vencedor;
        this.tempo = 0;
        this.id = id;

    }
     /**
     * Retorna o tempo da partida.
     *
     * @return o tempo da partida em minutos
     */
    public double getTempo() {
        return tempo;
    }
     /**
     * Define o tempo da partida.
     *
     * @param tempo o tempo em minutos
     */
    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
    // Getters e setters para jogadores e árbitro
    // (documentados de forma similar aos métodos abaixo)
    public Jogador getJogador1Equipe1() {
        return jogador1Equipe1;
    }

    public Jogador getJogador2Equipe1() {
        return jogador2Equipe1;
    }

    public Jogador getJogador1Equipe2() {
        return jogador1Equipe2;
    }

    public Jogador getJogador2Equipe2() {
        return jogador2Equipe2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }
    /**
     * Retorna o resultado ou vencedor da partida.
     *
     * @return o vencedor da partida
     */
    public String getVencedor() {
        return vencedor;
    }
    
    public void setJogador1Equipe1(Jogador jogador1Equipe1) {
        this.jogador1Equipe1 = jogador1Equipe1;
    }

    public void setJogador2Equipe1(Jogador jogador2Equipe1) {
        this.jogador2Equipe1 = jogador2Equipe1;
    }

    public void setJogador1Equipe2(Jogador jogador1Equipe2) {
        this.jogador1Equipe2 = jogador1Equipe2;
    }

    public void setJogador2Equipe2(Jogador jogador2Equipe2) {
        this.jogador2Equipe2 = jogador2Equipe2;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
    /**
     * Define o resultado ou vencedor da partida.
     *
     * @param vencedor o vencedor da partida
     */
    public void setVencedor(String resultado) {
        this.vencedor = resultado;
    }
    /**
     * Realiza a partida entre as duas equipes.
     * <p>
     * Aplica as regras, registra o tempo e determina o vencedor com base na entrada do usuário.
     * </p>
     */
    public void realizarPartida() {
        Equipe equipe1 = new Equipe(0, 0, 0, jogador1Equipe1, jogador2Equipe1);
        Equipe equipe2 = new Equipe(0, 0, 0, jogador1Equipe2, jogador2Equipe2);
        System.out.println(aplicarRegras());

        tempoPartida();
        determinarVencedor(equipe1, equipe2);

        jogador1Equipe1.incrementarPartidas();
        jogador2Equipe1.incrementarPartidas();
        jogador1Equipe2.incrementarPartidas();
        jogador2Equipe2.incrementarPartidas();

        equipe1.incrementarPartidas();
        equipe2.incrementarPartidas();

        System.out.println("Partida de duplas: ");
        System.out.println("Equipe 1: " + jogador1Equipe1.getNome() + " e " + jogador2Equipe1.getNome());
        System.out.println("Equipe 2: " + jogador1Equipe2.getNome() + " e " + jogador2Equipe2.getNome());
        System.out.println("Arbitrada por: " + arbitro.getNome());
    }
    /**
     * Aplica as regras da partida.
     *
     * @return uma descrição das regras
     */
    public String aplicarRegras(){
        return "O objetivo do jogo é dar xeque-mate no rei adversário. É formado por duplas que o vencedor ganha 3 pontos.  O xeque - mate acontece quando o rei está em uma posição na qual ele pode ser capturado (em xeque) e não pode escapar da captura. No começo da partida o tabuleiro é colocado de forma que cada jogador tem a casa branca (ou de cor clara) no canto inferior direito.";
    }
     /**
     * Determina a equipe vencedora com base na entrada do usuário.
     *
     * @param equipe1 a equipe 1
     * @param equipe2 a equipe 2
     * @return a equipe vencedora ou {@code null} em caso de erro
     */
    public Equipe determinarVencedor(Equipe equipe1, Equipe equipe2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique a equipe vencedora da partida: ");
        vencedor = scanner.nextLine();

        if(vencedor == "A equipe 1 foi a vencedora!"){
            equipe1.adicionarPontos(3);
            jogador1Equipe1.adicionarPontos(3);
            jogador2Equipe1.adicionarPontos(3);
            if (tempo <20) {
                equipe1.adicionarPontos(1);
            }
            return equipe1;

        }else if (vencedor == "A equipe 2 foi a vencedora!"){
            equipe2.adicionarPontos(3);
            jogador1Equipe2.adicionarPontos(3);
            jogador2Equipe2.adicionarPontos(3);
            if (tempo <20) {
                equipe2.adicionarPontos(1);
            }
            return equipe2;
        }else{
            System.out.println("Resultado inválido!");
            return null;
        }
    }
    /**
     * Solicita ao usuário o tempo da partida.
     *
     * @return o tempo informado pelo usuário
     */
    public double tempoPartida(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tempo da partida: ");
        tempo = scanner.nextDouble();
        return tempo;
    }
     /**
     * Retorna o identificador único da partida.
     *
     * @return o identificador da partida
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

}


