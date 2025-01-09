package Classes.Gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Classes.Controller.ControllerArbitro;
import Classes.Controller.ControllerCampeonato;

public class ScreenCampeonato extends JFrame {


    public void telaMenuCampeonato(){
        setTitle("Gestão de Campeonatos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));
        setLayout(new BorderLayout(75,75));

        JPanel panel = new JPanel(new GridLayout(8, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
        JLabel fraseLabel = new JLabel("Gestão de Campeonatos", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("O tabuleiro está pronto, e as peças estão posicionadas. Que comece o Campeonato Xeque&Mate!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel fraseLabel3 = new JLabel("Selecione uma opção para começar a gestão!", SwingConstants.CENTER);
        fraseLabel3.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton gerirPartidasButton = new JButton("Gerir Partidas");
        JButton gerirTorneiosButton = new JButton("Gerir Torneios");
        JButton visualizarRankingButton = new JButton("Visualizar Ranking");
        JButton visualizarPremiacoesButton = new JButton("Visualizar Premiações");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(fraseLabel3);
        panel.add(gerirPartidasButton);
        panel.add(gerirTorneiosButton);
        panel.add(visualizarRankingButton);
        panel.add(visualizarPremiacoesButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        gerirPartidasButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenCampeonato screenCampeonato = new ScreenCampeonato();
                screenCampeonato.telaGerirPartida();
            }
            
        });

        gerirTorneiosButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenCampeonato screenCampeonato = new ScreenCampeonato();
                screenCampeonato.telaMenuTorneios();
            }
            
        });

        visualizarRankingButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenCampeonato screenCampeonato = new ScreenCampeonato();
                screenCampeonato.telaVisualizarRanking();
            }
            
        });

        visualizarPremiacoesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenCampeonato screenCampeonato = new ScreenCampeonato();
                screenCampeonato.telaVisualizarPremiacoes();
                
            }
            
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
}

public void telaGerirPartida() {
    JFrame frame = new JFrame("Gerir Partidas");
    JButton partidasSingularesButton;
    JButton partidasDuplasButton;
    JButton voltarButton;

    // Configuração da janela
    frame.setTitle("Gerir Partidas");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(600, 300);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new BorderLayout());

    // Adicionando título
    JLabel tituloLabel = new JLabel("Selecione uma opção para gerir as partidas", SwingConstants.CENTER);
    tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
    frame.add(tituloLabel, BorderLayout.NORTH);

    // Painel de botões
    JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 10));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

    // Botão Gerir Partidas Singulares
    partidasSingularesButton = new JButton("Gerir Partidas Singulares");
    partidasSingularesButton.setPreferredSize(new Dimension(150, 40));
    partidasSingularesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            telaPartidasSingulares(); // Método que será implementado
        }
    });
    buttonPanel.add(partidasSingularesButton);

    // Botão Gerir Partidas Duplas
    partidasDuplasButton = new JButton("Gerir Partidas Duplas");
    partidasDuplasButton.setPreferredSize(new Dimension(150, 40));
    partidasDuplasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            telaPartidasDuplas(); // Método que será implementado
        }
    });
    buttonPanel.add(partidasDuplasButton);

    // Botão Voltar
    voltarButton = new JButton("Voltar");
    voltarButton.setPreferredSize(new Dimension(150, 40));
    voltarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            telaMenuPrincipal(); // Método que volta ao menu principal
        }
    });
    buttonPanel.add(voltarButton);

    // Adiciona o painel de botões na parte central
    frame.add(buttonPanel, BorderLayout.CENTER);
    frame.setVisible(true);
}
