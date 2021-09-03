package mz.com.soto.junior.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	// metodo conectar
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();

	}

}
