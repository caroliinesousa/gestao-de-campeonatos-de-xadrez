package Classes.Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Classes.Controller.ControllerPartidasSingulares;
import Classes.Controller.ControllerArbitro;
import Classes.Controller.ControllerJogador;
import Classes.Controller.ControllerTorneiosSingulares;
import Classes.Partidas.PartidaSingulares;
import Classes.Pessoas.Arbitro;
import Classes.Pessoas.Jogador;
/**
 * Classe ScreenTorneiosSingulares
 * Representa a interface gráfica para gerenciar torneios de duplas em um sistema esportivo.
 * 
 * @version 1.0
 * @since 2025
 */
public class ScreenTorneiosSingulares extends JFrame {
    /**
     * Controlador para gerenciar partidas de singulares.
     */
    private ControllerPartidasSingulares cps;
    /**
     * Controlador para gerenciar torneios de singulares.
     */
    private ControllerTorneiosSingulares controllerTorneiosSingulares;

    public ScreenTorneiosSingulares(ControllerPartidasSingulares cps) {
        this.cps = cps;
        this.controllerTorneiosSingulares = new ControllerTorneiosSingulares();
        for (PartidaSingulares ps : controllerTorneiosSingulares.consultarTorneioEliminatorio()){
            cps.adicionaPartidaPronta(ps);

        }
    }

    /**
     * Exibe o menu principal para gerenciar torneios singulares.
     */
    
