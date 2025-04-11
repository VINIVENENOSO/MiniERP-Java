package services;

import models.Cliente;
import utils.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    
        public void cadastrarCliente() {
        String nome = ScannerUtil.lerString("Nome do cliente: ");
        String cpf = ScannerUtil.lerString("CPF do cliente: ");

        clientes.add(new Cliente(nome, cpf));

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
        }else{
            System.out.println("\n --- Lista de Clientes ---");
            for (Cliente c : clientes){
                System.out.println(c);
            }
        }
    }
}
