package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "funcionarios")
@NamedQueries({
	@NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
	@NamedQuery(name = "Funcionario.buscarPorID", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.id = :id")
})
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_funcionario")
	private Long id;
	
	@NotEmpty(message = "Campo Nome é Obrigatório.")
	@Size(min = 5, max = 30, message = "Tamanho Inválido para o Campo Nome (5 - 30).")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@CPF(message = "CPF Inválido.")
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@NotEmpty(message = "Campo Senha é Obrigatório.")
	@Size(min = 6, max = 8, message = "Tamanho Inválido para o Campo Senha (6 - 8).")
	@Column(name = "senha", length = 32, nullable = false)
	private String senha;
	
	@NotEmpty(message = "Campo Função é Obrigatório.")
	@Column(name = "funcao", length = 40, nullable = false)
	private String funcao;
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, String cpf, String senha, String funcao) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.funcao = funcao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nNome: " + nome + "\nCpf: " + cpf + "\nSenha: " + senha + "\nFuncao: " + funcao
				+ "\n";
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
