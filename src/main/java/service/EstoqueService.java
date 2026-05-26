package service;

import database.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueService {
    public void cadastrarProduto(Produto produto) {
        String sql = """
                INSERT INTO produtos(nome, preco, quantidade, categoria)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, produto.nome);
            stmt.setDouble(2, produto.preco);
            stmt.setInt(3, produto.quantidade);
            stmt.setString(4, produto.categoria);

            stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso!");

        } catch(SQLException e) {
            System.out.println(("ERRO ao cadastrar: " + e.getMessage()));
        }


    }
}
