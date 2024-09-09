package Funcionamento;

import java.util.Scanner;

public class ItemDeOrcamento {
    private int quantidade;
    private Produto produto;
    private Orcamento orcamento;

    Produto p = new Produto();

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public static void getDadosItemOrcamento(Scanner tcl) {
        Produto seleção = Produto.selecionarProduto(tcl);
        if (seleção != null) {
            System.out.println("A quantidade no estoque é: " + seleção.getQuantidade());
            System.out.println("Qual a quantidade de itens que você deseja comprar:");
            int quantidade = tcl.nextInt();
            tcl.nextLine();
            if (quantidade <= seleção.getQuantidade()) {
                ItemDeOrcamento item = new ItemDeOrcamento(seleção, quantidade);
            } else {
                System.out.println("A quantidade que você quer não tem no estoque.");
            }
        }
    }

    public ItemDeOrcamento(Produto produto, int quantidade) {

        this.produto = produto;
        this.quantidade = quantidade;
    }
}
