package centauri.academy.proxima.cerepro.repository;

import static org.junit.Assert.assertEquals;
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
import centauri.academy.proxima.cerepro.entity.Questions;

/**
 * 
 * @author Roberto
 * 
 * 		   This class tests the behavior of class QuestionsRepository.
 * 
 * */
public class QuestionsRepositoryTest {
	
	static Logger log = LoggerFactory.getLogger(QuestionsRepositoryTest.class);
	
	private static QuestionsRepository questionsRepository = null;
	
	/**
	 * The method is performed one time before all methods of this class.
	 * This method initialize static field of this class called questionsRepository.
	 * This field contains the object which allow for access to database.
	 * 
	 * */
	@BeforeClass
	public static void initQuestionsRepositoryImpl() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - method: initQuestionsRepositoryImpl() - START");
		questionsRepository = new QuestionsRepository();
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - method: initQuestionsRepositoryImpl() - END");
	}
	
	/**
	 * This method is performed before and after each other method of this class but after method marked with annotation @BeforeClass.
	 * It allow of flush corresponding table of database.
	 * 
	 * */
	@After
	@Before
	public void flush() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - method: flush() - START");
		questionsRepository.deleteAll();
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - method: flush() - END");
	}
	
	/**
	 * This method test that instance field called questionRepository is enhanced,
	 * because otherwise we don't to execute his methods to access database.
	 * 
	 * */
	@Test
	public void testQuestionRepositoryNotNull() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testQuestionRepositoryNotNull() - START");
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
		int size = questionsRepository.findAll().size();
		EntityInterface entityInt = questionsRepository.getEntityForTest();
		Long retValue = questionsRepository.create(entityInt);
		int sizeUpdated = questionsRepository.findAll().size();
		assertNotNull(retValue);
		assertTrue(retValue > 0);
		assertEquals(size + 1, sizeUpdated);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testCreateOK() - END");
	}

	/**
	 * This method test the <b>anomalous behavior</b> of the method create of the class QuestionsRepository,
	 * when we try save an object Questions with instance field label equals NULL. 
	 * 
	 * */
	@Test
	public void testCreateKOForLabelNull() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testCreateKOForLabelNull() - START");
		int size = questionsRepository.findAll().size();
		EntityInterface entityInterf = questionsRepository.getEntityForTest();
		Questions quest = (Questions) entityInterf;
		quest.setLabel(null);
		Long retValue = questionsRepository.create(quest);
		int sizeUpdated = questionsRepository.findAll().size();
		assertTrue(retValue == -1);
		assertEquals(size, sizeUpdated);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testCreateKOForLabelNull() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method findById of the class QuestionsRepository.
	 * 
	 * */
	@Test
	public void testFindByIdOK() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testFindByIdOK() - START");
		EntityInterface entityInterf = questionsRepository.getEntityForTest();
		Long questId = questionsRepository.create(entityInterf);
		EntityInterface retValue = questionsRepository.findById(questId);
		Questions questRetValue = (Questions) retValue;
		assertNotNull(retValue);
		assertEquals(questId, questRetValue.getId());
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testFindById() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method findAll of the class QuestionsRepository.
	 * 
	 * */
	@Test
	public void testfindAll() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testfindAll() - START");
		final int N = 4;
		for(int i=0; i<N; i++)
			questionsRepository.create(questionsRepository.getEntityForTest());
		List<EntityInterface> retValue = questionsRepository.findAll();
		assertNotNull(retValue);
		assertTrue(retValue.size() == N);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testfindAll() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method update of the class QuestionsRepository.
	 * 
	 * */
	@Test
	public void testUpdate() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testUpdate() - START");
		Long questId = questionsRepository.create(questionsRepository.getEntityForTest());
		EntityInterface entityInterf = questionsRepository.findById(questId);
		Questions questionsUpdated = (Questions) entityInterf;
		String descriptionToUpdate = "updated description .....";
		questionsUpdated.setDescription(descriptionToUpdate);
		boolean retValue = questionsRepository.update(questionsUpdated);		
		EntityInterface retValue2 = questionsRepository.findById(questionsUpdated.getId());
		Questions questions = (Questions) retValue2;
		assertNotNull(questions);
		assertTrue(retValue);
		assertEquals(descriptionToUpdate, questions.getDescription());
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testUpdate() - END");
	}
	
	/**
	 * This method test the <b>normal behavior</b> of the method delete of the class QuestionsRepository.
	 * 
	 * */
	@Test
	public void testDeleteOK() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteOK() - START");
		Long questId = questionsRepository.create(questionsRepository.getEntityForTest());
		int size = questionsRepository.findAll().size();
		boolean retValue = questionsRepository.delete(questId.longValue());
		int sizeUpdate = questionsRepository.findAll().size();
		assertTrue(retValue);
		assertTrue((size - 1) == sizeUpdate);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteOK() - END");

	}	
	
	/**
	 * This method tests the <b>anomalous behavior</b> of the method delete of the class QuestionsRepository,
	 * when we try to delete an object Questions with id that not existing.
	 * 
	 * */
	@Test
	public void testDeleteKOFieldLong() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteKOFieldLong() - START");
		questionsRepository.create(questionsRepository.getEntityForTest());
		int size = questionsRepository.findAll().size();
		boolean retValue = questionsRepository.delete(Long.MAX_VALUE);
		int sizeUpdate = questionsRepository.findAll().size();
		assertFalse(retValue);
		assertTrue(size == sizeUpdate);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteKOFieldLong() - END");
	}	

	/**
	 *  This method tests the <b>normal behavior</b> of the method deleteAll of the class QuestionsRepository.
	 * 
	 * */
	@Test
	public void testDeleteAll() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteAll() - START");
		final int N = 4;
		for(int i=0; i<N; i++)
			questionsRepository.create(questionsRepository.getEntityForTest());
		int size = questionsRepository.findAll().size();
		int retValue = questionsRepository.deleteAll();
		int sizeUpdate = questionsRepository.findAll().size();
		assertTrue(retValue == N);
		assertTrue( (size - N) == sizeUpdate);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testDeleteAll() - END");
	}
}