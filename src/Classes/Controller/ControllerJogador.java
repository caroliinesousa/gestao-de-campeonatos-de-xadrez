package Classes.Controller;

import Classes.Pessoas.Jogador;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerJogador {
    private String NOME_ARQUIVO = "informacoesJogadores.txt";

    public void cadastrarJogador(String nome, String idade2, String genero, int ranking, int partidasJogadas) {
        int idade = Integer.parseInt(idade2);
        char sexo = genero.charAt(0);
        Jogador jogador = new Jogador(nome, idade, sexo, ranking, partidasJogadas, 0);
        try {
            salvarNoArquivo(jogador);

        } catch (IOException e) {
            System.err.println(e.getStackTrace()); // devolve o erro
        }

    }

    private void salvarNoArquivo(Jogador jogador) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.println("Nome: " + jogador.getNome() + ", Idade: " + jogador.getIdade() + ", Gênero: "
                    + jogador.getGenero() + ", Ranking: " + jogador.getRanking() + ", Partidas jogadas: "
                    + jogador.getPartidasJogadas());
        }
    }

    public void atualizarJogador(String nome, String idade2, String genero, int ranking, int partidasJogadas) {
        try {
            File arquivo = new File(NOME_ARQUIVO);
            if (!arquivo.exists()) {
                System.out.println("Arquivo de informações não encontrado!");
                return;
            }

            ArrayList<String> registros = new ArrayList<>();
            boolean encontrado = false;
            int idade = Integer.parseInt(idade2);
            char sexo = genero.charAt(0);

            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.contains("Nome: " + nome)) {
                    registros.add("Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero + ", Ranking: " + ranking + ", Partidas jogadas: " + partidasJogadas);
                    encontrado = true;
                } else {
                    registros.add(linha);
                }
            }
            scanner.close();

            if (!encontrado) {
                System.out.println("Jogador não encontrado!");
                return;
            }

            PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO));
            for (String registro : registros) {
                writer.println(registro);
            }
            writer.close();

            System.out.println("Jogador atualizado com sucesso!");

        } catch (NumberFormatException ex) {
            System.out.println("Idade inválida! Digite um número.");
        } catch (IOException ex) {
            System.out.println("Erro ao atualizar jogador: " + ex.getMessage());
        }
    }

    public void consultarJogador(String nome) {

        try {
            File arquivo = new File(NOME_ARQUIVO);
            if (!arquivo.exists()) {
                System.out.println("Arquivo de informações não encontrado!");
                return;
            }

            boolean encontrado = false;
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.contains("Nome: " + nome)) {
                    System.out.println("Jogador encontrado: " + linha);
                    encontrado = true;
                    break;
                }
            }
            scanner.close();

            if (!encontrado) {
                System.out.println("Jogador não encontrado!");
            }
        } catch (IOException ex) {
            System.out.println("Erro ao consultar jogador: " + ex.getMessage());
        }
    }

    public void excluirJogador(String nome) {
        try {
            File arquivo = new File(NOME_ARQUIVO);
            if (!arquivo.exists()) {
                System.out.println("Arquivo de informações não encontrado!");
            }

            ArrayList<String> registros = new ArrayList<>();
            boolean encontrado = false;

            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.contains("Nome: " + nome)) {
                    encontrado = true;
                } else {
                    registros.add(linha);
                }
            }
            scanner.close();

            if (!encontrado) {
                System.out.println("Jogador não encontrado!");
            }

            PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO));
            for (String registro : registros) {
                writer.println(registro);
            }
            writer.close();

            System.out.println("Jogador excluído com sucesso!");

        } catch (IOException ex) {
            System.out.println("Erro ao excluir jogador: " + ex.getMessage());
        }

    }
}