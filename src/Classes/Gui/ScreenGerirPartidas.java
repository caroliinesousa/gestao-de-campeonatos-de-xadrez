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
    
    public void telaGerirPartida() {
        JFrame frame = new JFrame("Gerir Partidas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
    
        // Título
        JLabel tituloLabel = new JLabel("Gerenciar Partidas", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);
    
        // Painel de botões
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
    
        // Botões
        JButton partidasSingularesButton = new JButton("Gerir Partidas Singulares");
        JButton partidasDuplasButton = new JButton("Gerir Partidas Duplas");
        JButton voltarButton = new JButton("Voltar ao Menu Principal");
    
        // Adiciona os botões ao painel
        buttonPanel.add(partidasSingularesButton);
        buttonPanel.add(partidasDuplasButton);
        buttonPanel.add(voltarButton);
    
        frame.add(buttonPanel, BorderLayout.CENTER);
    
        // Ações dos botões
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
                telaMenuGerenciamento(); // Retorna ao menu de gerenciamento
            }
        });
    
        frame.setVisible(true);
    }
}    