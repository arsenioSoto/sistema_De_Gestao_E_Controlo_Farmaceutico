package mz.com.soto.junior.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import mz.com.soto.junior.domain.Cliente;
import mz.com.soto.junior.util.HibernateUtil;

public class ClienteDAO extends GenericDAO<Cliente> {
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarOrdenado(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Cliente.class);
			consulta.createAlias("pessoa", "p");
			//exemplo de alias de alias
			//consulta.addOrder(Order.asc("p.cidade", "c"));
			consulta.addOrder(Order.asc("p.nome"));
			List<Cliente> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			
			throw erro;// serve para repropagar o erro para as caMADAS SUPERIORES
			
		}finally {//esse comando sempre ira rodar independentimente da funcaio
			sessao.close();
		}
	
	}
}


