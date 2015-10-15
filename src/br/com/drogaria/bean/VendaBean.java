package br.com.drogaria.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {
	private List<Produto> listaProduto;
	private List<Produto> listaProdutoFiltrados;
	
	private Venda vendaCadastro;
	private List<Item> listaItem;
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	public List<Produto> getListaProdutoFiltrados() {
		return listaProdutoFiltrados;
	}
	
	public void setListaProdutoFiltrados(List<Produto> listaProdutoFiltrados) {
		this.listaProdutoFiltrados = listaProdutoFiltrados;
	}
	
	public List<Item> getListaItem() {
		return listaItem == null ? listaItem = new ArrayList<>() : listaItem;
	}
	
	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}
	
	public Venda getVendaCadastro() {
		return vendaCadastro == null ? vendaCadastro = new Venda() : vendaCadastro;
	}
	
	public void setVendaCadastro(Venda vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}
	
	public void carregarProdutos() {

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProduto = produtoDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMensagemErro("Erro ao Listar os Produtos: " + ex.getMessage());
		}
	}
	
	public void adicionar(Produto produto) {
		Item item = new Item();
		
		item.setProduto(produto);
		int posicao = posicaoProduto(produto);
		if (posicao < 0) {
			item.setQuantidade(1);
			item.setValor_parcial(produto.getPreco());
			listaItem.add(item);
		} else {
			Item itemTemp = listaItem.get(posicao);
			item.setQuantidade(itemTemp.getQuantidade() + 1);
			item.setValor_parcial(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
			listaItem.set(posicao, item);
		}
		
		vendaCadastro.setValor_total(vendaCadastro.getValor_total().add(item.getValor_parcial()));
	}
	
	public int posicaoProduto(Produto produto) {
		int posicao = 0;
		
		for (Item item : listaItem) {
			if (item.getProduto().equals(produto))
				return posicao;
			posicao++;
		}
		
		return -1;	
	}
	
	public void remover(Item item) {
		int posicao = posicaoProduto(item.getProduto());
		
		if (posicao > -1) {
			Item itemTemp = listaItem.get(posicao);
			if (itemTemp.getQuantidade() > 1) {
				itemTemp.setQuantidade(itemTemp.getQuantidade() - 1);
				itemTemp.setValor_parcial(item.getValor_parcial().subtract(item.getProduto().getPreco()));
				listaItem.set(posicao, itemTemp);
				vendaCadastro.setValor_total(vendaCadastro.getValor_total().subtract(itemTemp.getProduto().getPreco()));
			} else {
				listaItem.remove(posicao);
			}
			vendaCadastro.setValor_total(vendaCadastro.getValor_total().subtract(item.getProduto().getPreco()));
		}
	}
	
}
