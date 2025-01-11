import java.util.ArrayList;
import java.util.List;

public class ControllerGerirPartidasSingulares {
    private List<PartidaSingular> partidas;

    public ControllerGerirPartidasSingulares() {
        this.partidas = new ArrayList<>();
    }

    // Adiciona uma partida singular, verifica se há dois jogadores e um árbitro
    public boolean adicionarPartida(String jogador1, String jogador2, String arbitro) {
        if (jogador1.isEmpty() || jogador2.isEmpty() || arbitro.isEmpty()) {
            return false; // Falha ao adicionar: Jogadores ou árbitro inválidos
        }
        PartidaSingular partida = new PartidaSingular(jogador1, jogador2, arbitro, 30);
        partidas.add(partida);
        return true;
    }

    // Retorna a lista de partidas formatada
    public ArrayList<String> listarPartidas() {
        ArrayList<String> lista = new ArrayList<>();
        for (PartidaSingular partida : partidas) {
            lista.add(partida.toString());
        }
        return lista;
    }

    // Define o vencedor de uma partida com base no índice
    public boolean definirVencedor(int indice, String vencedor) {
        if (indice >= 0 && indice < partidas.size()) {
            partidas.get(indice).setVencedor(vencedor);
            return true;
        }
        return false; // Falha: índice inválido
    }
}

// Classe representando uma partida singular
class PartidaSingular {
    private String jogador1;
    private String jogador2;
    private String arbitro;
    private String vencedor;
    private int tempoPartida;

    public PartidaSingular(String jogador1, String jogador2, String arbitro, int tempoPartida) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.arbitro = arbitro;
        this.tempoPartida = tempoPartida;
        this.vencedor = "Ainda não definido";
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    @Override
    public String toString() {
        return "Jogador 1: " + jogador1 + ", Jogador 2: " + jogador2 + ", Árbitro: " + arbitro +
               ", Tempo: " + tempoPartida + "min, Vencedor: " + vencedor;
    }
}
