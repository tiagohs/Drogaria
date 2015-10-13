package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ItemDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Item;

public class ItemDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		ItemDAO dao = new ItemDAO();
		VendaDAO vdao = new VendaDAO();
		ProdutoDAO pdao = new ProdutoDAO();
		
		dao.salvar(new Item(30, new BigDecimal(800.61), vdao.buscar(1L), pdao.buscar(3L)));
	}
	
	@Test
	@Ignore
	public void listar() {
		ItemDAO dao = new ItemDAO();
		
		System.out.println(dao.listar());
	}
	
	@Test
	@Ignore
	public void buscar() {
		ItemDAO dao = new ItemDAO();
		
		System.out.println(dao.buscar(1L));
	}
	
	@Test
	@Ignore
	public void excluir() {
		ItemDAO dao = new ItemDAO();
		
		dao.excluir(dao.buscar(2L));
	}
	
	@Test
	public void editar() {
		ItemDAO dao = new ItemDAO();
		
		Item item = dao.buscar(1L);
		item.setQuantidade(80);
		item.setValor_parcial(new BigDecimal(504.5));
		
		dao.editar(item);
	}
}
