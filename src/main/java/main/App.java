package main;

import model.Produto;
import service.EstoqueService;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        Produto p1 = new Produto();

        System.out.print("Nome: ");
        p1.nome = scanner.nextLine();

        System.out.print("Preço: ");
        p1.preco = scanner.nextDouble();

        System.out.print("Quantidade: ");
        p1.quantidade = scanner.nextInt();

        System.out.print("Categoria: ");
        p1.categoria = scanner.nextLine();

        EstoqueService service = new EstoqueService();

        service.cadastrarProduto(p1);
    }
}