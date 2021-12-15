package Prova04.Instantiation;

import Prova04.Model.Estoque;
import Prova04.Model.Produtos;
import Prova04.Model.TipoProduto;
import Prova04.Repository.EstoqueRepository;
import Prova04.Repository.ProdutosRepository;
import Prova04.Repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ProdutosRepository prep;

    @Autowired
    private TipoProdutoRepository trep;

    @Autowired
    private EstoqueRepository erep;

    @Override
    public void run(String... args) throws Exception{

        Estoque e1 = new Estoque(null, "Guitarras Eletricas");
        Estoque e2 = new Estoque(null, "Violoes Acusticos");
        erep.saveAll(Arrays.asList(e1, e2));

        TipoProduto t1 = new TipoProduto(null, "Guitarra");
        TipoProduto t2 = new TipoProduto(null, "Violao");
        trep.saveAll(Arrays.asList(t1, t2));

        Produtos p1 = new Produtos(null, "Guitarra Dean", "Dean", 1, 1500.00, 1800.00, t1, e1);
        Produtos p2 = new Produtos(null, "Guitarra Fender", "Fender", 1, 2000.00, 2200.00, t1, e1);
        Produtos p3 = new Produtos(null, "Violao Tagima", "Tagima", 1, 1200.00, 1500.00, t2, e2);
        Produtos p4 = new Produtos(null, "Guitarra LDT", "LDT", 1, 1800.00, 200.00, t1, e1);
        Produtos p5 = new Produtos(null, "Guitarra Takamine", "Takamine", 1, 300.00, 3500.00, t2, e2);
        prep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
