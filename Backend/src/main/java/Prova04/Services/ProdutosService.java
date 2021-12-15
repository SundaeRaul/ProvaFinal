package Prova04.Services;

import Prova04.Model.Produtos;
import Prova04.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    ProdutosRepository prep;

    public List<Produtos> ListaProdutos(){
        return prep.findAll();
    }

    public Produtos ListProdutoByid(Long produtoId) {
        Optional<Produtos> obj = prep.findById(produtoId);
        return obj.get();
    }

    public Produtos CadastraProduto(Produtos produto) {
        return prep.save(produto);
    }

    public void DeletaProduto(Long produtoId) {
        prep.deleteById(produtoId);
    }

    public Produtos AlteraProduto(Long produtoId, Produtos obj) {
        Produtos entity = prep.findById(produtoId).get();
        UpdateData(entity, obj);
        return prep.save(entity);
    }

    private void UpdateData(Produtos entity, Produtos obj) {
        entity.setNome(obj.getNome());
        entity.setFornecedor(obj.getFornecedor());
        entity.setPrecoCompra(obj.getPrecoCompra());
        entity.setPrecoVenda(obj.getPrecoVenda());
        entity.setQuantidade(obj.getQuantidade());
    }
}
