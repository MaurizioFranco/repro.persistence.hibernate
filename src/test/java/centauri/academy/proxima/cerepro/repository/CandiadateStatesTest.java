package centauri.academy.proxima.cerepro.repository;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.entity.CandidateStates;

/**
 * 
 * Unit test for CandidateStatesRespository
 *
 */
public class CandiadateStatesTest {
	private long insertResult;
	private long xRolesResult;
	private static CandidateStatesRepository candidateRepository;
	private static RolesRepository uRolesRepository;
	private CandidateStates cStates;
	private Roles usroles;
// Configuring logger to use instead of System.out.println()
	private static Logger logger = LoggerFactory.getLogger(CandiadateStatesTest.class);

//	@BeforeClass // Only once
//	public static void beforeAllTests() {
//		candidateRepository = new CandidateStatesRespository();
//		uRolesRepository = new RolesRepository();
//	}
//
//	@Before // before every Test (is possible use @After as an after test method
//	public void beforeTest() {
//		// Delete Roles table
//		candidateRepository.deleteAll();
//		uRolesRepository.deleteAll();
//		
//		usroles = uRolesRepository.getEntityForTest();
//		xRolesResult = uRolesRepository.create(usroles);
////		// Delete the complete table
//		// Fill the Entity CandidateStates
////		@SuppressWarnings("deprecation")
////		Date myDate = new Date(2014, 02, 11);
////		Timestamp tstamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
////		cStates = new CandidateStates();
////		cStates.setEmail("email2@email.com");
////		cStates.setPassword("pass_word");
////		cStates.setFirstname("first_name");
////		cStates.setLastname("last_name");
////		cStates.setDateofbirth(myDate);
////		cStates.setRegdate(tstamp);
////		cStates.setRole(usroles.getLevel());
////		cStates.setImgpath("prova");
////		cStates.setNote("note_test");
////		cStates.setenabled(0);
//		cStates = candidateRepository.getEntityForTest(usroles.getId());
//		insertResult = candidateRepository.create(cStates);
//// Test if the Roles Entity have something inside
//	}
//	
//	@After
//	public void afterTest() {
//		
//		candidateRepository.deleteAll();
//		uRolesRepository.deleteAll();
//	}
//
//	@Test
//	public void testSaveNewCandidateStatesOk() {// you should be make shure the table roles have something inside
//		logger.info("testSaveNewCandidateStatesOk - START");
//		logger.info("testSaveNewCandidateStatesOk - DEBUG - insertResult: " + insertResult);
//		try {
//
//			assertTrue(insertResult > 0);
//			logger.info("testSaveNewCandidateStatesOk - FINISHED");
//
//		} catch (Exception e) {
//
//			e.getStackTrace();
//			logger.error("Error: " + e, e);
//
//		}
//	}
//
//	@Test
//	public void testDeleteCandidateStatesById() {
//		logger.info("testDeleteCandidateStates - START");
//		logger.info("testDeleteCandidateStates - DEBUG - insertResult: " + insertResult);
//		try {
//
//			candidateRepository.delete(insertResult);
//			cStates = (CandidateStates)candidateRepository.findById(insertResult);
//			assertTrue(cStates == null);
//			logger.info("testDeleteCandidateStates - FINISHED");
//
//		} catch (Exception e) {
//
//			e.getStackTrace();
//			logger.error("Error: " + e, e);
//
//		}
//	}
//
//	@Test
//	public void testSelectCandidateStatesById() {
//		logger.info("testSelectCandidateStatesById - START");
//		logger.info("testSelectCandidateStatesById - DEBUG - insertResult: " + insertResult);
//		try {
//
//			CandidateStates cStates2 = (CandidateStates)candidateRepository.findById(insertResult);
//			assertTrue(cStates2.getId().equals(insertResult));
//			logger.info("testSelectCandidateStatesById - FINISHED");
//
//		} catch (Exception e) {
//
//			e.getStackTrace();
//			logger.error("Error: " + e, e);
//
//		}
//	}
//
//	@Test
//	public void testUpdateCandidateStates() {
//		logger.info("testUpdateCandidateStates - START");
//		logger.info("testUpdateCandidateStates - DEBUG - insertResult: " + insertResult);
////		CandidateStates cStates2 = new CandidateStates();
//
//		try {
//
////			Date myDate = new Date(2014, 02, 11);
////			Timestamp tstamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
////			cStates2.setId(2L);
////			cStates2.setEmail("emailtestxxx@email.com");
////			cStates2.setPassword("pass_word");
////			cStates2.setFirstname("first_name");
////			cStates2.setLastname("last_name");
////			cStates2.setDateofbirth(myDate);
////			cStates2.setRegdate(tstamp);
////			cStates2.setRole(2);
////			cStates2.setImgpath("prova");
////			cStates2.setNote("note_test");
////			cStates2.setenabled(0);
////			long id = candidateRepository.saveNewCandidateStates(cStates2);
//
//			cStates = (CandidateStates)candidateRepository.findAll().get(0);
//			cStates.setStatus_color("blue");
////			cStates2.setId(id);
//			// cStates updated
//			candidateRepository.update(cStates);
//			// get updated object
//			CandidateStates cStates3 = (CandidateStates)candidateRepository.findById(cStates.getId());
//			logger.info("*********" + cStates3.getStatus_color() + "**********");
//			assertTrue(cStates3.getStatus_color().equals("blue"));
//			logger.info("testUpdateCandidateStates - FINISHED");
//
//		} catch (Exception e) {
//
//			e.getStackTrace();
//			logger.error("Error: " + e, e);
//
//		}
//	}
//
//	@Test
//	public void testSelectAllCandidateStatess() {
//		logger.info("testSelectAllCandidateStates - START");
//		logger.info("testUpdateCandidateStates - DEBUG - insertResult: " + insertResult);
//
//		try {
//
//			assertTrue(candidateRepository.findAll().size() == 1);
//
//		} catch (Exception e) {
//
//			e.getStackTrace();
//			logger.error("Error: " + e, e);
//			logger.info("testSelectAllCandidateStatess - FINISHED");
//
//		}
//
//	}
//
//	@Test
//	public void testDeleteAll() {
//		logger.info("DeleteAll - START");
//
//		try {
//
//			candidateRepository.deleteAll();
//			logger.info("DeleteAll - FINISH");
//			assertTrue(candidateRepository.findAll().size() == 0);
//
//		} catch (Exception e) {
//
//			e.getStackTrace();
//			logger.error("Error: " + e, e);
//
//		}
//	}

}// End class
