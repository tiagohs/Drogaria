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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produtos")
@NamedQueries({
	@NamedQuery(name="Produto.listar", query="SELECT produto FROM Produto produto"),
	@NamedQuery(name="Produto.buscarPorID", query="SELECT produto FROM Produto produto WHERE id = :id")
})
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private Long id;
	
	@NotEmpty(message = "Campo Descrição é Obrigatório.")
	@Size(max = 100, min = 5, message = "Tamanho Inválido para o Campo Nome (5 - 100).")
	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;
	
	@NotNull(message = "Campo Preço é Obrigatório.")
	@DecimalMin(message = "Informe um Valor maior ou Igual a 0.", value = "0.00")
	@DecimalMax(message = "Informe um Valor menor ou Igual a 99999.99.", value = "99999.99")
	@Column(name = "preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@NotNull(message = "Campo Quantidade é Obrigatório.")
	@Min(message = "Informe um Valor maior ou Igual a 0.", value = 0L)
	@Max(message = "Informe um Valor menor ou Igual a 9999.", value = 9999L)
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@NotNull(message = "Campo Fabricante é Obrigatório.")
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

	@Override
	public String toString() {
		return "ID: " + id + "\nDescricao: " + descricao + "\nPreco: " + preco + "\nQuantidade: " + quantidade
				+ "\n\nFabricante: \n" + fabricante + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
