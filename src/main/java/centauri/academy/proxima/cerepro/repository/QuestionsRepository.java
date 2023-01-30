package centauri.academy.proxima.cerepro.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Questions;

/**
 * 
 * @author Roberto
 * 
 *         This class handle the access to database (DAO pattern) for type
 *         Questions object.
 */
public class QuestionsRepository implements RepositoryInterface {

	private static Logger log = LoggerFactory.getLogger(QuestionsRepository.class);

//	private HibernateUtil hibernateUtil = HibernateUtil.getInstance();
//	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

//	/**
//	 * This method create a Questions object and save it into database.
//	 * 
//	 * @param the Questions object that you want to save.
//	 * @return the id identifier created by database
//	 * */
//	@Override
//	public Long create(EntityInterface entityInterf) {
//		log.info("class QuestionsRepository - method: create(Questions questions) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		long retValue = 0;
//
//		try {
//			trx = session.beginTransaction();
//
//			retValue = ((Long) session.save(entityInterf)).longValue();
//			
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class QuestionsRepository on method -- create(Questions questions) -- ", ex);
//			ex.printStackTrace();
//			retValue = -1;
//			try {
//				trx.rollback();
//			} catch(Exception eex) {
//				log.error("error in class QuestionsRepository on method -- create(Questions questions) -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null)
//			{
//				try {
//					session.close();
//				} catch(Exception ex) {
//					log.error("error in class QuestionsRepository on method -- create(Questions questions) -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//		
//		Questions questions = (Questions) entityInterf;
//		log.info( "object Questions[ " + questions.getId() + ", "+ questions.getDescription() +" ]" + " created succesfully!");
//		log.info("class QuestionsRepository - method: create(Questions questions) - END");
//		return retValue;
//	}

	/**
	 * This method retrieve all Questions object that persist into database.
	 * 
	 * @param void.
	 * @return the List of Questions object retrieved
	 */
	@Override
	public List<EntityInterface> findAll() {
		return findAll(Questions.class);
	}

//	/**
//	 * This method retrieve all Questions object that persist into database.
//	 * 
//	 * @param void.
//	 * @return the List of Questions object retrieved
//	 * */
//	@Override
//	public List<EntityInterface> findAll() {
//		log.info("class QuestionsRepository - method: findAll() - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		List<EntityInterface> list = new ArrayList<>();
//
//		try {
//			trx = session.beginTransaction();
//
//			@SuppressWarnings("unchecked")
//			Query<EntityInterface> query = session.createQuery("SELECT qst FROM Questions qst");
//			list = query.getResultList();
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class QuestionsRepository on method -- findAll() -- ", ex);
//			ex.printStackTrace();
//			try {
//				trx.rollback();
//			} catch(Exception eex) {
//				log.error("error in class QuestionsRepository on method -- findAll() -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null)
//			{
//				try {
//					session.close();
//				} catch(Exception ex) {
//					log.error("error in class QuestionsRepository on method -- findAll() -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//		
//		log.info( "RETRIEVED " + list.size() + " item from database");
//		log.info("class QuestionsRepository - method: findAll() - END");
//		return list;
//	}

//	/**
//	 * This method retrieve a Questions object given it id into database.
//	 *  
//	 * @param the id of record that i want retrieved.
//	 * @return the object Question associated with id
//	 * */
////	@Override
//	public EntityInterface findById(long id) {
//		log.info("class QuestionsRepository - method: findById(T id) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		Questions questionRetrieve = null;
//
//		try {
//			trx = session.beginTransaction();
//
//			questionRetrieve = session.find(Questions.class, id);
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class QuestionsRepository on method -- findById(T id) -- ", ex);
//			ex.printStackTrace();
//			try {
//				trx.rollback();
//			} catch(Exception eex) {
//				log.error("error in class QuestionsRepository on method -- findById(T id) -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null)
//			{
//				try {
//					session.close();
//				} catch(Exception ex) {
//					log.error("error in class QuestionsRepository on method -- findById(T id) -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//		
//		log.info( "RETRIEVED 1 item from database:\n\t--> Questions[ " + questionRetrieve.getId() + ", "+ questionRetrieve.getDescription() +" ]");
//		log.info("class QuestionsRepository - method: findById(T id) - END");
//		return questionRetrieve;
//	}

