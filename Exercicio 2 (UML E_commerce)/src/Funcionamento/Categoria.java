package Funcionamento;

import java.util.List;
import java.util.Scanner;

public class Categoria {
    private static List<Categoria> listaCategorias;
    private int codCategoria;
    private String nomeCategoria;
    private String departamento;
    
    public int getCodCategoria() {
        return codCategoria;
    }
    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }
    public String getNomeCategoria() {
        return nomeCategoria;
    }
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public static void criaCategoria(Scanner tcl){
        System.out.println("Digite o código da categoria:");
        int codCategoria = tcl.nextInt();
        tcl.nextLine();
        System.out.println("Digite o nome da categoria:");
        String nomeCategoria = tcl.nextLine();
        System.out.println("Digite o departamento da categoria:");
        String departamento = tcl.nextLine();
        Categoria categoria = new Categoria();
        categoria.setCodCategoria(codCategoria);
        categoria.setNomeCategoria(nomeCategoria);
        categoria.setDepartamento(departamento);
        listaCategorias.add(categoria);
    }

    public static Categoria selecionaCategoria(Scanner tcl){
        System.out.println("Selecione uma categoria:");
        for (int i = 0; i < listaCategorias.size(); i++) {
            Categoria categoria = listaCategorias.get(i);
            System.out.println((i + 1) + " - " + categoria.getNomeCategoria());
        }
        int opcao = tcl.nextInt() - 1;
        tcl.nextLine();
        if (opcao >= 0 && opcao < listaCategorias.size()) {
            return listaCategorias.get(opcao);
        } else {
            return null;
        }
    }

    
}
