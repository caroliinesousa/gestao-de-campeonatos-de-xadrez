package Classes.Controller;
import Classes.Pessoas.Jogador;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;

public class ControllerJogador {
    private String NOME_ARQUIVO = "informacoesJogadores.txt";

    public void cadastrarJogador(String nome, int idade, String genero, int ranking, int partidasJogadas) {
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
            writer.println("Nome: " + jogador.getNome() + ", Idade: " + jogador.getIdade() + ", Gênero: " + jogador.getGenero() + ", Ranking: " + jogador.getRanking() + ", Partidas jogadas: "+ jogador.getPartidasJogadas());
        }
    }

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
                registros.add("Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero + ", Ranking: " + ranking + ", Partidas jogadas: " + partidasJogadas);
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
}