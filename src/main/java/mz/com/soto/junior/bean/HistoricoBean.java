package mz.com.soto.junior.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import mz.com.soto.junior.dao.FabricanteDAO;
import mz.com.soto.junior.dao.FuncionarioDAO;
import mz.com.soto.junior.dao.HistoricoDAO;
import mz.com.soto.junior.dao.ProdutoDAO;
import mz.com.soto.junior.domain.Funcionario;
import mz.com.soto.junior.domain.Historico;
import mz.com.soto.junior.domain.Produto;

//classe bean recebe o modelo e o controlo
//usamos anotacoes para identifocar que e uma classe de negocio ou seja 
//dizemos que esta classe e responsavel por tratar de de modelo e da visao

//ligando a visao co o controlo usando el express
//el #, O tom Cat Cria atomaticamento um Objecto do tipo EstadoBean estadoBean, entao e so ir ate a visao chamar o objecto criado

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HistoricoBean implements Serializable {
	private Produto produto;
	private Boolean exibePainelDados;
	
	private Historico historico;
	
	private List<Historico> historicos;
	
	private Funcionario funcionario;
	
	private List<Funcionario> funcionarios;
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Boolean getExibePainelDados() {
		return exibePainelDados;
	}

	public void setExibePainelDados(Boolean exibePainelDados) {
		this.exibePainelDados = exibePainelDados;
	}
	
	public Historico getHistorico() {
		return historico;
	}
	
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	
	
	public List<Historico> getHistoricos() {
		return historicos;
	}
	
	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@PostConstruct
	public void novo() {
		historico = new Historico();
		produto = new Produto();
		exibePainelDados = false;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarios = funcionarioDAO.listarOrdenado();
	}

	public void buscar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto resultado = produtoDAO.buscar(produto.getCodigo());

			if (resultado == null) {
				exibePainelDados = false;
				Messages.addGlobalWarn("Não existe produto cadastrado para o código informado");
			} else {
				exibePainelDados = true;
				produto = resultado;
				
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioDAO.listar("dataAdmissao");
				
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar o produto");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			historico.setHorario(new Date());
			historico.setProduto(produto);
			
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar("dataAdmissao");
			
			HistoricoDAO historicoDAO = new HistoricoDAO();
			historicoDAO.salvar(historico);
			
			Messages.addGlobalInfo("Histórico salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o histórico");
			erro.printStackTrace();
		}
	}
	
	
}
