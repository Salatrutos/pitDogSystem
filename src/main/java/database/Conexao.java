package database;

import java.sql.*;

public class Conexao {

    private static final String URL =
            "jdbc:sqlite:src/main/java/database/pitdog.sqlite";

    public static Connection conectar() {

        Connection conn = null;

        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Conectado ao banco!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return conn;
    }
    private static void criarTabelas(Connection conn) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXIST produtos (
                id          INTEGER PRIMARY KEY AUTOINCREMENT,
                nome        TEXT    NOT NULL,
                preco       REAL    NOT NULL,
                quantidade  INTEGER NOT NULL,
                categoria   TEXT    NOT NULL
                );""";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
}

