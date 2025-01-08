package Classes.Controller;
import java.util.ArrayList;

public class ControllerPartidas {
    private ArrayList<Partida> partidas;

    public ControllerPartidas() {
        partidas = new ArrayList<>();
    }

    
    public void cadastrarPartida(String jogador1, String jogador2, String arbitro, String resultado, int idPartida, double tempoPartida) {
        Partida novaPartida = new Partida(jogador1, jogador2, arbitro, resultado, idPartida, tempoPartida);
        partidas.add(novaPartida);
        System.out.println("Partida cadastrada com sucesso!");
    }

    
    public String consultarPartida(int idPartida) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getIdPartida().equals(idPartida)) {
                return "Partida encontrada: " + idPartida;
            }
        }
        return "Partida não encontrada.";
    }

    
    public void atualizarPartida(int idPartida, String novoResultado) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getIdPartida().equals(idPartida)) {
                partida.setResultado(novoResultado);
                System.out.println("Resultado atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }

    
    public void excluirPartida(int idPartida) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getId().equals(idPartida)) {
                idpartidas.remove(i);
                System.out.println("Partida excluída com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }


    private static class Partida {
        private static int contador = 1;
        private String jogador1;
        private String jogador2;
        private String arbitro;
        private String resultado;
        private int idPartida;
        private double tempoPartida;

        public Partida(String jogador1, String jogador2, String arbitro, String resultado, int idPartida, double tempoPartida) {
            this.idPartida = "P" + contador;
            contador++;
            this.jogador1 = jogador1;
            this.jogador2 = jogador2;
            this.arbitro = arbitro;
            this.resultado = resultado;
            this.tempoPartida = tempoPartida;
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
        public String getIdPartida() {
            return idPartida;
        }

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        public String getTempoPartida() {
            return tempoPartida;
        }

        @Override
        public String toString() {
            return  ", Jogador 1: " + jogador1 + ", Jogador 2: " + jogador2 + ", Arbitro: " + arbitro + ", Resultado: " + resultado + "ID Partida: " + idPartida + ", Tempo partida: " tempoPartida;
        }
    }
}
