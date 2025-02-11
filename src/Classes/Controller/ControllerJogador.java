package Classes.Controller;
import Classes.Pessoas.Jogador;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
    /**
 * Classe responsável pelo gerenciamento de jogadores, incluindo operações de cadastro,
 * atualização, consulta, exclusão e leitura de informações a partir de um arquivo.
 */
public class ControllerJogador {
    private String NOME_ARQUIVO = "informacoesJogadores.txt";
    /**
     * Cadastra um novo jogador no sistema e salva suas informações no arquivo.
     *
     * @param nome            Nome do jogador.
     * @param idade           Idade do jogador.
     * @param genero          Gênero do jogador.
     * @param ranking         Ranking atual do jogador.
     * @param partidasJogadas Número de partidas jogadas pelo jogador.
     */
    public void cadastrarJogador(String nome, int idade, String genero, int ranking, int partidasJogadas) {
        char sexo = genero.charAt(0);
        Jogador jogador = new Jogador(nome, idade, sexo, ranking, partidasJogadas, 0);
        try {
            salvarNoArquivo(jogador);

        } catch (IOException e) {
            System.err.println(e.getStackTrace()); // devolve o erro
        }
    }
    /**
     * Salva as informações de um jogador no arquivo.
     *
     * @param jogador Objeto do tipo Jogador contendo as informações a serem salvas.
     * @throws IOException Caso ocorra um erro durante a escrita no arquivo.
     */
    private void salvarNoArquivo(Jogador jogador) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.println("Nome: " + jogador.getNome() + ", Idade: " + jogador.getIdade() + ", Gênero: " + jogador.getGenero() + ", Ranking: " + jogador.getRanking() + ", Partidas jogadas: "+ jogador.getPartidasJogadas());
        }
    }
    /**
     * Atualiza as informações de um jogador existente no arquivo.
     *
     * @param nome            Nome do jogador a ser atualizado.
     * @param idade           Nova idade do jogador.
     * @param genero          Novo gênero do jogador.
     * @param ranking         Novo ranking do jogador.
     * @param partidasJogadas Novo número de partidas jogadas pelo jogador.
     * @return true se o jogador foi encontrado e atualizado, false caso contrário.
     */
    public boolean atualizarJogador(String nome, int idade, String genero, int ranking, int partidasJogadas) {
    try {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) {
            System.out.println("Arquivo de informações não encontrado!");
            return false;
        }

        ArrayList<String> registros = new ArrayList<>();
        boolean encontrado = false;
        char sexo = genero.charAt(0);

        Scanner scanner = new Scanner(arquivo);
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            if (linha.contains("Nome: " + nome)) {
                registros.add("Nome: " + nome + ", Idade: " + idade + ", Gênero: " + sexo + ", Ranking: " + ranking + ", Partidas jogadas: " + partidasJogadas);
                encontrado = true;
            } else {
                registros.add(linha);
            }
        }
        scanner.close();

        if (!encontrado) {
            System.out.println("Jogador não encontrado!");
            return false;
        }

        PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO));
        for (String registro : registros) {
            writer.println(registro);
        }
        writer.close();

        System.out.println("Jogador atualizado com sucesso!");
        return true;

    } catch (NumberFormatException ex) {
        System.out.println("Idade inválida! Digite um número.");
        return false;
    } catch (IOException ex) {
        System.out.println("Erro ao atualizar jogador: " + ex.getMessage());
        return false;
    }
}
    /**
     * Consulta um jogador no arquivo e controla a visibilidade do botão de cadastro.
     *
     * @param nome            Nome do jogador a ser consultado.
     * @param cadastrarButton Botão de cadastro que será exibido ou ocultado com base no resultado da consulta.
     * @return true se o jogador foi encontrado, false caso contrário.
     */
    public boolean consultarJogador(String nome, JButton cadastrarButton) {
    File arquivo = new File(NOME_ARQUIVO);

    if (!arquivo.exists()) {
        System.out.println("Arquivo de informações não encontrado!");
        return false;
    }

    boolean encontrado = false;

    try (Scanner scanner = new Scanner(arquivo)) {
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            if (linha.toLowerCase().contains(("Nome: " + nome).toLowerCase())) {
                System.out.println("Jogador encontrado: " + linha);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Jogador não encontrado!");
            cadastrarButton.setVisible(true); 
        } else {
            cadastrarButton.setVisible(false); 
        }

    } catch (IOException ex) {
        System.out.println("Erro ao consultar jogador: " + ex.getMessage());
        return false;
    }

    return encontrado;
}
     /**
     * Exclui um jogador do arquivo com base no nome.
     *
     * @param nome Nome do jogador a ser excluído.
     * @return true se o jogador foi encontrado e excluído, false caso contrário.
     */
    public boolean excluirJogador(String nome) {
    try {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) {
            System.out.println("Arquivo de informações não encontrado!");
            return false;
        }

        ArrayList<String> registros = new ArrayList<>();
        boolean encontrado = false;

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine().trim();
                if (linha.toLowerCase().contains("nome: " + nome.toLowerCase())) {
                    encontrado = true;
                } else if (!linha.isEmpty()) {
                    registros.add(linha);
                }
            }
        }

        if (!encontrado) {
            System.out.println("Jogador não encontrado!");
            return false;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO))) {
            for (String registro : registros) {
                writer.println(registro);
            }
        }

        System.out.println("Jogador excluído com sucesso!");
        return true;

    } catch (IOException ex) {
        System.out.println("Erro ao excluir jogador: " + ex.getMessage());
        return false;
    }
}
    /**
     * Lê as informações de um jogador no arquivo com base no nome.
     *
     * @param nome Nome do jogador a ser consultado.
     * @return Objeto Jogador com as informações encontradas ou null se o jogador não for encontrado.
     */
public Jogador lendoArquivoJogador(String nome) {
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists()) {
            System.out.println("Arquivo de informações não encontrado!");
            return null;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            Jogador jogador = null;

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.toLowerCase().contains(("Nome: " + nome).toLowerCase())) {
                    System.out.println("Jogador encontrado: " + linha);
                    String[] partes = linha.split(", ");
                    //String nome = partes[0].split(": ")[1];
                    int idade = Integer.parseInt(partes[1].split(": ")[1]);
                    char genero = partes[2].split(": ")[1].charAt(0);
                    int ranking = Integer.parseInt(partes[3].split(": ")[1]);
                    int partidasJogadas = Integer.parseInt(partes[4].split(": ")[1]);

                    jogador = new Jogador(nome, idade, genero, ranking, partidasJogadas,0);
                    break;
                }
            }
            return jogador;

        } catch (IOException ex) {
            System.out.println("Erro ao consultar Árbitro: " + ex.getMessage());
            return null;
        }

    }
}