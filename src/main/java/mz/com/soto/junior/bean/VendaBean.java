package mz.com.soto.junior.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.soto.junior.dao.ClienteDAO;
import mz.com.soto.junior.dao.FuncionarioDAO;
import mz.com.soto.junior.dao.ProdutoDAO;
import mz.com.soto.junior.dao.VendaDAO;
import mz.com.soto.junior.domain.Cliente;
import mz.com.soto.junior.domain.Funcionario;
import mz.com.soto.junior.domain.ItemVenda;
import mz.com.soto.junior.domain.Produto;
import mz.com.soto.junior.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

	private Venda venda;
	private List<Produto> produtos;
	private List<ItemVenda> itensVenda;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;
	
	private List<Venda> vendas;
	
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	@PostConstruct
	public void novo() {
		try {
			
			venda = new Venda();
			venda.setPrecoTotal(new BigDecimal("0.00"));
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("descricao");
			itensVenda = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Produtos");
			erro.printStackTrace();
		}
	}
	
	public void adicionar(ActionEvent evento) {
		
	Produto	produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
	
	int achou = -1;
	
	for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
		if (itensVenda.get(posicao).getProduto().equals(produto)) {
			achou = posicao;
		}
	}
	if (achou < 0) {
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setValorParcial(produto.getPreco());
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(new Short("1"));
		
		itensVenda.add(itemVenda);
	}else {
		ItemVenda itemVenda = itensVenda.get(achou);
		itemVenda.setQuantidade(new Short (itemVenda.getQuantidade() + 1 + ""));
		itemVenda.setValorParcial(produto.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
	}
	calcular();

	}
	
	public void remover(ActionEvent evento) {
		ItemVenda itemVenda = (ItemVenda) evento.getComponent().getAttributes().get("produtoSelecionado");
	
		int achou = -1;
		
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			if (itensVenda.get(posicao).getProduto().equals(itemVenda.getProduto())) {
				achou = posicao;
			}
		}
		if (achou > -1) {
			itensVenda.remove(achou);
		}
		
		calcular();
	}
	
	public void atualizarPrecoParcial(){
		for(ItemVenda itemVenda : this.itensVenda){
			itemVenda.setValorParcial(itemVenda.getProduto().getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
		}
		this.calcular();
	}
	
	public void calcular(){
		venda.setPrecoTotal(new BigDecimal("0.00"));
		
		for(int posicao = 0; posicao < itensVenda.size(); posicao++){
			ItemVenda itemVenda = itensVenda.get(posicao);
			venda.setPrecoTotal(venda.getPrecoTotal().add(itemVenda.getValorParcial()));
		}
	}
	
	public void finalizar(){
		try{
			venda.setHorario(new Date());
			
			venda.setCliente(null);
			venda.setFuncionario(null);
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listarOrdenado();
			
			ClienteDAO clienteDAO= new ClienteDAO();
			clientes = clienteDAO.listarOrdenado();
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar finalizar a venda");
			erro.printStackTrace();
		}
	}
	public void salvar() {
		try {
			if(venda.getPrecoTotal().signum() == 0){
				Messages.addGlobalError("Adiciona pelo menos um item para a venda");
				return;
			}
			
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda, itensVenda);
			
			novo();
			Messages.addGlobalInfo("Venda realizada com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a venda");
			erro.printStackTrace();
		}
	}
	
	public void listar(){
		VendaDAO vendaDAO = new VendaDAO();
		vendas = vendaDAO.listar("horario");
	}
}



	