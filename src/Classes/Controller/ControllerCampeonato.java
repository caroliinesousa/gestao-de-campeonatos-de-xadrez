package Classes.Controller;
import java.util.ArrayList;

public class ControllerCampeonato {
    private ArrayList<Partida> partidas;
    /**
 * Controlador para gerenciar partidas de um campeonato.
 * Permite cadastrar, consultar, atualizar e excluir partidas.
 */
    public ControllerCampeonato() {
        partidas = new ArrayList<>();
    }

    /**
     * Cadastra uma nova partida no campeonato.
     *
     * @param jogador1 Nome do jogador 1.
     * @param jogador2 Nome do jogador 2.
     * @param resultado Resultado da partida.
     */
    public void cadastrarPartida(String jogador1, String jogador2, String resultado) {
        Partida novaPartida = new Partida(jogador1, jogador2, resultado);
        partidas.add(novaPartida);
        System.out.println("Partida cadastrada com sucesso!");
    }

     /**
     * Consulta uma partida pelo ID.
     *
     * @param idPartida ID da partida a ser consultada.
     * @return Detalhes da partida, ou uma mensagem caso não seja encontrada.
     */
    public String consultarPartida(String idPartida) {
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            if (partida.getId().equals(idPartida)) {
                return "Partida encontrada: " + partida.toString();
            }
        }
        return "Partida não encontrada.";
    }

     /**
     * Atualiza o resultado de uma partida pelo ID.
     *
     * @param idPartida ID da partida a ser atualizada.
     * @param novoResultado Novo resultado da partida.
     */
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

    /**
     * Exclui uma partida pelo ID.
     *
     * @param idPartida ID da partida a ser excluída.
     */
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

    /**
     * Classe interna que representa uma partida.
     */
    private static class Partida {
        private static int contador = 1;
        private String id;
        private String jogador1;
        private String jogador2;
        private String resultado;
         /**
         * Construtor da classe Partida.
         *
         * @param jogador1 Nome do jogador 1.
         * @param jogador2 Nome do jogador 2.
         * @param resultado Resultado da partida.
         */
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
