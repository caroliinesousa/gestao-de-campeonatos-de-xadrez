package Classes.Torneios;

import java.util.ArrayList;

import Classes.Partidas.Equipe;
import Classes.Partidas.PartidaDuplas;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;

public abstract class TorneioDuplas {
    private ArrayList<PartidaDuplas> partidas;

    public TorneioDuplas() {
        this.partidas = new ArrayList<>();

    }

    public void adicionarPartida(PartidaDuplas partida) {
        partidas.add(partida);
        System.out.println("Partida adicionada ao torneio de duplas.");
    }

    public String determinarVencedorTorneioDuplas(Equipe[] equipes) {

        Equipe vencedora = equipes[0];

        int pontos = equipes[0].getPontos();
        for (Equipe equipe : equipes) {
            if (pontos < equipe.getPontos()) {
                vencedora = equipe;
            }
            pontos = equipe.getPontos();
        }

        return "A euipe vencedora do torneio de duplas foi: " + vencedora;
    }

    public void realizarTorneio() {
        Arbitro arbitro = new Arbitro("jose", 65, 'M', "FIFA");
        Jogador jogador1 = new Jogador("joao", 22, 'M');
        Jogador jogador2 = new Jogador("joao", 22, 'M');
        Jogador jogador3 = new Jogador("joao", 22, 'M');
        Jogador jogador4 = new Jogador("joao", 22, 'M');
        Jogador jogador5 = new Jogador("joao", 22, 'M');
        Jogador jogador6 = new Jogador("joao", 22, 'M');
        Jogador jogador7 = new Jogador("joao", 22, 'M');
        Jogador jogador8 = new Jogador("joao", 22, 'M');

        Equipe equipe1 = new Equipe(0, 0, 0, jogador1, jogador2);
        Equipe equipe2 = new Equipe(0, 0, 0, jogador3, jogador4);
        Equipe equipe3 = new Equipe(0, 0, 0, jogador5, jogador6);
        Equipe equipe4 = new Equipe(0, 0, 0, jogador7, jogador8);

        Equipe[] equipes = { equipe1, equipe2, equipe3, equipe4 };

        PartidaDuplas partida1 = new PartidaDuplas(arbitro, jogador1, jogador2, jogador3, jogador4, null, 0);
        PartidaDuplas partida2 = new PartidaDuplas(arbitro, jogador5, jogador6, jogador7, jogador8, null, 0);
        PartidaDuplas partida3 = new PartidaDuplas(arbitro, jogador1, jogador2, jogador7, jogador8, null, 0);

        determinarVencedorTorneioDuplas(equipes);
    }
}
