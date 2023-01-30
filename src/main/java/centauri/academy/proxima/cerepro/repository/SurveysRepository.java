package centauri.academy.proxima.cerepro.repository;

import java.util.List;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.Surveys;
import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.util.HibernateUtil;

/**
 * 
 * @author daniel -
 *
 */
public class SurveysRepository implements RepositoryInterface {

//	public final static Long INSERT_RESULT_KO = -1L;
	public HibernateUtil hibernateUtil = HibernateUtil.getInstance();
	public SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

	Logger logger = LoggerFactory.getLogger("SurveysRepository");

	public EntityInterface getEntityForTest() {
		Surveys srv = new Surveys();
		srv.setDescription("surveys description");
		srv.setLabel("surveys label");
		srv.setTime(1);
		return srv;
	}

	public List<EntityInterface> findAll() {
		return findAll(Surveys.class);
	}

	public EntityInterface findById(long id) {
		return findById(id, Surveys.class);
	}

	public int deleteAll() {
		return deleteAll(Surveys.class);
	}

	public boolean delete(long id) {
		return delete(Surveys.class, id);
	}

//	public Long create(EntityInterface newS) {
//		logger.info("create - inizio ");
//		Session session = sessionFactory.openSession();
//
//		long returnValue = 0;
//
//		try {
//
//			Transaction t = session.beginTransaction();
//
//			returnValue = (Long) session.save(newS); // ritorna ID del oggetto
//
//			t.commit();
//			logger.info("StoreData - salvataggio completato!");
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//			returnValue = -1;
//		} finally {
//			try {
//				if (session != null) {
//					session.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				logger.error("Error: " + e, e);
//			}
//			return returnValue;
//		}
//
//	}// chiudo metodo

//	public boolean delete(long id) { 	
//		logger.info("deleteSurveyById - START");
//		Session session = sessionFactory.openSession();
//		boolean retValue = true;
//		try {
//			Transaction t = session.beginTransaction();
//			// find() returns a User that have the specific "id"
//			Surveys surveysToDelete = session.find(Surveys.class, id);
//
//			session.delete(surveysToDelete);
//			t.commit();
//
//		} catch (Exception e) {
//
//			logger.error("Error: " + e, e);
//			// System.out.println(e.getMessage());
//			e.printStackTrace();
//			 retValue = false;
//
//		} finally {
//
//			try {
//				session.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//				logger.error("Error: " + e, e);
//			}
//
//		}
//		return retValue;
//	}

//	public boolean update(EntityInterface entity) {
//		logger.info("updateSurvey - START");
//		Session session = sessionFactory.openSession();
//		boolean retValue = true;
//		try {
//			Transaction t = session.beginTransaction();
//			// find() returns a User that have the specific "id"
//
//			session.update(entity);
//
//			t.commit();
//		} catch (Exception e) {
//
//			logger.error("Error: " + e, e);
//			// System.out.println(e.getMessage());
//			e.printStackTrace();
//			retValue = false;
//
//		} finally {
//
//			try {
//				session.close();
//			} catch (Exception e) {
//
//				e.printStackTrace();
//				logger.error("Error: " + e, e);
//			}
//
//		}
//		return retValue ;
//	}

//	public  EntityInterface findById(long id) { 
//
//		logger.info("getSurveyById - START");
//		Session session = sessionFactory.openSession();
//		Transaction t = null;
//		Surveys surveysFounded = null;
//		try {
//		 t = session.beginTransaction();
//		// find() returns a User that have the specific "id"
//		 surveysFounded = session.find(Surveys.class, id);
//		t.commit();
//	} catch (Exception ex) {
//		logger.error("error in class QuestionsRepository on method -- findById(T id) -- ", ex);
//		ex.printStackTrace();
//		try {
//			t.rollback();
//		} catch(Exception eex) {
//			logger.error("error in class QuestionsRepository on method -- findById(T id) -- when execute rollback", eex);
//			eex.printStackTrace();
//		}
//} finally {
//	if (session != null)
//	{
//		try {
//		session.close();
//	} catch(Exception ex) {
//		logger.error("error in class QuestionsRepository on method -- findById(T id) -- when close session", ex);
//		ex.printStackTrace();
//	}
//}
//}
//
//		return surveysFounded;
//	}

//	public int deleteAll() {
//		Session session = sessionFactory.openSession();
//		logger.debug("open session with database");
//		Transaction trx = null;
//		int retValue = 0;
//
//		try {
//			trx = session.beginTransaction();
//
//			Query<Surveys> query = session.createQuery("DELETE FROM Surveys srv");
//			int returnedValue = query.executeUpdate();
//
//			trx.commit();
//			retValue = returnedValue;
//		} catch (Exception ex) {
//			trx.rollback();
//			ex.printStackTrace();
//			
//			logger.error("error in class SurveysRepository on method -- delete(T id) -- ");
//			retValue = -1;
//		} finally {
//			if (session != null)
//				session.close();
//			logger.debug("close session with database");
//		}
//
//		logger.info("deleteAll succesfully!");
//		return retValue;
//	}

}