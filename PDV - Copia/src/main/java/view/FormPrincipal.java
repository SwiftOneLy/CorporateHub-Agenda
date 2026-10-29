package view;

import connection.ConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FormPrincipal extends JFrame {
    private JPanel pnlPrincipal;
    private JButton sairButton;
    private JButton vendasButton;
    private JButton caixaButton;
    private JButton produtosButton;
    private JButton fornecedoresButton;
    private JLabel lblBanco;
    private JLabel lblDatabase;
    private JLabel lblData;
    private JButton lblSobre;
    private JLabel lblCor;


    public FormPrincipal() {
        // 1. Associa o painel do .form à janela
        setContentPane(pnlPrincipal);

        // 2. Define o encerramento da aplicação ao fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Define o tamanho da janela (para exibir a dashboard inteira)
        setSize(1100, 650);

        // 4. Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Usa LocalDateTime per ottenere sia la data che l'ora corrente
        LocalDateTime actualDateTime = LocalDateTime.now();

// Definisci il formato desiderato (ad esempio: 22/10/2026 21:56:00)
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        lblSobre.addActionListener(e -> sobre());


// Imposta il testo nel JLabel
        lblData.setText(actualDateTime.format(formattedDate));

        verificarConexao();



        //titulo
        setTitle("Shinra LTDA");


        //icone de janela
        ImageIcon icone = new ImageIcon(getClass().getResource("/icons/s.png"));
        setIconImage(icone.getImage());






    }//fim do construtor

    //testar a conexao
    private void verificarConexao(){
        //criar o objeto para acessar o metodo testarConexao
        ConnectionFactory conexao = new ConnectionFactory();
        //se retorno for verdadeiro, sucesso


        if(conexao.testarConexao()){
            lblBanco.setText("Banco Conectado");
            lblDatabase.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/dbon.png"))));
            lblCor.setForeground(Color.green);

        }else{
            lblBanco.setText("Banco desconectado");
            lblDatabase.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/dboff.png"))));
        }
    }
    //abrir a tela sobre
    private void sobre(){
        Sobre sobre = new Sobre(); //criar objeto
        sobre.setVisible(true);//abrir a janela sobre

    }

    public static ImageIcon redToGreen(ImageIcon icone) {
        BufferedImage imagem = new BufferedImage(
                icone.getIconWidth(),
                icone.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g = imagem.createGraphics();
        g.drawImage(icone.getImage(), 0, 0, null);
        g.dispose();

        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                Color pixel = new Color(imagem.getRGB(x, y), true);

                int vermelho = pixel.getRed();
                int g_val = pixel.getGreen(); // renomeado para evitar conflito com 'verde'
                int b = pixel.getBlue();

                // Identifica pixels predominantemente vermelhos
                if (vermelho > g_val && vermelho > b) {
                    imagem.setRGB(x, y, new Color(
                            0,               // vermelho (zerado)
                            220,             // verde (aumentado)
                            0,               // azul
                            pixel.getAlpha() // mantém a transparência original
                    ).getRGB());
                }
            }
        }

        return new ImageIcon(imagem);
    }
}

