package Classes.Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;

public class ControllerArbitro {

    public void cadastrarArbitro(String nome, String idadeTexto, String genero, JFrame parent) {
        try {
            int idade = Integer.parseInt(idadeTexto);
            char sexo = genero.charAt(0);

            if (!nome.isEmpty()) {
                if (!idadeTexto.isEmpty()) {

                    if (!genero.isEmpty()) {
                        Arbitro arbitro = new Arbitro(nome, idade, sexo, genero);
                        salvarNoArquivo(arbitro);
                        JOptionPane.showMessageDialog(parent, "Arbitro cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(parent, "Preencha o campo gênero!");
                    }
                } else {
                    JOptionPane.showMessageDialog(parent, "Preencha o campo idade!");
                }

            } else if (idadeTexto.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Preencha o campo idade!");
            } else if (genero.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Preencha o campo gênero!");
            } else {
                JOptionPane.showMessageDialog(parent, "Preencha o campo nome!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Idade inválida! Digite um número.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parent, "Preencha todos os campos: ");
        }
    }

    private void salvarNoArquivo(Arbitro arbitro) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("informacoesCampeonato.txt", true))) {
            writer.write("Nome: " + arbitro.getNome() + ", Idade: " + arbitro.getIdade() + ", Gênero: "
                    + arbitro.getGenero());
            writer.newLine();
        }
    }

    public void atualizarArbitro(String nome, String idadeTexto, String genero, String certificacoes){
            try {
                int idade = Integer.parseInt(idadeTexto);
                char sexo = genero.charAt(0);
    
                List<String> registros = new ArrayList<>();
                boolean encontrado = false;
    
                File arquivo = new File("informacoesCampeonato.txt");
                if (arquivo.exists()) {
                    Scanner scanner = new Scanner(arquivo);
                    while (scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        if (linha.contains("Nome: " + nome)) {
                            registros.add("Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero + ", Certificações: " + certificacoes);
                            encontrado = true;
                        } else {
                            registros.add(linha);
                        }
                    }
                    scanner.close();
                }
    
                if (encontrado == false) {
                    System.out.println("Árbitro não encontrado!");
                    return;
                }
    
                PrintWriter writer = new PrintWriter(new FileWriter("informacoesCampeonato.txt"));
                for (String registro : registros) {
                    writer.println(registro);
                }
                writer.close();
                System.out.println("Árbitro atualizado com sucesso!");
    
            } catch (NumberFormatException ex) {
                System.out.println("Idade inválida! Digite um número.");
            } catch (IOException ex) {
                System.out.println("Erro ao atualizar árbitro: " + ex.getMessage());
            }
        }
    
    public void consultarArbitro(String nome) {
        try {
            File arquivo = new File("informacoesCampeonato.txt");
            if (arquivo.exists() == false) {
                System.out.println("Arquivo de informações não encontrado!");
                return;
            }

            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.contains("Nome: " + nome)) {
                    System.out.println(linha);
                    scanner.close();
                    return;
                }
            }
            scanner.close();
            System.out.println("Árbitro não encontrado!");

        } catch (IOException ex) {
            System.out.println("Erro ao consultar árbitro: " + ex.getMessage());
        }
    }
    

    public void excluirArbitro(String nome) {
        public void excluirArbitro(String nome) {
            try {
                List<String> registros = new ArrayList<>();
                boolean encontrado = false;
    
                File arquivo = new File("informacoesCampeonato.txt");
                if (arquivo.exists() == false) {
                    System.out.println("Arquivo de informações não encontrado!");
                    return;
                }
    
                Scanner scanner = new Scanner(arquivo);
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    if (linha.contains("Nome: " + nome) == false) {
                        registros.add(linha);
                    } else {
                        encontrado = true;
                    }
                }
                scanner.close();
    
                if (encontrado == false) {
                    System.out.println("Árbitro não encontrado!");
                    return;
                }
    
                PrintWriter writer = new PrintWriter(new FileWriter("informacoesCampeonato.txt"));
                for (String registro : registros) {
                    writer.println(registro);
                }
                writer.close();
                System.out.println("Árbitro excluído com sucesso!");
    
            } catch (IOException ex) {
                System.out.println("Erro ao excluir árbitro: " + ex.getMessage());
            }
        }
    }
    }

