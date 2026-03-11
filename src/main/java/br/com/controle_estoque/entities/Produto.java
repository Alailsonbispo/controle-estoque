package br.com.controle_estoque.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;

    @Positive(message = "A quantidade deve ser maior que zero")
    private Integer quantidade;

    @Column(name = "estoque_minimo")
    private Integer estoqueMinimo;

    @Positive(message = "O preço deve ser maior que zero")
    @Column(name = "preco_unitario")
    private Double precoUnitario;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Produto() {}

    public Produto(String nome, String categoria, Integer quantidade, Integer estoqueMinimo, Double precoUnitario) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
        this.precoUnitario = precoUnitario;
    }
}