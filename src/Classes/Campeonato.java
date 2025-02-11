package Classes;

import java.io.*;
import java.util.*;

/**
 * A classe {@code Campeonato} representa um sistema para gerenciar informações
 * de rankings de jogadores em um campeonato.
 * <p>
 * Esta classe fornece métodos para ler e exibir o conteúdo de um arquivo
 * de rankings. O arquivo padrão utilizado é {@code ranking.txt}.
 * </p>
 */

public class Campeonato {
    /**
         * Nome do arquivo que contém os rankings dos jogadores.
         */

    private static final String NOME_ARQUIVO_RANKING = "ranking.txt";

    /**
     * Lê o arquivo de rankings ({@code ranking.txt}) e exibe os rankings dos jogadores no console.
     * <p>
     * Caso o arquivo não seja encontrado, exibe uma mensagem de erro informando
     * que o arquivo não foi localizado. Em caso de falha na leitura do arquivo,
     * uma mensagem de erro será exibida com detalhes da exceção.
     * </p>
     */

    public void lerRankings() {
        File arquivo = new File(NOME_ARQUIVO_RANKING);

        // Verifica se o arquivo existe
        if (!arquivo.exists()) {
            System.out.println("O arquivo de rankings não foi encontrado.");
            return;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            System.out.println("Rankings Atualizados:");
            System.out.println("---------------------");

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo de rankings: " + e.getMessage());
        }
    }
}

