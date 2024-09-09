package Business;

import java.util.Scanner;

import Funcionamento.ItemDeOrcamento;
import Funcionamento.Orcamento;
import Funcionamento.Produto;
import Funcionamento.Categoria;
import Funcionamento.Cliente;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);

        Produto produto = new Produto();
        Orcamento orcamento = new Orcamento();
        int chose = 0;
        while (chose != 10) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar cliente");
            System.out.println("2 - Imprimir lista de clientes");
            System.out.println("3 - Criar categoria");
            System.out.println("4 - Criar produto");
            System.out.println("5 - Adicionar produto");
            System.out.println("6 - Tirar produto");
            System.out.println("7 - Adicionar item de orçamento");
            System.out.println("8 - Criar orçamento");
            System.out.println("9 - Pagar orçamento");
            System.out.println("10 - Sair");

            chose = tcl.nextInt();
            tcl.nextLine();
            switch (chose) {
                case 1:
                    Cliente.criaCliente(tcl);
                    break;
                case 2:
                    Cliente.imprimeListaClientes();
                    ;
                    break;
                case 3:
                    Categoria.criaCategoria(tcl);
                    break;
                case 4:
                    produto.criaProduto(tcl);
                    break;
                case 5:
                    produto.adicionaProduto(tcl);
                    break;
                case 6:
                    produto.tiraProduto(tcl);
                    break;
                case 7:
                    ItemDeOrcamento.getDadosItemOrcamento(tcl);
                    break;
                case 8:
                    orcamento.criaOrcamento(tcl);
                    ;
                    break;
                case 9:
                    orcamento.pagarOrcamentos(tcl);
                    break;
                case 10:
                    break;
            }

        }

        tcl.close();
    }

}
