package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "fabricantes")
@NamedQueries({ 
	@NamedQuery(name = "Fabricante.listar", query = "SELECT fabricante FROM Fabricante fabricante"),
	@NamedQuery(name="Fabricante.buscarPorID", query="SELECT fabricante FROM Fabricante fabricante WHERE fabricante.id = :id")
	})
public class Fabricante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_fabricante")
	private Long id;

	@Column(name = "fab_descricao", length = 50, nullable = false)
	private String descricao;
	
	public Fabricante() {
	}
	
	public Fabricante(String descricao) {
		this.descricao = descricao;
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

	@Override
	public String toString() {
		return "ID: " + id + "\nDescricao: " + descricao + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fabricante) {
			Fabricante fabricante = (Fabricante)obj;
			return (this.getId().equals(fabricante.getId()));
		}
		return false;
	}
	
}
