package mz.com.soto.junior.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import mz.com.soto.junior.dao.ProdutoDAO;
import mz.com.soto.junior.domain.Produto;

// http://localhost:8080/Junior/rest/produto
@Path("produto")
public class ProdutoService {
	
	@GET
	public String listar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> produtos = produtoDAO.listar("descricao");
		
		
		Gson gson = new Gson();
		String json = gson.toJson(produtos);
		
		return json;
	}
	
	@POST
	public String Salvar(String json) {
		Gson gson = new Gson();
		Produto produto = gson.fromJson(json, Produto.class);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.merge(produto);
		
		
		String jsonSaida = gson.toJson(produto);
		return jsonSaida;
	}

}
