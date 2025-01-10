package Classes.Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import Classes.Controller.ControllerPartidasSingulares;

public class ScreenPartidasSingulares extends JFrame {

    public ScreenPartidasSingulares() {
    }
    public void telaMenuPartidasSingulares() {
        setTitle("Gestão de Partidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Gestão de Partidas", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie as Partidas com facilidade. Escolha uma das opções para começar!", SwingConstants.CENTER);
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

        cadastrarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasSingulares.telaCadastrarPartidasSingulares();
            }
        });

        atualizarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasSingulares screenPartida = new ScreenPartidasSingulares();
                ScreenPartidasSingulares.telaAtualizarPartidasSingulares();
            }
        });

        consultarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidapublic void telaGerirTorneios(){
            JFrame frame = new JFrame("Gerir Torneios");
            JButton torneiosSingularesField;
            JButton torneiosDuplasField;
            JButton salvarButton;
            JButton sairButton;
            ControllerCampeonato gerirTorneios;
    
            gerirTorneios = new ControllerCampeonato();
    
            setTitle("Gestão de Campeonatos");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(800, 400);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(5, 1));
            setLayout(new BorderLayout(75,75));
    
            JPanel panel = new JPanel(new GridLayout(8, 1));
            panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
            JLabel fraseLabel = new JLabel("Gestão de Torneios", SwingConstants.CENTER);
            fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
            JLabel fraseLabel2 = new JLabel("Gerencie torneios com facilidade. Escolha uma das opções para começar!", SwingConstants.CENTER);
            fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel fraseLabel3 = new JLabel("Selecione uma opção para começar a gestão!", SwingConstants.CENTER);
            fraseLabel3.setFont(new Font("Arial", Font.PLAIN, 12));
    
            JButton torneiosSingularesButton = new JButton("Gerir Torneios Singulares por pontos");
            JButton torneiosDuplasButton = new JButton("Gerir Torneios Duplas");
            JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

            panel.add(fraseLabel);
            panel.add(fraseLabel2);
            panel.add(torneiosSingularesButton);
            panel.add(torneiosDuplasButton);
            panel.add(voltarApaginaInicialButton);
    
            add(panel);
            setVisible(true); screenPartida = new ScreenPartida();
                screenPartida.telaConsultarPartida();
            }
        });

        excluirPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartida screenPartida = new ScreenPartida();
                screenPartida.telaExcluirPartida();
            }
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {
