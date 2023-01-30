package centauri.academy.proxima.cerepro.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.entity.SurveysReplies;
import centauri.academy.proxima.cerepro.entity.User;

/**
 * 
 * @author Roberto
 * 
 *         This class tests the behavior of class SurveysQuestionsRepository.
 * 
 */
public class SurveyRepliesRepositoryTest {
	static Logger log = LoggerFactory.getLogger(SurveyRepliesRepositoryTest.class);

	private static SurveyRepliesRepository surveyRepliesRepository = null;
	private static SurveysRepository surveysRepository = null;
	private static CandidateStatesRepository candidateStatesRepository = null;
	private static UserRepository userRepository = null;
	private static RolesRepository rolesRepository = null;

	/**
	 * The method is performed one time before all methods of this class. This
	 * method initialize static field of this class called surveyRepliesRepository,
	 * surveysRepository, userRepository and rolesRepository. These fields contains
	 * the object which allow for access to database.
	 * 
	 */
	@BeforeClass
	public static void init() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - init() - START");
		surveyRepliesRepository = new SurveyRepliesRepository();
		candidateStatesRepository = new CandidateStatesRepository ();
		userRepository = new UserRepository();
		rolesRepository = new RolesRepository();
		surveysRepository = new SurveysRepository();
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - init() - END");
	}

	/**
	 * This method is performed before and after each other method of this class but after
	 * method marked with annotation @BeforeClass. It allow of flush corresponding
	 * table of database.
	 * 
	 */
	@After
	@Before
	public void flush() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - flush() - START");
		surveyRepliesRepository.deleteAll();
		candidateStatesRepository.deleteAll();
		userRepository.deleteAll();
		rolesRepository.deleteAll();
		surveysRepository.deleteAll();
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - flush() - END");
	}

	/**
	 * This method test that instance fields called questionRepository,
	 * surveysRepository, questionsRepository are enhanced, because otherwise we
	 * don't to execute their methods to access database.
	 * 
	 */
	@Test
	public void testQuestionRepositoryNotNull() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName()
				+ " - testQuestionRepositoryNotNull() - START");
		assertNotNull(surveyRepliesRepository);
		assertNotNull(surveysRepository);
		assertNotNull(rolesRepository);
		assertNotNull(userRepository);
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName()
				+ " - testQuestionRepositoryNotNull() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method create of the class
	 * QuestionsRepository
	 * 
	 */
	@Test
	public void testCreateOK() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testCreateOK() - START");
		Long idSurvey = surveysRepository.create(surveysRepository.getEntityForTest());
		Roles roles = rolesRepository.getEntityForTest();
		rolesRepository.create(roles);
		User usr = userRepository.getEntityForTest(roles.getLevel());
		Long idUser = userRepository.create(usr);
		int size = surveyRepliesRepository.findAll().size();
		Long idSR = surveyRepliesRepository.create(surveyRepliesRepository.getEntityForTest(idSurvey, idUser));
		int sizeUpdate = surveyRepliesRepository.findAll().size();
		assertNotNull(idSR);
		assertTrue((size + 1) == sizeUpdate);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName() + " - testCreateOK() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method FindById of the
	 * class SurveysQuestionsRepository
	 * 
	 */
	@Test
	public void testFindByIdOk() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testFindByIdOk() - START");
		Long idSurvey = surveysRepository.create(surveysRepository.getEntityForTest());
		Roles roles = rolesRepository.getEntityForTest();
		rolesRepository.create(roles);
		User usr = userRepository.getEntityForTest(roles.getLevel());
		Long idUser = userRepository.create(usr);
		Long idSR = surveyRepliesRepository.create(surveyRepliesRepository.getEntityForTest(idSurvey, idUser));
		EntityInterface retValue = surveyRepliesRepository.findById(idSR);
		SurveysReplies surveysReplies = (SurveysReplies) retValue;
		assertNotNull(surveysReplies);
		assertEquals(idSR, surveysReplies.getId());
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testFindByIdOk() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method findAll of the
	 * class QuestionsRepository.
	 * 
	 */
	@Test
	public void testFindAll() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testFindAllOk() - START");
		final int N = 4;
		Long idSurvey = surveysRepository.create(surveysRepository.getEntityForTest());
		Roles roles = rolesRepository.getEntityForTest();
		rolesRepository.create(roles);
		User usr = null;
		Long idUser = null;
		Long idSR = null;
		for (int i = 0; i<N; i++) {
			usr = userRepository.getEntityForTest(roles.getLevel());
			usr.setEmail("bim_bum_bam" + i + "@email.it");
			idUser = userRepository.create(usr);
			idSR = surveyRepliesRepository.create(surveyRepliesRepository.getEntityForTest(idSurvey, idUser));
		}
		List<EntityInterface> retValue = surveyRepliesRepository.findAll();
		assertNotNull(retValue);
		assertTrue(retValue.size() == N);
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testFindAllOk() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method update of the class
	 * SurveysQuestionsRepository.
	 * 
	 */
	@Test
	public void testUpdate() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testUpdate() - START");
		Long idSurvey = surveysRepository.create(surveysRepository.getEntityForTest());
		Roles roles = rolesRepository.getEntityForTest();
		rolesRepository.create(roles);
		User usr = userRepository.getEntityForTest(roles.getLevel());
		Long idUser = userRepository.create(usr);
		Long idSR = surveyRepliesRepository.create(surveyRepliesRepository.getEntityForTest(idSurvey, idUser));
		EntityInterface entityInterf = surveyRepliesRepository.findById(idSR);
		SurveysReplies surveyRepliesToUpdate = (SurveysReplies) entityInterf;
		String answerToUpdate = "new answer";
		String pdfToUpdate = "new pdf file name";
		surveyRepliesToUpdate.setAnswer(answerToUpdate);
		surveyRepliesToUpdate.setPdfFileName(pdfToUpdate);
		boolean retValue = surveyRepliesRepository.update(surveyRepliesToUpdate);
		EntityInterface retValue2 = surveyRepliesRepository.findById(surveyRepliesToUpdate.getId());
		SurveysReplies surveysReplies = (SurveysReplies) retValue2;
		assertNotNull(surveysReplies);
		assertTrue(retValue);
		assertEquals(answerToUpdate, surveysReplies.getAnswer());
		assertEquals(pdfToUpdate, surveysReplies.getPdfFileName());
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testUpdate() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method delete of the class
	 * SurveysQuestionsRepository.
	 * 
	 */
	@Test
	public void testDeleteByIdOK() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testDeleteByIdOK() - START");
		Long idSurvey = surveysRepository.create(surveysRepository.getEntityForTest());
		Roles roles = rolesRepository.getEntityForTest();
		rolesRepository.create(roles);
		User usr = userRepository.getEntityForTest(roles.getLevel());
		Long idUser = userRepository.create(usr);
		Long idSR = surveyRepliesRepository.create(surveyRepliesRepository.getEntityForTest(idSurvey, idUser));
		int size = surveyRepliesRepository.findAll().size();
		boolean retValue = surveyRepliesRepository.delete(idSR.longValue());
		int sizeUpdate = surveyRepliesRepository.findAll().size();
		assertTrue(retValue);
		assertTrue((size - 1) == sizeUpdate);
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testDeleteByIdOK() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method deleteAll of the
	 * class SurveysQuestionsRepository.
	 * 
	 */
	@Test
	public void testDeleteAll() {
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testDeleteAll() - START");
		final int N = 4;
		Long idSurvey = surveysRepository.create(surveysRepository.getEntityForTest());
		Roles roles = rolesRepository.getEntityForTest();
		rolesRepository.create(roles);
		User usr = null;
		Long idUser = null;
		Long idSR = null;
		for (int i = 0; i<N; i++) {
			usr = userRepository.getEntityForTest(roles.getLevel());
			usr.setEmail("bim_bum_bam" + i + "@email.it");
			idUser = userRepository.create(usr);
			idSR = surveyRepliesRepository.create(surveyRepliesRepository.getEntityForTest(idSurvey, idUser));
		}
		int size = surveyRepliesRepository.findAll().size();
		int retValue = surveyRepliesRepository.deleteAll();
		int sizeUpdate = surveyRepliesRepository.findAll().size();
		assertTrue(retValue == N);
		assertTrue((size - N) == sizeUpdate);
		log.info("class " + SurveyRepliesRepositoryTest.class.getSimpleName() + " - testDeleteAll() - END");
	}
}
