import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import view.Agenda;

public class Main {

    public static void main(String[] args) {
        //uso do Flatlaf
        //FlatLightLaf.setup();
        FlatDarkLaf.setup();

        Agenda janelaPrincipal = new Agenda();
        janelaPrincipal.setVisible(true);
    }
}
