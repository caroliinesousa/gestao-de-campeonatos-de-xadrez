package Classes.Controller;
import java.util.ArrayList;

import Classes.Partidas.PartidaDuplas;

public class ControllerPartidasDuplas {
    private ArrayList<PartidaDuplas> partidasDuplas;

    public ControllerPartidasDuplas() {
        partidasDuplas = new ArrayList<>();
    }

     public void cadastrarPartidasDuplas(String jogador1Equipe1, String jogador1Equipe2, String jogador2Equipe1, String jogador2Equipe2, String arbitro, String resultado, int idPartida, double tempo) {
        PartidasDuplas novaPartida = new PartidasDuplas(jogador1Equipe1, jogador2Equipe1, jogador1Equipe2, jogador2Equipe2, arbitro, resultado, idPartida, tempo);
        PartidasDuplas.add(novaPartida);
        System.out.println("Partida cadastrada com sucesso!");
    }

    public String consultarPartidasDuplas(int idPartida) {
        for (int i = 0; i < partidasDuplas.size(); i++) {
            PartidasDuplas partidaDuplas = PartidasDuplas.get(i);
            if (partidasDuplas.getIdPartida().equals(idPartida)) {
                return "Partida encontrada: " + idPartida;
            }
        }
        return "Partida não encontrada.";
    }

     public void atualizarPartidasDuplas(int idPartida, String novoResultado) {
        for (int i = 0; i < partidasDuplas.size(); i++) {
            PartidasDuplas partidaDuplas = PartidasDuplas.get(i);
            if (partidasDuplas.getIdPartida().equals(idPartida)) {
                partidasDuplas.setResultado(novoResultado);
                System.out.println("Resultado atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }

    
    public void excluirPartidasDuplas(int idPartida) {
        for (int i = 0; i < partidasDuplas.size(); i++) {
            PartidasDuplas partida = partida.get(i);
            if (partidasDuplas.getIdPartidas().equals(idPartida)) {
                idpartidas.remove(i);
                System.out.println("Partida excluída com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }

    private static class PartidasDuplas {
        private static int contador = 1;
        private String jogador1Equipe1;
        private String jogador2Equipe1;
        private String jogador1Equipe2;
        private String jogador2Equipe2;
        private String arbitro;
        private String resultado;
        private int idPartida;
        private double tempo;

        public PartidasDuplas(String jogador1Equipe1, String jogador2Equipe1, String jogador1Equipe2, String jogador2Equipe2, String arbitro, String resultado, int idPartida, double tempo) {
            this.idPartida = contador;
            contador++;
            this.jogador1Equipe1 = jogador1Equipe1;
            this.jogador2Equipe1 = jogador2Equipe1;
            this.jogador1Equipe2 = jogador1Equipe2;
            this.jogador2Equipe2 = jogador2Equipe2;
            this.arbitro = arbitro;
            this.resultado = resultado;
            this.tempo = tempo;
        }

        public String getJogador1Equipe1() {
            return jogador1Equipe1;
        }

        public String getJogador2Equipe1() {
            return jogador2Equipe1;
        }

        public String getJogador1Equipe2() {
            return jogador1Equipe2;
        }

        public String getJogador2Equipe2() {
            return jogador2Equipe2;
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

        Override
        public String toString() {
            return  ", Jogador 1 Equipe 1: " + jogador1Equipe1 + ", Jogador 2 Equipe 1: " + jogador2Equipe1 +  ", jogador 1 Equipe 2  " + jogador1Equipe2 + " jogador 2 Equipe 2 " + jogador2Equipe2 + " arbitro: " + arbitro + " Resultado: " + resultado  + "  IDPartida:  " + idPartida + ", Tempo partida: " + tempo;
        }
    }
}

