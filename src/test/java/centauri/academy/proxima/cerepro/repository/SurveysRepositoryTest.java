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
import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.entity.Surveys;

/**
 * 
 * @author daniel -
 *
 */

public class SurveysRepositoryTest {
	private static SurveysRepository surveysRepository;

	public static Logger log = LoggerFactory.getLogger(SurveysRepositoryTest.class);

	/**
	 * The method is performed one time before all methods of this class. This
	 * method initialize static field of this class called surveysRepository. This
	 * field contains the object which allow for access to database.
	 * 
	 */
	@BeforeClass
	public static void init() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: init() - START");
		surveysRepository = new SurveysRepository();
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: init() - END");
	}

	/**
	 * This method is performed before and after each other method of this class but
	 * after method marked with annotation @BeforeClass. It allow of flush
	 * corresponding table of database.
	 * 
	 */
	@After
	@Before
	public void flush() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: flush() - START");
		surveysRepository.deleteAll();
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: flush() - END");

	}

	/**
	 * This method test that instance field called SurveysRepository is enhanced,
	 * because otherwise we don't to execute his methods to access database.
	 * 
	 * */
	@Test
	public void testSurveysRepositoryNotNull() {
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testSurveysRepositoryNotNull() - START");
		assertNotNull(surveysRepository);
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName()  +" - testSurveysRepositoryNotNull() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method create of the class surveysRepository
	 * 
	 * */
	@Test
	public void testCreateOK() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testCreateOK() - START");
		int size = surveysRepository.findAll().size();
		EntityInterface entityInt = surveysRepository.getEntityForTest();
		Long retValue = surveysRepository.create(entityInt);
		int sizeUpdated = surveysRepository.findAll().size();
		assertNotNull(retValue);
		assertTrue(retValue > 0);
		assertEquals(size + 1, sizeUpdated);
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testCreateOK() - END");

	}
	
	/**
	 * This method test the <b>anomalous behavior</b> of the method create of the class SurveysRepository,
	 * when we try save an object Surveys with instance field label equals NULL. 
	 * 
	 * */
	@Test
	public void testCreateKOForLabelNull() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName()  +" - testCreateKOForLabelNull() - START");
		int size = surveysRepository.findAll().size();
		EntityInterface entityInterf = surveysRepository.getEntityForTest();
		Surveys quest = (Surveys) entityInterf;
		quest.setLabel(null);
		Long retValue = surveysRepository.create(quest);
		int sizeUpdated = surveysRepository.findAll().size();
		assertTrue(retValue == -1);
		assertEquals(size, sizeUpdated);
		log.info("class " + SurveysRepositoryTest.class.getSimpleName()  +" - testCreateKOForLabelNull() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method update of the class SurveysRepository.
	 * 
	 * */
	@Test
	public void testUpdate() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testUpdate() - START");
		Long questId = surveysRepository.create(surveysRepository.getEntityForTest());
		EntityInterface entityInterf = surveysRepository.findById(questId);
		Surveys surveysUpdated = (Surveys) entityInterf;
		String descriptionToUpdate = "updated description .....";
		surveysUpdated.setDescription(descriptionToUpdate);
		boolean retValue = surveysRepository.update(surveysUpdated);		
		EntityInterface retValue2 = surveysRepository.findById(surveysUpdated.getId());
		Surveys surveys = (Surveys) retValue2;
		assertNotNull(surveys);
		assertTrue(retValue);
		assertEquals(descriptionToUpdate, surveys.getDescription());
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testUpdate() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method findById of the class SurveysRepository.
	 * 
	 * */
	@Test
	public void testFindByIdOK() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testFindByIdOK() - START");
		EntityInterface entityInterf = surveysRepository.getEntityForTest();
		Long sueveysId = surveysRepository.create(entityInterf);
		EntityInterface retValue = surveysRepository.findById(sueveysId);
		Surveys surveysRetValue = (Surveys) retValue;
		assertNotNull(retValue);
		assertEquals(sueveysId, surveysRetValue.getId());
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testFindByIdOK() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method delete of the class SurveysRepository.
	 * 
	 * */
	@Test
	public void testDeleteOK() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testDeleteOK() - START");
		Long surveysId = surveysRepository.create(surveysRepository.getEntityForTest());
		int size = surveysRepository.findAll().size();
		boolean retValue = surveysRepository.delete(surveysId.longValue());
		int sizeUpdate = surveysRepository.findAll().size();
		assertTrue(retValue);
		assertTrue((size - 1) == sizeUpdate);
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testDeleteOK() - END");

	}

	/**
	 *  This method tests the <b>normal behavior</b> of the method deleteAll of the class SurveysRepository.
	 * 
	 * */
	@Test
	public void testDeleteAll() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testDeleteAll() - START");
		final int N = 4;
		for(int i=0; i<N; i++)
			surveysRepository.create(surveysRepository.getEntityForTest());
		int size = surveysRepository.findAll().size();
		int retValue = surveysRepository.deleteAll();
		int sizeUpdate = surveysRepository.findAll().size();
		assertTrue(retValue == N);
		assertTrue( (size - N) == sizeUpdate);
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testDeleteAll() - END");

	}

	/**
	 * This method test the <b>normal behavior</b> of the method findAll of the class SurveysRepository.
	 * 
	 * */
	@Test
	public void testfindAll() {
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testfindAll() - START");
		final int N = 4;
		for(int i=0; i<N; i++)
			surveysRepository.create(surveysRepository.getEntityForTest());
		List<EntityInterface> retValue = surveysRepository.findAll();
		assertNotNull(retValue);
		assertTrue(retValue.size() == N);
		log.info("class " + SurveysRepositoryTest.class.getSimpleName() + " - method: testfindAll() - END");

	}

}
