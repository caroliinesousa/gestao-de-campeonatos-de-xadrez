package Classes.Partidas;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;

public class PartidaDuplas implements ControloPartida {
    private Jogador jogador1Equipe1;
    private Jogador jogador2Equipe1;
    private Jogador jogador1Equipe2;
    private Jogador jogador2Equipe2;
    private Arbitro arbitro;
    private String resultado;
    private double tempo;

    public PartidaDuplas(Arbitro arbitro, Jogador jogador1Equipe1, Jogador jogador2Equipe1, Jogador jogador1Equipe2,Jogador jogador2Equipe2, String resultado,double tempo) {
        this.jogador1Equipe1 = jogador1Equipe1;
        this.jogador2Equipe1 = jogador2Equipe1;
        this.jogador1Equipe2 = jogador1Equipe2;
        this.jogador2Equipe2 = jogador2Equipe2;
        this.arbitro = arbitro;
        this.resultado = resultado;
        this.tempo = tempo;

    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

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

    public String getResultado() {
        return resultado;
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

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

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
    public String aplicarRegras(){
        return "O objetivo do jogo é dar xeque-mate no rei adversário. O xeque - mate acontece quando o rei está em uma posição na qual ele pode ser capturado (em xeque) e não pode escapar da captura. No começo da partida o tabuleiro é colocado de forma que cada jogador tem a casa branca (ou de cor clara) no canto inferior direito.";
    }

    public Equipe determinarVencedor(Equipe equipe1, Equipe equipe2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique a equipe vencedora da partida: ");
        resultado = scanner.nextLine();

        if(resultado == "A equipe 1 foi a vencedora!"){
            equipe1.adicionarPontos(3);
            jogador1Equipe1.adicionarPontos(3);
            jogador2Equipe1.adicionarPontos(3);
            if (tempo <20) {
                equipe1.adicionarPontos(1);
            }
            return equipe1;

        }else if (resultado == "A equipe 2 foi a vencedora!"){
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

    public double tempoPartida(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tempo da partida: ");
        tempo = scanner.nextDouble();
        return tempo;
    }

}


