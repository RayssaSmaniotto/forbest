package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @author Rayssa Smaniotto 23/08/2017)
 */
public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost/for_best?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static Connection conexao;
    public static Properties properties;

    public static Connection conectar() {
        try {
            properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", SENHA);

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(HOST, properties);
            return conexao;

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public static void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}