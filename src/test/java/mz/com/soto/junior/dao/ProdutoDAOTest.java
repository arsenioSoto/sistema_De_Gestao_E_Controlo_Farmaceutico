package mz.com.soto.junior.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import mz.com.soto.junior.domain.Fabricante;
import mz.com.soto.junior.domain.Produto;

public class ProdutoDAOTest {

	@Test
	public void salvar() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("1"));

		Produto produto = new Produto();
		produto.setDescricao("Morfina");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("123.23"));
		produto.setQuantidade(new Short("33"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("Produto salvo com sucesso");

	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		for (Produto produto : resultado) {
			System.out.println("Codigo do Produto: " + produto.getCodigo());
			System.out.println("Nome do Produto: " + produto.getDescricao());
			System.out.println("Preco do Produto " + produto.getPreco());
			System.out.println("Quantidade do produto: " + produto.getQuantidade());
			System.out.println("Nome e Codigo do Fabricante: " + produto.getFabricante().getDescricao() + " - "
					+ produto.getFabricante().getCodigo());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro Encontrado!");
		} else {

			System.out.println("Codigo do Produto: " + produto.getCodigo());
			System.out.println("Nome do Produto: " + produto.getDescricao());
			System.out.println("Preco do Produto " + produto.getPreco());
			System.out.println("Quantidade do produto: " + produto.getQuantidade());
			System.out.println("Nome e Codigo do Fabricante: " + produto.getFabricante().getDescricao() + " - "
					+ produto.getFabricante().getCodigo());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 44L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Codigo do Produto: " + produto.getCodigo());
			System.out.println("Nome do Produto: " + produto.getDescricao());
			System.out.println("Preco do Produto " + produto.getPreco());
			System.out.println("Quantidade do produto: " + produto.getQuantidade());
			System.out.println("Nome e Codigo do Fabricante: " + produto.getFabricante().getDescricao() + " - "
					+ produto.getFabricante().getCodigo());
		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigoProduto = 1L;
		Long codigoFabricante = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);

		System.out.println("Codigo do Fabricante " + fabricante.getCodigo());
		System.out.println("Nome do Fabricante: " + fabricante.getDescricao());

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		System.out.println("Registro a ser Editado");
		System.out.println("Codigo do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getDescricao());
		System.out.println("Quantidade do Produto: " + produto.getQuantidade());
		System.out.println("Preco do Produto: " + produto.getPreco());
		

		produto.setDescricao("Mandioca");
		produto.setPreco(new BigDecimal("121"));
		produto.setQuantidade(new Short("12"));
		produto.setFabricante(fabricante);
		produtoDAO.editar(produto);

		produtoDAO.excluir(produto);
		System.out.println("Codigo do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getDescricao());
		System.out.println("Preco do Produto " + produto.getPreco());
		System.out.println("Quantidade do produto: " + produto.getQuantidade());
		System.out.println("Nome e Codigo do Fabricante: " + produto.getFabricante().getDescricao() + " - "
				+ produto.getFabricante().getCodigo());
	}
}
