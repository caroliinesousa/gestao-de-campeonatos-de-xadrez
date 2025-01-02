package Classes.Controller;

import Classes.Pessoas.Jogador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerJogador {
    
    public void cadastrarJogador(String nome, String idadeTexto, String genero, int ranking, int partidasJogadas) {
        int idade = Integer.parseInt(idadeTexto);
        char sexo = genero.charAt(0);
        Jogador jogador = new Jogador(nome, idade, sexo, ranking, partidasJogadas,0);
        try {
            salvarNoArquivo(jogador);
            
        } catch (IOException e) {
            System.err.println(e.getStackTrace()); //devolve o erro
        }
        
    }

    private void salvarNoArquivo(Jogador jogador) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("informacoesCampeonato.txt", true))) {
            writer.write("Nome: " + jogador.getNome() + ", Idade: " + jogador.getIdade() + ", Gênero: " + jogador.getGenero() + ", Ranking: " + jogador.getRanking() + ", Partidas jogadas: " + jogador.getPartidasJogadas());
            writer.newLine();
        }
    }


    public void atualizarJogador(String nome, String idadeTexto, String genero, int ranking, int partidasJogadas) {
    try {
        File arquivo = new File("informacoesCampeonato.txt");
        if (!arquivo.exists()) {
            System.out.println("Arquivo de informações não encontrado!");
            return;
        }

        List<String> registros = new ArrayList<>();
        boolean encontrado = false;
        int idade = Integer.parseInt(idadeTexto);
        char sexo = genero.charAt(0);

        // Leitura do arquivo
        Scanner scanner = new Scanner(arquivo);
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            if (linha.contains("Nome: " + nome)) {
                // Substitui o registro pelo atualizado
                registros.add("Nome: " + nome + 
                              ", Idade: " + idade + 
                              ", Gênero: " + genero + 
                              ", Ranking: " + ranking + 
                              ", Partidas jogadas: " + partidasJogadas);
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

        // Reescrita do arquivo com os registros atualizados
        PrintWriter writer = new PrintWriter(new FileWriter("informacoesCampeonato.txt"));
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


    public void consultarJogador(String nome){


    }

    public void excluirJogador(String nome){
        
    }
}