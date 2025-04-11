package models;

public class Pedido {
    private Cliente cliente;
    private List<Produto> Produtos;
    private double valorTotal;

    public Pedido(Cliente cliente, List<Produto> produtos, double valorTotal) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }
    
    public String getCliente(){
        return cliente;
    }
    public List<Produto> getProdutos(){
        return produtos;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public String toString() {
        return "Cliente: " + cliente.getNome() +
               " \nProdutos " + produtos +
               "\nValor Total: R$ " + valorTotal;
     }
}
