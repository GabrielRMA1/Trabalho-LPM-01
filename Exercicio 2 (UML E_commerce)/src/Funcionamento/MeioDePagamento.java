package Funcionamento;

public class MeioDePagamento {
    private static final int NUMMAXPARCELAS = 3;
    private String nomePgto;
    private int numParcelas;
    private double taxaCartao;

    public String getNomePgto() {
        return nomePgto;
    }

    public void setNomePgto(String nomePgto) {
        this.nomePgto = nomePgto;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        if (numParcelas > NUMMAXPARCELAS) {
            this.numParcelas = NUMMAXPARCELAS;
        } else {
            this.numParcelas = numParcelas;
        }

    }

    public double getTaxaCartao() {
        return taxaCartao;
    }

    public void setTaxaCartao(double taxaCartao) {
        this.taxaCartao = taxaCartao;
    }

    public MeioDePagamento(String nomePgto, int numParcelas, double taxaCartao) {
        this.nomePgto = nomePgto;
        if (numParcelas > NUMMAXPARCELAS) {
            this.numParcelas = NUMMAXPARCELAS;
        } else {
            this.numParcelas = numParcelas;
        }

        this.taxaCartao = taxaCartao;
    }

}
