package br.com.drogaria.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="vendas")
@NamedQueries({
	@NamedQuery(name="Venda.listar", query="SELECT venda FROM Venda venda"),
	@NamedQuery(name="Venda.buscarPorID", query="SELECT venda FROM Venda venda WHERE id = :id")
})
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_vendas")
	private Long id;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="horario", nullable=false)
	private Date horario; 
	
	@Column(name="valor_total", nullable=false, precision = 7, scale = 2)
	private BigDecimal valor_total;
	
	//Muitas vendas são realizadas por um Funcionario
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="funcionario_id_funcionario", referencedColumnName="id_funcionario", nullable = false)
	private Funcionario funcionario;
	
	public Venda() {
	}
	
	public Venda(Date horario, BigDecimal valor_total, Funcionario funcionario) {
		this.horario = horario;
		this.valor_total = valor_total;
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nHorario: " + horario + "\nValor_total: " + valor_total + "\n\nFuncionario: \n\n"
				+ funcionario + "\n";
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
