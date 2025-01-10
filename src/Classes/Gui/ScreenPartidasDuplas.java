package Classes.Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Classes.Controller.ControllerArbitro;
import Classes.Controller.ControllerPartidasDuplas;

public class ScreenPartidasDuplas extends JFrame {

    public ScreenPartidasDuplas() {

    }
    public static void telaMenuPartidasDuplas(){

        setTitle("Gestão de Partidas Duplas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));
        setLayout(new BorderLayout(75,75));

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
        JLabel fraseLabel = new JLabel("Gestão de Partidas Duplas", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Partidas com facilidade. Preencha as lacunas abaixo!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton jogador1Equipe1Button = new JButton("Jogador 1 Equipe 1");
        JButton jogador2Equipe1Button = new JButton("Jogador 2 Equipe 1");
        JButton jogador1Equipe2Button = new JButton("Jogador 1 Equipe 2");
        JButton jogador2Equipe2Button = new JButton("Jogador 2 Equipe 2");
        JButton arbitroButton = new JButton("Árbitro");
        JButton resultadoButton = new JButton("Resultado Partida");
        JButton idPartidaButton = new JButton("ID Partida");
        JButton tempoButton = new JButton("Tempo da Partida");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(jogador1Equipe1Button);
        panel.add(jogador2Equipe1Button);
        panel.add(jogador1Equipe2Button);
        panel.add(jogador2Equipe2Button);
        panel.add(arbitroButton);
        panel.add(resultadoButton);
        panel.add(idPartidaButton);
        panel.add(tempoButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        jogador1Equipe1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaJogador1Equipe1();
            }
        });

        jogador2Equipe1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaJogador2Equipe1();
            }
        });

        jogador1Equipe2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaJogador1Equipe2();
            }
        });

        jogador2Equipe2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaJogador2Equipe2();
            }
        });

        arbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaArbitro();
            }
        });

        resultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaResultado();
            }
        });

        idPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaidPartida();
            }
        });

        tempoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaTempo();
            }
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });

        public void telaCadastrarPartidasDuplas() {
        JFrame frame = new JFrame("Cadastro de Partidas");
        JTextField jogador1Equipe1Field;
        JTextField jogador2Equipe1Field;
        JTextField jogador1Equipe2Field;
        JTextField jogador2Equipe2Field;
        JTextField arbitroField;
        JTextField resultadoField;
        JTextField idPartidaField;
        JTextField tempoField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerPartidasDuplas cadastrarPartidasDuplas;

        cadastrarPartidasDuplas = new ControllerPartidasDuplas();

        frame.setTitle("Cadastro de arbitro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6, 2));

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Nome Jogador 1 Equipe 1:"));
        jogador1Equipe1Field = new JTextField();
        inputs.add(jogador1Equipe1Field);

        inputs.add(new JLabel("Nome Jogador 2 Equipe 1:"));
        jogador2Equipe1Field = new JTextField();
        inputs.add(jogador2Equipe1Field);

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Nome Jogador 1 Equipe 2:"));
        jogador1Equipe2Field = new JTextField();
        inputs.add(jogador1Equipe2Field);

        inputs.add(new JLabel("Nome Jogador 2 Equipe 2:"));
        jogador2Equipe2Field = new JTextField();
        inputs.add(jogador2Equipe2Field);

        inputs.add(new JLabel("Nome Arbitro:"));
        arbitroField = new JTextField();
        inputs.add(arbitroField);

        inputs.add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        inputs.add(resultadoField);

        inputs.add(new JLabel("ID Partida:"));
        idPartidaField = new JTextField();
        inputs.add(idPartidaField);

        inputs.add(new JLabel("Tempo Partida:"));
        tempoField = new JTextField();
        inputs.add(tempoField);

        frame.add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPartidasDuplas.cadastrarPartidasDuplas(jogador1Equipe1Field.getText(), jogador2Equipe1Field.getText(), jogador1Equipe2Field.getText(), jogador2Equipe2Field.getText(), arbitroField.getText(), resultadoField.getText(), idPartidaField.getText(), tempoField.getText());
                jogador1Equipe1Field.setText("");
                jogador2Equipe1Field.setText("");
                jogador1Equipe2Field.setText("");
                jogador2Equipe2Field.setText("");
                arbitroField.setText("");
                resultadoField.setText("");
                idPartidaField.setText("");
                tempoField.setText("");
            }
            });
        frame.add(salvarButton);
        frame.setVisible(true);

        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  
                telaMenuPartidas();

            }
        });
        frame.add(voltarButton);
        frame.setVisible(true);
    }

    public void telaAtualizarPartidasDuplas() {
        JFrame frame = new JFrame("Atualizacao de Partidas");
        JTextField jogador1Equipe1Field;
        JTextField jogador2Equipe1Field;
        JTextField jogador1Equipe2Field;
        JTextField jogador2Equipe2Field;
        JTextField arbitroField;
        JTextField resultadoField;
        JTextField idPartidaField;
        JTextField tempoField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerPartidasDuplas atualizarPartidasDuplas;

        atualizarPartidasDuplas = new ControllerPartidasDuplas();

        frame.setTitle("Atualizar Partida");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6, 2));

        inputs.add(new JLabel("Nome Jogador 1 Equipe 1:"));
        jogador1Equipe1Field = new JTextField();
        inputs.add(jogador1Equipe1Field);

        inputs.add(new JLabel("Nome Jogador 2 Equipe 1:"));
        jogador2Equipe1Field = new JTextField();
        inputs.add(jogador2Equipe1Field);

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Nome Jogador 1 Equipe 2:"));
        jogador1Equipe2Field = new JTextField();
        inputs.add(jogador1Equipe2Field);

        inputs.add(new JLabel("Nome Jogador 2 Equipe 2:"));
        jogador2Equipe2Field = new JTextField();
        inputs.add(jogador2Equipe2Field);
        inputs.add(new JLabel("Nome Arbitro:"));
        arbitroField = new JTextField();
        inputs.add(arbitroField);

        inputs.add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        inputs.add(resultadoField);

        inputs.add(new JLabel("ID Partida:"));
        idPartidaField = new JTextField();
        inputs.add(idPartidaField);

        inputs.add(new JLabel("Tempo Partida:"));
        tempoField = new JTextField();
        inputs.add(tempoField);

        frame.add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPartidasDuplas.cadastrarPartidasDuplas(jogador1Equipe1Field.getText(), jogador2Equipe1Field.getText(), jogador1Equipe2Field.getText(), jogador2Equipe2Field.getText(), arbitroField.getText(), idPartidaField.getText(), resultadoField.getText(), tempoField.getText());
                jogador1Equipe1Field.setText("");
                jogador2Equipe1Field.setText("");
                jogador1Equipe2Field.setText("");
                jogador2Equipe2Field.setText("");
                arbitroField.setText("");
                resultadoField.setText("");
                idPartidaField.setText("");
                tempoField.setText("");
            }
            });
        frame.add(salvarButton);
        frame.setVisible(true);

        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  
                telaMenuPartidasDuplas();

            }
        });
        frame.add(voltarButton);
        frame.setVisible(true);
    }

    public void telaConsultarPartidasDuplas() {

        JTextField idPartidaField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerPartidasDuplas consultarPartidasDuplas;

        consultarPartidasDuplas = new ControllerPartidasDuplas();

        setTitle("Consulta de Partidas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JPanel inputs = new JPanel(new GridLayout(3, 1));
        inputs.add(new JLabel("ID Partida:", SwingConstants.CENTER));
        idPartidaField = new JTextField();
        inputs.add(idPartidaField);

        add(inputs);

        salvarButton = new JButton("Consultar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarArbitro.consultarArbitro(idPartidaField.getText());
                idPartidaField.setText("");
                
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

    public void telaExcluirPartidasDuplas() {

        JTextField idPartidaField;
        JButton excluirButton;
        JButton voltarButton;
        ControllerArbitro excluirArbitro;
        excluirArbitro = new ControllerArbitro();

        setTitle("Excluir Partidas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JPanel inputs = new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("id arbitro:" , SwingConstants.CENTER));
        idPartidaField = new JTextField();
        inputs.add(idPartidaField);

        add(inputs);

        excluirButton = new JButton("Excluir");
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirPartidasDuplas.excluirPartidasDuplas(idPartidaField.getText());
                idPartidaField.setText("");
                
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




        

