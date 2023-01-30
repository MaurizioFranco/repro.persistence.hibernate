package centauri.academy.proxima.cerepro.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.User;

public class UserRepository implements RepositoryInterface {
//	private SessionFactory session_factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	Logger logger = LoggerFactory.getLogger("UserRepository");

	public User getEntityForTest(int roleLevel) {
		return getEntityForTest(roleLevel, "email2@email.com");
	}
	
	public User getEntityForTest(int roleLevel, String email) {
		User tmpUser = new User();
		// TO ALL set for all fields!!!!!
//		@SuppressWarnings("deprecation")
		Date myDate = new Date(2014, 02, 11);
		Timestamp tstamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
		tmpUser.setEmail(email);
		tmpUser.setPassword("pass_word");
		tmpUser.setFirstname("first_name");
		tmpUser.setLastname("last_name");
		tmpUser.setDateofbirth(myDate);
		tmpUser.setRegdate(tstamp);
		tmpUser.setRole(roleLevel);
		tmpUser.setImgpath("prova");
		tmpUser.setNote("note_test");
		tmpUser.setenabled(0);
		return tmpUser;
	}
	
	
	
	public List<EntityInterface> findAll() {
		return findAll(User.class);
	}

	public EntityInterface findById(long id) {
		return findById(id, User.class);
	}

	public int deleteAll() { // returns the number of lines erased
		return deleteAll(User.class);
	}
	public boolean delete(long id) {
		return delete(User.class, id);
	}



	@Deprecated
	@Override
	public EntityInterface getEntityForTest() {
		// TODO Auto-generated method stub
		return null;
	}

	public  EntityInterface findByEmail(String email) {
		logger.info("findByEmail - START - with email: " + email);
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		EntityInterface entity = null;
		try {
			// creating transaction object
			String hql = "SELECT obj FROM User obj WHERE email = '" + email + "'";
			Query<EntityInterface> query = session.createQuery(hql);
			List results = query.list(); 
			logger.info("findByEmail - DEBUG - results.size(): " + results.size());
			if(results.size() > 0) {
				entity = (EntityInterface) results.get(0);
			} else {
				entity = null;
			}
//			Long id = (Long)results.get(0);
//			logger.info("findByEmail - DEBUG - id: " + id.longValue());
//			trx = session.beginTransaction();
//			entity = (EntityInterface) session.find(User.class, id);// search by specific class and id
			logger.info("findByEmail - DEBUG - entity: " + entity);
//			trx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entity = null;
//			try {
//				trx.rollback();
//			} catch (Exception ex) {
//				e.printStackTrace();
//			}
			logger.error("Error: " + e, e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error: " + e, e);
			}
		}
		return entity;
	}


}// End class
