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

    public void telaGerirPartidas() {
        setTitle("Gestão de Partidas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10)); // Espaçamento entre os componentes

        // Painel para o título e subtítulo
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        JLabel fraseLabel = new JLabel("Gestão de Partidas", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Partidas com facilidade!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        titlePanel.add(fraseLabel);
        titlePanel.add(fraseLabel2);

        // Painel para os botões
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // 3 linhas, 10px de espaço vertical
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        JButton PartidasSingularesButton = new JButton("Partidas Singulares");
        JButton PartidasDuplasButton = new JButton("Partidas Duplas");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");

        buttonPanel.add(PartidasSingularesButton);
        buttonPanel.add(PartidasDuplasButton);
        buttonPanel.add(voltarApaginaInicialButton);

        // Adiciona os painéis ao JFrame
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);

        // Ações dos botões
        PartidasSingularesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasSingulares screenPartidasSingulares = new ScreenPartidasSingulares();
                screenPartidasSingulares.telaMenuPartidasSingulares();
            }
        });

        PartidasDuplasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenPartidasDuplas screenPartidasDuplas = new ScreenPartidasDuplas();
                screenPartidasDuplas.telaMenuPartidasDuplas();
            }
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
            }
        });
    }
}
