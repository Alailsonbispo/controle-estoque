package br.com.controle_estoque.services;

import br.com.controle_estoque.dto.ProdutoRequestDTO;
import br.com.controle_estoque.entities.Produto;
import br.com.controle_estoque.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // 1. Listar todos
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // 2. Buscar itens para reposição
    public List<Produto> buscarListaCompras() {
        return repository.findAll().stream()
                .filter(p -> p.getQuantidade() <= p.getEstoqueMinimo())
                .collect(Collectors.toList());
    }

    // 3. Salvar novo
    @Transactional
    public Produto salvar(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        copiarDtoParaEntidade(dto, produto);
        return repository.save(produto);
    }

    // --- O MÉTODO QUE ESTAVA FALTANDO: ---
    @Transactional
    public Produto atualizar(Long id, ProdutoRequestDTO dto) {
        // Busca o produto pelo ID ou lança erro se não achar
        Produto produtoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));

        // Atualiza os dados com o que veio do Front-end
        copiarDtoParaEntidade(dto, produtoExistente);

        // O Hibernate identifica que o objeto tem ID e faz um UPDATE automático
        // A anotação @UpdateTimestamp na Entity vai carimbar a data de hoje agora!
        return repository.save(produtoExistente);
    }

    // 4. Excluir
    @Transactional
    public void excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Impossível excluir: Produto não encontrado.");
        }
    }

    // Método auxiliar para não repetir código de cópia de dados
    private void copiarDtoParaEntidade(ProdutoRequestDTO dto, Produto entidade) {
        entidade.setNome(dto.getNome());
        entidade.setCategoria(dto.getCategoria());
        entidade.setQuantidade(dto.getQuantidade());
        entidade.setEstoqueMinimo(dto.getEstoqueMinimo());
        entidade.setPrecoUnitario(dto.getPrecoUnitario());
    }
}