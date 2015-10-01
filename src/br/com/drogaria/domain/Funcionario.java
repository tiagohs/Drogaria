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

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "senha", length = 32, nullable = false)
	private String senha;

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
	
	
}
