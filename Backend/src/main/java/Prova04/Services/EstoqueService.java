package Prova04.Services;

import Prova04.Model.Estoque;
import Prova04.Repository.EstoqueRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository erep;

    public List<Estoque> ListaEstoque() {
        return erep.findAll();
    }

    public Estoque ListaEstoqueById(Long estoqueid) {
        Optional<Estoque> obj = erep.findById(estoqueid);
        return obj.get();
    }

    public Estoque CadastraEstoque(Estoque estoque) {
        return erep.save(estoque);
    }

    public void DeletaEstoque(Long estoqueId) {
        erep.deleteById(estoqueId);
    }

    public Estoque AlteraEstoque(Long estoqueId, Estoque obj) {
        Estoque entity = erep.findById(estoqueId).get();
        UpdateData(entity, obj);
        return erep.save(entity);
    }

    private void UpdateData(Estoque entity, Estoque obj) {
        entity.setNome(obj.getNome());
    }
}
