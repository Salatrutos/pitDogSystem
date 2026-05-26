package main;

import model.Produto;
import service.EstoqueService;


public class App {
    public static void main(String[] args){
        Produto p1 = new Produto();
        p1.nome = "X-Tudo";
        p1.preco = 25.0;
        p1.quantidade = 10;
        p1.categoria = "Sanduiche";

        EstoqueService service = new EstoqueService();

        service.cadastrarProduto(p1);
    }
}