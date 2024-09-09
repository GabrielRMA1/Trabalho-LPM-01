package Funcionamento;

import java.util.Scanner;

public class Endereco {

    private int codEndereco;
    private String logradouro;
    private int numero;
    private String completo;
    private String bairro;
    private int cep;
    private String cidade;
    private String estado;
    private Cliente cliente;

    public Endereco(int codEndereco, String logradouro, int numero, String completo, String bairro, int cep, String cidade, String estado) {
        this.codEndereco = codEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.completo = completo;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public static Endereco criarEndereco(int codEndereco, String logradouro, int numero, String completo, String bairro, int cep, String cidade, String estado){
        return new Endereco(codEndereco, logradouro, numero, completo, bairro, cep, cidade, estado);
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodEndereco() {
        return codEndereco;
    }
    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCompleto() {
        return completo;
    }
    public void setCompleto(String completo) {
        this.completo = completo;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public static Endereco criaEndereco(Scanner tcl){
        System.out.println("Digite o código de criação do endereço:");
        int novoCod = tcl.nextInt();
        tcl.nextLine();
        System.out.println("Digite o logradouro:");
        String novoLogradouro = tcl.nextLine();
        System.out.println("Digite o número:");
        int novoNumero = tcl.nextInt();
        tcl.nextLine();
        System.out.println("Digite o complemento:");
        String novoCompleto = tcl.nextLine();
        System.out.println("Digite o bairro:");
        String novoBairro = tcl.nextLine();
        System.out.println("Digite o cep:");
        int novoCep = tcl.nextInt();
        tcl.nextLine();
        System.out.println("Digite a cidade:");
        String novaCidade = tcl.nextLine();
        System.out.println("Digite o estado:");
        String novoEstado = tcl.nextLine();
        return new Endereco(novoCod, novoLogradouro, novoNumero, novoCompleto, novoBairro, novoCep, novaCidade, novoEstado);
    }
}
