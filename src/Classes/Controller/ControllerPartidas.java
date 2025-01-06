package Classes.Controller;
import java.util.ArrayList;

public class ControllerPartidas {
    private ArrayList<Partida> partidas;

    public ControllerPartidas() {
        partidas = new ArrayList<>();
    }

    
    public void cadastrarPartida(String jogador1, String jogador2, String arbitro, String resultado, int id double tempoPartida) {
        Partida novaPartida = new Partida(jogador1, jogador2, arbitro, resultado, id, tempoPartida);
        partidas.add(novaPartida);
        System.out.println("Partida cadastrada com sucesso!");
    }

    
    public String consultarPartida(String idPartida) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getId().equals(idPartida)) {
                return "Partida encontrada: " + partida.toString();
            }
        }
        return "Partida não encontrada.";
    }

    
    public void atualizarPartida(String idPartida, String novoResultado) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getId().equals(idPartida)) {
                partida.setResultado(novoResultado);
                System.out.println("Resultado atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }

    
    public void excluirPartida(String idPartida) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getId().equals(idPartida)) {
                partidas.remove(i);
                System.out.println("Partida excluída com sucesso!");
                return;
            }
        }
        System.out.println("Partida não encontrada.");
    }


    private static class Partida {
        private static int contador = 1;
        private String id;
        private String jogador1;
        private String jogador2;
        private String arbitro;
        private String resultado;
        private int id;
        private double tempoPartida;

        public Partida(String jogador1, String jogador2, String arbitro, String resultado, int id, double tempoPartida) {
            this.id = "P" + contador;
            contador++;
            this.jogador1 = jogador1;
            this.jogador2 = jogador2;
            this.arbitro = arbitro;
            this.resultado = resultado;
            this.tempoPartida = tempoPartida;
        }

        public String getId() {
            return id;
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

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        public String getTempoPartida() {
            return tempoPartida;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Jogador 1: " + jogador1 + ", Jogador 2: " + jogador2 + ", Arbitro: " + arbitro + ", Resultado: " + resultado + ", Tempo partida: " tempoPartida;
        }
    }
}
