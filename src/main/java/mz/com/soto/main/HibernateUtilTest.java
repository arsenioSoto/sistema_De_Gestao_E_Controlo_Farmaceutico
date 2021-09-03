package mz.com.soto.main;

import org.hibernate.Session;

import mz.com.soto.junior.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session sessao= HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
