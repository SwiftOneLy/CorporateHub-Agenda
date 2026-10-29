package connection;

//importações relacionadas ao arquivo db.properties
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
//importações relacionadas a conexão com o banco
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {

    //metodo responsavel por conectar o banco
    public Connection conectar() throws SQLException {

        //Atenção! Além de tratar exceções o try encerra automaticamente as conexões com o banco após operações

        Properties propriedades = new Properties();

        //Criar na pasta raiz do usuário um diretório Agenda e dentro outro diretório config
        //Dentro de config criar um arquivo puro de nom db.properties
        //db.url=JDBC:mysql://localhost:3306/agenda
        //db.user=root
        //db.password=
        //É possível criar esta estrutura de pastas e arquivo na distribuição (pesquisar)

        Path arquivo = Path.of(
                System.getProperty("user.home"),
                "Shinra", "config", "db.properties"
        );

        //le o arquivo db.properties
        try (FileInputStream entrada = new FileInputStream(arquivo.toFile())) {
            propriedades.load(entrada);
        } catch (IOException e) {
            throw new SQLException("Erro ao ler db.properties.", e);
        }

        return DriverManager.getConnection(
                propriedades.getProperty("db.url"),
                propriedades.getProperty("db.user"),
                propriedades.getProperty("db.password")
        );
    }

    public boolean testarConexao() {
        try (Connection conexao = conectar()) {
            return conexao.isValid(3);//limite de tempo para verificar a conexão
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
