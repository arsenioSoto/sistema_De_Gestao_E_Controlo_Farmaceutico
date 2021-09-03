package mz.com.soto.junior.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;

import mz.com.soto.junior.dao.FabricanteDAO;
import mz.com.soto.junior.domain.Fabricante;

//classe bean recebe o modelo e o controlo
//usamos anotacoes para identifocar que e uma classe de negocio ou seja 
//dizemos que esta classe e responsavel por tratar de de modelo e da visao

//ligando a visao co o controlo usando el express
//el #, O tom Cat Cria atomaticamento um Objecto do tipo EstadoBean estadoBean, entao e so ir ate a visao chamar o objecto criado
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct // subConstrutor, e chamado logo que o construtor normal eh terminado de chamar
	public void listar() {

		try {
			// FabricanteDAO fabricanteDAO = new FabricanteDAO();
			// fabricantes = fabricanteDAO.listar("descricao");

			Client cliente = ClientBuilder.newClient();

			WebTarget caminho = cliente.target("http://localhost:8080/Junior/rest/fabricante");
			String json = caminho.request().get(String.class);

			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);

			fabricantes = Arrays.asList(vetor);
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os fabricantes!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		fabricante = new Fabricante();
	}

	public void salvar() {
		try {
			// FabricanteDAO fabricanteDAO = new FabricanteDAO();
			// fabricanteDAO.merge(fabricante);
			// novo();
			// fabricantes = fabricanteDAO.listar("descricao");

			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://localhost:8080/Junior/rest/fabricante");

			Gson gson = new Gson();

			String json = gson.toJson(fabricante);
			caminho.request().post(Entity.json(json));

			fabricante = new Fabricante();

			json = caminho.request().get(String.class);
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			fabricantes = Arrays.asList(vetor);

			Messages.addGlobalInfo("Fabricante salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o fabricante!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {

			fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");

			Client cliente = ClientBuilder.newClient();

			WebTarget caminho = cliente.target("http://localhost:8080/Junior/rest/fabricante");

			caminho.path("{codigo}").resolveTemplate("codigo", fabricante.getCodigo()).request().delete();
			String json = caminho.request().get(String.class);  
			
			Gson gson = new Gson();

		
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			fabricantes = Arrays.asList(vetor);

			// FabricanteDAO fabricanteDAO = new FabricanteDAO();
			// fabricanteDAO.excluir(fabricante);

			// fabricantes = fabricanteDAO.listar("descricao");

			Messages.addGlobalInfo("Fabricante removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover este fabricante" + fabricante.getDescricao());
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");

	}

}
