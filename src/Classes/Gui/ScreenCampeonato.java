package Classes.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Classes.Controller.ControllerPartidasSingulares;
import Classes.Controller.ControllerRanking;

/**
 * A classe {@code ScreenCampeonato} fornece a interface gráfica para gerenciar
 * campeonatos.
 * <p>
 * Inclui funcionalidades para gerenciar partidas, torneios, rankings e
 * premiações, apresentando telas específicas
 * para cada operação.
 * </p>
 */
public class ScreenCampeonato extends JFrame {
    /** Controlador responsável pelas partidas singulares. */
    private ControllerPartidasSingulares cps;

    /**
     * Construtor da classe {@code ScreenCampeonato}.
     *
     * @param cps o controlador responsável pelas partidas singulares
     */
    public ScreenCampeonato(ControllerPartidasSingulares cps) {

        this.cps = cps;
    }

    /**
     * Exibe o menu principal de gestão de campeonatos.
     */
    public void telaMenuCampeonato() {
        setTitle("Gestão de Campeonatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));
        setLayout(new BorderLayout(75, 75));

        JPanel panel = new JPanel(new GridLayout(8, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Gestão de Campeonatos", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel(
                "O tabuleiro está pronto, e as peças estão posicionadas. Que comece o Campeonato Xeque&Mate!",
                SwingConstants.CENTER);
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
                telaGerirPartida();
            }

        });

        gerirTorneiosButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                telaGerirTorneios();
            }

        });

        visualizarRankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaVisualizarRanking();
            }
        });

        visualizarPremiacoesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                telaVisualizarPremiacoes();

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
     * Exibe a tela para gerenciar partidas.
     */
    public void telaGerirPartida() {
        JFrame frame = new JFrame("Gestão de Partidas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new GridLayout(2, 1, 5, 5));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));

        JLabel tituloLabel = new JLabel("Gestão de Partidas", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel fraseLabel2 = new JLabel("Gerencie partidas com facilidade. Escolha uma das opções para começar!",
                SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        titlePanel.add(tituloLabel);
        titlePanel.add(fraseLabel2);

        frame.add(titlePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        JButton partidasSingularesButton = new JButton("Partidas Singulares");
        JButton partidasDuplasButton = new JButton("Partidas Duplas");
        JButton voltarButton = new JButton("Voltar");

        partidasSingularesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria uma nova instância da tela e chama o método para exibir o menu
                ScreenPartidasSingulares screen = new ScreenPartidasSingulares(cps);
                screen.telaMenuPartidasSingulares();
            }
        });

        partidasDuplasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screen = new ScreenPartidasDuplas();
                screen.telaMenuPartidasDuplas();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(partidasSingularesButton);
        buttonPanel.add(partidasDuplasButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * Exibe a tela para gerenciar torneios.
     */
    public void telaGerirTorneios() {
        JFrame frame = new JFrame("Gerir Torneios");
        frame.setTitle("Gestão de Torneios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6, 1));
        frame.setLayout(new BorderLayout(75, 75));

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        JLabel fraseLabel = new JLabel("Gestão de Torneios", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie torneios com facilidade. Escolha uma das opções para começar!",
                SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel fraseLabel3 = new JLabel("Selecione uma opção para começar a gestão!", SwingConstants.CENTER);
        fraseLabel3.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton torneiosSingularesButton = new JButton("Torneios Singulares");
        JButton torneiosDuplasButton = new JButton("Torneios Duplas");
        JButton voltarButton = new JButton("Voltar");

        torneiosSingularesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ScreenTorneiosSingulares screenTorneios = new ScreenTorneiosSingulares(cps);
                screenTorneios.telaTorneiosSingulares(); // Chama a tela corretamente
            }
        });

        torneiosDuplasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ScreenTorneiosDuplas screenTorneios = new ScreenTorneiosDuplas();
                screenTorneios.telaMenuTorneiosDuplas();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

        buttonPanel.add(fraseLabel);
        buttonPanel.add(fraseLabel2);
        buttonPanel.add(torneiosSingularesButton);
        buttonPanel.add(torneiosDuplasButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    /**
     * Exibe a tela para visualizar premiações.
     */
    public void telaVisualizarPremiacoes() {
        JFrame frame = new JFrame("Visualizar Premiações");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JLabel titleLabel = new JLabel("Premiações", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel subTitleLabel = new JLabel("Confira os prêmios disponíveis para os vencedores!", SwingConstants.CENTER);
        subTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        titlePanel.add(titleLabel);
        titlePanel.add(subTitleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        String[] columnNames = { "Tipo de Partida", "Premiação" };
        String[][] data = {
                { "Partidas Singulares", "30.000 EUR / Viagem / Carro" },
                { "Partidas Duplas", "40.000 EUR por dupla / Viagem / Carro" }
        };

        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(35);
        table.setEnabled(false); // Desativa edição da tabela
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        table.getTableHeader().setBackground(new Color(220, 220, 220));
        table.getTableHeader().setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(voltarButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    /**
     * Exibe a tela para visualizar o ranking.
     */
    public void telaVisualizarRanking() {
        JFrame frame = new JFrame("Visualizar Rankings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 20));

        JLabel tituloLabel = new JLabel("Ranking Atual dos Jogadores", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(tituloLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ControllerRanking controllerRanking = new ControllerRanking();
        String[][] dados = controllerRanking.lerDadosDoArquivo("ranking.txt");

        String[] colunas = { "Ranking", "Nome", "Pontos" };

        JTable tabela = new JTable(dados, colunas);
        tabela.setFillsViewportHeight(true);
        tabela.setEnabled(false);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabela.setFont(new Font("Arial", Font.PLAIN, 12));
        tabela.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(tabela);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(centerPanel, BorderLayout.CENTER);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(voltarButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}