package centauri.academy.proxima.cerepro.repository;

import static org.junit.Assert.assertFalse;
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
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;

/**
 * 
 * @author Roberto
 * 
 * 		   This class tests the behavior of class SurveysQuestionsRepository.
 * 
 * */
public class SurveyQuestionsRepositoryTest {
	static Logger log = LoggerFactory.getLogger(SurveysRepositoryTest.class);

	private static SurveyQuestionsRepository surveyQuestionsRepository = null;
	private static SurveysRepository surveysRepository = null;
	private static QuestionsRepository questionsRepository = null;

	/**
	 * The method is performed one time before all methods of this class.
	 * This method initialize static field of this class called surveyQuestionsRepository, surveysRepository, questionsRepository.
	 * These fields contains the object which allow for access to database.
	 * 
	 * */
	@BeforeClass
	public static void init() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - init() - START");
		surveyQuestionsRepository = new SurveyQuestionsRepository();
		surveysRepository = new SurveysRepository();
		questionsRepository = new QuestionsRepository();
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - init() - END");
	}

	/**
	 * This method is performed before and adter each other method of this class but after method marked with annotation @BeforeClass.
	 * It allow of flush corresponding table of database.
	 * 
	 * */
	@After
	@Before
	public void flush() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - flush() - START");
		surveyQuestionsRepository.deleteAll();
		surveysRepository.deleteAll(); 
		questionsRepository.deleteAll();
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - flush() - END");

	}

	/**
	 * This method test that instance fields called questionRepository, surveysRepository, questionsRepository are enhanced,
	 * because otherwise we don't to execute their methods to access database.
	 * 
	 * */
	@Test
	public void testQuestionRepositoryNotNull() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testQuestionRepositoryNotNull() - START");
		assertNotNull(surveyQuestionsRepository);
		assertNotNull(surveysRepository);
		assertNotNull(questionsRepository);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testQuestionRepositoryNotNull() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method create of the class QuestionsRepository
	 * 
	 * */
	@Test
	public void testCreateOK() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testCreateOK() - START");
		Long idS = surveysRepository.create(surveysRepository.getEntityForTest());
		Long idQ = questionsRepository.create(questionsRepository.getEntityForTest());
		int size = surveyQuestionsRepository.findAll().size();
		Long idSQ = surveyQuestionsRepository.create(surveyQuestionsRepository.getEntityForTest(idQ, idS));
		int sizeUpdate = surveyQuestionsRepository.findAll().size();
		assertNotNull(idSQ);
		assertTrue(idSQ > 0);
		assertTrue((size + 1) == sizeUpdate);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testCreateOK() - END");
	}
	
	/**
	 * This method test the <b>normal behavior</b> of the method FindById of the class SurveysQuestionsRepository
	 * 
	 * */
	@Test
	public void testFindByIdOk() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testFindByIdOk() - START");
		Long idS = surveysRepository.create(surveysRepository.getEntityForTest());
		Long idQ = questionsRepository.create(questionsRepository.getEntityForTest());
		SurveysQuestions sq = (SurveysQuestions) surveyQuestionsRepository.getEntityForTest(idQ, idS);
		Long idSQ = surveyQuestionsRepository.create(sq);
		SurveysQuestions retValue = (SurveysQuestions) surveyQuestionsRepository.findById(idSQ);
		assertNotNull(retValue);
		assertTrue(idSQ == retValue.getId());
