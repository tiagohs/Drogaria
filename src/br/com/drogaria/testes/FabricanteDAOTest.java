package br.com.drogaria.testes;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	public void salvar() {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Descricao 1");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("Descricao 2");
		
		FabricanteDAO dao = new FabricanteDAO();
		
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		
		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante.toString());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante f1 = dao.buscar(2L);
		Fabricante f2 = dao.buscar(6L);
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante f1 = new Fabricante("DescricaoX");
		f1.setId(3L);
		dao.excluir(f1);
	}
	
	@Test
	@Ignore
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante f = new Fabricante();
		f.setId(3L);
		f.setDescricao("DescricaoX");
		dao.editar(f);
	}
}
