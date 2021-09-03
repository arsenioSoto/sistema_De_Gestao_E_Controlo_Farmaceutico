package mz.com.soto.junior.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// http://localhost:8081/Junior/rest/junior/[Nome Repositorio de Servico = junior]
@Path("junior")
public class JuniorService {
	@GET
	public String exibir() {
		return " Arsenio Soto Junior " ;
	}

}
