package mz.com.soto.junior.dao;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import mz.com.soto.junior.domain.Cidade;
import mz.com.soto.junior.domain.Pessoa;


public class PessoaDAOTest {
	

	@Test
	@Ignore
	public void salvar() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(new Long("1"));

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Arsenio Soto");
		pessoa.setBairro("t3");
		pessoa.setBilheteIdentidade("1234324");
		pessoa.setAnoNascimento(new Date());
		pessoa.setEmail("sotosword@Gmail.com");
		pessoa.setMorada("bf q12");
		pessoa.setNuite("123");
		pessoa.setNumero(new Short("123"));
		pessoa.setRua("da Beirra");
		pessoa.setSexo("Masculino");
		pessoa.setTelefone("845072619");
		pessoa.setCidade(cidade);
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

		System.out.println("Produto salvo com sucesso");

	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		for (Pessoa pessoa : resultado) {
			System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
			System.out.println("Nome da Pessoa: " + pessoa.getNome());
			System.out.println("Numerio de Documento da Pessoa " + pessoa.getBilheteIdentidade());
			System.out.println("Sexo da Pessoa: " + pessoa.getSexo());
			System.out.println("Cidade da Pessoa: " + pessoa.getCidade().getNome());
			System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Nenhum registro Encontrado!");
		} else {

			System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
			System.out.println("Nome da Pessoa: " + pessoa.getNome());
			System.out.println("Numerio de Documento da Pessoa " + pessoa.getBilheteIdentidade());
			System.out.println("Sexo da Pessoa: " + pessoa.getSexo());
			System.out.println("Cidade da Pessoa: " + pessoa.getCidade().getNome());
			System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 44L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
			System.out.println("Nome da Pessoa: " + pessoa.getNome());
			System.out.println("Numerio de Documento da Pessoa " + pessoa.getBilheteIdentidade());
			System.out.println("Sexo da Pessoa: " + pessoa.getSexo());
			System.out.println("Cidade da Pessoa: " + pessoa.getCidade().getNome());
			System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigoPessoa = 1L;
		Long codigoCidade = 1L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		System.out.println("Codigo da Cidade " + cidade.getCodigo());
		System.out.println("Nome da Cidade e Estado: " + cidade.getNome()+ " _ " + cidade.getEstado().getNome());

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da Pessoa: " + pessoa.getNome());
		System.out.println("Numerio de Documento da Pessoa " + pessoa.getBilheteIdentidade());
		System.out.println("Sexo da Pessoa: " + pessoa.getSexo());
		
		pessoa.setNome("Arsenio Soto");
		pessoa.setBairro("t3");
		pessoa.setBilheteIdentidade("1234324");
		pessoa.setAnoNascimento(new Date());
		pessoa.setEmail("sotosword@Gmail.com");
		pessoa.setMorada("bf q12");
		pessoa.setNuite("123");
		pessoa.setNumero(new Short("123"));
		pessoa.setRua("da Beirra");
		pessoa.setSexo("Masculino");
		pessoa.setTelefone("845072619");
		pessoa.setCidade(cidade);
		pessoaDAO.editar(pessoa);

		System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da Pessoa: " + pessoa.getNome());
		System.out.println("Numerio de Documento da Pessoa " + pessoa.getBilheteIdentidade());
		System.out.println("Sexo da Pessoa: " + pessoa.getSexo());
		System.out.println("Cidade da Pessoa: " + pessoa.getCidade().getNome());
		System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
	}

}
