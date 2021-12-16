package Prova04.Repository;

import Prova04.Model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
