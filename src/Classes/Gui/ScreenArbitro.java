package Classes.Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import Classes.Controller.ControllerArbitro;

/**
 * A classe {@code ScreenArbitro} fornece a interface gráfica para gerenciar
 * árbitros no sistema.
 * <p>
 * Inclui funcionalidades para cadastrar, consultar, atualizar e excluir
 * árbitros, apresentando telas específicas
 * para cada operação.
 * </p>
 */
public class ScreenArbitro extends JFrame {
    /**
     * Construtor padrão da classe {@code ScreenArbitro}.
     */
    public ScreenArbitro() {
    }

    /**
     * Exibe o menu principal de gestão de árbitros.
     */
    public void telaMenuArbitro() {

        setTitle("Gestão de Árbitros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));
        setLayout(new BorderLayout(75, 75));

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Gestão de Árbitros", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Árbitros com facilidade. Escolha uma das opções para começar!",
                SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton cadastrarArbitroButton = new JButton("Cadastrar Árbitro");
        JButton consultarArbitroButton = new JButton("Consultar Árbitro");
        JButton atualizarArbitroButton = new JButton("Atualizar Árbitro");
        JButton excluirArbitroButton = new JButton("Excluir Árbitro");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(cadastrarArbitroButton);
        panel.add(consultarArbitroButton);
        panel.add(atualizarArbitroButton);
        panel.add(excluirArbitroButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        cadastrarArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarArbitro();
            }
        });

        atualizarArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenArbitro screenArbitro = new ScreenArbitro();
                screenArbitro.telaAtualizarArbitro();
            }
        });

        consultarArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenArbitro screenArbitro = new ScreenArbitro();
                screenArbitro.telaConsultarArbitro();
            }
        });

        excluirArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenArbitro screenArbitro = new ScreenArbitro();
                screenArbitro.telaExcluirArbitro();
            }
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });

    }

    /**
     * Exibe a tela para cadastrar um novo árbitro.
     */
    public void telaCadastrarArbitro() {
        JFrame frame = new JFrame("Cadastro de Árbitro");
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField certificacoesField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerArbitro cadastrarArbitro = new ControllerArbitro();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel inputs = new JPanel(new GridLayout(4, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputs.add(new JLabel("Nome Árbitro:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        inputs.add(new JLabel("Idade Árbitro:"));
        idadeField = new JTextField();
        inputs.add(idadeField);

        inputs.add(new JLabel("Gênero Árbitro:"));
        sexoField = new JTextField();
        inputs.add(sexoField);

        inputs.add(new JLabel("Certificações:"));
        certificacoesField = new JTextField();
        inputs.add(certificacoesField);

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
                if (nomeField.getText().isEmpty() || idadeField.getText().isEmpty() || sexoField.getText().isEmpty()
                        || certificacoesField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int idade = Integer.parseInt(idadeField.getText()); // Converte idade para int

                        cadastrarArbitro.cadastrarArbitro(
                                nomeField.getText(),
                                idade,
                                sexoField.getText(),
                                certificacoesField.getText());
                        nomeField.setText("");
                        idadeField.setText("");
                        sexoField.setText("");
                        certificacoesField.setText("");

                        JOptionPane.showMessageDialog(frame, "Árbitro cadastrado com sucesso!", "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Idade inválida! Digite um número válido.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        nomeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        idadeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        sexoField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        certificacoesField.addKeyListener(new KeyAdapter() {
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
                telaMenuArbitro();
            }
        });

        buttonPanel.add(salvarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void telaConsultarArbitro() {
        JFrame frame = new JFrame("Consulta de Árbitro");
        JTextField nomeField;
        JButton consultarButton;
        JButton voltarButton;
        JButton cadastrarButton = new JButton("Cadastrar Árbitro");
        JLabel statusLabel;

        ControllerArbitro consultarArbitro = new ControllerArbitro();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel inputsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nomeLabel = new JLabel("Nome do Arbitro:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputsPanel.add(nomeLabel, gbc);

        nomeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputsPanel.add(nomeField, gbc);

        frame.add(inputsPanel, BorderLayout.CENTER);

        statusLabel = new JLabel(" ", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(statusLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        consultarButton = new JButton("Consultar");
        consultarButton.setPreferredSize(new Dimension(120, 40));
        consultarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeArbitro = nomeField.getText();
                if (nomeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Digite um nome antes de consultar!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean encontrado = consultarArbitro.consultarArbitro(nomeArbitro, cadastrarButton);
                    if (encontrado) {
                        statusLabel.setText("Arbitro encontrado: " + nomeArbitro);
                        statusLabel.setForeground(Color.GREEN);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Árbitro não encontrado. Você pode cadastrá-lo agora.",
                                "Aviso", JOptionPane.WARNING_MESSAGE);
                        statusLabel.setText("Árbitro não encontrado.");
                        statusLabel.setForeground(Color.RED);
                    }
                    nomeField.setText("");
                }
            }
        });

        nomeField.addKeyListener(new KeyAdapter() {
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
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        cadastrarButton.setPreferredSize(new Dimension(150, 40));
        cadastrarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        cadastrarButton.setVisible(false);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                telaCadastrarArbitro();
            }
        });

        buttonPanel.add(consultarButton);
        buttonPanel.add(voltarButton);
        buttonPanel.add(cadastrarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void telaAtualizarArbitro() {
        JFrame frame = new JFrame("Atualizar Árbitro");
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField certificacoesField;
        JButton atualizarButton;
        JButton cadastrarButton;
        JButton voltarButton;
        ControllerArbitro atualizarArbitro = new ControllerArbitro();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputsPanel.add(new JLabel("Nome Árbitro:"));
        nomeField = new JTextField();
        inputsPanel.add(nomeField);

        inputsPanel.add(new JLabel("Idade Árbitro:"));
        idadeField = new JTextField();
        inputsPanel.add(idadeField);

        inputsPanel.add(new JLabel("Gênero Árbitro:"));
        sexoField = new JTextField();
        inputsPanel.add(sexoField);

        inputsPanel.add(new JLabel("Certificações:"));
        certificacoesField = new JTextField();
        inputsPanel.add(certificacoesField);

        add(inputsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        atualizarButton = new JButton("Atualizar");
        atualizarButton.setPreferredSize(new Dimension(120, 40));
        atualizarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));

        cadastrarButton = new JButton("Cadastrar Árbitro");
        cadastrarButton.setPreferredSize(new Dimension(160, 40));
        cadastrarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        cadastrarButton.setVisible(false);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                telaCadastrarArbitro();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String sexo = sexoField.getText();
                String certificacoes = certificacoesField.getText();

                if (nomeField.getText().isEmpty() || idadeField.getText().isEmpty() || sexoField.getText().isEmpty()
                        || certificacoesField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int idadeInt = Integer.parseInt(idadeField.getText());

                    boolean jogadorAtualizado = atualizarArbitro.atualizarArbitro(nome, idadeInt, sexo, certificacoes);

                    if (jogadorAtualizado) {
                        JOptionPane.showMessageDialog(frame, "Árbitro atualizado com sucesso!", "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE);
                        nomeField.setText("");
                        idadeField.setText("");
                        sexoField.setText("");
                        certificacoesField.setText("");

                    } else {
                        JOptionPane.showMessageDialog(frame, "Árbitro não encontrado! Cadastre abaixo!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        cadastrarButton.setVisible(true);
                    }
                }
            }
        });

        nomeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        idadeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        sexoField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        certificacoesField.addKeyListener(new KeyAdapter() {
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
                dispose();
            }
        });

        buttonPanel.add(atualizarButton);
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(voltarButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void telaExcluirArbitro() {
        JFrame frame = new JFrame("Excluir Árbitro");
        JTextField nomeField;
        JButton excluirButton;
        JButton voltarButton;
        ControllerArbitro excluirArbitro = new ControllerArbitro();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel inputs = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel nomeLabel = new JLabel("Nome Árbitro:");
        nomeLabel.setPreferredSize(new Dimension(100, 30));
        inputs.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(200, 30));
        inputs.add(nomeField);

        frame.add(inputs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        excluirButton = new JButton("Excluir");
        excluirButton.setPreferredSize(new Dimension(120, 40));
        excluirButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        excluirButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String nomeArbitro = nomeField.getText();

                if (nomeArbitro.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Digite um nome para excluir!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean arbitroExcluido = excluirArbitro.excluirArbitro(nomeArbitro);

                    if (arbitroExcluido) {
                        JOptionPane.showMessageDialog(frame, "Árbitro excluído com sucesso!", "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE);
                        nomeField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Árbitro não encontrado!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        nomeField.addKeyListener(new KeyAdapter() {
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
