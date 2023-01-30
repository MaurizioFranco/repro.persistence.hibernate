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
import centauri.academy.proxima.cerepro.entity.User;

/**
 * 
 * Unit test for UserRepository
 *
 */
public class UserRepositoryTest {
	private long insertResult;
	private long xRolesResult;
	private static UserRepository uRepository;
	private static RolesRepository uRolesRepository;
	private static CandidateStatesRepository candidateStatesRepository;
	private User usr;
	private Roles usroles;
// Configuring logger to use instead of System.out.println()
	private static Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

	@BeforeClass // Only once
	public static void beforeAllTests() {
		uRepository = new UserRepository();
		uRolesRepository = new RolesRepository();
		candidateStatesRepository = new CandidateStatesRepository();
	}

	@Before // before every Test (is possible use @After as an after test method
	public void beforeTest() {
		// Delete Roles table
		uRepository.deleteAll();
		candidateStatesRepository.deleteAll();
		uRolesRepository.deleteAll();
		usroles = uRolesRepository.getEntityForTest();
		xRolesResult = uRolesRepository.create(usroles);
//		// Delete the complete table
		// Fill the Entity user
//		@SuppressWarnings("deprecation")
//		Date myDate = new Date(2014, 02, 11);
//		Timestamp tstamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
//		usr = new User();
//		usr.setEmail("email2@email.com");
//		usr.setPassword("pass_word");
//		usr.setFirstname("first_name");
//		usr.setLastname("last_name");
//		usr.setDateofbirth(myDate);
//		usr.setRegdate(tstamp);
//		usr.setRole(usroles.getLevel());
//		usr.setImgpath("prova");
//		usr.setNote("note_test");
//		usr.setenabled(0);
		
// Test if the Roles Entity have something inside
	}
	
	@After
	public void afterTest() {
		candidateStatesRepository.deleteAll();
		uRepository.deleteAll();
		uRolesRepository.deleteAll();
	}

	@Test
	public void testSaveNewUserOk() {// you should be make shure the table roles have something inside
		logger.info("testSaveNewUserOk - START");
		logger.info("testSaveNewUserOk - DEBUG - insertResult: " + insertResult);
		try {
			usr = uRepository.getEntityForTest(usroles.getLevel());
			insertResult = uRepository.create(usr);
			assertTrue(insertResult > 0);
			logger.info("testSaveNewUserOk - FINISHED");

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}
	}

	@Test
	public void testDeleteUserById() {
		logger.info("testDeleteUser - START");
		logger.info("testDeleteUser - DEBUG - insertResult: " + insertResult);
		try {
			usr = uRepository.getEntityForTest(usroles.getLevel());
			insertResult = uRepository.create(usr);
			uRepository.delete(insertResult);
			usr = (User)uRepository.findById(insertResult);
			assertTrue(usr == null);
			logger.info("testDeleteUser - FINISHED");

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}
	}

	@Test
	public void testSelectUserById() {
		logger.info("testSelectUserById - START");
		logger.info("testSelectUserById - DEBUG - insertResult: " + insertResult);
		try {
			usr = uRepository.getEntityForTest(usroles.getLevel());
			insertResult = uRepository.create(usr);
			User usr2 = (User)uRepository.findById(insertResult);
			assertTrue(usr2.getId().equals(insertResult));
			logger.info("testSelectUserById - FINISHED");

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}
	}

	@Test
	public void testUpdateUser() {
		logger.info("testUpdateUser - START");
		logger.info("testUpdateUser - DEBUG - insertResult: " + insertResult);
//		User usr2 = new User();

		try {
			usr = uRepository.getEntityForTest(usroles.getLevel());
			insertResult = uRepository.create(usr);
//			Date myDate = new Date(2014, 02, 11);
//			Timestamp tstamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
//			usr2.setId(2L);
//			usr2.setEmail("emailtestxxx@email.com");
//			usr2.setPassword("pass_word");
//			usr2.setFirstname("first_name");
//			usr2.setLastname("last_name");
//			usr2.setDateofbirth(myDate);
//			usr2.setRegdate(tstamp);
//			usr2.setRole(2);
//			usr2.setImgpath("prova");
//			usr2.setNote("note_test");
//			usr2.setenabled(0);
//			long id = uRepository.saveNewUser(usr2);

			usr = (User)uRepository.findAll().get(0);
			usr.setEmail("1@2.3");
//			usr2.setId(id);
			// usr updated
			uRepository.update(usr);
			// get updated object
			User usr3 = (User)uRepository.findById(usr.getId());
			logger.info("*********" + usr3.getEmail() + "**********");
			assertTrue(usr3.getEmail().equals("1@2.3"));
			logger.info("testUpdateUser - FINISHED");

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}
	}

	@Test
	public void testSelectAllUsers() {
		logger.info("testSelectAllUser - START");
		logger.info("testUpdateUser - DEBUG - insertResult: " + insertResult);

		try {
			usr = uRepository.getEntityForTest(usroles.getLevel());
			insertResult = uRepository.create(usr);
			assertTrue(uRepository.findAll().size() == 1);

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);
			logger.info("testSelectAllUsers - FINISHED");

		}

	}

	@Test
	public void testDeleteAll() {
		logger.info("DeleteAll - START");

		try {
			usr = uRepository.getEntityForTest(usroles.getLevel());
			insertResult = uRepository.create(usr);
			uRepository.deleteAll();
			logger.info("DeleteAll - FINISH");
			assertTrue(uRepository.findAll().size() == 0);

		} catch (Exception e) {

			e.getStackTrace();
			logger.error("Error: " + e, e);

		}
	}
	
	@Test
	public void testSelectUserByEmail() {
		logger.info("testSelectUserByEmail - START");
		logger.info("testSelectUserByEmail - DEBUG - insertResult: " + insertResult);
		try {
			String email = "a@b.c" ;
			usr = uRepository.getEntityForTest(usroles.getLevel(), email);
			insertResult = uRepository.create(usr);
			User usr2 = (User)uRepository.findByEmail(email);
			assertTrue(usr2.getEmail().equals(email));
			logger.info("testSelectUserByEmail - FINISHED");
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("testSelectUserByEmail - Error: " + e, e);

		}
	}

}// End class
