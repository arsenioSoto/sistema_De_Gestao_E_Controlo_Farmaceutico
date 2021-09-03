package mz.com.soto.junior.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import mz.com.soto.junior.dao.CaixaDAO;
import mz.com.soto.junior.dao.ClienteDAO;
import mz.com.soto.junior.dao.FuncionarioDAO;
import mz.com.soto.junior.domain.Caixa;
import mz.com.soto.junior.domain.Funcionario;


@ManagedBean
@ViewScoped
public class CaixaBean {
	private Caixa caixa;

	private ScheduleModel caixas;
	private List<Funcionario> funcionarios;

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public ScheduleModel getCaixas() {
		return caixas;
	}

	public void setCaixas(ScheduleModel caixas) {
		this.caixas = caixas;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@PostConstruct
	public void listar() {
		caixas = new DefaultScheduleModel();
	}


	public void novo(SelectEvent evento) {
	try{
		caixa = new Caixa();
		caixa.setDataAbertura(new Date());
		//venda.setHorario(new Date());

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarios = funcionarioDAO.listarOrdenado();
	}catch(RuntimeException erro){
		Messages.addGlobalError("Ocorreu um erro ao tentar finalizar a venda");
		erro.printStackTrace();
		}
	}
	
	public void salvar(){
		//Calendar calendar = Calendar.getInstance();
		//calendar.setTime(caixa.getDataAbertura());
		//calendar.add(Calendar.DATE, 1);
		//caixa.setDataAbertura(calendar.getTime());
		
		CaixaDAO caixaDAO = new CaixaDAO();
		caixaDAO.salvar(caixa);
		Messages.addGlobalInfo("Caixa aberto com sucesso");
	}
}
