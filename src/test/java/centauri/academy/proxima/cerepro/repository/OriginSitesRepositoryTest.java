package centauri.academy.proxima.cerepro.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.OriginSites;


/**
 * 
 * @author maurizio - m.franco@proximanetwork.it
 *
 */
public class OriginSitesRepositoryTest {

	Logger logger = LoggerFactory.getLogger(OriginSitesRepositoryTest.class);

	@Before
	public void beforeTest() {
		logger.info("beforeTest - START");
		try {
			OriginSitesRepository yyy = new OriginSitesRepository();
			yyy.deleteAll();
			OriginSitesRepository xxx = new OriginSitesRepository();
			xxx.deleteAll();

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}

	}

//	@After
//	public void afterTest() {
//
//		try {
//			ItconsultantsRepository aaa = new ItconsultantsRepository();
//			aaa.deleteAll();
//			SurveyRepliesRepository bbb = new SurveyRepliesRepository();
//			bbb.deleteAll();
//			UserRepository yyy = new UserRepository();
//			yyy.deleteAll();
//			RolesRepository xxx = new RolesRepository();
//			xxx.deleteAll();
//
//		} catch (Exception e) {
//
//			e.getStackTrace();
//			logger.error("Error: " + e, e);
//
//		}
//
//	}

	@Test
	public void testInsert() {

//		System.out.println("Inizio insert test....");
		System.out.println("testInsert - START");
		try {

			OriginSitesRepository xxx = new OriginSitesRepository();
			OriginSites r = (OriginSites) xxx.getEntityForTest();
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

//		System.out.println("Inizio update test...");
		logger.info("Update - START");

		try {
			OriginSitesRepository xxx = new OriginSitesRepository();
			OriginSites r = (OriginSites) xxx.getEntityForTest();
			Long x = xxx.create(r);
			r.setLabel("aciaciac");
			r.setId(x);
			xxx.update(r);
			OriginSites r2 = (OriginSites) xxx.findById(x, OriginSites.class);
//		System.out.println("Fine del test update");

			logger.info("Update - FINISH");
			assertTrue(r2.getLabel().equals("aciaciac"));

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}

	}

	@Test
	public void testSelectById() {

//		System.out.println("Inizio select by id test...");
		logger.info("Select by id - START");

		try {
			OriginSitesRepository xxx = new OriginSitesRepository();
			OriginSites r = (OriginSites) xxx.getEntityForTest();
			Long x = xxx.create(r);
			OriginSites r2 = (OriginSites) xxx.findById(x, OriginSites.class);
//		System.out.println("Fine del test select by id");
			logger.info("Select by id - FINISH");

			assertTrue(r2.getId().equals(x));

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}

	}
//
	@Test
	public void testSelectAll() {

//		System.out.println("Inizio select all test...");
		logger.info("Select all - START");

		try {

			OriginSitesRepository xxx = new OriginSitesRepository();
			OriginSites r = (OriginSites) xxx.getEntityForTest();
			xxx.create(r);
//		System.out.println("Fine del test select all");
			logger.info("Select all - FINISH");

			assertTrue(xxx.findAll(OriginSites.class).size() == 1);

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}

	}

	@Test
	public void testDeleteById() {

//		System.out.println("Inizio delete by id test...");
		logger.info("Delete by id - START");

		try {
			OriginSitesRepository xxx = new OriginSitesRepository();
			OriginSites r = (OriginSites) xxx.getEntityForTest();
			Long x = xxx.create(r);
			r.setId(x);
			xxx.delete(x);
//		System.out.println("Fine del test delete by id");
			logger.info("Delete by id - FINISH");

			assertTrue(xxx.findAll(OriginSites.class).size() == 0);

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}

	}

	@Test
	public void testDeleteAll() {

     	System.out.println("Inizio delete all test...");
		logger.info("Delete all - START");

		try {
			OriginSitesRepository xxx = new OriginSitesRepository();
			OriginSites r = (OriginSites) xxx.getEntityForTest();
			xxx.create(r);
			xxx.deleteAll();
			System.out.println("Fine del test delete all");
			logger.info("Delete all - FINISH");

			assertTrue(xxx.findAll(OriginSites.class).size() == 0);

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}
	}

}
