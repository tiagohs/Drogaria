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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
@NamedQueries({
	@NamedQuery(name="Item.listar", query="SELECT item FROM Item item"),
	@NamedQuery(name="Item.buscarPorID", query="SELECT item FROM Item item WHERE id = :id")
})
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
	
	public Item() {
	}
	
	public Item(Integer quantidade, BigDecimal valor_parcial, Venda venda, Produto produto) {
		this.quantidade = quantidade;
		this.valor_parcial = valor_parcial;
		this.venda = venda;
		this.produto = produto;
	}

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

	@Override
	public String toString() {
		return "Id: " + id + "\nQuantidade: " + quantidade + "\nValor Parcial: " + valor_parcial + "\n\nVenda: " + venda
				+ "\n\nProduto: " + produto + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((valor_parcial == null) ? 0 : valor_parcial.hashCode());
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			Item item = (Item)obj;
			return (this.getId().equals(item.getId()));
		}
		return false;
	}
	
	
}
