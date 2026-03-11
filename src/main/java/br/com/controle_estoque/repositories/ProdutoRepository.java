package br.com.controle_estoque.repositories;

import br.com.controle_estoque.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Esta query busca produtos onde a quantidade atual é menor ou igual ao mínimo definido
    @Query("SELECT p FROM Produto p WHERE p.quantidade <= p.estoqueMinimo")
    List<Produto> buscarProdutosAbaixoDoMinimo();
}