package br.com.drogaria.domain;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="vendas")
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_vendas")
	private long id;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="horario", nullable=false)
	private Calendar horario; 
	
	@Column(name="valor_total", nullable=false, precision = 7, scale = 2)
	private BigDecimal valor_total;
	
	//Muitas vendas são realizadas por um Funcionario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="funcionario_id_funcionario", referencedColumnName="id_funcionario", nullable = false)
	private Funcionario funcionario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
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
	
	
}
