package Funcionamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    private static final int ESTOQUEMINIMO = 5;
    private static int quantidadeTotal = 0;
    private int codProduto;
    private String nomeProduto;
    private double valorProduto;
    private int quantidade;
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();
    private Categoria categoria;

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean decrementaQuantidade(int quantidade) {
        if (quantidade >= 0 && validaEstoque(quantidade) == true) {
            this.quantidade -= quantidade;
            quantidadeTotal -= quantidade;
            if (verificaEstoqueSeguranca() == true) {
                System.out.println("Estoque está acima do minimo");
            } else {
                System.out.println("Estoque abaixo do minimo");
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean incrementaQuantidade(int quantidade) {
        if (this.quantidade >= 0) {
            this.quantidade += quantidade;
            quantidadeTotal -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    public boolean validaEstoque(int quantidade) {
        return quantidade >= 0 && this.quantidade >= quantidade;
    }

    private boolean verificaEstoqueSeguranca() {
        return (this.quantidade > ESTOQUEMINIMO);
    }

    public static int getValida() {
        return quantidadeTotal;
    }

    /*
     * private void geraPedidoCompra(){
     * 
     * }
     */

    public void criaProduto(Scanner tcl) {
        System.out.println("Quantos produtos você quer adicionar");
        int numeroProdutosAdicionados = tcl.nextInt();
        tcl.nextLine();
        for (int i = 0; i < numeroProdutosAdicionados; i++) {
            Produto produto = new Produto();
            System.out.println("Digite o nome do produto:");
            String nomeProduto = tcl.nextLine();
            produto.setNomeProduto(nomeProduto);
            System.out.println("Digite o valor do produto:");
            double valor = tcl.nextDouble();
            produto.setValorProduto(valor);
            tcl.nextLine();
            System.out.println("Digite a quantidade do produto no estoque:");
            int quantidadeEstoque = tcl.nextInt();
            produto.setQuantidade(quantidadeEstoque);
            tcl.nextLine();
            System.out.println("Digite o codigo do produto:");
            int codNovoProduto = tcl.nextInt();
            produto.setCodProduto(codNovoProduto);
            System.out.println("Selecione a categoria para o produto:");
            Categoria categoriaSelecionada = Categoria.selecionaCategoria(tcl);
            produto.setCategoria(categoriaSelecionada);
            tcl.nextLine();

            listaProdutos.add(produto);

        }
    }

    public static Produto selecionarProduto(Scanner tcl) {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return null;
        }
        System.out.println("Selecione um produto:");
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto produto = listaProdutos.get(i);
            System.out.println((i + 1) + ": " + produto.getNomeProduto() + "-" + produto.categoria.getNomeCategoria());
        }
        int opcao = tcl.nextInt() - 1;
        tcl.nextLine();
        if (opcao >= 0 && opcao < listaProdutos.size()) {
            return listaProdutos.get(opcao);
        } else {
            return null;
        }

    }

    public void adicionaProduto(Scanner tcl) {
        Produto produto = selecionarProduto(tcl);

        if (produto != null) {

            System.out.println("Quantos produtos você quer adicionar");
            int quantidade = tcl.nextInt();
            tcl.nextLine();
            if (produto.incrementaQuantidade(quantidade)) {
                System.out.println("Estoque atual: " + produto.getQuantidade());
            } else {
                System.out.println("Não foi possivel atualizar o estoque");
            }
        }

    }

    public void tiraProduto(Scanner tcl) {
        Produto produto = selecionarProduto(tcl);

        if (produto != null) {

            System.out.println("Quantos produtos você quer tirar");
            int quantidade = tcl.nextInt();
            tcl.nextLine();
            if (produto.decrementaQuantidade(quantidade)) {
                System.out.println("Estoque atual: " + produto.getQuantidade());
            } else {
                System.out.println("Erro ao atualizar o estoque");
            }

        }

    }
}
