package br.com.controle_estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoRequestDTO {

        @NotBlank
        private String nome;

        @NotBlank
        private String categoria;

        @Positive
        private Integer quantidade;

        @Positive
        private Integer estoqueMinimo;

        @Positive
        private Double precoUnitario;

        // --- SE VOCÊ NÃO USA LOMBOK, PRECISA DESSES MÉTODOS ABAIXO ---

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getCategoria() {
                return categoria;
        }

        public void setCategoria(String categoria) {
                this.categoria = categoria;
        }

        public Integer getQuantidade() {
                return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
                this.quantidade = quantidade;
        }

        public Integer getEstoqueMinimo() {
                return estoqueMinimo;
        }

        public void setEstoqueMinimo(Integer estoqueMinimo) {
                this.estoqueMinimo = estoqueMinimo;
        }

        public Double getPrecoUnitario() {
                return precoUnitario;
        }

        public void setPrecoUnitario(Double precoUnitario) {
                this.precoUnitario = precoUnitario;
        }
}