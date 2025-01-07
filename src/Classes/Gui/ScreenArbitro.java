package Classes.Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Classes.Controller.ControllerArbitro;

public class ScreenArbitro extends JFrame {

    public ScreenArbitro() {

    }
    public void telaMenuArbitro(){

        setTitle("Gestão de Árbitros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));
        setLayout(new BorderLayout(75,75));

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(40,100,40,100));
        JLabel fraseLabel = new JLabel("Gestão de Árbitros", SwingConstants.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JLabel fraseLabel2 = new JLabel("Gerencie os Árbitros com facilidade. Escolha uma das opções para começar!", SwingConstants.CENTER);
        fraseLabel2.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton cadastrarArbitroButton = new JButton("Cadastrar Árbitro");
        JButton consultarArbitroButton = new JButton("Consultar Árbitro");
        JButton atualizarArbitroButton = new JButton("Atualizar Árbitro");
        JButton excluirArbitroButton = new JButton("Excluir Árbitro");
        JButton voltarApaginaInicialButton = new JButton("Voltar a Página Inicial");


        panel.add(fraseLabel);
        panel.add(fraseLabel2);
        panel.add(cadastrarArbitroButton);
        panel.add(consultarArbitroButton);
        panel.add(atualizarArbitroButton);
        panel.add(excluirArbitroButton);
        panel.add(voltarApaginaInicialButton);

        add(panel);
        setVisible(true);

        cadastrarArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarArbitro();
            }
        });

        atualizarArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenArbitro screenArbitro = new ScreenArbitro();
                screenArbitro.telaAtualizarArbitro();
            }
        });

        consultarArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenArbitro screenArbitro = new ScreenArbitro();
                screenArbitro.telaConsultarArbitro();
            }
        });

        excluirArbitroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenArbitro screenArbitro = new ScreenArbitro();
                screenArbitro.telaExcluirArbitro();
            }
        });

        voltarApaginaInicialButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
    

    }

    public void telaCadastrarArbitro() {
        JFrame frame = new JFrame("Cadastro de Árbitro");
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField certificacoesField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerArbitro cadastrarArbitro = new ControllerArbitro();
    
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);  
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
    
        // Painel de inputs centralizado
        JPanel inputs = new JPanel(new GridLayout(4, 2, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        inputs.add(new JLabel("Nome Árbitro:"));
        nomeField = new JTextField();
        inputs.add(nomeField);
    
        inputs.add(new JLabel("Idade Árbitro:"));
        idadeField = new JTextField();
        inputs.add(idadeField);
    
        inputs.add(new JLabel("Gênero Árbitro:"));
        sexoField = new JTextField();
        inputs.add(sexoField);
    
        inputs.add(new JLabel("Certificações:"));
        certificacoesField = new JTextField();
        inputs.add(certificacoesField);
    
        frame.add(inputs, BorderLayout.CENTER);
    
        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    
        salvarButton = new JButton("Salvar");
        salvarButton.setPreferredSize(new Dimension(120, 40));
        salvarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarArbitro.cadastrarArbitro(
                    nomeField.getText(),
                    idadeField.getText(),
                    sexoField.getText(),
                    certificacoesField.getText()
                );
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
                certificacoesField.setText("");
            }
        });
    
        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                telaMenuArbitro();
            }
        });
    
        buttonPanel.add(salvarButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    public void telaConsultarArbitro() {
        JFrame frame = new JFrame("Consulta de Árbitro");
        JTextField nomeField;
        JButton consultarButton;
        JButton voltarButton;
        JButton cadastrarButton = new JButton("Cadastrar Árbitro");
        JLabel statusLabel;
    
        ControllerArbitro consultarArbitro = new ControllerArbitro();
    
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
    
        JPanel inputsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        JLabel nomeLabel = new JLabel("Nome do Arbitro:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputsPanel.add(nomeLabel, gbc);
    
        nomeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputsPanel.add(nomeField, gbc);
    
        frame.add(inputsPanel, BorderLayout.CENTER);
    
        statusLabel = new JLabel(" ", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(statusLabel, BorderLayout.NORTH);
    
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    
        consultarButton = new JButton("Consultar");
        consultarButton.setPreferredSize(new Dimension(120, 40));
        consultarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeArbitro = nomeField.getText();
                boolean encontrado = consultarArbitro.consultarArbitro(nomeArbitro, cadastrarButton);
                if (encontrado) {
                    statusLabel.setText("Arbitro encontrado: " + nomeArbitro);
                    statusLabel.setForeground(Color.GREEN);
                } else {
                    JOptionPane.showMessageDialog(frame, "Árbitro não encontrado. Você pode cadastrá-lo agora.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    statusLabel.setText("Árbitro não encontrado.");
                    statusLabel.setForeground(Color.RED);
                }
                nomeField.setText("");
            }
        });
    
        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    
        cadastrarButton.setPreferredSize(new Dimension(150, 40));
        cadastrarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        cadastrarButton.setVisible(false);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                telaCadastrarArbitro();
            }
        });
    
        buttonPanel.add(consultarButton);
        buttonPanel.add(voltarButton);
        buttonPanel.add(cadastrarButton);
    
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }    

    public void telaAtualizarArbitro() {
        JTextField nomeField;
        JTextField idadeField;
        JTextField sexoField;
        JTextField certificacoesField;
        JButton salvarButton;
        JButton voltarButton;
        ControllerArbitro atualizarArbitro = new ControllerArbitro();
    
        setTitle("Atualizar Árbitro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    
        JPanel inputsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        inputsPanel.add(new JLabel("Nome Árbitro:"));
        nomeField = new JTextField();
        inputsPanel.add(nomeField);
    
        inputsPanel.add(new JLabel("Idade Árbitro:"));
        idadeField = new JTextField();
        inputsPanel.add(idadeField);
    
        inputsPanel.add(new JLabel("Gênero Árbitro:"));
        sexoField = new JTextField();
        inputsPanel.add(sexoField);
    
        inputsPanel.add(new JLabel("Certificações:"));
        certificacoesField = new JTextField();
        inputsPanel.add(certificacoesField);
    
        add(inputsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    
        salvarButton = new JButton("Atualizar");
        salvarButton.setPreferredSize(new Dimension(120, 40));
        salvarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarArbitro.atualizarArbitro(
                    nomeField.getText(),
                    idadeField.getText(),
                    sexoField.getText(),
                    certificacoesField.getText()
                );
                nomeField.setText("");
                idadeField.setText("");
                sexoField.setText("");
                certificacoesField.setText("");
            }
        });
    
        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    
        buttonPanel.add(salvarButton);
        buttonPanel.add(voltarButton);
    
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    

    public void telaExcluirArbitro() {
        JFrame frame = new JFrame("Excluir Árbitro");
        JTextField nomeField;
        JButton excluirButton;
        JButton voltarButton;
        ControllerArbitro excluirArbitro = new ControllerArbitro();
    
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 250);  
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
    
        JPanel inputs = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputs.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
    
        JLabel nomeLabel = new JLabel("Nome Árbitro:");
        nomeLabel.setPreferredSize(new Dimension(100, 30));  
        inputs.add(nomeLabel);
    
        nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(200, 30));  
        inputs.add(nomeField);
    
        frame.add(inputs, BorderLayout.CENTER);
    
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    
        excluirButton = new JButton("Excluir");
        excluirButton.setPreferredSize(new Dimension(120, 40));
        excluirButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirArbitro.excluirArbitro(nomeField.getText());
                nomeField.setText("");
            }
        });
    
        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 40));
        voltarButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    
        buttonPanel.add(excluirButton);
        buttonPanel.add(voltarButton);
    
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

