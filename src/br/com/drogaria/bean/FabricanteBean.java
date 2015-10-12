package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private List<Fabricante> listaFabricantes;
	private List<Fabricante> listaFabricantesFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<Fabricante> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public void novo() {
		novoFabricante();
	}

	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricante);
			novoFabricante();

			FacesUtil.adicionarMensagemInfo("Fabricante Salvo com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMensagemErro("Erro ao tentar incluir um fabricante: " + ex.getMessage());
		}
	}

	public void carregarPesquisa() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMensagemErro("Erro ao Listar os Fabricantes: " + ex.getMessage());
		}
	}
	
	public void carregarCadastro() {
		String valor = null;
		
		try {
			valor = FacesUtil.getParametro("fabId");
			
			if (valor != null) {
				Long fabricanteID = Long.parseLong(valor);
				
				FabricanteDAO dao = new FabricanteDAO();
				fabricante = dao.buscar(fabricanteID);
			} else {
				fabricante = new Fabricante();
			}
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMensagemErro("Erro ao Obter os Dados do Fabricante: " + ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);

			FacesUtil.adicionarMensagemInfo("Fabricante Removido com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMensagemErro("Erro ao tentar remover um fabricante: " + ex.getMessage());
		}
	}
	
	public void editar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.editar(fabricante);

			FacesUtil.adicionarMensagemInfo("Fabricante Editado com Sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMensagemErro("Erro ao tentar editar um fabricante: " + ex.getMessage());
		}
	}
	
	private void novoFabricante() {
		fabricante = new Fabricante();
	}
}
