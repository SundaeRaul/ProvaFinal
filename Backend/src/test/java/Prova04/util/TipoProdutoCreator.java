package Prova04.util;

import Prova04.Model.TipoProduto;

public class TipoProdutoCreator {

    public static TipoProduto createTipoProduto() {
        TipoProduto tp = new TipoProduto(1L, "Guitarra");
        return tp;
    }
}
