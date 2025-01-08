package Classes;
import javax.swing.UIManager;
import Classes.Gui.*;

public class Main {
    public static void main(String[] args) {
        //new ScreenJogador().setVisible(true);
        //new ScreenArbitro().setVisible(true);
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ScreenMenu().telaPrincipal();
        
    }
}
