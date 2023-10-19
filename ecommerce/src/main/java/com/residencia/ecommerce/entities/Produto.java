package com.residencia.ecommerce.entities;

import java.awt.Image;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;

	@Column(name = "nome", nullable = false, unique = true)
	private String nome;

	@Column(name = "descricao", nullable = false, unique = true)
	private String descricao;

	@Column(name = "qtd_estoque", nullable = false)
	private Integer qtdEstoque;

	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	@Column(name = "valor_unitario", nullable = false)
	private Double valorUnitario;

	// private String imagemNome; // revisar este atributo de imagem

	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categora")
	private Categoria categoria;

	// constructors
	public Produto() {
	}

	public Produto(Long idProduto, String nome, String descricao, Integer qtdEstoque, Date dataCadastro,
			Double valorUnitario, Categoria categoria) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.categoria = categoria;
	}

	// get e set
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
