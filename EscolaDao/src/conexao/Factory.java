package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String USER = "";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
           return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar conctar-se com o banco de dados ",ex);
        }
    }
}
