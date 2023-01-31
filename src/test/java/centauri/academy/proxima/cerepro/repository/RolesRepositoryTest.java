package centauri.academy.proxima.cerepro.repository;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.Roles;

/**
 * 
 * @author maurizio - m.franco@proximanetwork.it
 *
 */
public class RolesRepositoryTest {

	Logger logger = LoggerFactory.getLogger(RolesRepositoryTest.class);

	@Inject
	RolesRepository xxx ;
	
	@Before
	@After
	public void beforeTest() {
		logger.info("beforeTest - START");
		try {
			SurveyRepliesRepository bbb = new SurveyRepliesRepository();
			bbb.deleteAll();
			UserRepository yyy = new UserRepository();
			yyy.deleteAll();
			
			xxx.deleteAll();

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}

	}	

	@Test
	public void testInsert() {

//		System.out.println("Inizio insert test....");
		System.out.println("testInsert - START");
		try {

			Roles r = (Roles) xxx.getEntityForTest();
			xxx.create(r);
//		System.out.println("Fine del test insert");
			System.out.println("testInsert - FINISH");
			assertTrue(xxx.findAll().size() == 1);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error: " + e);

		}

	}

	@Test
	public void testUpdate() {
		logger.info("testUpdate - START");
		try {
			int levelToUpdate = 25;
			Roles r = (Roles) xxx.getEntityForTest();
			Long x = xxx.create(r);
			r.setLevel(levelToUpdate);
			r.setId(x);
			xxx.update(r);
			Roles r2 = (Roles) xxx.findById(x);
			logger.info("testUpdate - FINISH");
			assertTrue(r2.getLevel() == levelToUpdate);
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("testUpdate - ERROR - : " + e, e);
		}
	}

	@Test
	public void testSelectById() {
		logger.info("testSelectById - START");
		try {
			Roles r = (Roles) xxx.getEntityForTest();
			Long x = xxx.create(r);
			Roles r2 = (Roles) xxx.findById(x);
			logger.info("testSelectById - DEBUG");
			assertTrue(r2.getId().equals(x));
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("testSelectById - ERROR: " + e, e);
		}
	}

	@Test
	public void testSelectAll() {
		logger.info("testSelectAll - START");
		try {
			Roles r = (Roles) xxx.getEntityForTest();
			xxx.create(r);
			logger.info("testSelectAll - DEBUG");
			assertTrue(xxx.findAll().size() == 1);
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("testSelectAll - ERROR: " + e, e);
		}
	}

	@Test
	public void testDeleteById() {
		logger.info("testDeleteById - START");

		try {
			Roles r = (Roles) xxx.getEntityForTest();
			Long x = xxx.create(r);
			assertTrue(x.longValue()>0);
			boolean deleteResult = xxx.delete(x);
			assertTrue(deleteResult);
			logger.info("testDeleteById - DEBUG - xxx.findAll().size(): " + xxx.findAll().size());
			assertTrue(xxx.findAll().size() == 0);
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("testDeleteById - ERROR: " + e, e);
		}
	}

	@Test
	public void testDeleteAll() {
		logger.info("testDeleteAll - START");
		try {
			Roles r = (Roles) xxx.getEntityForTest();
			xxx.create(r);
			xxx.deleteAll();
			logger.info("testDeleteAll - DEBUG");
			assertTrue(xxx.findAll(Roles.class).size() == 0);
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("testDeleteAll - ERROR: " + e, e);
		}
	}

}
