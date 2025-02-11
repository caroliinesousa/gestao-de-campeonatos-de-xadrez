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
import javax.swing.SwingConstants;

import Classes.Controller.ControllerPartidasSingulares;

/**
 * A classe {@code ScreenMenu} representa a tela principal do sistema "Xeque &
 * Mate".
 * <p>
 * Esta interface gráfica permite navegar para as seções de gestão de jogadores,
 * árbitros,
 * campeonatos e sair da aplicação.
 * </p>
 */
public class ScreenMenu extends JFrame {
    /** Controlador responsável pelas partidas singulares. */
    private ControllerPartidasSingulares cps;

    /**
     * Construtor da classe {@code ScreenMenu}.
     *
     * @param cps o controlador responsável pelas partidas singulares
     */
    public ScreenMenu(ControllerPartidasSingulares cps) {
        this.cps = cps;
    }

    /**
     * Exibe a tela principal com opções de navegação.
     */
    public void telaPrincipal() {
        setTitle("Página Inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(75, 75));

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        JLabel fraseLabel = new JLabel("Bem Vindo ao Xeque & Mate!", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel(
                "Gerencie jogadores, árbitros e campeonatos de forma simples e eficiente. Selecione uma opção para começar!",
                SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton gerirJogadoresButton = new JButton("Gerir Jogadores");
        JButton gerirArbitrosButton = new JButton("Gerir Árbitros");
        JButton gerirCampeonatoButton = new JButton("Gerir Campeonato");
        JButton sairButton = new JButton("Sair");

        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(gerirJogadoresButton);
        panel.add(gerirArbitrosButton);
        panel.add(gerirCampeonatoButton);
        panel.add(sairButton);

        add(panel);
        setVisible(true);

        gerirJogadoresButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenJogador screenJogador = new ScreenJogador();
                screenJogador.telaMenuJogador();
            }

        });

        gerirArbitrosButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenArbitro screenArbitro = new ScreenArbitro();
                screenArbitro.telaMenuArbitro();
            }

        });

        gerirCampeonatoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenCampeonato screenCampeonato = new ScreenCampeonato(cps);
                screenCampeonato.telaMenuCampeonato();
            }

        });

        sairButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

    }

}
