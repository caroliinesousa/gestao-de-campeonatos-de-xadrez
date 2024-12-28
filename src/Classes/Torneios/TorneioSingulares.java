package Classes.Torneios;
import java.util.ArrayList;

import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Jogador;

public abstract class TorneioSingulares {
    private ArrayList<PartidaSingulares> partidas;

    public TorneioSingulares() {
        this.partidas = new ArrayList<>();
    }
    public void adicionarPartida(PartidaSingulares partida) {
        partidas.add(partida);
        System.out.println("Partida adicionada ao torneio de singulares.");
    }

    public String determinarVencedorTorneioSingulares() {
        if (partidas.size() == 0) {
            return "Nenhuma partida foi realizada.";
        }

        Jogador vencedor = new Jogador("Joao", 20, 'M');
        int maiorRanking = 9999;

        for (PartidaSingulares partida : partidas) {
            Jogador jogador1 = partida.getJogador1();
            Jogador jogador2 = partida.getJogador2();
            

            if (jogador1.getRanking() < maiorRanking) {
                vencedor = jogador1;
                maiorRanking = jogador1.getRanking();
            }

            if (jogador2.getRanking() < maiorRanking) {
                vencedor = jogador2;
                maiorRanking = jogador2.getRanking();
            }
        }

        return "Vencedor do Torneio: " + vencedor.getNome();
    }
}
