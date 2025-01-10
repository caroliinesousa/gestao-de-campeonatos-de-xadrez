package Classes;

import java.io.*;
import java.util.*;

public class Campeonato {

    private static final String NOME_ARQUIVO_RANKING = "ranking.txt";

    /**
     * Lê o arquivo rankings.txt e exibe os rankings dos jogadores.
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

