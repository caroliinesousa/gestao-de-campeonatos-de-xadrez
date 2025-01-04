package Classes.Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;

import javax.swing.*;

import Classes.Controller.ControllerArbitro;

public class ScreenArbitro extends JFrame {

    public ScreenArbitro() {

    }
    public void telaMenuArbitro(){

        setTitle("Gestao de Arbitros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));
        setLayout(new BorderLayout(75,75));

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
        JLabel fraseLabel = new JLabel("Bem Vindo ao Campeonato X", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JButton cadastrarArbitroButton = new JButton("Cadastrar Arbitro");
        JButton consultarArbitroButton = new JButton("Consultar Arbitro");
        JButton atualizarArbitroButton = new JButton("Atualizar Arbitro");
        JButton excluirArbitroButton = new JButton("Excluir Arbitro");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");


        panel.add(fraseLabel);
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
                System.exit(0);
            }
            
        });
    

    }
    public void telaCadastrarArbitro() {
        JFrame frame = new JFrame("Cadastro de Arbitro");
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField certificacoesField;
        JButton salvarButton;
        ControllerArbitro cadastrarArbitro;

        cadastrarArbitro = new ControllerArbitro();

        frame.setTitle("Cadastro de arbitro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 2));

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Nome arbitro:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        inputs.add(new JLabel("Idade arbitro:"));
        idadeField = new JTextField();
        inputs.add(idadeField);

        inputs.add(new JLabel("Gênero arbitro:"));
        sexoField = new JTextField();
        inputs.add(sexoField);

        inputs.add(new JLabel("Certificacoes:"));
        certificacoesField = new JTextField();
        inputs.add(certificacoesField);

        frame.add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarArbitro.cadastrarArbitro(nomeField.getText(), idadeField.getText(), sexoField.getText(), certificacoesField.getText());
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
                certificacoesField.setText("");
            }
        });
        frame.add(salvarButton);
        frame.setVisible(true);

    }

    public void telaAtualizarArbitro() {
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField certificacoesField;
        JButton salvarButton;
        ControllerArbitro atualizarArbitro;

        atualizarArbitro = new ControllerArbitro();

        setTitle("Atualizar arbitro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Nome arbitro:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        inputs.add(new JLabel("Idade arbitro:"));
        idadeField = new JTextField();
        inputs.add(idadeField);

        inputs.add(new JLabel("Gênero arbitro:"));
        sexoField = new JTextField();
        inputs.add(sexoField);

        inputs.add(new JLabel("Certificacoes:"));
        certificacoesField = new JTextField();
        inputs.add(certificacoesField);


        add(inputs);
        
        salvarButton = new JButton("Atualizar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarArbitro.atualizarArbitro(nomeField.getText(), idadeField.getText(), sexoField.getText(), certificacoesField.getText());
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
                certificacoesField.setText("");
            }
        });
        add(salvarButton);
        setVisible(true);

    }

    public void telaConsultarArbitro() {

        JTextField nomeField;
        JButton salvarButton;
        ControllerArbitro consultarArbitro;

        consultarArbitro = new ControllerArbitro();

        setTitle("Consulta de arbitro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JPanel inputs = new JPanel(new GridLayout(3, 1));
        inputs.add(new JLabel("Nome arbitro:", SwingConstants.CENTER));
        nomeField = new JTextField();
        inputs.add(nomeField);

        add(inputs);

        salvarButton = new JButton("Consultar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarArbitro.consultarArbitro(nomeField.getText());
                nomeField.setText("");
                
            }
        });
        add(salvarButton);
        setVisible(true);

    }

    public void telaExcluirArbitro() {

        JTextField nomeField;
        JButton salvarButton;
        ControllerArbitro excluirArbitro;
        excluirArbitro = new ControllerArbitro();

        setTitle("Excluir arbitro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JPanel inputs = new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome arbitro:" , SwingConstants.CENTER));
        nomeField = new JTextField();
        inputs.add(nomeField);

        add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirArbitro.excluirArbitro(nomeField.getText());
                nomeField.setText("");
                
            }
        });
        add(salvarButton);
        setVisible(true);
    }

    public void telaVoltarAoMenu() {
        JButton voltarApaginaInicialButton;
        
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    
        voltarApaginaInicialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose(); 
                screenArbitro.setVisible(true);
                screenArbitro.toFront();
            }
        });
    }

}

