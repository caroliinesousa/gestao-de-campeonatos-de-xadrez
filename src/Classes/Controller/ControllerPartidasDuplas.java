package Classes.Controller;
import java.util.ArrayList;

import Classes.Partidas.PartidaDuplas;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;

public class ControllerPartidasDuplas {
    private ArrayList<PartidaDuplas> partidas;
    /**
 * Classe responsável por gerenciar partidas de duplas, incluindo operações como
 * adicionar, atualizar, consultar, listar e excluir partidas.
 */
    public ControllerPartidasDuplas() {
        this.partidas = new ArrayList<>(); 
    }
     /**
     * Adiciona uma partida pronta à lista de partidas.
     *
     * @param pd Objeto do tipo PartidaDuplas a ser adicionado.
     */
    public void adicionaPartidaPronta(PartidaDuplas pd){
        partidas.add(pd);
    }
    /**
     * Adiciona uma nova partida de duplas à lista.
     *
     * @param jogador1Equipe1 Jogador 1 da equipe 1.
     * @param jogador2Equipe1 Jogador 2 da equipe 1.
     * @param jogador1Equipe2 Jogador 1 da equipe 2.
     * @param jogador2Equipe2 Jogador 2 da equipe 2.
     * @param arbitro         Árbitro responsável pela partida.
     * @param id              Identificador único da partida.
     * @return true se a partida foi adicionada com sucesso.
     */
    public boolean adicionarPartida(Jogador jogador1Equipe1, Jogador jogador2Equipe1, Jogador jogador1Equipe2, Jogador jogador2Equipe2, Arbitro arbitro, int id) {
        PartidaDuplas partida = new PartidaDuplas(jogador1Equipe1, jogador1Equipe1, jogador2Equipe1, jogador1Equipe2, jogador2Equipe2, arbitro, "Ainda não definido! ", id, id);
        partidas.add(partida);
        jogador1Equipe1.incrementarPartidas();
        jogador2Equipe1.incrementarPartidas();
        jogador1Equipe2.incrementarPartidas();
        jogador2Equipe2.incrementarPartidas();
        return true;
    }
    /**
     * Retorna a lista de partidas registradas.
     *
     * @return Lista de objetos do tipo PartidaDuplas.
     */
    public ArrayList<PartidaDuplas> listarPartidas() {
        return partidas;
    }
     /**
     * Consulta uma partida de duplas pelo ID e retorna informações detalhadas.
     *
     * @param id Identificador único da partida.
     * @return String com as informações da partida ou mensagem de não encontrado.
     */
    public String consultarPartidasDuplas(int id){
        for (PartidaDuplas ps : partidas) {
            if (ps.getId() == id) {
                String mensagem = "Partida encontrada! \nJogador 1: " + ps.getJogador1Equipe1().getNome() + "\nJogador 2: " + ps.getJogador2Equipe1().getNome() + "\nJogador 3: " + ps.getJogador1Equipe2().getNome() + "\nJogador 4: " + ps.getJogador2Equipe2().getNome() + "\nArbitrada por: " + ps.getArbitro().getNome() + "\nO Vencedor foi: " + ps.getVencedor() + "\nDuração da Partida: " + ps.getTempo();
                return mensagem;

            }

        } 
        return "Partida não encontrada!";
    }       
    /**
     * Retorna um objeto do tipo PartidaDuplas correspondente ao ID fornecido.
     *
     * @param id Identificador único da partida.
     * @return Objeto PartidaDuplas correspondente ou null se não encontrado.
     */
    public PartidaDuplas devolverPartidasDuplas(int id){
        for (PartidaDuplas pd : partidas) {
            if (pd.getId() == id) {
                return pd;

            }

        } 
        return null;
    }    
    /**
     * Atualiza as informações de uma partida de duplas pelo ID.
     *
     * @param jogador1Equipe1 Jogador 1 da equipe 1.
     * @param jogador2Equipe1 Jogador 2 da equipe 1.
     * @param jogador1Equipe2 Jogador 1 da equipe 2.
     * @param jogador2Equipe2 Jogador 2 da equipe 2.
     * @param arbitro         Árbitro responsável pela partida.
     * @param vencedor        Nome do vencedor da partida.
     * @param tempo           Duração da partida.
     * @param id              Identificador único da partida.
     * @return true se a partida foi atualizada com sucesso, false caso contrário.
     */
    public boolean atualizarPartida(Jogador jogador1Equipe1, Jogador jogador2Equipe1, Jogador jogador1Equipe2, Jogador jogador2Equipe2, Arbitro arbitro, String vencedor, double tempo, int id) {
        for (PartidaDuplas ps : partidas) {
            if (ps.getId() == id) {
                ps.setJogador1Equipe1(jogador1Equipe1);
                ps.setJogador2Equipe1(jogador2Equipe1);
                ps.setJogador1Equipe2(jogador2Equipe1);
                ps.setJogador2Equipe2(jogador2Equipe2);
                ps.setArbitro(arbitro);
                ps.setVencedor(vencedor);
                ps.setTempo(tempo);

                if(jogador1Equipe1.getNome().equals(vencedor) || jogador2Equipe1.getNome().equals(vencedor)){
                    jogador1Equipe1.adicionarPontos(5); jogador2Equipe1.adicionarPontos(5);

                }else{
                    jogador1Equipe2.adicionarPontos(5); 
                    jogador2Equipe2.adicionarPontos(5);

                }
                return true;
            }

        }
        return false;

    }
    /**
     * Exclui uma partida de duplas pelo ID.
     *
     * @param id Identificador único da partida.
     * @return true se a partida foi excluída com sucesso, false caso contrário.
     */
    public boolean excluirPartida(int id) {
        for (PartidaDuplas ps : partidas) {
            if (ps.getId() == id) {
                partidas.remove(ps);
                return true;

            }

        }
        return false;

    }
}
