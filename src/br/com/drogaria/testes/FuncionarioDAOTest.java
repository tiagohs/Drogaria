package br.com.drogaria.testes;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
	public void salvar() {
		Funcionario f1 = new Funcionario("Tiago", "42475450860", "123456", "Atendente");
		Funcionario f2 = new Funcionario("Henrique", "4257856234", "421256", "Diretor");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		List<Funcionario> funcionarios = dao.listar();
		
		for (Funcionario f : funcionarios) {
			System.out.println(f);
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario f1 = dao.buscar(1L);
		Funcionario f2 = dao.buscar(3L);
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = new Funcionario("Henrique", "4254565445", "23121", "Diretor");
		f1.setId(1L);
		dao.excluir(f1);
	}
	
	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = new Funcionario("Henrique", "4254565445", "23121", "Diretor");
		f1.setId(1L);
		dao.editar(f1);
	}
}
