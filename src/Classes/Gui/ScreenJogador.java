package Classes.Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import Classes.Controller.ControllerJogador;

public class ScreenJogador extends JFrame {

    public ScreenJogador() {
    }
    public void telaMenuJogador() {
        setTitle("Gestão de Jogadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Gestão de Jogadores", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Jogadores com facilidade. Escolha uma das opções para começar!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton cadastrarJogadorButton = new JButton("Cadastrar Jogador");
        JButton consultarJogadorButton = new JButton("Consultar Jogador");
        JButton atualizarJogadorButton = new JButton("Atualizar Jogador");
        JButton excluirJogadorButton = new JButton("Excluir Jogador");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(cadastrarJogadorButton);
        panel.add(consultarJogadorButton);
        panel.add(atualizarJogadorButton);
        panel.add(excluirJogadorButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        cadastrarJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarJogador();
            }
        });

        atualizarJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenJogador screenJogador = new ScreenJogador();
                screenJogador.telaAtualizarJogador();
            }
        });

        consultarJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenJogador screenJogador = new ScreenJogador();
                screenJogador.telaConsultarJogador();
            }
        });

        excluirJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenJogador screenJogador = new ScreenJogador();
                screenJogador.telaExcluirJogador();
            }
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
    }

    public void telaCadastrarJogador() {
        JFrame frame = new JFrame("Cadastrar Jogador");
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField rankingField;
        JTextField partidasField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerJogador controller = new ControllerJogador();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel inputs = new JPanel(new GridLayout(5, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputs.add(new JLabel("Nome Jogador:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        inputs.add(new JLabel("Idade Jogador:"));
        idadeField = new JTextField();
        inputs.add(idadeField);

        inputs.add(new JLabel("Gênero Jogador:"));
        sexoField = new JTextField();
        inputs.add(sexoField);

        inputs.add(new JLabel("Ranking Jogador:"));
        rankingField = new JTextField();
        inputs.add(rankingField);

        inputs.add(new JLabel("Partidas Jogador:"));
        partidasField = new JTextField();
        inputs.add(partidasField);

        frame.add(inputs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        salvarButton = new JButton("Salvar");
        salvarButton.setPreferredSize(new Dimension(120, 40));
        salvarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String sexo = sexoField.getText();
                
                if (nomeField.getText().isEmpty() || idadeField.getText().isEmpty() || sexoField.getText().isEmpty() || rankingField.getText().isEmpty() || partidasField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }else{
                    int idadeInt = Integer.parseInt(idadeField.getText());
                    int rankingInt = Integer.parseInt(rankingField.getText());
                    int partidasInt = Integer.parseInt(partidasField.getText());

                    controller.cadastrarJogador(nome, idadeInt, sexo, rankingInt, partidasInt);
                    nomeField.setText("");
                    idadeField.setText("");
                    sexoField.setText("");
                    rankingField.setText("");
                    partidasField.setText("");
                    JOptionPane.showMessageDialog(frame, "Jogador cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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

        rankingField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        partidasField.addKeyListener(new KeyAdapter() {
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
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                telaMenuJogador();
            }
        });

        buttonPanel.add(salvarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void telaConsultarJogador() {
        JFrame frame = new JFrame("Consulta de Jogador");
        JTextField nomeField;
        JButton consultarButton;
        JButton voltarButton;
        JButton cadastrarButton = new JButton("Cadastrar Jogador");
        JLabel statusLabel;
    
        ControllerJogador consultarJogador = new ControllerJogador();
    
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
    
        JPanel inputsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        JLabel nomeLabel = new JLabel("Nome do Jogador:");
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
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeJogador = nomeField.getText();
                if (nomeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Digite um nome antes de consultar!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean encontrado = consultarJogador.consultarJogador(nomeJogador, cadastrarButton);
                    if (encontrado) {
                        statusLabel.setText("Jogador encontrado: " + nomeJogador);
                        statusLabel.setForeground(Color.GREEN);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Jogador não encontrado. Você pode cadastrá-lo agora.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        statusLabel.setText("Jogador não encontrado.");
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
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    
        cadastrarButton.setPreferredSize(new Dimension(150, 40));
        cadastrarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        cadastrarButton.setVisible(false);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                telaCadastrarJogador();
            }
        });
    
        buttonPanel.add(consultarButton);
        buttonPanel.add(voltarButton);
        buttonPanel.add(cadastrarButton);
    
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }    

    public void telaAtualizarJogador() {
        JFrame frame = new JFrame("Atualizar Jogador");
        JTextField nomeField, idadeField, sexoField, rankingField, partidasField;
        JButton atualizarButton, voltarButton, cadastrarButton;
        ControllerJogador atualizarJogador = new ControllerJogador();
    
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
    
        JPanel inputs = new JPanel(new GridLayout(5, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        inputs.add(new JLabel("Nome Jogador:"));
        nomeField = new JTextField();
        inputs.add(nomeField);
    
        inputs.add(new JLabel("Idade Jogador:"));
        idadeField = new JTextField();
        inputs.add(idadeField);
    
        inputs.add(new JLabel("Gênero Jogador:"));
        sexoField = new JTextField();
        inputs.add(sexoField);
    
        inputs.add(new JLabel("Ranking Jogador:"));
        rankingField = new JTextField();
        inputs.add(rankingField);
    
        inputs.add(new JLabel("Partidas Jogador:"));
        partidasField = new JTextField();
        inputs.add(partidasField);
    
        frame.add(inputs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    
        atualizarButton = new JButton("Atualizar");
        atualizarButton.setPreferredSize(new Dimension(120, 40));
        atualizarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
    
        cadastrarButton = new JButton("Cadastrar Jogador");
        cadastrarButton.setPreferredSize(new Dimension(160, 40));
        cadastrarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        cadastrarButton.setVisible(false);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                telaCadastrarJogador();
            }
        });
    
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String sexo = sexoField.getText();
    
                if (nomeField.getText().isEmpty() || idadeField.getText().isEmpty() || sexoField.getText().isEmpty() || rankingField.getText().isEmpty() || partidasField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    int idadeInt = Integer.parseInt(idadeField.getText());
                    int rankingInt = Integer.parseInt(rankingField.getText());
                    int partidasInt = Integer.parseInt(partidasField.getText());
    
                    boolean jogadorAtualizado = atualizarJogador.atualizarJogador(nome, idadeInt, sexo, rankingInt, partidasInt);
    
                    if (jogadorAtualizado) {
                        JOptionPane.showMessageDialog(frame, "Jogador atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        nomeField.setText("");
                        idadeField.setText("");
                        sexoField.setText("");
                        rankingField.setText("");
                        partidasField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Jogador não encontrado! Cadastre abaixo!", "Erro", JOptionPane.ERROR_MESSAGE);
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

        rankingField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        partidasField.addKeyListener(new KeyAdapter() {
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
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    
        buttonPanel.add(atualizarButton);
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(voltarButton);
    
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    public void telaExcluirJogador() {
    JFrame frame = new JFrame("Excluir Jogador");
    JTextField nomeField;
    JButton excluirButton;
    JButton voltarButton;
    ControllerJogador excluirJogador = new ControllerJogador();

    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(600, 250);  
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new BorderLayout());

    JPanel inputs = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

    JLabel nomeLabel = new JLabel("Nome Jogador:");
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
        BorderFactory.createEmptyBorder(5, 15, 5, 15)
    ));
    excluirButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String nomeJogador = nomeField.getText();

            if (nomeJogador.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Digite um nome para excluir!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                boolean jogadorExcluido = excluirJogador.excluirJogador(nomeJogador);
                if (jogadorExcluido) {
                    JOptionPane.showMessageDialog(frame, "Jogador excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    nomeField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Jogador não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
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
        BorderFactory.createEmptyBorder(5, 15, 5, 15)
    ));
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