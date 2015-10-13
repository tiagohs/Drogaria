package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void inserir() {
		ProdutoDAO dao = new ProdutoDAO();
		FabricanteDAO fdao = new FabricanteDAO();
		Fabricante fabricante = fdao.buscar(5L);

		Produto p1 = new Produto("Produto 1 Criado", new BigDecimal(50.40), 5, fabricante);
		
		dao.salvar(p1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> produtos = dao.listar();
		
		System.out.println(produtos);
	}
	
	@Test
	@Ignore
	public void buscar() {
		ProdutoDAO dao = new ProdutoDAO();
		
		System.out.println(dao.buscar(1L));
	}
	
	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto p = dao.buscar(2L);
		dao.excluir(p);
	}
	
	@Test
	public void editar() {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto p = dao.buscar(3L);
		p.setDescricao("Nova Descricao Produto 1");
		dao.editar(p);
	}
}
