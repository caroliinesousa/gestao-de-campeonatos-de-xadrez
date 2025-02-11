package Classes.Controller;

import Classes.Pessoas.Arbitro;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
/**
 * Classe para gerenciar as funcionalidades relacionadas aos árbitros.
 * Permite operações como cadastro, consulta, atualização e exclusão.
 * 
 * 
 * @version 1.0
 * @since 2025
 */
public class ControllerArbitro {
    /**
     * Nome do arquivo onde as informações dos árbitros são armazenadas.
     */
    private String NOME_ARQUIVO = "informacoesArbitros.txt";
    /**
     * Cadastra um novo árbitro no sistema e salva suas informações no arquivo.
     * 
     * @param nome Nome do árbitro.
     * @param idade Idade do árbitro.
     * @param genero Gênero do árbitro ("M" para masculino, "F" para feminino, etc.).
     * @param certificacoes Certificações do árbitro.
     */
    public void cadastrarArbitro(String nome, int idade, String genero, String certificacoes) {
        char sexo = genero.charAt(0);
        Arbitro arbitro = new Arbitro(nome, idade, sexo, certificacoes);
        try {
            salvarNoArquivo(arbitro);

        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }
    /**
     * Salva as informações de um árbitro no arquivo.
     * 
     * @param arbitro Objeto do tipo Arbitro a ser salvo.
     * @throws IOException Caso ocorra um erro ao acessar o arquivo.
     */
    private void salvarNoArquivo(Arbitro arbitro) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.println("Nome: " + arbitro.getNome() + ", Idade: " + arbitro.getIdade() + ", Gênero: "
                    + arbitro.getGenero() + ", certificacoes: " + arbitro.getCertificacoes());
        }
    }
    /**
     * Atualiza as informações de um árbitro no arquivo.
     * 
     * @param nome Nome do árbitro.
     * @param idade Nova idade do árbitro.
     * @param genero Novo gênero do árbitro.
     * @param certificacoes Novas certificações do árbitro.
     * @return true se o árbitro foi atualizado com sucesso, false caso contrário.
     */
    public boolean atualizarArbitro(String nome, int idade, String genero, String certificacoes) {
        try {
            File arquivo = new File(NOME_ARQUIVO);
            if (!arquivo.exists()) {
                System.out.println("Arquivo de informações não encontrado!");
                return false;
            }

            ArrayList<String> registros = new ArrayList<>();
            boolean encontrado = false;

            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine().trim();
                if (linha.toLowerCase().contains("nome: " + nome.toLowerCase())) {
                    registros.add("Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero + ", Certificações: "
                            + certificacoes);
                    encontrado = true;
                } else {
                    registros.add(linha);
                }
            }
            scanner.close();

            if (!encontrado) {
                System.out.println("Árbitro não encontrado!");
                return false;
            }

            PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO));
            for (String registro : registros) {
                writer.println(registro);
            }
            writer.close();

            System.out.println("Árbitro atualizado com sucesso!");
            return true;

        } catch (IOException ex) {
            System.out.println("Erro ao atualizar árbitro: " + ex.getMessage());
            return false;
        }
    }
     /**
     * Consulta as informações de um árbitro no arquivo.
     * 
     * @param nome Nome do árbitro a ser consultado.
     * @param cadastrarButton Botão que será exibido caso o árbitro não seja encontrado.
     * @return true se o árbitro foi encontrado, false caso contrário.
     */
    public boolean consultarArbitro(String nome, JButton cadastrarButton) {
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
                    System.out.println("Árbitro encontrado: " + linha);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Árbitro não encontrado!");
                cadastrarButton.setVisible(true);
            } else {
                cadastrarButton.setVisible(false);
            }

        } catch (IOException ex) {
            System.out.println("Erro ao consultar Árbitro: " + ex.getMessage());
            return false;
        }

        return encontrado;
    }
    /**
     * Exclui as informações de um árbitro no arquivo.
     * 
     * @param nome Nome do árbitro a ser excluído.
     * @return true se o árbitro foi excluído com sucesso, false caso contrário.
     */
    public boolean excluirArbitro(String nome) {
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
                System.out.println("Árbitro não encontrado!");
                return false;
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO))) {
                for (String registro : registros) {
                    writer.println(registro);
                }
            }

            System.out.println("Árbitro excluído com sucesso!");
            return true;

        } catch (IOException ex) {
            System.out.println("Erro ao excluir árbitro: " + ex.getMessage());
            return false;
        }

    }
    /**
     * Lê as informações de um árbitro no arquivo e retorna um objeto Arbitro.
     * 
     * @param nome Nome do árbitro a ser buscado.
     * @return Objeto Arbitro com as informações encontradas, ou null caso não seja encontrado.
     */ 
    public Arbitro lendoArquivoArbitro(String nome) {
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists()) {
            System.out.println("Arquivo de informações não encontrado!");
            return null;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            Arbitro arbitro = null;

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.toLowerCase().contains(("Nome: " + nome).toLowerCase())) {
                    System.out.println("Árbitro encontrado: " + linha);
                    String[] partes = linha.split(", ");
                    //String nome = partes[0].split(": ")[1];
                    int idade = Integer.parseInt(partes[1].split(": ")[1]);
                    char genero = partes[2].split(": ")[1].charAt(0);
                    String certificacoes = partes[3].split(": ")[1];
                    arbitro = new Arbitro(nome, idade, genero, certificacoes);
                    break;
                }
            }
            return arbitro;

        } catch (IOException ex) {
            System.out.println("Erro ao consultar Árbitro: " + ex.getMessage());
            return null;
        }

    }
}