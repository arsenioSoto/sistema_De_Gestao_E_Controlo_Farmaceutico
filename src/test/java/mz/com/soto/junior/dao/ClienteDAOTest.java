package mz.com.soto.junior.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import mz.com.soto.junior.domain.Cliente;
import mz.com.soto.junior.domain.Pessoa;



public class ClienteDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);

		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		System.out.println("Cliente salvo com sucesso.");
	}
	
	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		for (Cliente cliente : resultado) {
			System.out.println("Codigo do cliente: " + cliente.getCodigo());
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
			System.out.println("Email " + cliente.getPessoa().getEmail());
			System.out.println("Data Liberado: " + cliente.getDataCadastro() + " - " + cliente.getLiberado());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro Encontrado!");
		} else {

			System.out.println("Codigo do cliente: " + cliente.getCodigo());
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
			System.out.println("Email " + cliente.getPessoa().getEmail());
			System.out.println("Data Liberado: " + cliente.getDataCadastro() + " - " + cliente.getLiberado());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 44L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum Registro encontrado");
		} else {
			System.out.println("Codigo do cliente: " + cliente.getCodigo());
			System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
			System.out.println("Email " + cliente.getPessoa().getEmail());
			System.out.println("Data Liberado: " + cliente.getDataCadastro() + " - " + cliente.getLiberado());
		}

	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigoPessoa = 1L;
		Long codigoCliente = 1L;
		
		
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		System.out.println("Codigo do cliente: " + pessoa.getCodigo());
		System.out.println("Nome do cliente: " + pessoa.getNome());
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		System.out.println("Registro a ser Editado");
		System.out.println("Codigo da Cidade: " + cliente.getCodigo());
		System.out.println("Nome da Cidade: " + cliente.getPessoa().getNome());
	

		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		clienteDAO.editar(cliente);
		
		System.out.println("Codigo do cliente: " + cliente.getCodigo());
		System.out.println("Nome do cliente: " + cliente.getPessoa().getNome());
		System.out.println("Email " + cliente.getPessoa().getEmail());
		System.out.println("Data Liberado: " + cliente.getDataCadastro() + " - " + cliente.getLiberado());
	}


}
