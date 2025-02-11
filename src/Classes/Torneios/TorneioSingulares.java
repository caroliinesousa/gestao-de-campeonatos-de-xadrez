package Classes.Torneios;
import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Jogador;
import java.util.ArrayList;
/**
 * A classe abstrata {@code TorneioSingulares} representa um torneio de partidas singulares.
 * <p>
 * Fornece métodos para adicionar e excluir partidas, além de determinar o vencedor com base
 * no ranking dos jogadores.
 * </p>
 */
public abstract class TorneioSingulares {
    /** Lista de partidas singulares pertencentes ao torneio. */
    private ArrayList<PartidaSingulares> partidas;
     /**
     * Construtor padrão da classe {@code TorneioSingulares}.
     * Inicializa a lista de partidas.
     */
    public TorneioSingulares() {
        this.partidas = new ArrayList<>();
    }
    /**
     * Adiciona uma partida ao torneio de singulares.
     *
     * @param partida a partida singular a ser adicionada
     */
    public void adicionarPartida(PartidaSingulares partida) {
        partidas.add(partida);
        System.out.println("Partida adicionada ao torneio de singulares.");
    }
    /**
     * Retorna a lista de partidas do torneio.
     *
     * @return uma lista contendo todas as partidas singulares
     */
    public ArrayList<PartidaSingulares> getPartidas(){
        return this.partidas;
    }
    /**
     * Exclui todas as partidas do torneio de singulares.
     */
    public void excluirPartidas(){
        partidas.clear();
        System.out.println("Partida excluída do torneio singulares.");

    }
    /**
     * Determina o vencedor do torneio de singulares com base no menor ranking dos jogadores.
     * <p>
     * O jogador com o menor ranking entre todas as partidas realizadas é considerado o vencedor.
     * </p>
     *
     * @return uma mensagem indicando o vencedor do torneio
     */
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
