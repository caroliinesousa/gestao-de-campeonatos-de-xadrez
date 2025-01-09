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

public class ScreenGerirPartidas extends JFrame {


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
        JLabel fraseLabel2 = new JLabel("Gerencie os Partidas com facilidade!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton PartidasSingularesButton = new JButton("Partidas Singulares");
        JButton PartidasDuplasButton = new JButton("Partidas Duplas");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(PartidasSingularesButton);
        panel.add(PartidasDuplasButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        gerirPartidasSingularesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenGerirPartidasSingulares screenGerirPartidasSingulares = new ScreenGerirPartidasSingulares();
                ScreenGerirPartidasSingulares.telaMenuGerirPartidasSingulares();
            }
            
        });

        gerirPartidasDuplasButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenGerirPartidasDuplas screenGerirPartidasDuplas = new ScreenGerirPartidasDuplas();
                ScreenGerirPartidasDuplas.telaMenuGerirPartidasDuplas();
            }
            
        });

         voltarApaginaInicialButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });