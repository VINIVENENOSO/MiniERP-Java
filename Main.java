import services.ClienteService;
import services.EstoqueService;
import utils.ScannerUtil;

public class Main {
    public static void main(String[] args) {
        EstoqueService estoqueService = new EstoqueService();
        ClienteService clienteService = new ClienteService();
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Cadastrar Clientes");
            System.out.println("4. Listar Clientes");
            System.out.println("0. Sair");

            opcao = ScannerUtil.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> estoqueService.cadastrarProduto();
                case 2 -> estoqueService.listarProdutos();
                case 3 -> clienteService.cadastrarCliente();
                case 4 -> clienteService.listarClientes();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
