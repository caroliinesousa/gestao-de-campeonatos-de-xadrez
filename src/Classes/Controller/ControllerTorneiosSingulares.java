package Classes.Controller;
import java.util.ArrayList;
import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
import Classes.Torneios.TorneioSingularesEliminatorias;
import Classes.Torneios.TorneioSingularesPontos;
/**
 * Classe responsável pelo gerenciamento de torneios de singulares,
 * incluindo torneios por eliminatórias e por pontos.
 */
public class ControllerTorneiosSingulares {
    private TorneioSingularesEliminatorias tse;
    private TorneioSingularesPontos tsp;

    public ControllerTorneiosSingulares() {
        this.tse = new TorneioSingularesEliminatorias();
        this.tsp = new TorneioSingularesPontos();
        //criaTorneioTeste();
    }
    /**
     * Cadastra um torneio de eliminatórias com as partidas fornecidas.
     *
     * @param p1 Primeira partida do torneio.
     * @param p2 Segunda partida do torneio.
     * @param p3 Terceira partida do torneio.
     */
    public void cadastrarTorneioEliminatorios(PartidaSingulares p1, PartidaSingulares p2, PartidaSingulares p3) {
        tse.adicionarPartida(p1);
        tse.adicionarPartida(p2);
        tse.adicionarPartida(p3);
        
    }
     /**
     * Cadastra um torneio de pontos com as partidas fornecidas.
     *
     * @param p1 Primeira partida do torneio.
     * @param p2 Segunda partida do torneio.
     * @param p3 Terceira partida do torneio.
     */
    public void cadastrarTorneioPontos(PartidaSingulares p1, PartidaSingulares p2, PartidaSingulares p3) {
        tsp.adicionarPartida(p1);
        tsp.adicionarPartida(p2);
        tsp.adicionarPartida(p3);
        
    }

     /**
     * Consulta as partidas do torneio de eliminatórias.
     *
     * @return Lista de partidas cadastradas no torneio de eliminatórias.
     */
    public ArrayList<PartidaSingulares> consultarTorneioEliminatorio() {
        return tse.getPartidas();
    }
    /**
     * Consulta as partidas do torneio de pontos.
     *
     * @return Lista de partidas cadastradas no torneio de pontos.
     */
    public ArrayList<PartidaSingulares> consultarTorneioPontos() {
        return tsp.getPartidas();
    }

    /**
     * Consulta as partidas do torneio de pontos.
     *
     * @return Lista de partidas cadastradas no torneio de pontos.
     */
    public void atualizarTorneioEliminatorio(PartidaSingulares p1, PartidaSingulares p2, PartidaSingulares p3) {
        tse.excluirPartidas();
        tse.adicionarPartida(p1);
        tse.adicionarPartida(p2);
        tse.adicionarPartida(p3);
    }
    /**
     * Atualiza as partidas do torneio de pontos, substituindo pelas fornecidas.
     *
     * @param p1 Nova primeira partida do torneio.
     * @param p2 Nova segunda partida do torneio.
     * @param p3 Nova terceira partida do torneio.
     */
    public void atualizarTorneioPontos(PartidaSingulares p1, PartidaSingulares p2, PartidaSingulares p3) {
        tsp.excluirPartidas();
        tsp.adicionarPartida(p1);
        tsp.adicionarPartida(p2);
        tsp.adicionarPartida(p3);
    }
    /**
     * Exclui todas as partidas do torneio de eliminatórias.
     */
    public void excluirTorneiosEliminatorios() {
        tse.excluirPartidas();
        
       
    }
    /**
     * Exclui todas as partidas do torneio de pontos.
     */
    public void excluirTorneiosPontos() {
        tsp.excluirPartidas();
        
       
    }
    /**
     * Gera uma string com informações detalhadas das partidas do torneio de eliminatórias.
     *
     * @return Informações das partidas do torneio de eliminatórias.
     */
    public String getPartidasTextoEliminatoria(){
        String mensagem = "";
        for (PartidaSingulares ps : tse.getPartidas()){
            //resultado e tempo
            mensagem += "Partida" + ps.getId() + "\nJogador 1: " + ps.getJogador1().getNome() + "\nJogador 2: " + ps.getJogador2().getNome() + "\nArbitro: " + ps.getArbitro().getNome()  + "\nVencedor Torneio Eliminatorios: " + ps.getVencedor() + "\nDuração da Partida: " + ps.getTempo();
        }
        return mensagem;
    }
    /**
     * Gera uma string com informações detalhadas das partidas do torneio de pontos.
     *
     * @return Informações das partidas do torneio de pontos.
     */
    public String getPartidasTextoPontos(){
        String mensagem = "";
        for (PartidaSingulares ps : tsp.getPartidas()){
            //resultado e tempo
            mensagem += "Partida" + ps.getId() + "\nJogador 1: " + ps.getJogador1().getNome() + "\nJogador 2: " + ps.getJogador2().getNome() + "\nArbitro: " + ps.getArbitro().getNome() + "\nVencedor Torneio Pontos: " + ps.getVencedor() + "\nDuração da Partida: " + ps.getTempo();
        }
        return mensagem;
    }
    /**
     * Método de teste para criar torneios de exemplo com dados fictícios.
     */
    public void criaTorneioTeste(){
        Arbitro arbitro = new Arbitro("Luan", 65, 'M', "FADE");
        Jogador jogador1 = new Jogador("joao", 22, 'M');
        Jogador jogador2 = new Jogador("kalebe", 22, 'M');
        Jogador jogador3 = new Jogador("vitor", 22, 'M');
        Jogador jogador4 = new Jogador("carlos", 22, 'M');

        PartidaSingulares partida1 = new PartidaSingulares(jogador1, jogador2, arbitro, 2.0, 1, "Eliminatorio");
        partida1.setVencedor(jogador2.getNome());
        PartidaSingulares partida2 = new PartidaSingulares(jogador3, jogador4, arbitro, 2.0, 2, "Eliminatorio");
        partida2.setVencedor(jogador4.getNome());
        PartidaSingulares partida3 = new PartidaSingulares(jogador2, jogador4, arbitro, 2.0, 3, "Eliminatorio");
        partida3.setVencedor(jogador2.getNome());

        tse.adicionarPartida(partida1);
        tse.adicionarPartida(partida2);
        tse.adicionarPartida(partida3);
        tsp.adicionarPartida(partida1);
        tsp.adicionarPartida(partida2);
        tsp.adicionarPartida(partida3);

    }


    

}