//		assertTrue(sq.getSurveyId() == retValue.getSurveyId());
		assertTrue(sq.getQuestionId() == retValue.getQuestionId());
		assertTrue(sq.getPosition() == retValue.getPosition());
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testFindByIdOk() - END");
	}
	
	/**
	 * This method test the <b>normal behavior</b> of the method findAll of the class QuestionsRepository.
	 * 
	 * */
	@Test
	public void testFindAllOk() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testFindAllOk() - START");
		Long idS1 = surveysRepository.create(surveysRepository.getEntityForTest());
		Long idS2 = surveysRepository.create(surveysRepository.getEntityForTest());
		Long idQ1 = questionsRepository.create(questionsRepository.getEntityForTest());
		Long idQ2 = questionsRepository.create(questionsRepository.getEntityForTest());
		surveyQuestionsRepository.create(surveyQuestionsRepository.getEntityForTest(idQ1, idS1));
		surveyQuestionsRepository.create(surveyQuestionsRepository.getEntityForTest(idQ2, idS2));
		List<EntityInterface> retListSQ = surveyQuestionsRepository.findAll();
		assertNotNull(retListSQ);
		assertTrue(retListSQ.size() == 2);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testFindAllOk() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method update of the class SurveysQuestionsRepository.
	 * 
	 * */
	@Test
	public void testUpdate() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testUpdate() - START");
		Long idS1 = surveysRepository.create(surveysRepository.getEntityForTest());
		Long idQ1 = questionsRepository.create(questionsRepository.getEntityForTest());
		Long idSQ1 = surveyQuestionsRepository.create(surveyQuestionsRepository.getEntityForTest(idQ1, idS1));
		SurveysQuestions surveysQuestions = (SurveysQuestions) surveyQuestionsRepository.findById(idSQ1);		
		int positionToUpdate = 1234567890;
		surveysQuestions.setPosition(positionToUpdate);
		boolean retValue = surveyQuestionsRepository.update(surveysQuestions);
		assertTrue(retValue);
		SurveysQuestions retValue2 = (SurveysQuestions) surveyQuestionsRepository.findById(surveysQuestions.getId());
		assertNotNull(retValue2);
		assertTrue(positionToUpdate == retValue2.getPosition());
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testUpdate() - END");
	}
	
	/**
	 * This method test the <b>normal behavior</b> of the method delete of the class SurveysQuestionsRepository.
	 * 
	 * */
	@Test
	public void testDeleteByIdOK() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteByIdOK() - START");
		Long idS1 = surveysRepository.create(surveysRepository.getEntityForTest());
		Long idS2 = surveysRepository.create(surveysRepository.getEntityForTest());
		Long idQ1 = questionsRepository.create(questionsRepository.getEntityForTest());
		Long idQ2 = questionsRepository.create(questionsRepository.getEntityForTest());
		Long idSQ1 = surveyQuestionsRepository.create(surveyQuestionsRepository.getEntityForTest(idQ1, idS1));
		Long idSQ2 = surveyQuestionsRepository.create(surveyQuestionsRepository.getEntityForTest(idQ2, idS2));
		List<EntityInterface> listSq = surveyQuestionsRepository.findAll();
		boolean retValue = surveyQuestionsRepository.delete( idSQ1);
		List<EntityInterface> listSqUpdate = surveyQuestionsRepository.findAll();
		assertTrue(retValue);
		assertNotNull(listSq);
		assertTrue(listSqUpdate.size() == (listSq.size()-1));
		
		for(int i=0; i<listSq.size(); i++)
			assertTrue( ((SurveysQuestions) listSq.get(i)).getId() != idS1);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteByIdOK() - END");
	}	
	
	/**
	 * This method test the <b>anomalous behavior</b> of the method delete of the class SurveysQuestionsRepository,
	 * when we try to delete an object SurveysQuestions with id that not existing.
	 * 
	 * */
	@Test
	public void testDeleteKOFieldLong() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteKOFieldLong() - START");
		boolean retValue = surveyQuestionsRepository.delete(Long.MAX_VALUE);
		assertFalse(retValue);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteKOFieldLong() - END");

	}	
	
	/**
	 *  This method test the <b>normal behavior</b> of the method deleteAll of the class SurveysQuestionsRepository.
	 * 
	 * */
	@Test
	public void testDeleteAll() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteAll() - START");
		final int N = 4;
		Long idS = null;
		Long idQ = null;
		Long idSQ = null;
		for(int i=0; i<N; i++) {
			 idS = surveysRepository.create(surveysRepository.getEntityForTest());
			 idQ = questionsRepository.create(questionsRepository.getEntityForTest());
			 idSQ = surveyQuestionsRepository.create(surveyQuestionsRepository.getEntityForTest(idQ, idS));
		}
		assertTrue(surveyQuestionsRepository.findAll().size() == N);
		surveyQuestionsRepository.deleteAll();
		assertTrue(surveyQuestionsRepository.findAll().size() == 0);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteAll() - END");
	}
}
