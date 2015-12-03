package presentacion;
import javax.swing.UIManager;

public class Inicio{
   
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new FrmInicioSesion().setVisible(true);
    }
    
}
