package mz.com.soto.junior.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.soto.junior.dao.EstadoDAO;
import mz.com.soto.junior.domain.Estado;

//classe bean recebe o modelo e o controlo
//usamos anotacoes para identifocar que e uma classe de negocio ou seja 
//dizemos que esta classe e responsavel por tratar de de modelo e da visao

//ligando a visao co o controlo usando el express
//el #, O tom Cat Cria atomaticamento um Objecto do tipo EstadoBean estadoBean, entao e so ir ate a visao chamar o objecto criado
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;
	
	
	
	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@PostConstruct //subConstrutor, e chamado logo que o construtor normal eh terminado de chamar
	public void listar() {
		
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar o estado!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		estado = new Estado();
	}
	
	
	public void salvar() {
		try {
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.merge(estado);
		
		novo();
		estados = estadoDAO.listar("nome");
		
		Messages.addGlobalInfo("Estado salvo com sucesso!");
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado!");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		EstadoDAO  estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		estados =estadoDAO.listar("nome");
		Messages.addGlobalInfo("Estado removido com sucesso!");
		}catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir o estado! \n" + estado.getNome() + "\n Erro de Integridade Referencial");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento ) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}

}
