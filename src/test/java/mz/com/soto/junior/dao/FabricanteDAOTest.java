package mz.com.soto.junior.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.soto.junior.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	//@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Coca cola");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		System.out.println("Total de Registros encontrados : " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro Encontrado!");
		} else {
			System.out.println("Total de Registros encontrados : ");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro Removido com sucesso!");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());

		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			System.out.println("Registro Editado - Antes" );
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
			fabricante.setDescricao("2M");
			fabricanteDAO.editar(fabricante);
			System.out.println("Registro Editado - Depois");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		
		}	
	}
	
	@Test
	@Ignore
	public void merge() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("mzmzmz");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.merge(fabricante);
	}
	@Test
	@Ignore
	public void mergeEditar() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(2L);
		fabricante.setDescricao("Swing");
		fabricanteDAO.merge(fabricante);
	}

}
