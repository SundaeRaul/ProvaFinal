package Prova04.util;

import Prova04.Model.Produtos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProdutosCreator {

    public static Produtos createInvalidProduto() {
        Produtos p1 = new Produtos(1L, "", "Tagima", 1, 750.00, 800.00, TipoProdutoCreator.createTipoProduto(), EstoqueCreator.createEstoque());
        return p1;
    }

    public static Produtos createValidProduct() {
        Produtos p1 = new Produtos(1L, "Guitarra Memphis", "Tagima", 1, 750.00, 800.00, TipoProdutoCreator.createTipoProduto(), EstoqueCreator.createEstoque());
        return p1;
    }
}
