package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;

	@Column(name = "preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	// Ou seja, muitos produtos pertencem a um fabricante
	//Com EAGER, os Fabricantes já devem ser carregados juntos. Enquanto LAZER só seriam carregados depois.
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante_id_fabricante", referencedColumnName = "id_fabricante", nullable = false)
	private Fabricante fabricante;
	
	public Produto() {
	}
	
	public Produto(String descricao, BigDecimal preco, Integer quantidade, Fabricante fabricante) {
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.fabricante = fabricante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
