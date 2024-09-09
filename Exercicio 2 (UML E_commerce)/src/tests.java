import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Funcionamento.Categoria;
import Funcionamento.Cliente;
import Funcionamento.Endereco;
import Funcionamento.ItemDeOrcamento;
import Funcionamento.MeioDePagamento;
import Funcionamento.Orcamento;
import Funcionamento.Pagamento;
import Funcionamento.Produto;

public class tests {
    Produto produto;
    Categoria categoria;
    Cliente cliente1;
    Cliente cliente2;
    Endereco endereco1;
    Endereco endereco2;
    ItemDeOrcamento item;
    MeioDePagamento meioDePagamento1;
    MeioDePagamento meioDePagamento2;
    Orcamento orcamento;
    Pagamento pagamento1;
    Pagamento pagamento2;


    @BeforeEach
    void setUp() {
        produto = new Produto();
        produto.setCodProduto(1);
        produto.setNomeProduto("Produto 1");
        produto.setValorProduto(10.0);
        produto.setQuantidade(10);
        categoria = new Categoria();
        categoria.setCodCategoria(1);
        categoria.setNomeCategoria("Categoria 1");
        categoria.setDepartamento("Departamento 1");
        produto.setCategoria(categoria);
        cliente1 = new Cliente(1,"Cliente 1", "12345678901");
        cliente2 = new Cliente(2,"Cliente 2", "12345678902");
        endereco1 = new Endereco(1, "Rua 1", 1, "Rua 1, 1", "Bairro 1", 12345678, "Cidade 1", "Estado 1");
        endereco2 = new Endereco(2, "Rua 2", 2, "Rua 2, 2", "Bairro 2", 12345679, "Cidade 2", "Estado 2");
        item = new ItemDeOrcamento(produto, 5);
        meioDePagamento1 = new MeioDePagamento("Cartão de Crédito", 1, 1.0);
        meioDePagamento2 = new MeioDePagamento("À vista", 0,0 );
        orcamento = new Orcamento();
        pagamento1 = new Pagamento(10.0, meioDePagamento1);
        pagamento2 = new Pagamento(10.0, meioDePagamento2);

    }

    @Test
    void testDecrementaQuantidade() {
        produto.decrementaQuantidade(5);
        assertEquals(5, produto.getQuantidade());

    }

    @Test
    void testGetCategoria() {
        assertEquals(categoria, produto.getCategoria());
    }

    @Test
    void testGetCodProduto() {
        assertEquals(1, produto.getCodProduto());

    }

    @Test
    void testGetNomeProduto() {
        assertEquals("Produto 1", produto.getNomeProduto());

    }

    @Test
    void testGetQuantidade() {
        assertEquals(10, produto.getQuantidade());

    }

    @Test
    void testGetValorProduto() {
        assertEquals(10.0, produto.getValorProduto(), 0.0001);

    }

    @Test
    void testIncrementaQuantidade() {
        produto.incrementaQuantidade(5);
        assertEquals(15, produto.getQuantidade());

    }

    @Test
    void testValidaEstoque() {
        assertEquals(true, produto.validaEstoque(5));
        assertEquals(false, produto.validaEstoque(15));

    }

    @Test
    void testGetCodCategoria() {
        assertEquals(1, categoria.getCodCategoria());
        
    }

    @Test
    void testGetDepartamento() {
        assertEquals("Departamento 1", categoria.getDepartamento());
        
    }

    @Test
    void testGetNomeCategoria() {
        assertEquals("Categoria 1", categoria.getNomeCategoria());
        
    }

    @Test
    void testGetCodCliente() {
        assertEquals(1, cliente1.getCodCliente());
        
    }

    @Test
    void testGetCpf() {
        assertEquals("12345678901", cliente1.getCpf());
        
    }

    @Test
    void testGetListaEnderecos() {
        assertEquals(0, cliente1.getListaEnderecos().size());
        cliente1.adicionarEndereco(endereco1);
        assertEquals(1, cliente1.getListaEnderecos().size());
        cliente1.adicionarEndereco(endereco2);
        assertEquals(2, cliente1.getListaEnderecos().size());
        
    }

