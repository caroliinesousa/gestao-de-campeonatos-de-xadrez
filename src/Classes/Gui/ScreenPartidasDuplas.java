/**
 * Classe ScreenPartidasDuplas
 * Representa a interface gráfica para gerenciar as partidas duplas.
 * 
 * @version 1.0
 * @since 2025
 */
package Classes.Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Classes.Controller.ControllerArbitro;
import Classes.Controller.ControllerJogador;
import Classes.Controller.ControllerPartidasDuplas;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Representa a tela para gerenciar partidas duplas.
 * Fornece opções para cadastrar, consultar, atualizar e excluir partidas.
 * 
 * @author AnaSousaEvitorFontenele
 * @version 1.0
 * @since 2025
 */
public class ScreenPartidasDuplas extends JFrame {
    /**
     * Controlador para gerenciar partidas duplas.
     */
    public ControllerPartidasDuplas controllerPartidasDuplas;

    /**
     * Construtor da classe ScreenPartidasDuplas.
     * Inicializa o controlador de partidas duplas.
     */
    public ScreenPartidasDuplas() {
        controllerPartidasDuplas = new ControllerPartidasDuplas();
    }

    /**
     * Exibe o menu principal para gerenciar partidas duplas.
     */
    public void telaMenuPartidasDuplas() {
        setTitle("Gestão de Partidas Duplas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Gestão de Partidas Duplas", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Partidas com facilidade. Escolha uma das opções para começar!",
                SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton cadastrarPartidaButton = new JButton("Cadastrar Partida");
        JButton consultarPartidaButton = new JButton("Consultar Partida");
        JButton atualizarPartidaButton = new JButton("Atualizar Partida");
        JButton excluirPartidaButton = new JButton("Excluir Partida");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(cadastrarPartidaButton);
        panel.add(consultarPartidaButton);
        panel.add(atualizarPartidaButton);
        panel.add(excluirPartidaButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        // Configura os botões
        cadastrarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarPartidasDuplas();
            }
        });

        atualizarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAtualizarPartidasDuplas();
            }
        });

        consultarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsultarPartidasDuplas();
            }
        });

        excluirPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaExcluirPartidasDuplas();
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
     * Exibe a tela para cadastro de partidas duplas.
     */
    public void telaCadastrarPartidasDuplas() {
        JFrame frame = new JFrame("Cadastro de Partidas Duplas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(20, 20));

        JPanel inputsPanel = new JPanel(new GridLayout(6, 2, 15, 15));
        inputsPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JTextField jogador1Equipe1Field = new JTextField();
        JTextField jogador2Equipe1Field = new JTextField();
        JTextField jogador1Equipe2Field = new JTextField();
        JTextField jogador2Equipe2Field = new JTextField();
        JTextField arbitroField = new JTextField();
        JTextField idField = new JTextField();

        inputsPanel.add(new JLabel("Nome Jogador 1 Equipe 1:"));
        inputsPanel.add(jogador1Equipe1Field);
        inputsPanel.add(new JLabel("Nome Jogador 2 Equipe 1:"));
        inputsPanel.add(jogador2Equipe1Field);
        inputsPanel.add(new JLabel("Nome Jogador 1 Equipe 2:"));
        inputsPanel.add(jogador1Equipe2Field);
        inputsPanel.add(new JLabel("Nome Jogador 2 Equipe 2:"));
        inputsPanel.add(jogador2Equipe2Field);
        inputsPanel.add(new JLabel("Nome Árbitro:"));
        inputsPanel.add(arbitroField);
        inputsPanel.add(new JLabel("ID da Partida:"));
        inputsPanel.add(idField);

        frame.add(inputsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton salvarButton = new JButton("Salvar");
        JButton voltarButton = new JButton("Voltar");

        salvarButton.setPreferredSize(new Dimension(150, 50));
        voltarButton.setPreferredSize(new Dimension(150, 50));

        frame.add(buttonPanel, BorderLayout.SOUTH);

        salvarButton = new JButton("Salvar");
        salvarButton.setPreferredSize(new Dimension(120, 40));
        salvarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jogador1Equipe1Nome = jogador1Equipe1Field.getText();
                String jogador2Equipe1Nome = jogador2Equipe1Field.getText();
                String jogador1Equipe2Nome = jogador1Equipe2Field.getText();
                String jogador2Equipe2Nome = jogador2Equipe2Field.getText();
                String arbitroNome = arbitroField.getText();

                if (jogador1Equipe1Nome.isEmpty() || jogador2Equipe1Nome.isEmpty() || jogador1Equipe2Nome.isEmpty()
                        || jogador2Equipe2Nome.isEmpty() || arbitroNome.isEmpty()
                        || idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idField.getText());
                        ControllerJogador controllerjogador = new ControllerJogador();
                        ControllerArbitro controllerarbitro = new ControllerArbitro();
                        Jogador jogador1Equipe1 = controllerjogador.lendoArquivoJogador(jogador1Equipe1Nome);
                        Jogador jogador2Equipe1 = controllerjogador.lendoArquivoJogador(jogador2Equipe1Nome);
                        Jogador jogador1Equipe2 = controllerjogador.lendoArquivoJogador(jogador1Equipe2Nome);
                        Jogador jogador2Equipe2 = controllerjogador.lendoArquivoJogador(jogador2Equipe2Nome);
                        Arbitro arbitro = controllerarbitro.lendoArquivoArbitro(arbitroNome);

                        controllerPartidasDuplas.adicionarPartida(jogador1Equipe1, jogador2Equipe1, jogador1Equipe2,
                                jogador2Equipe2, arbitro, idPartida);

                        JOptionPane.showMessageDialog(frame, "Partida cadastrada com sucesso!", "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE);

                        jogador1Equipe1Field.setText("");
                        jogador2Equipe1Field.setText("");
                        jogador1Equipe2Field.setText("");
                        jogador2Equipe2Field.setText("");
                        arbitroField.setText("");
                        idField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        jogador1Equipe1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador2Equipe1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador1Equipe2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador2Equipe2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        arbitroField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
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
     * Exibe a tela para consulta de partidas duplas.
     */
    public void telaConsultarPartidasDuplas() {
        JFrame frame = new JFrame("Consultar Partida Dupla");
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
                        String resultado = controllerPartidasDuplas.consultarPartidasDuplas(idPartida);

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
     * Exibe a tela para atualizar partidas duplas.
     */
    public void telaAtualizarPartidasDuplas() {
        JFrame frame = new JFrame("Atualizar Partida Dupla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(20, 20));

        JPanel inputsPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        inputsPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JTextField idField = new JTextField();
        JTextField jogador1Equipe1Field = new JTextField();
        JTextField jogador2Equipe1Field = new JTextField();
        JTextField jogador1Equipe2Field = new JTextField();
        JTextField jogador2Equipe2Field = new JTextField();
        JTextField arbitroField = new JTextField();
        JTextField resultadoField = new JTextField();
        JTextField tempoField = new JTextField();

        inputsPanel.add(new JLabel("ID Partida:"));
        inputsPanel.add(idField);

        inputsPanel.add(new JLabel("Nome Jogador 1 Equipe 1: "));
        inputsPanel.add(jogador1Equipe1Field);

        inputsPanel.add(new JLabel("Nome Jogador 2 Equipe 1: "));
        inputsPanel.add(jogador2Equipe1Field);

        inputsPanel.add(new JLabel("Nome Jogador 1 Equipe 2: "));
        inputsPanel.add(jogador1Equipe2Field);

        inputsPanel.add(new JLabel("Nome Jogador 2 Equipe 2: "));
        inputsPanel.add(jogador2Equipe2Field);

        inputsPanel.add(new JLabel("Nome Árbitro: "));
        inputsPanel.add(arbitroField);

        inputsPanel.add(new JLabel("Vencedores da Partida: "));
        inputsPanel.add(resultadoField);

        inputsPanel.add(new JLabel("Duração da Partida: "));
        inputsPanel.add(tempoField);

        frame.add(inputsPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton atualizarButton = new JButton("Atualizar");
        JButton voltarButton = new JButton("Voltar");

        // Ajuste do tamanho dos botões
        atualizarButton.setPreferredSize(new Dimension(150, 50));
        voltarButton.setPreferredSize(new Dimension(150, 50));

        buttonPanel.add(atualizarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        atualizarButton.setPreferredSize(new Dimension(120, 40));
        atualizarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idField.getText().isEmpty() || jogador1Equipe1Field.getText().isEmpty() ||
                        jogador2Equipe1Field.getText().isEmpty() || jogador1Equipe2Field.getText().isEmpty()
                        || jogador2Equipe2Field.getText().isEmpty() || arbitroField.getText().isEmpty() ||
                        resultadoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idField.getText());
                        String jogador1Equipe1Nome = jogador1Equipe1Field.getText();
                        String jogador2Equipe1Nome = jogador2Equipe1Field.getText();
                        String jogador1Equipe2Nome = jogador1Equipe2Field.getText();
                        String jogador2Equipe2Nome = jogador2Equipe2Field.getText();
                        String arbitroNome = arbitroField.getText();
                        String vencedor = resultadoField.getText();
                        double tempo = Double.parseDouble(tempoField.getText());

                        ControllerJogador controllerjogador = new ControllerJogador();
                        ControllerArbitro controllerarbitro = new ControllerArbitro();
                        Jogador jogador1Equipe1 = controllerjogador.lendoArquivoJogador(jogador1Equipe1Nome);
                        Jogador jogador2Equipe1 = controllerjogador.lendoArquivoJogador(jogador2Equipe1Nome);
                        Jogador jogador1Equipe2 = controllerjogador.lendoArquivoJogador(jogador1Equipe2Nome);
                        Jogador jogador2Equipe2 = controllerjogador.lendoArquivoJogador(jogador2Equipe2Nome);
                        Arbitro arbitro = controllerarbitro.lendoArquivoArbitro(arbitroNome);

                        boolean atualizado = controllerPartidasDuplas.atualizarPartida(jogador1Equipe1, jogador2Equipe1,
                                jogador1Equipe2, jogador2Equipe2, arbitro,
                                vencedor, tempo, idPartida);

                        if (atualizado) {
                            JOptionPane.showMessageDialog(frame, "Partida atualizada com sucesso!", "Sucesso",
                                    JOptionPane.INFORMATION_MESSAGE);
                            idField.setText("");
                            jogador1Equipe1Field.setText("");
                            jogador2Equipe1Field.setText("");
                            jogador1Equipe2Field.setText("");
                            jogador2Equipe2Field.setText("");
                            arbitroField.setText("");
                            resultadoField.setText("");
                            tempoField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Partida não encontrada!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        jogador1Equipe1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador2Equipe1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador1Equipe2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador2Equipe2Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        arbitroField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        resultadoField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
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

        tempoField.addKeyListener(new KeyAdapter() {
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
     * Exibe a tela para excluir partidas duplas.
     */
    public void telaExcluirPartidasDuplas() {
        JFrame frame = new JFrame("Excluir Partida Dupla");
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
                String idText = idField.getText().trim(); // Remove espaços em branco

                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Digite o ID da partida para excluir!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idText);
                        boolean excluido = controllerPartidasDuplas.excluirPartida(idPartida);

                        if (excluido) {
                            JOptionPane.showMessageDialog(frame, "Partida excluída com sucesso!", "Sucesso",
                                    JOptionPane.INFORMATION_MESSAGE);
                            idField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Partida não encontrada!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
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

        buttonPanel.add(excluirButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}