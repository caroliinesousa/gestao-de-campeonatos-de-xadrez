package Classes.Controller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import Classes.Pessoas.Arbitro;

public class ControllerArbitro {
    private String NOME_ARQUIVO = "informacoesArbitros.txt";

    public void cadastrarArbitro(String nome, int idade, String genero, String certificacoes) {
        char sexo = genero.charAt(0);
        Arbitro arbitro = new Arbitro(nome, idade, sexo, certificacoes);
        try {
            salvarNoArquivo(arbitro);

        } catch (IOException e) {
            System.err.println(e.getStackTrace()); 
        }
    }

    private void salvarNoArquivo(Arbitro arbitro) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.println("Nome: " + arbitro.getNome() + ", Idade: " + arbitro.getIdade() + ", Gênero: " + arbitro.getGenero() + ", certificacoes: " + arbitro.getCertificacoes());
        }
    }

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
                    registros.add("Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero + ", Certificações: " + certificacoes);
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
    }