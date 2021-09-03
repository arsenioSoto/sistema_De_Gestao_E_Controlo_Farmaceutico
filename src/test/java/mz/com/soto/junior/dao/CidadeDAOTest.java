package mz.com.soto.junior.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.soto.junior.domain.Cidade;
import mz.com.soto.junior.domain.Estado;

public class CidadeDAOTest {

	@Test
	//@Ignore
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);

		Cidade cidade = new Cidade();
		cidade.setNome("Maputo");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Codigo do estado " + cidade.getEstado().getCodigo());
			System.out.println(
					"Nome do estado e sigla: " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro Encontrado!");
		} else {

			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Codigo do estado " + cidade.getEstado().getCodigo());
			System.out.println(
					"Nome do estado e sigla: " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 44L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			cidadeDAO.excluir(cidade);
			System.out.println("Registro removido com sucesso");
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Codigo do estado " + cidade.getEstado().getCodigo());
			System.out.println(
					"Nome do estado e sigla: " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigoEstado = 1L;
		Long codigoCidade = 1L;
		
		
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		System.out.println("Codigo do estado " + estado.getCodigo());
		System.out.println("Nome do estado e sigla: " + estado.getSigla() + " - " + estado.getNome());
		
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Registro a ser Editado");
		System.out.println("Codigo da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
	

		cidade.setNome("Gaza");
		cidade.setEstado(estado);
		cidadeDAO.editar(cidade);
		
		System.out.println("Registro removido com sucesso");
		System.out.println("Codigo da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Codigo do estado " + cidade.getEstado().getCodigo());
		System.out.println("Nome do estado e sigla: " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
	}
	
	@Test
	
	public void buscarPorEstado() {
		Long codigoEstado = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(codigoEstado);

		for (Cidade cidade : resultado) {
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Codigo do estado " + cidade.getEstado().getCodigo());
			System.out.println(
					"Nome do estado e sigla: " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
		}
	}

}
