package Classes.Gui;
import java.awt.BorderLayout;
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
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 400);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new BorderLayout());

    JPanel titlePanel = new JPanel(new GridLayout(2, 1, 5, 5));
    titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

    JLabel tituloLabel = new JLabel("Gerenciar Partidas", SwingConstants.CENTER);
    tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));

    JLabel fraseLabel2 = new JLabel("Gerencie partidas com facilidade. Escolha uma das opções para começar!", SwingConstants.CENTER);
    fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

    titlePanel.add(tituloLabel);
    titlePanel.add(fraseLabel2);

    frame.add(titlePanel, BorderLayout.NORTH);

    JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

    JButton partidasSingularesButton = new JButton("Gerir Partidas Singulares");
    JButton partidasDuplasButton = new JButton("Gerir Partidas Duplas");
    JButton voltarButton = new JButton("Voltar ao Menu Principal");

    partidasSingularesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            telaPartidasSingulares(); // Método a ser implementado
        }
    });

    partidasDuplasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            telaPartidasDuplas(); // Método a ser implementado
        }
    });

    voltarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            telaMenuPrincipal(); // Método a ser implementado
        }
    });

    buttonPanel.add(partidasSingularesButton);
    buttonPanel.add(partidasDuplasButton);
    buttonPanel.add(voltarButton);

    frame.add(buttonPanel, BorderLayout.CENTER);

    frame.setVisible(true);
}

public void telaGerirTorneios() {
    // Configurações básicas da janela
    JFrame frame = new JFrame("Gerir Torneios");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 400);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new BorderLayout());

    // Painel superior para o título e subtítulo
    JPanel titlePanel = new JPanel(new GridLayout(2, 1, 5, 5));
    titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

    JLabel fraseLabel = new JLabel("Gestão de Torneios", SwingConstants.CENTER);
    fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));

    JLabel fraseLabel2 = new JLabel("Gerencie torneios com facilidade. Selecione uma opção para começar!", SwingConstants.CENTER);
    fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

    titlePanel.add(fraseLabel);
    titlePanel.add(fraseLabel2);
    frame.add(titlePanel, BorderLayout.NORTH);

    // Painel de botões
    JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

    // Botões
    JButton torneiosSingularesButton = new JButton("Gerir Torneios Singulares por Pontos");
    JButton torneiosDuplasButton = new JButton("Gerir Torneios Duplas");
    JButton voltarApaginaInicialButton = new JButton("Voltar à Página Inicial");

    // Adiciona os botões ao painel
    buttonPanel.add(torneiosSingularesButton);
    buttonPanel.add(torneiosDuplasButton);
    buttonPanel.add(voltarApaginaInicialButton);

    // Adiciona o painel de botões ao centro da tela
    frame.add(buttonPanel, BorderLayout.CENTER);

    // Ação do botão de voltar
    voltarApaginaInicialButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            telaMenuPrincipal(); // Método a ser implementado
        }
    });

    // Exibe a janela
    frame.setVisible(true);
}
}