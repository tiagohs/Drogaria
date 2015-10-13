package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Venda;

public class VendaDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		VendaDAO dao = new VendaDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		
		Funcionario funcionario = fdao.buscar(3L);
		dao.salvar(new Venda(new Date(), new BigDecimal(58.50), funcionario));
	}
	
	@Test
	@Ignore
	public void listar() {
		VendaDAO dao = new VendaDAO();
		
		System.out.println(dao.listar());
	}
	
	@Test
	@Ignore
	public void buscar() {
		VendaDAO dao = new VendaDAO();
		
		System.out.println(dao.buscar(1L));
	}
	
	@Test
	@Ignore
	public void excluir() {
		VendaDAO dao = new VendaDAO();
		
		dao.excluir(dao.buscar(2L));
	}
	
	@Test
	public void editar() {
		VendaDAO dao = new VendaDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		
		Venda venda = dao.buscar(1L);
		venda.setHorario(new Date());
		venda.setFuncionario(fdao.buscar(4L));
		
		dao.editar(venda);
	}
}
