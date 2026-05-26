package service;

import database.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueService {

    public void cadastrarSanduiche(String nome, double preco, int quantidade) {
        String sql = """
                INSERT INTO sanduiches(nome, preco, quantidade, categoria_id)
                VALUES (?, ?, ?, 1)
                """;
        executar(sql, nome, preco, quantidade);
    }

    public void cadastrarBebidas(String nome, double preco, int quantidade) {
        String sql = """
                INSERT INTO bebidas(nome, preco, quantidade, categoria_id)
                VALUES (?, ?, ?, 1)
                """;
        executar(sql, nome, preco, quantidade);
    }

    public void executar(String sql, String nome, double preco, int quantidade) {

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso!");

        } catch(SQLException e) {
            System.out.println(("ERRO ao cadastrar: " + e.getMessage()));
        }


    }
}
