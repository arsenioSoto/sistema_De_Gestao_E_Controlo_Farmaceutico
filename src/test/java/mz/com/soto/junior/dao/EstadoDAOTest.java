package mz.com.soto.junior.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.soto.junior.domain.Estado;

public class EstadoDAOTest {

	@Test
	//@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Matola");
		estado.setSigla("MT");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("Total de Registros encontrados : " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro Encontrado!");
		} else {
			System.out.println("Total de Registros encontrados : ");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro removido com sucesso");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " _ " + estado.getNome());
		}

	}
	
	@Test
	public void editar() {
		Long codigo = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			System.out.println("Registro Editado Antes");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " _ " + estado.getNome());
			
			estado.setSigla("mt");
			estado.setNome("matola");
			estadoDAO.editar(estado);
			
			System.out.println("Registro Editado Depois");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " _ " + estado.getNome());
		}

	}
		
		
	
}
