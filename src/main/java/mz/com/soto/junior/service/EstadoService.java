package mz.com.soto.junior.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import mz.com.soto.junior.dao.EstadoDAO;
import mz.com.soto.junior.domain.Estado;


@Path("estado")
public class EstadoService {
	@GET
	public String listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> estados = estadoDAO.listar("nome");

		Gson gson = new Gson();
		String json = gson.toJson(estados);

		return json;
	}
}
