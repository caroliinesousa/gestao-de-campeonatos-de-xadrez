package Classes.Gui;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenGerirPartidasSingulares {
    private JFrame frame;
    private Classes.Controller.ControllerGerirPartidasSingulares controller;

    public ScreenGerirPartidasSingulares() {
        controller = new Classes.Controller.ControllerGerirPartidasSingulares(); // Instancia o controlador
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Gerenciar Partidas Singulares");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Título
        JLabel titulo = new JLabel("Gerenciar Partidas Singulares", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titulo, BorderLayout.NORTH);

        // Painel central
        JPanel centerPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Inputs
        JTextField jogador1Field = new JTextField();
        JTextField jogador2Field = new JTextField();
        JTextField arbitroField = new JTextField();

        centerPanel.add(new JLabel("Jogador 1:"));
        centerPanel.add(jogador1Field);

        centerPanel.add(new JLabel("Jogador 2:"));
        centerPanel.add(jogador2Field);

        centerPanel.add(new JLabel("Árbitro:"));
        centerPanel.add(arbitroField);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Botões
        JButton criarPartidaButton = new JButton("Criar Partida");
        JButton iniciarPartidaButton = new JButton("Iniciar Partida");
        JButton detalhesPartidaButton = new JButton("Exibir Detalhes");
        JButton voltarButton = new JButton("Voltar");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(criarPartidaButton);
        buttonPanel.add(iniciarPartidaButton);
        buttonPanel.add(detalhesPartidaButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        criarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jogador1Nome = jogador1Field.getText().trim();
                String jogador2Nome = jogador2Field.getText().trim();
                String arbitroNome = arbitroField.getText().trim();

                if (jogador1Nome.isEmpty() || jogador2Nome.isEmpty() || arbitroNome.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Jogador jogador1 = new Jogador(jogador1Nome); // Substitua pelo seu método de instanciar jogador
                Jogador jogador2 = new Jogador(jogador2Nome);
                Arbitro arbitro = new Arbitro(arbitroNome);

                controller.criarNovaPartida(jogador1, jogador2, arbitro);
                JOptionPane.showMessageDialog(frame, "Partida criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        iniciarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.iniciarPartida();
            }
        });

        detalhesPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exibirDetalhesDaPartida();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

}
