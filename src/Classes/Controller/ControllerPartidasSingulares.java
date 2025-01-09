package Classes.Controller;
import java.util.ArrayList;

import Classes.Partidas.PartidaSingulares;

public class ControllerPartidasSingulares {
    private ArrayList<PartidaSingulares> partidasSingulares;

    public ControllerPartidasSingulares() {
        partidasSingulares = new ArrayList<>();
    }

    
    public void cadastrarPartidasSingulares(String jogador1, String jogador2, String arbitro, String resultado, int idPartida, double tempo) {
        PartidasSingulares novaPartida = new PartidasSingulares(jogador1, jogador2, arbitro, resultado, idPartida, tempo);
        partidasSingulares.add(novaPartida);
        System.out.println("Partida cadastrada com sucesso!");
    }

    
    public String consultarPartidasSingulares(int idPartida) {
        for (int i = 0; i < partidasSingulares.size(); i++) {
            PartidaSingulares partida = PartidasSingulares.get(i);
            if (partidasSingulares.getIdPartida().equals(idPartida)) {
                return "Partida encontrada: " + idPartida;
            }
        }
        return "Partida não encontrada.";
    }

    
    public void atualizarPartidasSingulares(int idPartida, String novoResultado) {
        for (int i = 0; i < partidasSingulares.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getIdPartida().equals(idPartida)) {
                partida.setResultado(novoResultado);
                System.out.println("Resultado atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }

    
    public void excluirPartidasSingulares(int idPartida) {
        for (int i = 0; i < partidasSingulares.size(); i++) {
            PartidasSingulares partida = PartidasSingulares.getId(i);
            if (partida.getId().equals(idPartida)) {
                idpartidas.remove(i);
                System.out.println("Partida excluída com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }


    private static class PartidasSingulares {
        private static int contador = 1;
        private String jogador1;
        private String jogador2;
        private String arbitro;
        private String resultado;
        private int idPartida;
        private double tempo;

        public PartidasSingulares(String jogador1, String jogador2, String arbitro, String resultado, int idPartida, double tempo) {
            this.idPartida = contador;
            contador++;
            this.jogador1 = jogador1;
            this.jogador2 = jogador2;
            this.arbitro = arbitro;
            this.resultado = resultado;
            this.tempo = tempo;
        }


        public String getJogador1() {
            return jogador1;
        }

        public String getJogador2() {
            return jogador2;
        }

         public String getArbitro() {
            return arbitro;
        }

        public String getResultado() {
            return resultado;
        }
        public int getIdPartida() {
            return idPartida;
        }

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        public double gettempo() {
            return tempo;
        }

        @Override
        public String toString() {
            return  ", Jogador 1 Equipe 1: " + jogador1 + ", Jogador 2 Equipe 1: " + jogador2 + ", Jogador 1 Equipe 2: " + jogador1 + ", Jogador 2 Equipe 2: " + jogador2 + ", Arbitro: " + arbitro + ", Resultado: " + resultado + "ID Partida: " + idPartida + ", Tempo partida: " + tempo;
        }
    }
}
