package Funcionamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static List<Orcamento> listaOrcamentos = new ArrayList<>();
    private List<Endereco> listaEnderecos;
    private int codCliente;
    private String nome;
    private String cpf;

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void criaCliente(Scanner tcl) {
        System.out.println("Quantos clientes você quer cadastrar?");
        int numeroClientesAdicionados = tcl.nextInt();
        tcl.nextLine();
        for (int i = 0; i < numeroClientesAdicionados; i++){
            System.out.println("Digite o nome do cliente:");
            String novoNome = tcl.nextLine();
            System.out.println("Digite o cpf do cliente:");
            String novoCpf = tcl.nextLine();
            System.out.println("Digite o código do cliente:");
            int novoCod = tcl.nextInt();
            tcl.nextLine();
            Cliente cliente = new Cliente(novoCod, novoNome, novoCpf);
            System.out.println("Digite o número de endereços que deseja adicionar:");
            int numeroEnderecos = tcl.nextInt();
            tcl.nextLine();
            for (int j = 0; j < numeroEnderecos; j++) {
                Endereco endereco = Endereco.criaEndereco(tcl);
                cliente.adicionarEndereco(endereco);
            }
            cliente.mostraEnderecos();
            listaClientes.add(cliente);
        }

    }

    public static Cliente selecionarCliente(Scanner tcl) {
        System.out.println("Selecione um cliente:");
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            System.out.println((i + 1) + " - " + cliente.getNome());
        }
        int opcao = tcl.nextInt() - 1;
        tcl.nextLine();
        if (opcao >= 0 && opcao < listaClientes.size()) {
            return listaClientes.get(opcao);
        } else {
            return null;
        }
    }

    public static void imprimeListaClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println("Cliente: " + cliente.getNome() + ", Cpf:" + cliente.getCpf() + ", Código:" + cliente.getCodCliente());
        }
    }

    public void mostraEnderecos() {
        for (Endereco endereco : listaEnderecos) {
            System.out.println("Endereço: " + endereco.getLogradouro() + ", " + endereco.getNumero() + ", "
                    + endereco.getCompleto() + ", " + endereco.getBairro() + ", " + endereco.getCep() + ", "
                    + endereco.getCidade() + ", " + endereco.getEstado());
        }
    }

    public Cliente(int codCliente, String nome, String cpf) {
        this.codCliente = codCliente;
        this.cpf = cpf;
        this.nome = nome;
        this.listaEnderecos = new ArrayList<>();
    }

    public void adicionarEndereco(Endereco endereco) {
        endereco.setCliente(this);
        listaEnderecos.add(endereco);
    }

    public void adicionarOrcamento(Orcamento orcamento) {
        orcamento.setCliente(this);
        listaOrcamentos.add(orcamento);
    }

    public static Orcamento selecionarOrcamento(Scanner tcl) {
        System.out.println("Selecione um orçamento:");
        for (int i = 0; i < listaOrcamentos.size(); i++) {
            Orcamento orcamento = listaOrcamentos.get(i);
            System.out.println((i + 1) + " - " + orcamento.getCliente().getNome());
        }
        int opcao = tcl.nextInt() - 1;
        tcl.nextLine();
        if (opcao >= 0 && opcao < listaOrcamentos.size()) {
            return listaOrcamentos.get(opcao);
        } else {
            return null;
        }
    }
}