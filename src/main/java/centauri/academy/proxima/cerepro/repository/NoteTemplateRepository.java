/**
 * 
 */
package centauri.academy.proxima.cerepro.repository;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.NoteTemplate;


/**
 * @author Vincenzo
 *
 */

public class NoteTemplateRepository implements RepositoryInterface{
	private Logger logger = LoggerFactory.getLogger(NoteTemplateRepository.class);

	
	/**
	 * 
	 * */
	@Override
	public boolean delete(long id) {
		return delete(NoteTemplate.class, id);
	}
	/**
	 * 
	 * */
	@Override
	public NoteTemplate findById(long id) {
		return (NoteTemplate) findById(id,NoteTemplate.class);
	}

	/**
	 * This method retrive all Questions object that persist into database.
	 * 
	 * @param void.
	 * @return the List of Questions object retrived
	 */
	@Override
	public List<EntityInterface> findAll(){
		return findAll(NoteTemplate.class);
	}
	
	/**
	 * 
	 * */
	@Override
	public int deleteAll() {
		return deleteAll(NoteTemplate.class);
	}
	public  EntityInterface findByTitle(String title) {
		logger.info("findByTitle - START");
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		EntityInterface entity = null;
		try {
			// creating transaction object
			String hql = "SELECT obj FROM NoteTemplate obj WHERE title = '" + title + "'";
			Query<EntityInterface> query = session.createQuery(hql);
			List results = query.list(); 
//			EntityInterface enti = query.uniqueResult();
			logger.info("findByTitle - DEBUG - results.size(): " + results.size());
			if(results.size() > 0) {
				entity = (EntityInterface) results.get(0);
			} else {
				entity = null;
			}
			logger.info("findByTitle - DEBUG - entity: " + entity);
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
	
	
	/**
	 * 
	 * */
	public NoteTemplate getEntityForTest() {
		Random rand = new Random(); 
		long numRand =  rand.nextLong() + System.currentTimeMillis();
		NoteTemplate ntp = new NoteTemplate();
		ntp.setTitle("title" + numRand); // because field title in db is unique
		ntp.setContent("content");
		return ntp;
	}
	
}
