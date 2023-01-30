package centauri.academy.proxima.cerepro.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.SurveysReplies;

/**
 * 
 * @author Roberto
 * 
 *         This class handle the access to database (DAO pattern) for type
 *         SurveysReplies object.
 */
public class SurveyRepliesRepository implements RepositoryInterface{

	private static Logger log = LoggerFactory.getLogger(SurveyRepliesRepository.class);

//	private HibernateUtil hibernateUtil = HibernateUtil.getInstance();
//	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

//	/**
//	 * This method create a SurveyReplies object and save it into database.
//	 * 
//	 * @param the SurveyRepolies object that you want to save.
//	 * @return the id identifier created by database
//	 */
////	@Override
//	public Long create(SurveysReplies surveyReplies) {
//		log.info("class SurveyRepliesRepository - method: create(SurveysReplies surveyReplies) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		long retValue = 0;
//
//		try {
//			trx = session.beginTransaction();
//
//			retValue = ((Long) session.save(surveyReplies)).longValue();
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error(
//					"error in class SurveyRepliesRepository on method -- create(SurveysReplies surveyReplies) -- ",
//					ex);
//			ex.printStackTrace();
//			retValue = -1;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error(
//						"error in class SurveyRepliesRepository on method -- create(SurveysReplies surveyReplies) -- when execute rollback",
//						eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error(
//							"error in class SurveyRepliesRepository on method -- create(SurveysReplies surveyReplies) -- when close session",
//							ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("object SurveyReplies[ id=" + surveyReplies.getId() + ", idSurvey=" + surveyReplies.getSurveyId()
//				+ ", idUser= " + surveyReplies.getUserId() + ", startTime= " + surveyReplies.getStartTime()
//				+ ", endTime= " + surveyReplies.getEndTime() + ", answers= " + surveyReplies.getAnswer()
//				+ " ]" + " created succesfully!");
//		log.info("class SurveyRepliesRepository - method: create(SurveysReplies surveyReplies) - END");
//		return retValue;
//	}

//	/**
//	 * This method retrieve all SurveyQuestions object that persist into database.
//	 * 
//	 * @param void.
//	 * @return the List of SurveyQuestions object retrieved
//	 */
// 	@Override
//	public List<SurveysReplies> findAll() {
//		log.info("class SurveyRepliesRepository - method: findAll() - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		List<SurveysReplies> list = new ArrayList<SurveysReplies>();
//
//		try {
//			trx = session.beginTransaction();
//
//			@SuppressWarnings("unchecked")
//			Query<SurveysReplies> query = session.createQuery("SELECT sr FROM SurveysReplies sr");
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
//		log.info("class SurveyRepliesRepository - method: findAll() - END");
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
		return findAll(SurveysReplies.class);
	}
	
//	/**
//	 * This method retrieve a SurveyReplies object given it id into database.
//	 * 
//	 * @param the id of record that i want retrieved.
//	 * @return the object SurveyReplies associated with id
//	 */
//	@Override
//	public SurveysReplies findById(long id) {
//		log.info("class SurveyRepliesRepository - method: findById(T id) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		SurveysReplies surveyRepliesRetrieve = null;
//
//		try {
//			trx = session.beginTransaction();
//
//			surveyRepliesRetrieve = session.find(SurveysReplies.class, id);
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class SurveyRepliesRepository on method -- findById(T id) -- ");
//			ex.printStackTrace();
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error("error in class SurveyRepliesRepository on method -- findById(T id) -- when execute rollback",
//						eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error(
//							"error in class SurveyRepliesRepository on method -- findById(T id) -- when close session");
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("RETRIEVED 1 item from database:\n\t--> SurveyQuestions[ id=" + surveyRepliesRetrieve.getId()
//				+ ", idSurvey=" + surveyRepliesRetrieve.getSurveyId() + ", idUser= " + surveyRepliesRetrieve.getUserId() + 
//				", startTime= " + surveyRepliesRetrieve.getStartTime()
//				+ ", endTime= " + surveyRepliesRetrieve.getEndTime() + ", answers= " + surveyRepliesRetrieve.getAnswer()
//				+ " ]");
//		log.info("class SurveyRepliesRepository - method: findById(T id) - END");
//		return surveyRepliesRetrieve;
//	}
	
	/**
	 * This method retrieve a SurveyReplies object given it id into database.
	 * 
	 * @param the id of record that i want retrieved.
	 * @return the object SurveyReplies associated with id
	 */
	@Override
	public SurveysReplies findById(long id) {
		return (SurveysReplies) findById(id, SurveysReplies.class);
	}

//	/**
//	 * This method update a SurveysReplies object into database.
//	 * 
//	 * @param the object SurveysReplies that contains new values to update.
//	 * @return true if the SurveysReplies object is update into database, false otherwise
//	 */
//	@Override
//	public boolean update(EntityInterface entityInterf) {
//		log.info("class SurveyRepliesRepository - method: update(SurveysReplies surveyRepliesUpdated) - START");
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
//					"error in class SurveyRepliesRepository on method -- update(SurveysReplies surveyRepliesUpdated) -- ");
//			ex.printStackTrace();
//			retValue = false;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error(
//						"error in class SurveyRepliesRepository on method -- update(SurveysReplies surveyRepliesUpdated) -- when execute rollback",
//						eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error(
//							"error in class SurveyRepliesRepository on method -- update(SurveysReplies surveyRepliesUpdated) -- when close session");
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		SurveysReplies sr = (SurveysReplies) entityInterf;
//		log.info("object SurveysReplies[ id=" + sr.getId() + ", idSurvey="
//				+ sr.getSurveyId() + ", idUser= " + sr.getUserId() + 
//				", startTime= " + sr.getStartTime()
//				+ ", endTime= " + sr.getEndTime() + ", answers= " + sr.getAnswer()
//				+ " ]");
//		log.info("class SurveyRepliesRepository - method: update(SurveysQuestions surveyQuestionsUpdated) - END");
//		return retValue;
//	}

//	/**
//	 * This method delete a SurveysReplies object with specific id if it present into
//	 * corresponding table database.
//	 * 
//	 * @param the id Questions object that i want deleted to table database.
//	 * @return true if the Questions object is deleted of table database, false
//	 *         otherwise
//	 */
//	@Override
//	public boolean delete(long id) {
//		log.info("class SurveyRepliesRepository - method: delete(T id) - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		boolean retValue = true;
//
//		try {
//			trx = session.beginTransaction();
//
//			SurveysReplies surveysRepliesToDelete = session.find(SurveysReplies.class, id);
//			session.delete(surveysRepliesToDelete);
//
//			trx.commit();
//		} catch (Exception ex) {
//			log.error("error in class SurveyRepliesRepository on method -- delete(T id) -- ");
//			ex.printStackTrace();
//			retValue = false;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error("error in class SurveyRepliesRepository on method -- delete(T id) -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error("error in class SurveyRepliesRepository on method -- delete(T id) -- when close session");
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("object SurveysReplies[ SurveyQuestions with id = " + id + "]" + " deleted succesfully!");
//		log.info("class SurveyRepliesRepository - method: delete(T id) - END");
//		return retValue;
//	}
	
	/**
	 * This method delete a SurveysReplies object with specific id if it present into
	 * corresponding table database.
	 * 
	 * @param the id Questions object that i want deleted to table database.
	 * @return true if the Questions object is deleted of table database, false
	 *         otherwise
	 */
	public boolean delete(long id) {
		return delete(SurveysReplies.class, id);
	}
	

//	/**
//	 * This method delete all SurveysReplies object into corresponding table database.
//	 * 
//	 * @param void
//	 * @return an int that represents of SurveysReplies object deleted.
//	 */
//	public int deleteAll() {
//		log.info("class SurveyRepliesRepository - method: deleteAll() - START");
//		Session session = sessionFactory.openSession();
//		log.debug("open session with database");
//		Transaction trx = null;
//		int retValue = 0;
//
//		try {
//			trx = session.beginTransaction();
//
//			@SuppressWarnings("unchecked")
//			Query<SurveysReplies> query = session.createQuery("DELETE FROM SurveysReplies sr");
//			int returnedValue = query.executeUpdate();
//
//			trx.commit();
//			retValue = returnedValue;
//		} catch (Exception ex) {
//			log.error("error in class SurveyRepliesRepository on method -- deleteAll() -- ", ex);
//			ex.printStackTrace();
//			retValue = -1;
//			try {
//				trx.rollback();
//			} catch (Exception eex) {
//				log.error("error in class SurveyRepliesRepository on method -- deleteAll() -- when execute rollback", eex);
//				eex.printStackTrace();
//			}
//		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception ex) {
//					log.error("error in class SurveyRepliesRepository on method -- deleteAll() -- when close session", ex);
//					ex.printStackTrace();
//				}
//			}
//		}
//
//		log.info("deleteAll succesfully!");
//		log.info("class SurveyRepliesRepository - method: deleteAll() - END");
//		return retValue;
//	}
	/**
	 * This method delete all SurveysReplies object into corresponding table database.
	 * 
	 * @param void
	 * @return an int that represents of SurveysReplies object deleted.
	 */
	@Override
	public int deleteAll() {
		return deleteAll(SurveysReplies.class);
	}
	
	/**
	 *  This method provide an object (i.e mock object) that will want use for testing
	 * 
	 *  @param the id of Surveys object and the id of User object 
	 *  @return Object SurveysReplies with all instance field valorized except field id.
	 * 
	 * */
	public SurveysReplies getEntityForTest(long idSurveys, long idUser) {
		SurveysReplies sr = new SurveysReplies();
		sr.setSurveyId(idSurveys);
		sr.setUserId(idUser);
		sr.setStartTime(Timestamp.valueOf(LocalDateTime.now()));
		sr.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
		sr.setAnswer("answer");
		sr.setPdfFileName("pdf file");
		sr.setPoints("points");
		
		return sr;
	}
	
	/**
	 *  This method provide an object (i.e mock object) that will want use for testing
	 * 
	 *  @param the id of Surveys object and the id of User object 
	 *  @return Object SurveysReplies with all insance field valorized except fields id, surveyId and userId.
	 * 
	 * */
	@Override
	public SurveysReplies getEntityForTest() {
		SurveysReplies sr = new SurveysReplies();
		sr.setSurveyId(null);
		sr.setUserId(null);
		sr.setStartTime(Timestamp.valueOf(LocalDateTime.now()));
		sr.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
		sr.setAnswer("answer");
		sr.setPdfFileName("pdf file");
		sr.setPoints("points");
		
		return sr;
	}
}