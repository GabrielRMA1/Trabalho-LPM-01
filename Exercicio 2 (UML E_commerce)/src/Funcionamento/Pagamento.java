package Funcionamento;

public class Pagamento {
    private boolean confirmacao = false;
    private double valorPgto;
    private MeioDePagamento meioDePagamento;
    private Orcamento orcamento;

    public Pagamento(double valorPgto, MeioDePagamento meioDePagamento) {
        this.valorPgto = valorPgto;
        this.meioDePagamento = meioDePagamento;
    }

    public boolean isConfirmado() {
        return confirmacao;
    }

    public double getValorPgto() {
        return valorPgto;
    }

    public MeioDePagamento getMeioDePagamento() {
        return meioDePagamento;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    
    public void confirmarPgto() {
        if (orcamento.getValorTotal() == valorPgto) {
            this.confirmacao = true;
            System.out.println("Pagamento de " + valorPgto + " reais " + meioDePagamento.getNomePgto() + "foi realizado.");
        } else {
            System.out.println("Pagamento não foi realizado. Valor incorreto.");
        }
    }
}