    @Test
    void testGetNome() {
        assertEquals("Cliente 1", cliente1.getNome());
    }

    @Test
    void testMostraEnderecos() {
        cliente1.adicionarEndereco(endereco1);
        cliente1.adicionarEndereco(endereco2);
        cliente1.mostraEnderecos();
        
    }

    @Test
    void testGetProduto() {
        assertEquals(produto, item.getProduto());
        
    }

    @Test
    void testGetQuantidade2() {
        assertEquals(5, item.getQuantidade());
    }

    @Test
    void testGetBairro() {
        assertEquals("Bairro 1", endereco1.getBairro());
        assertEquals("Bairro 2", endereco2.getBairro());
    }

    @Test
    void testGetCep() {
        assertEquals(12345678, endereco1.getCep());
        assertEquals(12345679, endereco2.getCep());
        
    }

    @Test
    void testGetCidade() {
        assertEquals("Cidade 1", endereco1.getCidade());
        assertEquals("Cidade 2", endereco2.getCidade());
        
    }

    @Test
    void testGetCliente() {
        endereco1.setCliente(cliente1);
        assertEquals(cliente1, endereco1.getCliente());
        
    }

    @Test
    void testGetCodEndereco() {
        assertEquals(1, endereco1.getCodEndereco());
        assertEquals(2, endereco2.getCodEndereco());
    }

    @Test
    void testGetCompleto() {
        assertEquals("Rua 1, 1", endereco1.getCompleto());
        assertEquals("Rua 2, 2", endereco2.getCompleto());
    }

    @Test
    void testGetEstado() {
        assertEquals("Estado 1", endereco1.getEstado());
        assertEquals("Estado 2", endereco2.getEstado());
        
    }

    @Test
    void testGetLogradouro() {
        assertEquals("Rua 1", endereco1.getLogradouro());
        assertEquals("Rua 2", endereco2.getLogradouro());
        
    }

    @Test
    void testGetNumero() {
        assertEquals(1, endereco1.getNumero());
        assertEquals(2, endereco2.getNumero());
        
    }

    @Test
    void testGetNomePgto() {
        assertEquals("Cartão de Crédito", meioDePagamento1.getNomePgto());
        assertEquals("À vista", meioDePagamento2.getNomePgto());
        
    }

    @Test
    void testGetNumParcelas() {
        assertEquals(1, meioDePagamento1.getNumParcelas());
        assertEquals(0, meioDePagamento2.getNumParcelas());
        
    }

    @Test
    void testGetTaxaCartao() {
        assertEquals(1.0, meioDePagamento1.getTaxaCartao(), 0.0001);
        assertEquals(0.0, meioDePagamento2.getTaxaCartao(), 0.0001);
        
    }

    @Test
    void testGetCodOrcamento() {
        assertEquals(0, orcamento.getCodOrcamento());
        
    }

    @Test
    void testGetValorTotal() {
        assertEquals(0.0, orcamento.getValorTotal(), 0.0001);
        
    }

    @Test
    void testConfirmarPgto() {
        orcamento.adicionarItem(item);
        orcamento.adicionarPagamento(pagamento1);
        orcamento.confirmarPgtos();
        assertEquals(true, orcamento.isOrcamentoPago());
    }
    

    @Test
    void testGetMeioDePagamento() {
        assertEquals(meioDePagamento1, pagamento1.getMeioDePagamento());
        assertEquals(meioDePagamento2, pagamento2.getMeioDePagamento());
        
    }

    @Test
    void testGetOrcamento2() {
        pagamento1.setOrcamento(orcamento);
        assertEquals(orcamento, pagamento1.getOrcamento());
        
    }

    @Test
    void testGetValorPgto() {
        assertEquals(10.0, pagamento1.getValorPgto(), 0.0001);
        assertEquals(10.0, pagamento2.getValorPgto(), 0.0001);
        
    }

}
