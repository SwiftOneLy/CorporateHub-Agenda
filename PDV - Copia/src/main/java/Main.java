import view.FormPrincipal;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args) {
        FormPrincipal formPrincipal = new FormPrincipal();
        formPrincipal.setVisible(true);

        FlatLightLaf.setup();

        FormPrincipal desk = new FormPrincipal();
        desk.setVisible(true);

    }


}
                                        