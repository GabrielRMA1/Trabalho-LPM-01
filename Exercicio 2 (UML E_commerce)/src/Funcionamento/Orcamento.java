package Funcionamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Orcamento {
    private int codOrcamento;
    private double valorTotal = 0.0;
    private boolean orcamentoPago = false;
    private ArrayList<ItemDeOrcamento> itensOrcamento = new ArrayList<>();
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();
    private Cliente cliente;

    public int getCodOrcamento() {
        return codOrcamento;
    }

    public void setCodOrcamento(int codOrcamento) {
        this.codOrcamento = codOrcamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void adicionarItem(ItemDeOrcamento item) {
        if (item != null) {
            itensOrcamento.add(item);
            this.valorTotal += item.getProduto().getValorProduto() * item.getQuantidade();
        }
    }

    public ArrayList<ItemDeOrcamento> getItensOrcamento() {
        return itensOrcamento;
    }

    public void listarItens() {
        for (ItemDeOrcamento item : itensOrcamento) {
            System.out.println(
                    "Produto: " + item.getProduto().getNomeProduto() + ", Quantidade: " + item.getQuantidade());
        }
    }

    public boolean adicionarPagamento(Pagamento pagamento) {
        if (pagamento != null && pagamentos.size() < 2) {
            pagamentos.add(pagamento);
            return true;
        }
        return false;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void confirmarPgtos() {
        if (!itensOrcamento.isEmpty() && !pagamentos.isEmpty()) {
            this.orcamentoPago = true;
            System.out.println("Pagamento confirmado.");
        } else {
            System.out.println("Orçamento sem itens ou sem pagamento. Não é possível confirmar.");
        }
    }

    public boolean isOrcamentoPago() {
        return orcamentoPago;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void criaOrcamento(Scanner tcl) {
        System.out.println("O valor total deu:");
        System.out.println(valorTotal);
        System.out.println("Qual cliente deseja adicionar ao orçamento?");
        Cliente.imprimeListaClientes();
        Cliente cliente = Cliente.selecionarCliente(tcl);
        if (cliente != null) {
            this.cliente = cliente;
            cliente.adicionarOrcamento(this);
        }
        System.out.println("Orçamento:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Valor total: " + valorTotal);
    }

    public void pagarOrcamentos(Scanner tcl) {
        System.out.println("Selecione o orçamento que deseja pagar:");
        Orcamento orcamento = Cliente.selecionarOrcamento(tcl);
        if (orcamento != null) {
            if (orcamento.isOrcamentoPago()) {
                System.out.println("Orçamento já foi pago.");
            } else {
                System.out.println("Como deseja pagar?");
                System.out.println("1 - À vista");
                System.out.println("2 - Parcelado");
                int opcao = tcl.nextInt();
                tcl.nextLine();
                if (opcao == 1) {
                    System.out.println("O valor total da compra é: " + valorTotal);
                    System.out.println("Digite o valor que irá pagar:");
                    double valor = tcl.nextDouble();
                    tcl.nextLine();
                    MeioDePagamento meioDePagamento = new MeioDePagamento("À vista", 0, 0);
                    Pagamento pagamento = new Pagamento(valor, meioDePagamento);
                    adicionarPagamento(pagamento);
                    pagamento.confirmarPgto();
                } else if (opcao == 2) {
                    System.out.println("O valor total da compra é: " + valorTotal);
                    System.out.println("Você pode parcelar em até 3 vezes.");
                    System.out.println("Em quantas vezes deseja parcelar?");
                    int vezes = tcl.nextInt();
                    tcl.nextLine();
                    System.out.println("Qual a taxa de juros do cartão?");
                    double taxa = tcl.nextDouble();
                    tcl.nextLine();
                    double taxaJurosDecimal = taxa / 100;
                    double valorParcela = calcularValorParcela(valorTotal, vezes, taxaJurosDecimal);
                    System.out.printf("O valor de cada parcela será: R$ %.2f%n", valorParcela);
                    MeioDePagamento meioDePagamento = new MeioDePagamento("Parcelado", vezes, taxa);
                    Pagamento pagamento = new Pagamento(valorTotal, meioDePagamento);
                    adicionarPagamento(pagamento);
                }
            }
        }

    }

    public static double calcularValorParcela(double valorTotal, int numeroParcelas, double taxaJuros) {
        double valorParcela = (valorTotal * taxaJuros) / (1 - Math.pow(1 + taxaJuros, -numeroParcelas));
        return valorParcela;
    }
}
