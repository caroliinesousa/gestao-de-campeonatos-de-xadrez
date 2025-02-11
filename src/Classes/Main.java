package Classes;
import Classes.Controller.ControllerPartidasSingulares;
import Classes.Gui.*;
import javax.swing.UIManager;

/**
 * Classe principal para inicializar o sistema.
 * <p>
 * Esta classe configura o visual do sistema para o estilo Windows, inicializa o controlador
 * de partidas singulares e exibe o menu principal do sistema.
 * </p>
 */

public class Main {

    /**
     * Método principal para executar o programa.
     *
     * @param args os argumentos de linha de comando (não utilizados neste programa)
     */

    public static void main(String[] args) {
        try {
            // Configura o visual do sistema para o estilo Windows, se disponível.
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Trata possíveis exceções relacionadas à configuração do visual.
            e.printStackTrace();
        }
         // Inicializa o controlador de partidas singulares.
        ControllerPartidasSingulares cps = new ControllerPartidasSingulares();
        // Inicializa e exibe o menu principal do sistema.
        ScreenMenu sm = new ScreenMenu(cps);
        sm.telaPrincipal();
    }
}
