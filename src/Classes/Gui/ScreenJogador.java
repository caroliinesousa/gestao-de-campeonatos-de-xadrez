package Classes.Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Gestão de Jogadores", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JButton cadastrarJogadorButton = new JButton("Cadastrar Jogador");
        JButton consultarJogadorButton = new JButton("Consultar Jogador");
        JButton atualizarJogadorButton = new JButton("Atualizar Jogador");
        JButton excluirJogadorButton = new JButton("Excluir Jogador");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

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
        
        // Configuração da tela de cadastro
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(30, 200, 0, 0);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 2));
    
        // Adicionando os campos de input
        JPanel inputs = new JPanel(new GridLayout(5, 2));
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
    
        frame.add(inputs);
    
        // Botão Salvar
        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rankingInt = Integer.parseInt(rankingField.getText());
                int partidasInt = Integer.parseInt(partidasField.getText());
                controller.cadastrarJogador(nomeField.getText(), idadeField.getText(), sexoField.getText(), rankingInt, partidasInt);
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
                rankingField.setText("");
                partidasField.setText("");
            }
        });
        frame.add(salvarButton);
        frame.setVisible(true);
    
        // Botão Voltar
        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fechar a janela de cadastro e voltar ao menu principal
                frame.dispose();  // Fecha a tela de cadastro
                telaMenuJogador();  // Reabre o menu principal na mesma janela
            }
        });
        frame.add(voltarButton);
        frame.setVisible(true);
    }
    


    public void telaAtualizarJogador() {
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField rankingField;
        JTextField partidasField;
        JButton atualizarButton;
        JButton voltarButton;
        ControllerJogador atualizarJogador;
        atualizarJogador = new ControllerJogador();

        setTitle("Atualizar Jogador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JPanel inputs = new JPanel(new GridLayout(5, 2));
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

        add(inputs);

        atualizarButton = new JButton("Atualizar");
        atualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rankingInt = Integer.parseInt(rankingField.getText());
                int partidasInt = Integer.parseInt(partidasField.getText());
                atualizarJogador.atualizarJogador(nomeField.getText(), idadeField.getText(), sexoField.getText(), rankingInt, partidasInt);
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
                rankingField.setText("");
                partidasField.setText("");

            }
        });
        add(atualizarButton);
        setVisible(true);

        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        add(voltarButton);
        setVisible(true);

    }

    public void telaConsultarJogador() {
        JTextField nomeField;
        JButton salvarButton;
        ControllerJogador consultarJogador;
        JButton voltarButton;
        consultarJogador = new ControllerJogador();

        setTitle("Consulta de Jogador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JPanel inputs = new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome Jogador:", SwingConstants.CENTER));
        nomeField = new JTextField();
        inputs.add(nomeField);

        add(inputs);

        salvarButton = new JButton("Consultar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarJogador.consultarJogador(nomeField.getText());
                nomeField.setText("");

            }
        });
        add(salvarButton);
        setVisible(true);

        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        add(voltarButton);
        setVisible(true);
    }

    public void telaExcluirJogador() {
        
        JTextField nomeField;
        JButton excluirButton;
        JButton voltarButton;
        ControllerJogador excluirJogador;
        excluirJogador = new ControllerJogador();

        setTitle("Excluir Jogador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JPanel inputs = new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome Jogador:", SwingConstants.CENTER));
        nomeField = new JTextField();
        inputs.add(nomeField);

        add(inputs);

        excluirButton = new JButton("Excluir");
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirJogador.excluirJogador(nomeField.getText());
                nomeField.setText("");

            }
        });
        add(excluirButton);
        setVisible(true);

        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        add(voltarButton);
        setVisible(true);
    }

    public void telaVoltarAoMenu() {
        JButton voltarApaginaInicialButton;
        
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    
       
        }
    }