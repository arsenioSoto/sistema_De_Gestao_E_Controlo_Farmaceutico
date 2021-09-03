package mz.com.soto.junior.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import mz.com.soto.junior.domain.Funcionario;
import mz.com.soto.junior.util.HibernateUtil;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarOrdenado(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.createAlias("pessoa", "p");
			consulta.addOrder(Order.asc("p.nome"));
			List<Funcionario> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			
			throw erro;// serve para repropagar o erro para as caMADAS SUPERIORES
			
		}finally {//esse comando sempre ira rodar independentimente da funcaio
			sessao.close();
		}
	
	}
}