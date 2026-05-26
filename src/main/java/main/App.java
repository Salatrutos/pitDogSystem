package main;

import model.Produto;
import service.EstoqueService;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.print("O que deseja cadastrar?\n");
        System.out.print("1- Sanduiche\n");
        System.out.print("2- Bebida\n");
        int opcao = scanner.nextInt();
        scanner.nextLine();

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

        if(opcao ==1){
            service.cadastrarSanduiche(p1.nome, p1.preco, p1.quantidade);
        } else if (opcao ==2) {
            service.cadastrarBebidas(p1.nome, p1.preco, p1.quantidade);
        }else { System.out.print("Opção Inválida!");

        }
    }
}