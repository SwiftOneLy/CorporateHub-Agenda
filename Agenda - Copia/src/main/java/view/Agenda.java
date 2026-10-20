package view;

import javax.swing.*;

public class Agenda extends JFrame {
    private JPanel pnlMain;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton buscarButton;
    private JTextField textField3;
    private JButton whatsappButton;
    private JButton adicionarButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JButton relatorioButton;
    private JButton limparButton;

    //construtor
    public Agenda(){
        setSize(500,340);//tamanho da janela em pixels
        //comportamento da janela ao fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //iniciar a janela no centro
        setLocationRelativeTo(null);

        //incluir o formulario
        setContentPane(pnlMain);
    }//fim do construtor

}//fim da classe agenda

