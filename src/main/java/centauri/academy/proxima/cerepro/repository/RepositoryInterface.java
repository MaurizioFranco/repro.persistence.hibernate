package centauri.academy.proxima.cerepro.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.util.HibernateUtil;

/**
 * 
 * @author Roberto
 * 
 */
public interface RepositoryInterface {

	public Logger logger = LoggerFactory.getLogger("RepositoryInterface");
	public final static Long INSERT_RESULT_KO = -1L;
	public HibernateUtil hibernateUtil = HibernateUtil.getInstance();
	public SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

	
	/**
	 * Insert a new Entity in the table
	 * @param entity
	 * @return
	 */
	public default Long create(EntityInterface entity) {
		logger.info("insert - START");
		Long resultValue = INSERT_RESULT_KO;
		Session session = null;
		Transaction trx = null;
		try {
			session = sessionFactory.openSession();
			trx = session.beginTransaction();
			resultValue = ((Long) session.save(entity)).longValue();
			trx.commit();
		} catch (Exception e) {
			resultValue = INSERT_RESULT_KO;
			e.printStackTrace();
			try {
				trx.rollback();
			} catch (Exception ex) {
				e.printStackTrace();
			}
			logger.error("Error: " + e, e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error: " + e, e);
			}
		}
		return resultValue;
	}

	/**
	 * This method is a default implementation of above abstract method findAll().
	 * 
	 * @param entity class.
	 * @return the List of entities retrieved
	 */
	public default List<EntityInterface> findAll(Class<? extends EntityInterface> entityClass) {
		logger.info("class QuestionsRepository - method: findAll() - START");
		Session session = sessionFactory.openSession();
		logger.debug("open session with database");
		Transaction trx = null;
		List<EntityInterface> list = new ArrayList<>();
		try {
			trx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<EntityInterface> query = session
					.createQuery("SELECT qst FROM " + entityClass.getSimpleName() + " qst");
			list = query.getResultList();
			trx.commit();
		} catch (Exception ex) {
			logger.error("error in class QuestionsRepository on method -- findAll() -- ", ex);
			ex.printStackTrace();
			try {
				trx.rollback();
			} catch (Exception eex) {
				logger.error("error in class QuestionsRepository on method -- findAll() -- when execute rollback", eex);
				eex.printStackTrace();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
					logger.error("error in class QuestionsRepository on method -- findAll() -- when close session", ex);
					ex.printStackTrace();
				}
			}
		}

		logger.debug("method - findAll(Class<? extends EntityInterface> entityClass) - RETRIEVED: " + list.size() + " item from database");
		logger.debug("method - findAll(Class<? extends EntityInterface> entityClass) - RETURNED: " + list.toString());
		logger.info("method - findAll(Class<? extends EntityInterface> entityClass) - END");
		return list;
	}

	

	public default EntityInterface findById(long id, Class<? extends EntityInterface> entityClass) {
		logger.info("findById - START");
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		EntityInterface entity = null;
		try {
			// creating transaction object
			trx = session.beginTransaction();
			entity = (EntityInterface) session.find(entityClass, id);// search by specific class and id
			trx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entity = null;
			try {
				trx.rollback();
			} catch (Exception ex) {
				e.printStackTrace();
			}
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

	public default boolean update(EntityInterface ei) {
		logger.info("update - START - object to updtae: " + ei.toString());
		Session session = null;
		Transaction trx = null;
		boolean returnValue = false;
		try {
			session = sessionFactory.openSession();
			trx = session.beginTransaction();

			session.update(ei);

			trx.commit();
			returnValue = true;
		} catch (Exception e) {
			returnValue = false;
			e.printStackTrace();
			try {
				trx.rollback();
			} catch (Exception ex) {
				e.printStackTrace();
			}
			logger.error("Error: " + e, e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error: " + e, e);
			}
		}
		return returnValue;
	}
	
	/**
	 * This method delete an entity with specific id if it present into
	 * corresponding table database.
	 * 
	 * @param the entity id that i want deleted to table database.
	 * @return true if the Questions object is deleted of table database, false
	 *         otherwise
	 */
	public default boolean delete(Class<? extends EntityInterface> clazz, long id) {
		logger.info("delete - START - id object to delete: " + id);
		boolean returnValue = false;
		Session session = null;
		Transaction trx = null;
		try {
			session = sessionFactory.openSession();
			trx = session.beginTransaction();
			
			EntityInterface searchedEntityToDelete = this.findById(id, clazz);
			session.delete(searchedEntityToDelete);

			trx.commit();
			returnValue = true;
		} catch (Exception e) {
			returnValue = false;
			e.printStackTrace();
			try {
				trx.rollback();
			} catch (Exception ex) {
				e.printStackTrace();
			}
			logger.error("Error: " + e, e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error: " + e, e);
			}
		}
		return returnValue;
	}

	

	/**
	 * Provides to delete all recordes from database for the table name retrieved from the entity class received
	 * @param entityClass, an entity of a Class that extends EntityInterface 
	 * @return an int representative of the deleted rows
	 */
	public default int deleteAll(Class<? extends EntityInterface> entityClass) {
		logger.info("deleteAll - START");
		Session session = null;
		int deletedRows = 0;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<EntityInterface> query = session.createQuery("delete from " + entityClass.getSimpleName());
			deletedRows = query.executeUpdate();
			session.getTransaction().commit();
			logger.info("deleteAll - update executed!!!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("deleteAll - ERROR - catch: " + e, e);
			deletedRows = 0;
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("deleteAll - ERROR - finally: " + e, e);
			}
		}
		return deletedRows;
	}

	
	/**
	 * This method delete an entity with specific id if it present into
	 * corresponding table database.
	 * 
	 * @param the entity id that i want to delete in the database
	 * @return true if the Questions object is deleted of table database, false
	 *         otherwise
	 */
	public boolean delete(long id) ;
	public EntityInterface findById(long id);
	/**
	 *
	 * @return an int representative of the deleted rows
	 */
	public int deleteAll();
	public EntityInterface getEntityForTest();
	/**
	 * This method retrieve all entities from database.
	 * 
	 * @param
	 * @return the List of entities retrieved
	 */
	public List<EntityInterface> findAll();
}
