package Classes.Controller;
import java.util.ArrayList;

public class ControllerTorneios {
    private ArrayList<Partida> partidas;

    public ControllerTorneios() {
        partidas = new ArrayList<>();
    }

    
    public void cadastrarTorneios(String jogador1, String jogador2, String arbitro, String resultado, int idPartida, double tempoPartida) {
        Partida novaPartida = new Partida(jogador1, jogador2, arbitro, resultado, idPartida, tempoPartida);
        partidas.add(novaPartida);
        System.out.println("Torneio cadastrado com sucesso!");
    }

    public String consultarTorneios(int idPartida) {
        for (int i = 0; i < torneios.size(); i++) {
           Torneio torneios = Torneios.get(i);
            if (torneios.getIdPartidas().equals(idPartida)) {
                return "Partida encontrada: " + torneios.toString();
            }
        }
        return "Partida não encontrada.";
    }

    public void atualizarTorneios(int idTorneios, String novoResultado) {
        for (int i = 0; i < Torneios.size(); i++) {
            Torneios torneios = torneios.get(i);
            if (torneios.getIdPartidas().equals(idPartida)) {
                torneios.setResultado(novoResultado);
                System.out.println("Resultado atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Torneios  não encontrada.");
    }

    public void excluirTorneios(int idTorneios) {
        for (int i = 0; i < torneios.size(); i++) {
            Torneios torneios = torneios.get(i);
            if (torneios.getId().equals(idTorneios)) {
                torneios.remove(i);
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

        public Torneios(String jogador1, String jogador2, String arbitro, String resultado, int idPartida, double tempoPartida) {
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
        public int getIdPartidas() {
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