    public void telaTorneiosSingulares() {
        setTitle("Torneios Singulares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(75, 75));

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Torneios Singulares", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Torneios com facilidade. Selecione uma opção para começar!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton eliminatorioButton = new JButton("Eliminatórios");
        JButton porPontoButton = new JButton("Por Ponto");
        JButton voltarButton = new JButton("Voltar");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(eliminatorioButton);
        panel.add(porPontoButton);
        panel.add(voltarButton);

        add(panel);
        setVisible(true);

        eliminatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenTorneiosSingulares screen = new ScreenTorneiosSingulares(cps);
                screen.telaMenuTorneiosEliminatorios();
            }
        });

        porPontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenTorneiosSingulares screen = new ScreenTorneiosSingulares(cps);
                screen.telaMenuTorneiosPorPontos();
                
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void telaMenuTorneiosEliminatorios(){
            setTitle("Gestão de Torneios Eliminatórios");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setResizable(false);
            setLocationRelativeTo(null);
    
            JPanel panel = new JPanel(new GridLayout(8, 1));
            panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
            JLabel tituloLabel = new JLabel("Gestão de Torneios Eliminatórios", SwingConstants.CENTER);
            tituloLabel.setFont(new Font("Arial", Font.BOLD, 28));
            JLabel fraseLabel = new JLabel("Xeque! Escolha uma das opções para começar!", SwingConstants.CENTER);
            fraseLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    
            JButton cadastrarTorneioEliminatorioButton = new JButton("Cadastrar Torneio");
            JButton consultarTorneioEliminatorioButton = new JButton("Consultar Torneio");
            JButton atualizarTorneioEliminatorioButton = new JButton("Atualizar Torneio");
            JButton excluirTorneioEliminatorioButton = new JButton("Excluir Torneio");
            JButton voltarButton = new JButton("Voltar a Página Inicial");
    
            panel.add(tituloLabel);
            panel.add(fraseLabel);
            panel.add(cadastrarTorneioEliminatorioButton);
            panel.add(consultarTorneioEliminatorioButton);
            panel.add(atualizarTorneioEliminatorioButton);
            panel.add(excluirTorneioEliminatorioButton);
            panel.add(voltarButton);
    
            add(panel);
            setVisible(true);
    
            cadastrarTorneioEliminatorioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaCadastrarTorneiosEliminatorios();
                }
            });
    
            consultarTorneioEliminatorioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaConsultarTorneiosEliminatorios();
                }
            });

            atualizarTorneioEliminatorioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaAtualizarTorneiosEliminatorios();
                }
            });
    
            excluirTorneioEliminatorioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaExcluirTorneiosEliminatorios();
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
     * Exibe a tela para cadastrar torneios Singulares Eliminatorios.
     */
    public void telaCadastrarTorneiosEliminatorios() {
        JFrame frame = new JFrame("Cadastro de Torneio Eliminatório");
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

                        PartidaSingulares partida1 = cps.devolverPartidasSingulares(idPartida1);
                        PartidaSingulares partida2 = cps.devolverPartidasSingulares(idPartida2);
                        PartidaSingulares partida3 = cps.devolverPartidasSingulares(idPartida3);
                        if (partida1 != null && partida2 != null && partida3 != null){

                            controllerTorneiosSingulares.cadastrarTorneioEliminatorios(partida1, partida2, partida3);
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
     * Exibe a tela para consultar torneios Singulares Eliminatorios.
     */
    public void telaConsultarTorneiosEliminatorios(){
        JFrame frame = new JFrame("Consultar Torneio Eliminatorio");
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
                    JOptionPane.showMessageDialog(frame, "Digite o ID da partida para consultar!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idField.getText());
                        String resultado = controllerTorneiosSingulares(idPartida);
            
                        if (resultado == null || resultado.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Partida não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, resultado, "Resultado da Consulta", JOptionPane.INFORMATION_MESSAGE);
                        }
            
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
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
     * Exibe a tela para atualizar torneios Singulares Eliminatorios.
     */
    public void telaAtualizarTorneiosEliminatorios(){
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

                        PartidaSingulares partida1 = cps.devolverPartidasSingulares(idPartida1);
                        PartidaSingulares partida2 = cps.devolverPartidasSingulares(idPartida2);
                        PartidaSingulares partida3 = cps.devolverPartidasSingulares(idPartida3);

                         controllerTorneiosSingulares.atualizarTorneioEliminatorio(partida1, partida2, partida3);
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
     * Exibe a tela para excluir torneios Singulares Eliminatorios.
     */
    public void telaExcluirTorneiosEliminatorios(){
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
                controllerTorneiosSingulares.excluirTorneiosEliminatorios();
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

    
    
    public void telaMenuTorneiosPorPontos(){
            setTitle("Gestão de Torneios Por Pontos");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setResizable(false);
            setLocationRelativeTo(null);
    
            JPanel panel = new JPanel(new GridLayout(8, 1));
            panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
            JLabel tituloLabel = new JLabel("Gestão de Torneios Por Ponto", SwingConstants.CENTER);
            tituloLabel.setFont(new Font("Arial", Font.BOLD, 28));
            JLabel fraseLabel = new JLabel("Xeque! Escolha uma das opções para começar!", SwingConstants.CENTER);
            fraseLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    
            JButton cadastrarTorneioPorPontoButton = new JButton("Cadastrar Torneio");
            JButton consultarTorneioPorPontoButton = new JButton("Consultar Torneio");
            JButton atualizarTorneioPorPontoButton = new JButton("Atualizar Torneio");
            JButton excluirTorneioPorPontoButton = new JButton("Excluir Torneio");
            JButton voltarButton = new JButton("Voltar a Página Inicial");
    
            panel.add(tituloLabel);
            panel.add(fraseLabel);
            panel.add(cadastrarTorneioPorPontoButton);
            panel.add(consultarTorneioPorPontoButton);
            panel.add(atualizarTorneioPorPontoButton);
            panel.add(excluirTorneioPorPontoButton);
            panel.add(voltarButton);
    
            add(panel);
            setVisible(true);
    
            cadastrarTorneioPorPontoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaCadastrarTorneiosEliminatorios();
                }
            });
    
            consultarTorneioPorPontoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaConsultarTorneiosEliminatorios();
                }
            });

            atualizarTorneioPorPontoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaAtualizarTorneiosEliminatorios();
                }
            });
    
            excluirTorneioPorPontoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaExcluirTorneiosEliminatorios();
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
     * Exibe a tela para cadastrar torneios Singulares Por Pontos.
     */
    public void telaCadastrarTorneiosPorPontos(){
        JFrame frame = new JFrame("Cadastro de Torneio Por Ponto");
        JTextField partida1Field;
        JTextField partida2Field;
        JTextField partida3Field;
        JButton salvarButton;
        JButton voltarButton;

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

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

                        PartidaSingulares partida1 = cps.devolverPartidasSingulares(idPartida1);
                        PartidaSingulares partida2 = cps.devolverPartidasSingulares(idPartida2);
                        PartidaSingulares partida3 = cps.devolverPartidasSingulares(idPartida3);
                        if (partida1 != null && partida2 != null && partida3 != null){

                            controllerTorneiosSingulares.cadastrarTorneioEliminatorios(partida1, partida2, partida3);
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
     * Exibe a tela para consultar torneios Singulares Por Pontos.
     */
    public void telaConsultarTorneiosPorPontos(){
        JFrame frame = new JFrame("Consultar Torneio Eliminatorio");
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
                    JOptionPane.showMessageDialog(frame, "Digite o ID da partida para consultar!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idPartida = Integer.parseInt(idField.getText());
                        String resultado = controllerTorneiosSingulares.telaConsultarTorneiosPontos(idPartida);
            
                        if (resultado == null || resultado.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Partida não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, resultado, "Resultado da Consulta", JOptionPane.INFORMATION_MESSAGE);
                        }
            
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID da partida deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
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
     * Exibe a tela para atualizar torneios Singulares Por Pontos.
     */
    public void telaAtualizarTorneioPorPontos(){
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

                        PartidaSingulares partida1 = cps.devolverPartidasSingulares(idPartida1);
                        PartidaSingulares partida2 = cps.devolverPartidasSingulares(idPartida2);
                        PartidaSingulares partida3 = cps.devolverPartidasSingulares(idPartida3);

                         controllerTorneiosSingulares.atualizarTorneioEliminatorio(partida1, partida2, partida3);
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
     * Exibe a tela para excluir torneios Singulares Por Pontos.
     */
    public void telaExcluirTorneioPorPonto(){
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
                controllerTorneiosSingulares.excluirTorneiosPontos();
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












