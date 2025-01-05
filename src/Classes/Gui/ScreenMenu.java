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

public class ScreenMenu extends JFrame {

    public void telaPrincipal(){
        setTitle("Página Inicial");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(75,75));

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
        JLabel fraseLabel = new JLabel("Bem Vindo ao Xeque & Mate!", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel fraseLabel2 = new JLabel("Gerencie jogadores, árbitros e campeonatos com facilidade. Selecione uma opção para começar!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 14));

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
                ScreenCampeonato screenCampeonato = new ScreenCampeonato();
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
