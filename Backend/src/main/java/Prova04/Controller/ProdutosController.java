package Prova04.Controller;

import Prova04.Model.Produtos;
import Prova04.Repository.ProdutosRepository;
import Prova04.Services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService pserv;

    @Autowired
    private ProdutosRepository prep;

    @GetMapping
    public List<Produtos> listarProtutos() {
        return pserv.ListaProdutos();
    }

    @GetMapping(value = "/{produtoId}")
    public ResponseEntity<Produtos> buscaProdutoById(@PathVariable Long produtoId) {
        Produtos obj = pserv.ListProdutoByid(produtoId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Produtos> cadastraProduto(@RequestBody Produtos produto) {
        produto = pserv.CadastraProduto(produto);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping(value ="/{produtoId}")
    public ResponseEntity<Produtos> alteraProduto(@RequestBody Produtos produto, @PathVariable Long produtoId) {
        produto = pserv.AlteraProduto(produtoId, produto);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping(value = "/{produtoId}")
        public ResponseEntity<Void> deletaProduto(@PathVariable Long produtoId) {
        pserv.DeletaProduto(produtoId);
        return ResponseEntity.noContent().build();
        }



}
