package services;

import models.Produto;
import utils.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class EstoqueService {
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto() {
        String nome = ScannerUtil.lerString("Nome do produto: ");
        int quantidade = ScannerUtil.lerInt("Quantidade: ");

        produtos.add(new Produto(nome, quantidade));

        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n--- Lista de Produtos ---");
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }
}
