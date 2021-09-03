package mz.com.soto.junior.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import mz.com.soto.junior.dao.PerfilDAO;
import mz.com.soto.junior.domain.Perfil;

//classe bean recebe o modelo e o controlo
//usamos anotacoes para identifocar que e uma classe de negocio ou seja 
//dizemos que esta classe e responsavel por tratar de de modelo e da visao

//ligando a visao co o controlo usando el express
//el #, O tom Cat Cria atomaticamento um Objecto do tipo EstadoBean estadoBean, entao e so ir ate a visao chamar o objecto criado
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable {
	private Perfil perfil;
	private List<Perfil> perfils;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	@PostConstruct // subConstrutor, e chamado logo que o construtor normal eh terminado de chamar
	public void listar() {

		try {
			PerfilDAO perfilDAO = new PerfilDAO();
			perfils = perfilDAO.listar("perfil");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os perfils!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		perfil = new Perfil();
	}

	public void salvar() {
		try {
			PerfilDAO perfilDAO = new PerfilDAO();
			perfilDAO.merge(perfil);
			novo();
			perfils = perfilDAO.listar("perfil");
			Messages.addGlobalInfo("Perfil salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Perfil!");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
		
			perfil = (Perfil) evento.getComponent().getAttributes().get("perfilSelecionado");
		
			PerfilDAO perfilDAO = new PerfilDAO();
			perfilDAO.excluir(perfil);
		
			perfils = perfilDAO.listar("perfil");
		
		Messages.addGlobalInfo("Perfil removido com sucesso!");
	}catch (RuntimeException erro) {
		Messages.addGlobalError("Ocorreu um erro ao tentar remover este Perfil" + perfil.getPerfil());
		erro.printStackTrace();
		}
	}
		
	public void editar(ActionEvent evento ) {
		perfil = (Perfil) evento.getComponent().getAttributes().get("perfilSelecionado");
		
	}

	
}
