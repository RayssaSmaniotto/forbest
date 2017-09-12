package database;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author(name= Ruan Pasta , date=19/07/2017)
 */
public class Limpeza {

    public static void truncateTabelas() {
        try {
            Statement st = Conexao.conectar().createStatement();
            st.addBatch("SET FOREIGN_KEY_CHECKS = 0");
            st.addBatch("TRUNCATE TABLE usuarios;");
            st.addBatch("TRUNCATE TABLE tags;");
            st.addBatch("TRUNCATE TABLE amigos;");
            st.addBatch("TRUNCATE TABLE posts;");
            st.addBatch("TRUNCATE TABLE doacoes;");
            st.addBatch("TRUNCATE TABLE posts_tarefas;");
            st.addBatch("TRUNCATE TABLE posts_tags;");
            st.addBatch("TRUNCATE TABLE posts_imagens;");
            st.addBatch("TRUNCATE TABLE posts_videos;");
            st.addBatch("TRUNCATE TABLE prestacao_contas;");
            st.addBatch("SET FOREIGN_KEY_CHECKS = 1");
            st.executeBatch();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());

        } finally {
            Conexao.desconectar();
        }
    }
}
