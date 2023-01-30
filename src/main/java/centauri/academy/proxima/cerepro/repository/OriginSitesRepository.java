package centauri.academy.proxima.cerepro.repository;


import java.util.List;

import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.OriginSites;


import centauri.academy.proxima.cerepro.util.HibernateUtil;

/**
 * 
 * @author maurizio - m.franco@proximanetwork.it
 *
 */
public class OriginSitesRepository implements RepositoryInterface {
	private final static Logger logger = LoggerFactory.getLogger("OriginSitesRepository");
	public final static Long INSERT_RESULT_KO = -1L;

	private final static HibernateUtil hibernateUtil = HibernateUtil.getInstance();
	private final static SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

	public EntityInterface getEntityForTest() {
		OriginSites os = new OriginSites();
		os.setLabel("label test");
		os.setDescription("label test");// TODO ---> generate a random int
		os.setImgpath("description test");
		return (EntityInterface) os;
	}
	
	public List<EntityInterface> findAll() {
	    return findAll(OriginSites.class);
	}

	public EntityInterface findById(long id) {
		return findById(id, OriginSites.class); 
	}
	
	public int deleteAll() {
		return deleteAll(OriginSites.class);
	}
		


	@Override
	public boolean delete(long id) {	
		return delete(OriginSites.class,id);
	}
}
