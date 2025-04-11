package services;

import models.Cliente;
import models.Produto;
import models.Pedido;
import utils.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Cliente> clientes;
    private List<Produto> produtos;

    public PedidoService(List<Cliente> clientes, List<Produto> produtos) {
        this.clientes = clientes;
        this.produtos = produtos;
    }

    public void registrarPedido() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível no estoque.");
            return;
        }

        // Selecionar cliente
        System.out.println("\n--- Clientes Cadastrados ---");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNome());
        }
        int indiceCliente = ScannerUtil.lerInt("Escolha o cliente pelo número: ");
        Cliente cliente = clientes.get(indiceCliente);

        // Selecionar produtos
        List<Produto> produtosSelecionados = new ArrayList<>();
        double valorTotal = 0.0;
        String continuar;

        do {
            System.out.println("\n--- Produtos Disponíveis ---");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(i + " - " + produtos.get(i));
            }

            int indiceProduto = ScannerUtil.lerInt("Escolha o produto pelo número: ");
            Produto produto = produtos.get(indiceProduto);

            produtosSelecionados.add(produto);
            valorTotal += produto.getPreco();

            continuar = ScannerUtil.lerString("Adicionar mais um produto? (s/n): ");
        } while (continuar.equalsIgnoreCase("s"));

        // Criar pedido
        Pedido pedido = new Pedido(cliente, produtosSelecionados, valorTotal);
        pedidos.add(pedido);

        System.out.println("\n✅ Pedido registrado com sucesso!");
        System.out.println(pedido);
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado ainda.");
        } else {
            System.out.println("\n--- Lista de Pedidos ---");
            for (Pedido p : pedidos) {
                System.out.println(p);
                System.out.println("---------------------------");
            }
        }
    }
}
