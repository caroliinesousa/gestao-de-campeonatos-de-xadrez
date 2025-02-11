/**
 * Classe ScreenPartidasSingulares
 * Representa a interface gráfica para gerenciar as partidas singulares.
 * 
 * @version 1.0
 * @since 2025
 */
package Classes.Gui;

import javax.swing.*;

import Classes.Controller.ControllerArbitro;
import Classes.Controller.ControllerJogador;
import Classes.Controller.ControllerPartidasSingulares;
import Classes.Pessoas.Jogador;
import Classes.Pessoas.Arbitro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe para gerenciar a interface gráfica das partidas singulares.
 * Fornece funcionalidades para cadastrar, consultar, atualizar e excluir
 * partidas.
 *
 * @author AnaSousaEvitorFontenele
 * @version 1.0
 * @since 2025
 */
public class ScreenPartidasSingulares extends JFrame {
    /**
     * Controlador para gerenciar as partidas singulares.
     */
    private ControllerPartidasSingulares controllerPartidasSingulares;

    /**
     * Construtor da classe ScreenPartidasSingulares.
     *
     * @param cps controlador das partidas singulares.
     */
    public ScreenPartidasSingulares(ControllerPartidasSingulares cps) {
        this.controllerPartidasSingulares = cps;
    }

    /**
     * Exibe o menu principal para gerenciar partidas singulares.
     */
    public void telaMenuPartidasSingulares() {
        setTitle("Gestão de Partidas Singulares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel tituloLabel = new JLabel("Partidas Singulares", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel = new JLabel("Xeque! Escolha uma das opções para começar!", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton cadastrarPartidaButton = new JButton("Cadastrar Partida");
        JButton consultarPartidaButton = new JButton("Consultar Partida");
        JButton atualizarPartidaButton = new JButton("Atualizar Partida");
        JButton excluirPartidaButton = new JButton("Excluir Partida");
        JButton voltarButton = new JButton("Voltar a Página Inicial");

        panel.add(tituloLabel);
        panel.add(fraseLabel);
        panel.add(cadastrarPartidaButton);
        panel.add(consultarPartidaButton);
        panel.add(atualizarPartidaButton);
        panel.add(excluirPartidaButton);
        panel.add(voltarButton);

        add(panel);
        setVisible(true);

        cadastrarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarPartidasSingulares();
            }
        });

        atualizarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAtualizarPartidasSingulares();
            }
        });

        consultarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsultarPartidasSingulares();
            }
        });

        excluirPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaExcluirPartidasSingulares();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    /**
     * Exibe a tela para cadastro de partidas singulares.
     */
    public void telaCadastrarPartidasSingulares() {
        JFrame frame = new JFrame("Cadastro de Partida");
        JTextField jogador1Field;
        JTextField jogador2Field;
        JTextField arbitroField;
        JTextField idField;
        JTextField tipoField;
        JButton salvarButton;
        JButton voltarButton;

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Painel de inputs
        JPanel inputs = new JPanel(new GridLayout(5, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputs.add(new JLabel("Jogador 1:"));
        jogador1Field = new JTextField();
        inputs.add(jogador1Field);

        inputs.add(new JLabel("Jogador 2:"));
        jogador2Field = new JTextField();
        inputs.add(jogador2Field);

        inputs.add(new JLabel("Árbitro:"));
        arbitroField = new JTextField();
        inputs.add(arbitroField);

        inputs.add(new JLabel("ID da Partida:"));
        idField = new JTextField();
        inputs.add(idField);

        inputs.add(new JLabel("Tipo da Partida:"));
        tipoField = new JTextField();
        inputs.add(tipoField);

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
                String jogador1Nome = jogador1Field.getText();
                String jogador2Nome = jogador2Field.getText();
                String arbitroNome = arbitroField.getText();
                String tipoPartida = tipoField.getText();

                if (jogador1Nome.isEmpty() || jogador2Nome.isEmpty() || arbitroNome.isEmpty()
                        || idField.getText().isEmpty() || tipoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idField.getText());
                        ControllerJogador controllerjogador = new ControllerJogador();
                        ControllerArbitro controllerarbitro = new ControllerArbitro();
                        Jogador jogador1 = controllerjogador.lendoArquivoJogador(jogador1Nome);
                        Jogador jogador2 = controllerjogador.lendoArquivoJogador(jogador2Nome);
                        Arbitro arbitro = controllerarbitro.lendoArquivoArbitro(arbitroNome);

                        controllerPartidasSingulares.adicionarPartida(jogador1, jogador2, arbitro, idPartida,
                                tipoPartida);

                        JOptionPane.showMessageDialog(frame, "Partida cadastrada com sucesso!", "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE);

                        jogador1Field.setText("");
                        jogador2Field.setText("");
                        arbitroField.setText("");
                        idField.setText("");
                        tipoField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        jogador1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador2Field.addKeyListener(new KeyAdapter() {
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

        tipoField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
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
     * Exibe a tela para atualizar partidas singulares.
     */
    public void telaAtualizarPartidasSingulares() {
        JFrame frame = new JFrame("Atualizar Partida Singular");
        JTextField idField = new JTextField();
        JTextField jogador1Field = new JTextField();
        JTextField jogador2Field = new JTextField();
        JTextField arbitroField = new JTextField();
        JTextField resultadoField = new JTextField();
        JTextField tempoField = new JTextField();
        JTextField tipoField = new JTextField();
        JButton atualizarButton = new JButton("Atualizar");
        JButton voltarButton = new JButton("Voltar");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Painel de inputs
        JPanel inputs = new JPanel(new GridLayout(7, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputs.add(new JLabel("ID da Partida:"));
        inputs.add(idField);

        inputs.add(new JLabel("Jogador 1:"));
        inputs.add(jogador1Field);

        inputs.add(new JLabel("Jogador 2:"));
        inputs.add(jogador2Field);

        inputs.add(new JLabel("Árbitro:"));
        inputs.add(arbitroField);

        inputs.add(new JLabel("Vencedor da Partida:"));
        inputs.add(resultadoField);

        inputs.add(new JLabel("Duração da partida:"));
        inputs.add(tempoField);

        inputs.add(new JLabel("Tipo da partida:"));
        inputs.add(tipoField);

        frame.add(inputs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        atualizarButton.setPreferredSize(new Dimension(120, 40));
        atualizarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idField.getText().isEmpty() || jogador1Field.getText().isEmpty() ||
                        jogador2Field.getText().isEmpty() || arbitroField.getText().isEmpty() ||
                        resultadoField.getText().isEmpty() || tipoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idField.getText());
                        String jogador1Nome = jogador1Field.getText();
                        String jogador2Nome = jogador2Field.getText();
                        String arbitroNome = arbitroField.getText();
                        String vencedor = resultadoField.getText();
                        String tipo = tipoField.getText();
                        double tempo = Double.parseDouble(tempoField.getText());

                        ControllerJogador controllerjogador = new ControllerJogador();
                        ControllerArbitro controllerarbitro = new ControllerArbitro();
                        Jogador jogador1 = controllerjogador.lendoArquivoJogador(jogador1Nome);
                        Jogador jogador2 = controllerjogador.lendoArquivoJogador(jogador2Nome);
                        Arbitro arbitro = controllerarbitro.lendoArquivoArbitro(arbitroNome);

                        boolean atualizado = controllerPartidasSingulares.atualizarPartida(jogador1, jogador2, arbitro,
                                vencedor, tempo, idPartida, tipo);

                        if (atualizado) {
                            JOptionPane.showMessageDialog(frame, "Partida atualizada com sucesso!", "Sucesso",
                                    JOptionPane.INFORMATION_MESSAGE);
                            idField.setText("");
                            jogador1Field.setText("");
                            jogador2Field.setText("");
                            arbitroField.setText("");
                            resultadoField.setText("");
                            tempoField.setText("");
                            tipoField.setText("");
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

        jogador1Field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        jogador2Field.addKeyListener(new KeyAdapter() {
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

        tipoField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
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
     * Exibe a tela para consultar partidas singulares.
     */
    public void telaConsultarPartidasSingulares() {
        JFrame frame = new JFrame("Consultar Partida Singular");
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
                        String resultado = controllerPartidasSingulares.consultarPartidasSingulares(idPartida);

                        if (resultado == null || resultado.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Partida não encontrada!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, resultado, "Resultado da Consulta",
                                    JOptionPane.INFORMATION_MESSAGE);
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

        buttonPanel.add(consultarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    /**
     * Exibe a tela para excluir partidas singulares.
     */
    public void telaExcluirPartidasSingulares() {
        JFrame frame = new JFrame("Excluir Partida Singular");
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
                        boolean excluido = controllerPartidasSingulares.excluirPartida(idPartida);

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
