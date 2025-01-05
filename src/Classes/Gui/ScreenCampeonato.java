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
import Classes.Controller.ControllerPartida;


public class ScreenCampeonato extends JFrame {


    public void telaMenuCampeonato(){
        setTitle("Gestão de Campeonatos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));
        setLayout(new BorderLayout(75,75));

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
        JLabel fraseLabel = new JLabel("Gestão de Campeonatos", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JButton gerirPartidasButton = new JButton("Gerir Partidas");
        JButton gerirTorneiosButton = new JButton("Gerir Campeonato");
        JButton visualizarRankingButton = new JButton("Visualizar Ranking");
        JButton visualizarPremiacoesButton = new JButton("Visualizar Premiações");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        panel.add(fraseLabel);
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
                screenCampeonato.telaMenuCampeonato();
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

    public void telaGerirPartida(){
        JFrame frame = new JFrame("Gerir Partidas");
        JTextField partidasSingularesField;
        JTextField partidasDuplasField;
        JButton salvarButton;
        JButton sairButton;
        ControllerCampeonato gerirPartidas;

        gerirPartidas = new ControllerPartida();

        frame.setTitle("Gerir Partidas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 2));

        JPanel inputs = new JPanel(new GridLayout(5, 2));
        inputs.add(new JLabel("Partidas Singulares:"));
        partidasSingularesField = new JTextField();
        inputs.add(partidasSingularesField);

        inputs.add(new JLabel("Partidas Duplas:"));
        partidasDuplasField = new JTextField();
        inputs.add(partidasDuplasField);
        
        frame.add(inputs);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarArbitro.cadastrarArbitro(partidasSingularesField.getText(), partidasDuplasField.getText());
                partidasSingularesField.setText("");
                partidasDuplasField.setText("");
            }
        });
        frame.add(salvarButton);
        frame.setVisible(true);


    }
   
}
