package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;

public class CadastrarArbitro {

    public void cadastrarArbitro(String nome, String idadeTexto, String genero, JFrame parent) {
        try {
            int idade = Integer.parseInt(idadeTexto);
            char sexo = genero.charAt(0);

            if (!nome.isEmpty()) {
                if(!idadeTexto.isEmpty()){

                    if(!genero.isEmpty()){
                        Arbitro arbitro = new Arbitro(nome, idade, sexo);
                        salvarNoArquivo(arbitro);
                        JOptionPane.showMessageDialog(parent, "Arbitro cadastrado com sucesso!");
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

    private void salvarNoArquivo(Arbitro arbitro) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("informacoesCampeonato.txt", true))) {
            writer.write("Nome: " + arbitro.getNome() + ", Idade: " + arbitro.getIdade() + ", Gênero: " + arbitro.getGenero());
            writer.newLine();
        }
    }
    
}
