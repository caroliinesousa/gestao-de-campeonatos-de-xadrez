package Classes.Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Classes.Controller.ControllerPartidas;

public class ScreenPartidas extends JFrame {

    public ScreenPartidas() {

    }
    public void telaMenuPartidas(){

        setTitle("Gestão de Partidas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));
        setLayout(new BorderLayout(75,75));

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
        JLabel fraseLabel = new JLabel("Gestão de Partidas", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Partidas com facilidade. Preencha as lacunas abaixo!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton jogador1Button = new JButton("Jogador 1");
        JButton jogador2Button = new JButton("Jogador 2 ");
        JButton arbitroButton = new JButton("Árbitro");
        JButton resultadoButton = new JButton("Resultado Partida");
        JButton idButton = new JButton("ID Partida");
        JButton tempoPartidaButton = new JButton("Tempo da Partida");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");


        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(jogador1Button);
        panel.add(jogador2Button);
        panel.add(arbitroButton);
        panel.add(resultado);
        panel.add(id);
        panel.add(tempoPartidaButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        jogador1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaJogador1();
            }
        });

        jogador2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidas screenPartidas = new ScreenPartidas();
                screenPartidas.telaJogador2();
            }
        });

        arbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidas screenPartidas = new ScreenPartidas();
                screenPartidas.telaArbitro();
            }
        });

        resultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidas screenPartidas = new ScreenPartidas();
                screenPartidas.telaResultado();
            }
        });

        tempoPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidas screenPartidas = new ScreenPartidas();
                screenPartidas.telaTempoPartida();
            }
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });

        }
    public void telaCadastrarPartidas() {
        JFrame frame = new JFrame("Cadastro de Partidas");
        JTextField jogador1Field;
        JTextField jogador2Field;
        JTextField arbitroField;
        JTextField resultadoField;
        JTextField idField;
        JTextField tempoPartidaField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerPartidas cadastrarPartida;

        cadastrarPartidas = new ControllerPartidas();

        frame.setTitle("Cadastro de arbitro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6, 2));

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Nome Jogador 1:"));
        jogador1Field = new JTextField();
        inputs.add(jogador1Field);

        inputs.add(new JLabel("Nome Jogador 2:"));
        jogador2Field = new JTextField();
        inputs.add(jogador2Field);

        inputs.add(new JLabel("Nome Arbitro:"));
        arbitroField = new JTextField();
        inputs.add(arbitroField);

        inputs.add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        inputs.add(resultadoField);

        inputs.add(new JLabel("ID Partida:"));
        idField = new JTextField();
        inputs.add(idField);

        inputs.add(new JLabel("Tempo Partida:"));
        tempoPartidaField = new JTextField();
        inputs.add(tempoPartidaField);

        frame.add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPartidas.cadastrarPartidas(jogador1Field.getText(), jogador2Field.getText(), arbitroField.getText(), resultadoField.getText(), tempoPartidaField.getText());
                jogador1Field.setText("");
                jogador2Field.setText("");
                arbitroField.setText("");
                resultadoField.setText("");
                idField.setText("");
                tempoPartidaField.setText("");
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

    public void telaAtualizarPartidas() {
        JFrame frame = new JFrame("Atualizacao de Partidas");
        JTextField jogador1Field;
        JTextField jogador2Field;
        JTextField arbitroField;
        JTextField resultadoField;
        JTextField idField;
        JTextField tempoPartidaField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerPartidas cadastrarPartida;

        atualizarPartidas = new ControllerPartidas();

        frame.setTitle("Atualizar Partida");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6, 2));

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Nome Jogador 1:"));
        jogador1Field = new JTextField();
        inputs.add(jogador1Field);

        inputs.add(new JLabel("Nome Jogador 2:"));
        jogador2Field = new JTextField();
        inputs.add(jogador2Field);

        inputs.add(new JLabel("Nome Arbitro:"));
        arbitroField = new JTextField();
        inputs.add(arbitroField);

        inputs.add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        inputs.add(resultadoField);

        inputs.add(new JLabel("ID Partida:"));
        idField = new JTextField();
        inputs.add(idField);

        inputs.add(new JLabel("Tempo Partida:"));
        tempoPartidaField = new JTextField();
        inputs.add(tempoPartidaField);

        frame.add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPartidas.cadastrarPartidas(jogador1Field.getText(), jogador2Field.getText(), arbitroField.getText(), resultadoField.getText(), tempoPartidaField.getText());
                jogador1Field.setText("");
                jogador2Field.setText("");
                arbitroField.setText("");
                resultadoField.setText("");
                idField.setText("");
                tempoPartidaField.setText("");
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

    public void telaConsultarPartidas() {

        JTextField idField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerPartidas consultarPartidas;

        consultarPartidas = new ControllerPartidas();

        setTitle("Consulta de Partidas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JPanel inputs = new JPanel(new GridLayout(3, 1));
        inputs.add(new JLabel("ID Partida:", SwingConstants.CENTER));
        idField = new JTextField();
        inputs.add(idField);

        add(inputs);

        salvarButton = new JButton("Consultar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarArbitro.consultarArbitro(idField.getText());
                idField.setText("");
                
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

    public void telaExcluirPartidas() {

        JTextField idField;
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
        idField = new JTextField();
        inputs.add(idField);

        add(inputs);

        excluirButton = new JButton("Excluir");
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirPartidas.excluirPartidas(idField.getText());
                idField.setText("");
                
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




        
