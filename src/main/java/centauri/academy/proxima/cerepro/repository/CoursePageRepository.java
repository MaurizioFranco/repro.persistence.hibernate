/**
 * 
 */
package centauri.academy.proxima.cerepro.repository;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.CoursePage;
import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.CoursePage;
import centauri.academy.proxima.cerepro.util.HibernateUtil;

/**
 * @author Mart
 *
 */
public class CoursePageRepository implements RepositoryInterface{

	Logger logger = LoggerFactory.getLogger("CoursePageRepository");

	public EntityInterface getEntityForTest() {
		CoursePage cp = new CoursePage();
		cp.setTitle("title");
		cp.setCode("codeX");
		cp.setBody_text("ciao a tutti");
		cp.setFile_name("candidate");
		return (EntityInterface) cp;
	}
	public List<EntityInterface> findAll() {
		return findAll(CoursePage.class);
	}

	public EntityInterface findById(long id) {
		return findById(id, CoursePage.class);
	}

	public int deleteAll() {
		return deleteAll(CoursePage.class);
	}

	public boolean delete(long id) {
		return delete(CoursePage.class, id);
	}

	public  EntityInterface findByCode(String code) {
		logger.info("findByCode - START");
		Session session = (Session) sessionFactory.openSession();
		Transaction trx = null;
		EntityInterface entity = null;
		try {
			String hql = "SELECT obj FROM CoursePage obj WHERE code = '" + code + "'";
			Query<EntityInterface> query = session.createQuery(hql);
			List results = query.list(); 
			logger.info("findByCode - DEBUG - results.size(): " + results.size());
			if(results.size() > 0) {
				entity = (EntityInterface) results.get(0);
			} else {
				entity = null;
			}
			logger.info("findByCode - DEBUG - entity: " + entity);

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
	
}
