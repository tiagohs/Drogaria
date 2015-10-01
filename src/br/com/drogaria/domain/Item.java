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
@Table(name = "itens")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_item")
	private Long id;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "valor_parcial", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor_parcial;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="vendas_id_venda", referencedColumnName="id_vendas", nullable=false)
	private Venda venda;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="produtos_id_produto", referencedColumnName="id_produto", nullable=false)
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor_parcial() {
		return valor_parcial;
	}

	public void setValor_parcial(BigDecimal valor_parcial) {
		this.valor_parcial = valor_parcial;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
