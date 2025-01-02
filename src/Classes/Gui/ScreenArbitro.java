package Classes.Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.Controller.ControllerArbitro;

public class ScreenArbitro extends JFrame {

    public ScreenArbitro() {

    }
    public void telaMenuArbitro(){

        setTitle("Gerir Arbitros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        JPanel panel = new JPanel(new GridLayout(6, 1));
        JLabel fraseLabel = new JLabel("Bem Vindo ao Campeonato X");
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
    

    }
    public void telaCadastrarArbitro() {
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JButton salvarButton;
        ControllerArbitro cadastrarArbitro;

        cadastrarArbitro = new ControllerArbitro();

        setTitle("Cadastro de arbitro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JPanel inputs = new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome arbitro:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        inputs.add(new JLabel("Idade arbitro:"));
        idadeField = new JTextField();
        inputs.add(idadeField);

        inputs.add(new JLabel("Gênero arbitro:"));
        sexoField = new JTextField();
        inputs.add(sexoField);

        add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarArbitro.cadastrarArbitro(nomeField.getText(), idadeField.getText(), sexoField.getText(),
                ScreenArbitro.this);
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
            }
        });
        add(salvarButton);
    

    }

    public void telaAtualizarArbitro() {
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField certificacoesField;
        JButton salvarButton;
        ControllerArbitro cadastrarArbitro;

        ControllerArbitro atualizarArbitro = new ControllerArbitro();

        setTitle("Atualizar arbitro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JPanel inputs = new JPanel(new GridLayout(4, 3));
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
        inputs.add(sexoField);


        add(inputs);

        salvarButton = new JButton("Atualizar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarArbitro.atualizarArbitro(nomeField.getText(), idadeField.getText(), sexoField.getText(), certificacoesField.getText());
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
            }
        });
        add(salvarButton);

    }

    public void telaConsultarArbitro() {

        JTextField nomeField;
        JButton salvarButton;
        ControllerArbitro consultarArbitro;

        consultarArbitro = new ControllerArbitro();

        setTitle("Consulta de arbitro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JPanel inputs = new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome arbitro:"));
        nomeField = new JTextField();
        inputs.add(nomeField);

        add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarArbitro.consultarArbitro(nomeField.getText());
                nomeField.setText("");
                
            }
        });
        add(salvarButton);

    }

    public void telaExcluirArbitro() {

        JTextField nomeField;
        JButton salvarButton;
        ControllerArbitro consultarArbitro;
        ControllerArbitro excluirArbitro = new ControllerArbitro();

        setTitle("Excluir arbitro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JPanel inputs = new JPanel(new GridLayout(3, 3));
        inputs.add(new JLabel("Nome arbitro:"));
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

    }

    }

