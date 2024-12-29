package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ScreenJogador extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField sexoField;
    private JButton salvarButton;
    private CadastrarJogador cadastrarJogador;

    public ScreenJogador() {
        cadastrarJogador = new CadastrarJogador();

        setTitle("Cadastro de Jogador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JPanel inputs =   new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome Jogador:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        inputs.add(new JLabel("Idade Jogador:"));
        idadeField = new JTextField();
        inputs.add(idadeField);

        inputs.add(new JLabel("Gênero Jogador:"));
        sexoField = new JTextField();
        inputs.add(sexoField);

        add(inputs);


        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarJogador.cadastrarJogador( nomeField.getText(), idadeField.getText(),  sexoField.getText(),  Screen.this  );
                limparCamposJogador();
            }
        });
        add(salvarButton);
    }

    private void limparCamposJogador() {
        nomeField.setText("");
        idadeField.setText("");
        sexoField.setText("");
    }
}