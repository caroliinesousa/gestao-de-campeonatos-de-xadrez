package Classes;

import Classes.Pessoas.Jogador;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class CadastrarJogador {

    public void cadastrarJogador(String nome, String idadeTexto, String genero, JFrame parent) {
        try {
            int idade = Integer.parseInt(idadeTexto);
            char sexo = genero.charAt(0);

            if (!nome.isEmpty()) {
                if(!idadeTexto.isEmpty()){

                    if(!genero.isEmpty()){
                        Jogador jogador = new Jogador(nome, idade, sexo);
                        salvarNoArquivo(jogador);
                        JOptionPane.showMessageDialog(parent, "Jogador cadastrado com sucesso!");
                    }else {
                        JOptionPane.showMessageDialog(parent, "Preencha o campo gênero!");
                    }
                }else {
                    JOptionPane.showMessageDialog(parent, "Preencha o campo idade!");
                }

            }else if(idadeTexto.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Preencha o campo idade!");
            }
            else if(genero.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Preencha o campo gênero!");
            }
            else {
                JOptionPane.showMessageDialog(parent, "Preencha o campo nome!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Idade inválida! Digite um número.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parent, "Preencha todos os campos: ");
        }
    }

    private void salvarNoArquivo(Jogador jogador) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("informacoesCampeonato.txt", true))) {
            writer.write("Nome: " + jogador.getNome() + ", Idade: " + jogador.getIdade() + ", Gênero: " + jogador.getGenero());
            writer.newLine();
        }
    }

}