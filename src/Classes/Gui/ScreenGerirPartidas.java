package Classes.Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Classes.Controller.ControllerPartida;

public class ScreenGerirPartidas extends JFrame {

    private ControllerPartida controllerPartida;

    public ScreenGerirPartidas() {
        controllerPartida = new ControllerPartida();
        telaGerirPartidas();
    }

    public void telaGerirPartidas() {
        setTitle("Gestão de Partidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Gestão de Partidas", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton cadastrarPartidaButton = new JButton("Cadastrar Partida");
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(cadastrarPartidaButton, gbc);

        JButton consultarPartidaButton = new JButton("Consultar Partida");
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(consultarPartidaButton, gbc);

        JButton atualizarPartidaButton = new JButton("Atualizar Partida");
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(atualizarPartidaButton, gbc);

        JButton excluirPartidaButton = new JButton("Excluir Partida");
        gbc.gridx = 1;
        gbc.gridy = 1;
        buttonPanel.add(excluirPartidaButton, gbc);

        JButton voltarMenuButton = new JButton("Voltar ao Menu Principal");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        buttonPanel.add(voltarMenuButton, gbc);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);

        cadastrarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarPartida();
            }
        });

        consultarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsultarPartida();
            }
        });

        atualizarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAtualizarPartida();
            }
        });

        excluirPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaExcluirPartida();
            }
        });

        voltarMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ScreenJogador menuScreen = new ScreenJogador();
                menuScreen.telaMenuJogador();
            }
        });
    }

    public void telaCadastrarPartida() {
        JFrame frame = new JFrame("Cadastrar Partida");
        JTextField jogador1Field = new JTextField();
        JTextField jogador2Field = new JTextField();
        JTextField resultadoField = new JTextField();
        JButton salvarButton = new JButton("Salvar");

        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Jogador 1:"));
        frame.add(jogador1Field);
        frame.add(new JLabel("Jogador 2:"));
        frame.add(jogador2Field);
        frame.add(new JLabel("Resultado:"));
        frame.add(resultadoField);
        frame.add(new JLabel());
        frame.add(salvarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jogador1 = jogador1Field.getText().trim();
                String jogador2 = jogador2Field.getText().trim();
                String resultado = resultadoField.getText().trim();
                
                controllerPartida.cadastrarPartida(jogador1, jogador2, resultado);
                JOptionPane.showMessageDialog(frame, "Partida cadastrada com sucesso!");
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void telaConsultarPartida() {
        JFrame frame = new JFrame("Consultar Partida");
        JTextField idPartidaField = new JTextField();
        JButton consultarButton = new JButton("Consultar");

        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2, 2));

        frame.add(new JLabel("ID da Partida:"));
        frame.add(idPartidaField);
        frame.add(new JLabel());
        frame.add(consultarButton);

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPartida = idPartidaField.getText().trim();
                String resultado = controllerPartida.consultarPartida(idPartida);
                JOptionPane.showMessageDialog(frame, resultado);
            }
        });

        frame.setVisible(true);
    }

    public void telaAtualizarPartida() {
        JFrame frame = new JFrame("Atualizar Partida");
        JTextField idPartidaField = new JTextField();
        JTextField novoResultadoField = new JTextField();
        JButton atualizarButton = new JButton("Atualizar");

        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(new JLabel("ID da Partida:"));
        frame.add(idPartidaField);
        frame.add(new JLabel("Novo Resultado:"));
        frame.add(novoResultadoField);
        frame.add(new JLabel());
        frame.add(atualizarButton);

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPartida = idPartidaField.getText().trim();
                String novoResultado = novoResultadoField.getText().trim();
                controllerPartida.atualizarPartida(idPartida, novoResultado);
                JOptionPane.showMessageDialog(frame, "Partida atualizada com sucesso!");
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void telaExcluirPartida() {
        JFrame frame = new JFrame("Excluir Partida");
        JTextField idPartidaField = new JTextField();
        JButton excluirButton = new JButton("Excluir");

        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2, 2));

        frame.add(new JLabel("ID da Partida:"));
        frame.add(idPartidaField);
        frame.add(new JLabel());
        frame.add(excluirButton);

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPartida = idPartidaField.getText().trim();
                controllerPartida.excluirPartida(idPartida);
                JOptionPane.showMessageDialog(frame, "Partida excluída com sucesso!");
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
