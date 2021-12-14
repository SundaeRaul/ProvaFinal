package Prova04.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;
    private String nome;
    private String fornecedor;
    private int quantidade;
    private float precoCompra;
    private float precoVenda;

    @ManyToOne
    @JoinColumn(name = "tipoproduto_tipo_id")
    private TipoProduto tipoproduto;

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque_id;

    public Estoque getEstoque_id() {
        return estoque_id;
    }

    public void setEstoque_id(Estoque estoque_id) {
        this.estoque_id = estoque_id;
    }

    public TipoProduto getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(TipoProduto tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }


}
