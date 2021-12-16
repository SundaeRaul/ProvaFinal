package Prova04.util;

import Prova04.Model.Estoque;

public class EstoqueCreator {

    public static Estoque createEstoque() {
        Estoque estoque = new Estoque(1L, "Guitarras Eletricas");
        return estoque;
    }
}