	/**
	 * This method retrieve a Questions object given it id into database.
	 * 
	 * @param the id of record that i want retrieved.
	 * @return the object Question associated with id
	 */
	@Override
	public Questions findById(long id) {
		return (Questions) findById(id, Questions.class);
	}

//	/**
//	 * This method update a Questions object into database.
//	 *  
//	 * @param the object Questions that contains new values to update.
//	 * @return true if the Questions object is update into database, false otherwise
//	 * */
////	@Override
//	public boolean update(EntityInterface entityInterf) {
//		log.info("class QuestionsRepository - method: update(Questions questionsUpdated) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		boolean retValue = true;
//
//		try {
//			trx = session.beginTransaction();
//
//			session.update(entityInterf);
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class QuestionsRepository on method -- update(Questions questions) -- ", ex);
//			ex.printStackTrace();
//			retValue = false;
//			try {
//				trx.rollback();
//			} catch(Exception eex) {
//				log.error("error in class QuestionsRepository on method -- update(Questions questionsUpdated) -- when execute rollback", eex);
//				eex.printStackTrace();
//			}			
//		} finally {
//			if (session != null)
//			{
//				try {
//					session.close();
//				} catch(Exception ex) {
//					log.error("error in class QuestionsRepository on method -- update(Questions questions) -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		Questions questions = (Questions) entityInterf;
//		log.info( "object Questions[ " + questions.getId() + ", "+ questions.getDescription() +" ]" + "updated succesfully!");
//		log.info("class QuestionsRepository - method: update(Questions questionsUpdated) - END");
//		return retValue;
//	}

//	/**
//	 * This method delete a Questions object with specific id if it present into corrisponding table database.
//	 *  
//	 * @param the id Questions object that i want deleted to table database.
//	 * @return true if the Questions object is deleted of table database, false otherwise
//	 * */
//	@Override
//	public boolean delete(long id) {
//		log.info("class QuestionsRepository - method: delete(T id) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		boolean retValue = true;
//
//		try {
//			trx = session.beginTransaction();
//
//			Questions questionToDelete = session.find(Questions.class, id);
//			session.delete(questionToDelete);
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class QuestionsRepository on method -- delete(T id) -- ", ex);
//			ex.printStackTrace();
//			retValue = false;
//			try {
//				trx.rollback();
//			} catch(Exception eex) {
//				log.error("error in class QuestionsRepository on method -- delete(T id) -- when execute rollback", eex);
//				eex.printStackTrace();
//			}			
//		} finally {
//			if (session != null)
//			{
//				try {
//					session.close();
//				} catch(Exception ex) {
//					log.error("error in class QuestionsRepository on method -- delete(T id) -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info( "object Questions[ Questions with id = " + id +"]" + "deleted succesfully!");
//		return retValue;
//	}
	
	/**
	 * This method delete a Questions object with specific id if it present into corrisponding table database.
	 *  
	 * @param the id Questions object that i want deleted to table database.
	 * @return true if the Questions object is deleted of table database, false otherwise
	 * */
	public boolean delete(long id) {
		return delete(Questions.class, id);
	}

//	/**
//	 * This method delete all Questions object into corresponding table database.
//	 *  
//	 * @param void
//	 * @return void
//	 * */
//	@Override
//	public int deleteAll() {
//		log.info("class QuestionsRepositoryImpl - method: deleteAll() - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		int retValue = 0;
//
//		try {
//			trx = session.beginTransaction();
//
//			@SuppressWarnings("unchecked")
//			Query<EntityInterface> query = session.createQuery("DELETE FROM Questions qst");
//			int returnedValue = query.executeUpdate();
//			
//			trx.commit();
//			retValue = returnedValue;
//		} catch (Exception ex) {
//			log.error("error in class QuestionsRepository on method -- deleteAll() -- ", ex);
//			ex.printStackTrace();
//			retValue = -1;
//			try {
//				trx.rollback();
//			} catch(Exception eex) {
//				
//				log.error("error in class QuestionsRepository on method -- deleteAll() -- when execute rollback", eex);
//				eex.printStackTrace();
//			}		
//		} finally {
//			if (session != null)
//			{
//				try {
//					session.close();
//				} catch(Exception ex) {
//					log.error("error in class QuestionsRepository on method -- deleteAll() -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info( "deleteAll succesfully!");
//		log.info("class QuestionsRepositoryImpl - method: deleteAll() - START");
//		return retValue;
//	}

	/**
	 * This method delete all Questions object into corresponding table database.
	 * 
	 * @param void
	 * @return void
	 */
	@Override
	public int deleteAll() {
		return deleteAll(Questions.class);
	}

	/**
	 * This method provide an object (i.e mock object) that will want use for
	 * testing
	 * 
	 * @param void
	 * @return Object Questions with all instance field not null except field id.
	 * 
	 */
	@Override
	public EntityInterface getEntityForTest() {
		Questions qst = new Questions();
		qst.setLabel("label of questions");
		qst.setDescription("description of questions");
		qst.setAnsa("ansa a");
		qst.setAnsb("ansa b");
		qst.setAnsc("ansa c");
		qst.setAnsd("ansa d");
		qst.setAnse("ansa e");
		qst.setAnsf("ansa f");
		qst.setAnsg("ansa g");
		qst.setAnsh("ansa h");
		qst.setCansa(true);
		qst.setCansb(true);
		qst.setCansc(true);
		qst.setCansd(true);
		qst.setCanse(true);
		qst.setCansf(true);
		qst.setCansg(true);
		qst.setCansh(true);
		qst.setFullAnswer("full answer");

		return qst;
	}
}