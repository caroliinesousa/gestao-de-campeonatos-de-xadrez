package Classes.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Classes.Controller.ControllerArbitro;
import Classes.Controller.ControllerJogador;
import Classes.Controller.ControllerPartidasDuplas;
import Classes.Controller.ControllerPartidasSingulares;
import Classes.Controller.ControllerTorneiosDuplas;
import Classes.Controller.ControllerTorneiosSingulares;
import Classes.Partidas.PartidaDuplas;
import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
/**
 * Classe ScreenTorneiosDuplas
 * Representa a interface gráfica para gerenciar torneios de duplas em um sistema esportivo.
 * 
 * @version 1.0
 * @since 2025
 */
public class ScreenTorneiosDuplas extends JFrame {
    /**
     * Controlador para gerenciar partidas de duplas.
     */
    private ControllerPartidasDuplas cpd;
    /**
     * Controlador para gerenciar torneios de duplas.
     */
    private ControllerTorneiosDuplas controllerTorneiosDuplas;

    /**
     * Exibe o menu principal para gerenciar torneios de duplas.
     */
    public void telaMenuTorneiosDuplas() {
        setTitle("Gestão de Torneio Duplas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Gestão Torneio Duplas", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie Torneios com facilidade. Escolha uma das opções para começar!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton cadastrarTorneioButton = new JButton("Cadastrar Torneio");
        JButton consultarTorneioButton = new JButton("Consultar Torneio");
        JButton atualizarTorneioButton = new JButton("Atualizar Torneio");
        JButton excluirTorneioButton = new JButton("Excluir Torneio");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(cadastrarTorneioButton);
        panel.add(consultarTorneioButton);
        panel.add(atualizarTorneioButton);
        panel.add(excluirTorneioButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);
    
        // Configura os botões
        cadastrarTorneioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarTorneiosDuplas();
            }
        });
    
        atualizarTorneioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAtualizarTorneiosDuplas();
            }
        });
    
        consultarTorneioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsultarTorneiosDuplas();
            }
        });
    
        excluirTorneioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaExcluirTorneiosDuplas();
            }
        });
    
        voltarApaginaInicialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    
        setVisible(true);
    }
    /**
     * Exibe a tela para cadastrar torneios de duplas.
     */
    public void telaCadastrarTorneiosDuplas(){
        JFrame frame = new JFrame("Cadastro Torneio Duplas");
        JTextField partida1Field;
        JTextField partida2Field;
        JTextField partida3Field;
        JButton salvarButton;
        JButton voltarButton;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Painel de inputs
        JPanel inputs = new JPanel(new GridLayout(4, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputs.add(new JLabel("Partida 1:"));
        partida1Field = new JTextField();
        inputs.add(partida1Field);

        inputs.add(new JLabel("Partida 2:"));
        partida2Field = new JTextField();
        inputs.add(partida2Field);

        inputs.add(new JLabel("Partida 3:"));
        partida3Field = new JTextField();
        inputs.add(partida3Field);


        frame.add(inputs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        salvarButton = new JButton("Salvar");
        salvarButton.setPreferredSize(new Dimension(120, 40));
        salvarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (partida1Field.getText().isEmpty() || partida2Field.getText().isEmpty() || partida3Field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida1 = Integer.parseInt(partida1Field.getText());
                        int idPartida2 = Integer.parseInt(partida2Field.getText());
                        int idPartida3 = Integer.parseInt(partida3Field.getText());

                        PartidaDuplas partida1 = cpd.devolverPartidasDuplas(idPartida1);
                        PartidaDuplas partida2 = cpd.devolverPartidasDuplas(idPartida2);
                        PartidaDuplas partida3 = cpd.devolverPartidasDuplas(idPartida3);
                        if (partida1 != null && partida2 != null && partida3 != null){

                            controllerTorneiosDuplas.cadastrarTorneioDuplas(partida1, partida2, partida3);
                            JOptionPane.showMessageDialog(frame, "Partida cadastrada com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);

                        }else{
                            System.out.println("Alguma das partidas esta vazia!");
                            JOptionPane.showMessageDialog(frame, "Partidas não encontradas!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        }

                        partida1Field.setText("");
                        partida2Field.setText("");
                        partida3Field.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        partida1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        partida2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        partida3Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(salvarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    /**
     * Exibe a tela para consultar torneios de duplas.
     */
    public void telaConsultarTorneiosDuplas(){
        JFrame frame = new JFrame("Consultar Torneio Dupla");
        JTextField idField = new JTextField();
        JButton consultarButton = new JButton("Consultar");
        JButton voltarButton = new JButton("Voltar");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Painel de inputs
        JPanel inputs = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel nomeLabel = new JLabel("ID da Partida:");
        nomeLabel.setPreferredSize(new Dimension(100, 30));
        inputs.add(nomeLabel);

        idField.setPreferredSize(new Dimension(200, 30));
        inputs.add(idField);

        frame.add(inputs, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        consultarButton.setPreferredSize(new Dimension(120, 40));
        consultarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Digite o ID da partida para consultar!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idField.getText());
                        String resultado = controllerTorneiosDuplas.consultarTorneioDuplas(idPartida);

                        JOptionPane.showMessageDialog(frame, resultado, "Resultado da Consulta",
                                JOptionPane.INFORMATION_MESSAGE);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        idField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(consultarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    /**
     * Exibe a tela para atualizar torneios de duplas.
     */
    public void telaAtualizarTorneiosDuplas(){
        JFrame frame = new JFrame("Atualizar Torneio");
        JTextField partida1Field = new JTextField();
        JTextField partida2Field = new JTextField();
        JTextField partida3Field = new JTextField();
        JButton atualizarButton = new JButton("Atualizar");
        JButton voltarButton = new JButton("Voltar");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Painel de inputs
        JPanel inputs = new JPanel(new GridLayout(6, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputs.add(new JLabel("Partida 1:"));
        inputs.add(partida1Field);

        inputs.add(new JLabel("Partida 2:"));
        inputs.add(partida2Field);

        inputs.add(new JLabel("Partida 3:"));
        inputs.add(partida3Field);

        frame.add(inputs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        atualizarButton.setPreferredSize(new Dimension(120, 40));
        atualizarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (partida1Field.getText().isEmpty() || partida2Field.getText().isEmpty() || partida3Field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida1 = Integer.parseInt(partida1Field.getText());
                        int idPartida2 = Integer.parseInt(partida2Field.getText());
                        int idPartida3 = Integer.parseInt(partida3Field.getText());

                        PartidaDuplas partida1 = cpd.devolverPartidasDuplas(idPartida1);
                        PartidaDuplas partida2 = cpd.devolverPartidasDuplas(idPartida2);
                        PartidaDuplas partida3 = cpd.devolverPartidasDuplas(idPartida3);

                         controllerTorneiosDuplas.atualizarTorneioDuplas(partida1, partida2, partida3);
                         JOptionPane.showMessageDialog(frame, "Partidas atualizadas com sucesso!!", "Sucesso",
                         JOptionPane.INFORMATION_MESSAGE);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        partida1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        partida2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        partida3Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });


        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(atualizarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    /**
     * Exibe a tela para excluir torneios de duplas.
     */
    public void telaExcluirTorneiosDuplas(){
        JFrame frame = new JFrame("Excluir Torneio");
        JTextField idField = new JTextField();
        JButton excluirButton = new JButton("Excluir");
        JButton voltarButton = new JButton("Voltar");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Painel de inputs
        JPanel inputs = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel nomeLabel = new JLabel("ID da Partida:");
        nomeLabel.setPreferredSize(new Dimension(100, 30));
        inputs.add(nomeLabel);

        idField.setPreferredSize(new Dimension(200, 30));
        inputs.add(idField);

        frame.add(inputs, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        excluirButton.setPreferredSize(new Dimension(120, 40));
        excluirButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));

        // Ação do botão Excluir
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerTorneiosDuplas.excluirTorneiosDuplas();
            }
        });

        idField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(excluirButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    }

