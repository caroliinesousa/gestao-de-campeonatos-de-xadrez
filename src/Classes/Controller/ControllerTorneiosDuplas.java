package Classes.Controller;
import java.util.ArrayList;

import Classes.Partidas.PartidaDuplas;
import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
import Classes.Torneios.TorneioDuplas;
/**
 * Classe responsável por gerenciar torneios de duplas, incluindo operações como
 * cadastro, consulta, atualização e exclusão de partidas associadas ao torneio.
 */
public class ControllerTorneiosDuplas {
    private TorneioDuplas td;
    

    public ControllerTorneiosDuplas() {
        this.td = new TorneioDuplas();
        
        //criaTorneioTeste();
    }
    /**
     * Cadastra um torneio de duplas com as partidas fornecidas.
     *
     * @param p1 Partida 1 do torneio.
     * @param p2 Partida 2 do torneio.
     * @param p3 Partida 3 do torneio.
     */
    public void cadastrarTorneioDuplas(PartidaDuplas p1, PartidaDuplas p2, PartidaDuplas p3) {
        td.adicionarPartida(p1);
        td.adicionarPartida(p2);
        td.adicionarPartida(p3);
        
    }
    /**
     * Consulta as partidas registradas no torneio de duplas.
     *
     * @return Lista de partidas do tipo PartidaDuplas.
     */
    public ArrayList<PartidaDuplas> consultarTorneioDuplas() {
        return td.getPartidas();
    }
    /**
     * Atualiza as partidas associadas ao torneio de duplas, substituindo as atuais
     * pelas fornecidas.
     *
     * @param p1 Nova partida 1 do torneio.
     * @param p2 Nova partida 2 do torneio.
     * @param p3 Nova partida 3 do torneio.
     */
    public void atualizarTorneioDuplas(PartidaDuplas p1, PartidaDuplas p2, PartidaDuplas p3) {
        td.excluirPartidas();
        td.adicionarPartida(p1);
        td.adicionarPartida(p2);
        td.adicionarPartida(p3);
    }

    public void excluirTorneiosDuplas() {
        td.excluirPartidas();
        
       
    }
    /**
     * Retorna as informações das partidas do torneio de duplas em formato de texto.
     *
     * @return String contendo as informações detalhadas das partidas.
     */
    public String getPartidasTextoDuplas(){
        String mensagem = "";
        for (PartidaSingulares ps : td.getPartidas()){
            //resultado e tempo
            mensagem += "Partida" + ps.getId() + "\nJogador 1 Equipe 1: " + ps.getJogador1Equipe1().getNome() + "\nJogador 2 Equipe 1: " + ps.getJogador2Equipe1().getNome() + "\nJogador 1 Equipe 2: " + ps.getJogador1Equipe2().getNome() + "\nJogador 2 Equipe 2: " + ps.getJogador2Equipe2().getNome() + "\nArbitro: " + ps.getArbitro().getNome()  + "\nVencedor Torneio Eliminatorios: " + ps.getVencedor() + "\nDuração da Partida: " + ps.getTempo();
        }
        return mensagem;
    }
     /**
     * Método de teste para criar um torneio de exemplo com dados fictícios.
     */
    public void criaTorneioTeste(){
        Arbitro arbitro = new Arbitro("Luan", 65, 'M', "FADE");
        Jogador jogador1Equipe1 = new Jogador("joao", 22, 'M');
        Jogador jogador2Equipe1 = new Jogador("kalebe", 22, 'M');
        Jogador jogador1Equipe2 = new Jogador("vitor", 22, 'M');
        Jogador jogador2Equipe2 = new Jogador("carlos", 22, 'M');

        PartidaSingulares partida1 = new PartidaSingulares(jogador1Equipe1, jogador2Equipe1, arbitro, 2.0, 1, "Eliminatorio");
        partida1.setVencedor(jogador2Equipe1.getNome());
        PartidaSingulares partida2 = new PartidaSingulares(jogador1Equipe2, jogador2Equipe2, arbitro, 2.0, 2, "Eliminatorio");
        partida2.setVencedor(jogador2Equipe2.getNome());
        PartidaSingulares partida3 = new PartidaSingulares(jogador2Equipe1, jogador2Equipe2, arbitro, 2.0, 3, "Eliminatorio");
        partida3.setVencedor(jogador2Equipe1.getNome());

        td.adicionarPartida(partida1);
        td.adicionarPartida(partida2);
        td.adicionarPartida(partida3);
}
}
