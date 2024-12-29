package Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScreenArbitro extends JFrame{
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField sexoField;
    private JButton salvarButton;
    private CadastrarArbitro cadastrarArbitro;

    public ScreenArbitro() {
        cadastrarArbitro = new CadastrarArbitro();

        setTitle("Cadastro de arbitro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JPanel inputs =   new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome arbitro:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        inputs.add(new JLabel("Idade arbitro:"));
        idadeField = new JTextField();
        inputs.add(idadeField);

        inputs.add(new JLabel("Gênero arbitro:"));
        sexoField = new JTextField();
        inputs.add(sexoField);

        add(inputs);


        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarArbitro.cadastrarArbitro( nomeField.getText(), idadeField.getText(),  sexoField.getText(),  ScreenArbitro.this  );
                limparCamposArbitro();
            }
        });
        add(salvarButton);
    }

    private void limparCamposArbitro() {
        nomeField.setText("");
        idadeField.setText("");
        sexoField.setText("");
    }
}

