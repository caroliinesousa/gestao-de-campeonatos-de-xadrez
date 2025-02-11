package Classes.Controller;

import java.util.ArrayList;
import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
/**
 * Classe responsável por gerenciar partidas de singulares, incluindo operações como
 * adicionar, atualizar, consultar, listar e excluir partidas.
 */
public class ControllerPartidasSingulares {
    private ArrayList<PartidaSingulares> partidas;

    public ControllerPartidasSingulares() {
        this.partidas = new ArrayList<>();
    }
     /**
     * Adiciona uma partida pronta à lista de partidas.
     *
     * @param ps Objeto do tipo PartidaSingulares a ser adicionado.
     */
    public void adicionaPartidaPronta(PartidaSingulares ps){
        partidas.add(ps);
    }
    /**
     * Adiciona uma nova partida de singulares à lista.
     *
     * @param jogador1 Jogador 1 da partida.
     * @param jogador2 Jogador 2 da partida.
     * @param arbitro  Árbitro responsável pela partida.
     * @param id       Identificador único da partida.
     * @param tipo     Tipo da partida.
     * @return true se a partida foi adicionada com sucesso.
     */
    public boolean adicionarPartida(Jogador jogador1, Jogador jogador2, Arbitro arbitro, int id, String tipo) {
        PartidaSingulares partida = new PartidaSingulares(jogador1, jogador2, arbitro, 0, id, tipo);
        partidas.add(partida);
        jogador1.incrementarPartidas();
        jogador2.incrementarPartidas();
        return true;
    }
     /**
     * Retorna a lista de partidas registradas.
     *
     * @return Lista de objetos do tipo PartidaSingulares.
     */
    public ArrayList<PartidaSingulares> listarPartidas() {
        return partidas;
    }
    /**
     * Consulta uma partida de singulares pelo ID e retorna informações detalhadas.
     *
     * @param id Identificador único da partida.
     * @return String com as informações da partida ou mensagem de não encontrado.
     */
    public String consultarPartidasSingulares(int id){
        for (PartidaSingulares ps : partidas) {
            if (ps.getId() == id) {
                String mensagem = "Partida encontrada! \nJogador 1: " + ps.getJogador1().getNome() + "\nJogador 2: " + ps.getJogador2().getNome() + "\nArbitrada por: " + ps.getArbitro().getNome() + "\nO Vencedor foi: " + ps.getVencedor() + "\nDuração da Partida: " + ps.getTempo();
                return mensagem;

            }

        } 
        return "Partida não encontrada!";
    }       
    /**
     * Retorna um objeto do tipo PartidaSingulares correspondente ao ID fornecido.
     *
     * @param id Identificador único da partida.
     * @return Objeto PartidaSingulares correspondente ou null se não encontrado.
     */
    public PartidaSingulares devolverPartidasSingulares(int id){
        for (PartidaSingulares ps : partidas) {
            if (ps.getId() == id) {
                return ps;

            }

        } 
        return null;
    }    
    /**
     * Atualiza as informações de uma partida de singulares pelo ID.
     *
     * @param jogador1 Jogador 1 da partida.
     * @param jogador2 Jogador 2 da partida.
     * @param arbitro  Árbitro responsável pela partida.
     * @param vencedor Nome do vencedor da partida.
     * @param tempo    Duração da partida.
     * @param id       Identificador único da partida.
     * @param tipo     Tipo da partida.
     * @return true se a partida foi atualizada com sucesso, false caso contrário.
     */
    public boolean atualizarPartida(Jogador jogador1, Jogador jogador2, Arbitro arbitro, String vencedor, double tempo,
            int id, String tipo) {
        for (PartidaSingulares ps : partidas) {
            if (ps.getId() == id) {
                ps.setJogador1(jogador1);
                ps.setJogador2(jogador2);
                ps.setArbitro(arbitro);
                ps.setVencedor(vencedor);
                ps.setTempo(tempo);
                ps.setTipo(tipo);

                if(jogador1.getNome().equals(vencedor)){
                    jogador1.adicionarPontos(5);

                }else{
                    jogador2.adicionarPontos(5);

                }
                return true;
            }

        }
        return false;

    }
    /**
     * Exclui uma partida de singulares pelo ID.
     *
     * @param id Identificador único da partida.
     * @return true se a partida foi excluída com sucesso, false caso contrário.
     */
    public boolean excluirPartida(int id) {
        for (PartidaSingulares ps : partidas) {
            if (ps.getId() == id) {
                partidas.remove(ps);
                return true;

            }

        }
        return false;

    }
}
