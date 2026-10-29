package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class Sobre extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JPanel pnlBody;
    private JLabel lblGithub;

    public Sobre() {

        setSize(380, 230);

        //comportamento ao fechar
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //titulo
        setTitle("Sobre");


        //icone de janela
        ImageIcon icone = new ImageIcon(getClass().getResource("/icons/sobre.png"));
        setIconImage(icone.getImage());

        //evitar redimensionamento
        setResizable(false);
        //iniciar centralizado
        setLocationRelativeTo(null);

        setContentPane(contentPane); //painel principal
        setModal(true);//impede abertura de varias paginas
        getRootPane().setDefaultButton(buttonOK);

        //maozinha
        lblGithub.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));

        //evento do botao OK
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        //evento do link do github
        lblGithub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                acessarGithub("https://github.com/SwiftOneLy");
            }
        });
    }//fim do construtor

    //metodo para fechar a janela
    private void onOK() {
        // dispose fecha apenas essa janela
        dispose();
    }

    //metodo para abrir um link no navegador padrão do desktop cliente
    private void acessarGithub(String url){
        // a linha abaixo obtem o sistema operacional do cliente
        Desktop desktop = Desktop.getDesktop();
        try {
            //criação de um objeto para acessar os métodos necessários para estabelecer uma conexão com a internet abrindo o link no navegador padrão do usuário
            URI uri = new URI(url);
            desktop.browse(uri);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}//fim da classe sobre
