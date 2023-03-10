package centauri.academy.proxima.cerepro.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
	
	private static Logger log = LoggerFactory.getLogger(HibernateUtil.class);
	
	private static HibernateUtil _instance = null;
	private SessionFactory sessionFactory = null;
	
	private HibernateUtil() {
		super();
	
		this.sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
											.buildSessionFactory();
		if(this.sessionFactory != null)
			log.debug("Sesssionfactory inizialized!");
	}
	
	
	public static synchronized HibernateUtil getInstance() {
		if(HibernateUtil._instance == null)
			HibernateUtil._instance = new HibernateUtil();
		return HibernateUtil._instance;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	public void closeSessionFactory() {
		this.sessionFactory.close();
		log.debug("sessionFactory to database close!");
	}
}