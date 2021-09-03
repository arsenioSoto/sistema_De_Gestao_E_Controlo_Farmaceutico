package mz.com.soto.junior.bean;

import java.io.Serializable;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;


import  mz.com.soto.junior.dao.FabricanteDAO;
import  mz.com.soto.junior.dao.ProdutoDAO;
import  mz.com.soto.junior.domain.Fabricante;
import  mz.com.soto.junior.domain.Produto;




@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean3  implements Serializable {
	private Produto produto;
	private Long codigoProduto;
	
	private List<Fabricante> fabricantes;
	private List<Produto> produtos;
	
	private FabricanteDAO fabricanteDAO;
	private ProdutoDAO produtoDAO;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Long getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@PostConstruct
	public void iniciar(){
		fabricanteDAO = new FabricanteDAO();
		produtoDAO = new ProdutoDAO();
	}
	
	public void listar() {
		try {
			produtos = produtoDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos");
			erro.printStackTrace();
		}
	}
	
	public void carregarEdicao(){
		try {
			produto = produtoDAO.buscar(codigoProduto);
			
			fabricantes = fabricanteDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar os dados para edição");
			erro.printStackTrace();
		}
	}
	public void editar(ActionEvent evento) {
		try {
			
			
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar("descricao");
			Messages.addGlobalInfo("Produto actualizado com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um produto");
			erro.printStackTrace();
		}
	}
}


