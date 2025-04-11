import models.Produto;
import models.Cliente;
import services.EstoqueService;
import services.ClienteService;
import services.PedidoService;
import utils.ScannerUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EstoqueService estoqueService = new EstoqueService();
        ClienteService clienteService = new ClienteService();

        // Pega as listas dos outros services
        List<Produto> produtos = estoqueService.getProdutos();
        List<Cliente> clientes = clienteService.getClientes();

        // Cria o PedidoService com as listas
        PedidoService pedidoService = new PedidoService(clientes, produtos);

        int opcao;

        do {
            System.out.println("\n=== Mini ERP Java ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Registrar Pedido"); // ✅ novo
            System.out.println("6. Listar Pedidos");   // ✅ novo
            System.out.println("0. Sair");

            opcao = ScannerUtil.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> estoqueService.cadastrarProduto();
                case 2 -> estoqueService.listarProdutos();
                case 3 -> clienteService.cadastrarCliente();
                case 4 -> clienteService.listarClientes();
                case 5 -> pedidoService.registrarPedido(); // ✅ novo
                case 6 -> pedidoService.listarPedidos();   // ✅ novo
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
