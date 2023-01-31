package centauri.academy.proxima.cerepro.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.User;
import centauri.academy.proxima.cerepro.util.HibernateUtil;

public class UserRepository implements RepositoryInterface {

	private final static Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	private static final int ROLE_ADMIN_NUMBER = 0;

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

	public User findByEmail(String email) {
		logger.info("findByEmail - START - with email: " + email);
		Session session = sessionFactory.openSession();
		User entity = null;
		try {
			String hql = "SELECT obj FROM " + User.class.getSimpleName() + " obj WHERE email = '" + email + "'";
			Query<User> query = session.createQuery(hql);
			List<User> results = query.list(); 
			logger.info("findByEmail - DEBUG - results.size(): " + results.size());
			if(results.size() > 0) {
				entity = results.get(0);
			} else {
				entity = null;
			}
			logger.info("findByEmail - DEBUG - entity: " + entity);
		} catch (Exception e) {
			e.printStackTrace();
			entity = null;
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
	
	public List<User> findByRole() {
		logger.info("findByRole - START - with role: " + ROLE_ADMIN_NUMBER);
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		List<User> entityList = null;
		try {
			String hql = "SELECT obj FROM " + User.class.getSimpleName() + " obj WHERE role = '" + ROLE_ADMIN_NUMBER + "'";
			Query<User> query = session.createQuery(hql);
			entityList = query.list();
			logger.info("findByRole - DEBUG - results.size(): " + entityList.size());
		} catch (Exception e) {
			e.printStackTrace();
			entityList = null;
			logger.error("Error: " + e, e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error: " + e, e);
			}
		}
		return entityList;
	}


}// End class
