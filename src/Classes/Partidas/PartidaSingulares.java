package Classes.Partidas;

import java.util.Scanner;

import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;

public class PartidaSingulares implements ControloPartida {
    private Jogador jogador1;
    private Jogador jogador2;
    private Arbitro arbitro;
    private String resultado;
    private double tempo;

    public PartidaSingulares(Jogador jogador1, Jogador jogador2, Arbitro arbitro, String resultado, double tempo) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.arbitro = arbitro;
        this.resultado = resultado;
        this.tempo = tempo;

    }
    
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public String getResultado() {
        return resultado;
    }
    public double getTempo() {
        return tempo;
    }
    public String aplicarRegras(){
        return "O objetivo do jogo é dar xeque-mate no rei adversário. O xeque - mate acontece quando o rei está em uma posição na qual ele pode ser capturado (em xeque) e não pode escapar da captura. No começo da partida o tabuleiro é colocado de forma que cada jogador tem a casa branca (ou de cor clara) no canto inferior direito.";
    }

     public double tempoPartida(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tempo da partida: ");
        tempo = scanner.nextDouble();
        return tempo;
    }

    public void realizarPartida() {
        System.out.println("Partida entre " + jogador1.getNome() + " e " + jogador2.getNome());
        System.out.println("Arbitrada por: "+ arbitro.getNome());
        System.out.println(aplicarRegras());

        tempoPartida();
        determinarVencedor(jogador1, jogador2);

        jogador1.incrementarPartidas();
        jogador2.incrementarPartidas();
    }
    public Jogador determinarVencedor(Jogador jogador1, Jogador jogador2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o vencedor da partida: ");
        resultado = scanner.nextLine();
        
        if (resultado == "O jogador 1 foi o vencedor!") {
            jogador1.adicionarPontos(5);
            return jogador1;  
        }else if (resultado == "O jogador 2 foi o vencedor!"){
            jogador2.adicionarPontos(5);
            return jogador2;

        }else{
            System.out.println("Resultado inválido!");
            return null;
        }
        
}
}