package Classes.Controller;
import java.util.ArrayList;

public class ControllerCampeonato {
    private ArrayList<Partida> partidas;

    public ControllerCampeonato() {
        partidas = new ArrayList<>();
    }

    // Método para cadastrar uma nova partida
    public void cadastrarPartida(String jogador1, String jogador2, String resultado) {
        Partida novaPartida = new Partida(jogador1, jogador2, resultado);
        partidas.add(novaPartida);
        System.out.println("Partida cadastrada com sucesso!");
    }

    // Método para consultar uma partida pelo ID
    public String consultarPartida(String idPartida) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getId().equals(idPartida)) {
                return "Partida encontrada: " + partida.toString();
            }
        }
        return "Partida não encontrada.";
    }

    // Método para atualizar o resultado de uma partida
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

    // Método para excluir uma partida pelo ID
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

    // Classe interna representando uma partida
    private static class Partida {
        private static int contador = 1;
        private String id;
        private String jogador1;
        private String jogador2;
        private String resultado;

        public Partida(String jogador1, String jogador2, String resultado) {
            this.id = "P" + contador;
            contador++;
            this.jogador1 = jogador1;
            this.jogador2 = jogador2;
            this.resultado = resultado;
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

        public String getResultado() {
            return resultado;
        }

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Jogador 1: " + jogador1 + ", Jogador 2: " + jogador2 + ", Resultado: " + resultado;
        }
    }
}
