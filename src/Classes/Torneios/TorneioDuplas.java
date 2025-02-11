package Classes.Torneios;

import java.util.ArrayList;
import Classes.Partidas.Equipe;
import Classes.Partidas.PartidaDuplas;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
/**
 * A classe abstrata {@code TorneioDuplas} representa um torneio de partidas em duplas.
 * <p>
 * Fornece métodos para adicionar partidas ao torneio, determinar o vencedor com base nos pontos acumulados,
 * e realizar o torneio, simulando equipes e partidas.
 * </p>
 */
public abstract class TorneioDuplas {
     /** Lista de partidas de duplas pertencentes ao torneio. */
    private ArrayList<PartidaDuplas> partidas;
     /**
     * Construtor padrão da classe {@code TorneioDuplas}.
     * Inicializa a lista de partidas.
     */
    public TorneioDuplas() {
        this.partidas = new ArrayList<>();

    }
    /**
     * Adiciona uma partida ao torneio de duplas.
     *
     * @param partida a partida de duplas a ser adicionada
     */
    public void adicionarPartida(PartidaDuplas partida) {
        partidas.add(partida);
        System.out.println("Partida adicionada ao torneio de duplas.");
    }
    /**
     * Determina a equipe vencedora do torneio com base nos pontos acumulados.
     *
     * @param equipes as equipes participantes do torneio
     * @return uma mensagem indicando a equipe vencedora
     */
    public String determinarVencedorTorneioDuplas(Equipe[] equipes) {

        Equipe vencedora = equipes[0];

        int pontos = equipes[0].getPontos();
        for (Equipe equipe : equipes) {
            if (pontos < equipe.getPontos()) {
                vencedora = equipe;
            }
            pontos = equipe.getPontos();
        }

        return "A equipe vencedora do torneio de duplas foi: " + vencedora;
    }
    /**
     * Simula a realização do torneio de duplas, criando equipes e partidas fictícias.
     */
    public void realizarTorneio() {
        Arbitro arbitro = new Arbitro("jose", 65, 'M', "FADE");
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
         // Classe anônima para instanciar um torneio abstrato.
        TorneioDuplas torneio1 = new TorneioDuplas() {
            
        };
        TorneioDuplas torneio2 = new TorneioDuplas(arbitro, jogador5, jogador6, jogador7, jogador8, null, 0);
        TorneioDuplas torneio3 = new TorneioDuplas(arbitro, jogador1, jogador2, jogador7, jogador8, null, 0);

        determinarVencedorTorneioDuplas(equipes);
    }
}
