package Classes.Controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para gerenciar o ranking dos jogadores.
 */
public class ControllerRanking {

    /**
     * Lê os dados do arquivo rankings.txt e retorna uma matriz de Strings com os dados.
     * @param nomeArquivo Nome do arquivo que contém os rankings.
     * @return String[][] com os dados organizados.
     */
    public String[][] lerDadosDoArquivo(String nomeArquivo) {
        List<JogadorRanking> listaJogadores = new ArrayList<>();

        try {
            File arquivo = new File(nomeArquivo);
            if (!arquivo.exists()) {
                System.out.println("Arquivo de rankings não encontrado!");
                return new String[][] {{"", "Nenhum jogador encontrado", ""}};
            }

            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine().trim();
                if (!linha.isEmpty()) {
                    String[] partes = linha.split(",");
                    String nome = partes[0].trim();
                    int pontos = Integer.parseInt(partes[1].trim());
                    listaJogadores.add(new JogadorRanking(nome, pontos));
                }
            }
            scanner.close();

            // Ordena a lista de jogadores por pontos (decrescente)
            Collections.sort(listaJogadores);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return new String[][] {{"", "Erro ao carregar os dados", ""}};
        }

        // Converte a lista de jogadores para uma matriz de Strings
        String[][] dados = new String[listaJogadores.size()][3];
        for (int i = 0; i < listaJogadores.size(); i++) {
            JogadorRanking jogador = listaJogadores.get(i);
            dados[i][0] = (i + 1) + "º";
            dados[i][1] = jogador.getNome();
            dados[i][2] = String.valueOf(jogador.getPontos());
        }

        return dados;
    }

    // Classe interna para representar um jogador no ranking
    private static class JogadorRanking implements Comparable<JogadorRanking> {
        private String nome;
        private int pontos;

        public JogadorRanking(String nome, int pontos) {
            this.nome = nome;
            this.pontos = pontos;
        }

        public String getNome() {
            return nome;
        }

        public int getPontos() {
            return pontos;
        }

        @Override
        public int compareTo(JogadorRanking outro) {
            return Integer.compare(outro.pontos, this.pontos); // Ordem decrescente
        }
    }
}
