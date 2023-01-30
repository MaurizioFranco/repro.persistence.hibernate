package centauri.academy.proxima.cerepro.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;

/**
 * 
 * @author Roberto
 * 
 *         This class handle the access to database (DAO pattern) for type
 *         SurveysQuestions object.
 */
public class SurveyQuestionsRepository implements RepositoryInterface{

	private static Logger log = LoggerFactory.getLogger(SurveyQuestionsRepository.class);

//	private HibernateUtil hibernateUtil = HibernateUtil.getInstance();
//	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

//	/**
//	 * This method create a SurveyQuestions object and save it into database.
//	 * 
//	 * @param the SurveyQuestions object that you want to save.
//	 * @return the id identifier created by database
//	 */
//	@Override
//	public Long create(EntityInterface entityInterf) {
//		log.info("class SurveyQuestionsRepository - method: create(SurveysQuestions surveyQuestions) - START");
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
//			log.error(
//					"error in class SurveyQuestionsRepository on method -- create(SurveyQuestions surveyQuestions) -- ",
//					ex);
//			ex.printStackTrace();
//			retValue = -1;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error(
//						"error in class QuestionsRepository on method -- create(SurveyQuestions surveyQuestions) -- when execute rollback",
//						eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error(
//							"error in class QuestionsRepository on method -- create(SurveyQuestions surveyQuestions) -- when close session",
//							ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		SurveysQuestions surveyQuestions = (SurveysQuestions) entityInterf;
//		log.info("object SurveyQuestions[ id=" + surveyQuestions.getId() + ", idSurvey=" + surveyQuestions.getSurveyId()
//				+ ", idQuestions= " + surveyQuestions.getQuestionId() + ", positions = " + surveyQuestions.getPosition()
//				+ " ]" + " created succesfully!");
//		log.info("class SurveyQuestionsRepository - method: create(SurveysQuestions surveyQuestions) - END");
//		return retValue;
//	}

//	/**
//	 * This method retrieve all SurveyQuestions object that persist into database.
//	 * 
//	 * @param void.
//	 * @return the List of SurveyQuestions object retrieved
//	 */
//	@Override
//	public List<EntityInterface> findAll() {
//		log.info("class SurveyQuestionsRepository - method: findAll() - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		List<EntityInterface> list = new ArrayList<>();
//
//		try {
//			trx = session.beginTransaction();
//
//			@SuppressWarnings("unchecked")
//			Query<EntityInterface> query = session.createQuery("SELECT sq FROM SurveysQuestions sq");
//			list = query.getResultList();
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class SurveyQuestionsRepositoryImpl on method -- findAll() -- ");
//			ex.printStackTrace();
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error("error in class QuestionsRepository on method -- findAll() -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error("error in class QuestionsRepositoryImpl on method -- findAll() -- when close session");
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("RETRIEVED " + list.size() + " item from database");
//		log.info("class SurveyQuestionsRepository - method: findAll() - END");
//		return list;
//	}

	/**
	 * This method retrieve all SurveyQuestions object that persist into database.
	 * 
	 * @param void.
	 * @return the List of SurveyQuestions object retrieved
	 */
	@Override
	public List<EntityInterface> findAll(){
		return findAll(SurveysQuestions.class);
	}
	
//	/**
//	 * This method retrieve a SurveyQuestions object given it id into database.
//	 * 
//	 * @param the id of record that i want retrieved.
//	 * @return the object SurveyQuestion associated with id
//	 */
//	@Override
//	public EntityInterface findById(long id) {
//		log.info("class SurveyQuestionsRepository - method: findById(T id) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		SurveysQuestions surveyQuestionRetrieve = null;
//
//		try {
//			trx = session.beginTransaction();
//
//			surveyQuestionRetrieve = session.find(SurveysQuestions.class, id);
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class SurveyQuestionsRepositoryImpl on method -- findById(T id) -- ");
//			ex.printStackTrace();
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error("error in class QuestionsRepository on method -- findById(T id) -- when execute rollback",
//						eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error(
//							"error in class QuestionsRepositoryImpl on method -- findById(T id) -- when close session");
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("RETRIEVED 1 item from database:\n\t--> SurveyQuestions[ id=" + surveyQuestionRetrieve.getId()
//				+ ", idSurvey=" + surveyQuestionRetrieve.getSurveyId() + ", idQuestions= "
//				+ surveyQuestionRetrieve.getQuestionId() + ", positions = " + surveyQuestionRetrieve.getPosition()
//				+ " ]");
//		log.info("class SurveyQuestionsRepository - method: findById(T id) - END");
//		return surveyQuestionRetrieve;
//	}
	
	/**
	 * This method retrieve a SurveyQuestions object given it id into database.
	 * 
	 * @param the id of record that i want retrieved.
	 * @return the object SurveyQuestion associated with id
	 */
	@Override
	public SurveysQuestions findById(long id) {
		return (SurveysQuestions) findById(id, SurveysQuestions.class);
	}
	
//	/**
//	 * This method update a Questions object into database.
//	 * 
//	 * @param the object Questions that contains new values to update.
//	 * @return true if the Questions object is update into database, false otherwise
//	 */
//	@Override
//	public boolean update(EntityInterface entityInterf) {
//		log.info("class SurveyQuestionsRepository - method: update(SurveysQuestions surveyQuestionsUpdated) - START");
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
//			log.error(
//					"error in class QuestionsRepositoryImpl on method -- update(SurveysQuestions surveyQuestionsUpdated) -- ");
//			ex.printStackTrace();
//			retValue = false;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error(
//						"error in class QuestionsRepository on method -- update(SurveysQuestions surveyQuestionsUpdated) -- when execute rollback",
//						eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error(
//							"error in class QuestionsRepositoryImpl on method -- update(SurveysQuestions surveyQuestionsUpdated) -- when close session");
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		SurveysQuestions surveyQuestionsUpdated = (SurveysQuestions) entityInterf;
//		log.info("object SurveyQuestions[ id=" + surveyQuestionsUpdated.getId() + ", idSurvey="
//				+ surveyQuestionsUpdated.getSurveyId() + " , idQuestions=" + surveyQuestionsUpdated.getQuestionId()
//				+ ", positions=" + surveyQuestionsUpdated.getPosition() + " ]");
//		log.info("class SurveyQuestionsRepository - method: update(SurveysQuestions surveyQuestionsUpdated) - END");
//		return retValue;
//	}

//	/**
//	 * This method delete a Questions object with specific id if it present into
//	 * corresponding table database.
//	 * 
//	 * @param the id Questions object that i want deleted to table database.
//	 * @return true if the Questions object is deleted of table database, false
//	 *         otherwise
//	 */
//	@Override
//	public boolean delete(long id) {
//		log.info("class SurveyQuestionsRepository - method: delete(T id) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		boolean retValue = true;
//
//		try {
//			trx = session.beginTransaction();
//
//			SurveysQuestions surveyQuestionToDelete = session.find(SurveysQuestions.class, id);
//			session.delete(surveyQuestionToDelete);
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class SurveyQuestionsRepositoryImpl on method -- delete(T id) -- ");
//			ex.printStackTrace();
//			retValue = false;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error("error in class QuestionsRepository on method -- delete(T id) -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error("error in class QuestionsRepositoryImpl on method -- delete(T id) -- when close session");
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("object SurveyQuestions[ SurveyQuestions with id = " + id + "]" + " deleted succesfully!");
//		log.info("class SurveyQuestionsRepository - method: delete(T id) - END");
//		return retValue;
//	}
	
    /**
	 * This method delete a Questions object with specific id if it present into
	 * corresponding table database.
	 * 
	 * @param the id Questions object that i want deleted to table database.
	 * @return true if the Questions object is deleted of table database, false
	 *         otherwise
	 */
	public boolean delete(long id) {
		return delete(SurveysQuestions.class, id);
	}

//	/**
//	 * This method delete all SurveyQuestions object into corresponding table
//	 * database.
//	 * 
//	 * @param void
//	 * @return an int that represents of SurveysQuestions object deleted.
//	 */
//	@Override
//	public int deleteAll() {
//		log.info("class SurveyQuestionsRepository - method: deleteAll() - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		int retValue = 0;
//
//		try {
//			trx = session.beginTransaction();
//
//			@SuppressWarnings("unchecked")
//			Query<EntityInterface> query = session.createQuery("DELETE FROM SurveysQuestions srvQst");
//			int returnedValue = query.executeUpdate();
//
//			trx.commit();
//			retValue = returnedValue;
//		} catch (Exception ex) {
//			log.error("error in class SurveyQuestionsRepositoryImpl on method -- deleteAll() -- ", ex);
//			ex.printStackTrace();
//			retValue = -1;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error("error in class QuestionsRepository on method -- deleteAll() -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error("error in class QuestionsRepositoryImpl on method -- deleteAll() -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("deleteAll succesfully!");
//		log.info("class SurveyQuestionsRepository - method: deleteAll() - END");
//		return retValue;
//	}
	
	/**
	 * This method delete all SurveyQuestions object into corresponding table
	 * database.
	 * 
	 * @param void
	 * @return an int that represents of SurveysQuestions object deleted.
	 */
	@Override
	public int deleteAll() {
		return deleteAll(SurveysQuestions.class);
	}
	
	/**
	 * This method provide an object (i.e mock object) that will want use for testing
	 * 
	 *  @param the id of Questions object and the id of Surveys object 
	 *  @return Object SurveysQuestions with all instance field valorized except field id.
	 * 
	 * */
	public EntityInterface getEntityForTest(long idQuestions, long idSurveys) {
		SurveysQuestions sv = new SurveysQuestions();
		sv.setSurveyId(idSurveys);
		sv.setQuestionId(idQuestions);
		sv.setPosition(1);
		
		return sv;
	}
	
	/**
	 * This method provide an object (i.e mock object) that will want use for testing
	 * 
	 *  @param the id of Questions object and the id of Surveys object 
	 *  @return Object SurveysQuestions with all instance field valorized except fields id, surveyIs and UserId.
	 * 
	 * */
	@Deprecated
	@Override
	public EntityInterface getEntityForTest() {
		SurveysQuestions sv = new SurveysQuestions();
		sv.setSurveyId(null);
		sv.setQuestionId(null);
		sv.setPosition(1);
		
		return sv;
	}
}