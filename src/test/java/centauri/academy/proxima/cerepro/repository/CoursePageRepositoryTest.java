package centauri.academy.proxima.cerepro.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.NoteTemplate;
import centauri.academy.proxima.cerepro.entity.CoursePage;

/**
 * 
 * @author daniel -
 *
 */

public class CoursePageRepositoryTest {
	private static CoursePageRepository coursePageRepository;

	public static Logger log = LoggerFactory.getLogger(CoursePageRepositoryTest.class);

	/**
	 * The method is performed one time before all methods of this class. This
	 * method initialize static field of this class called coursePageRepository. This
	 * field contains the object which allow for access to database.
	 * 
	 */
	@BeforeClass
	public static void init() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: init() - START");
		coursePageRepository = new CoursePageRepository();
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: init() - END");
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
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: flush() - START");
		coursePageRepository.deleteAll();
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: flush() - END");

	}

	/**
	 * This method test that instance field called CoursePageRepository is enhanced,
	 * because otherwise we don't to execute his methods to access database.
	 * 
	 * */
	@Test
	public void testCoursePageRepositoryNotNull() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName()  +" - testCoursePageRepositoryNotNull() - START");
		assertNotNull(coursePageRepository);
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName()  +" - testCoursePageRepositoryNotNull() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method create of the class coursePageRepository
	 * 
	 * */
	@Test
	public void testCreateOK() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testCreateOK() - START");
		int size = coursePageRepository.findAll().size();
		EntityInterface entityInt = coursePageRepository.getEntityForTest();
		Long retValue = coursePageRepository.create(entityInt);
		int sizeUpdated = coursePageRepository.findAll().size();
		assertNotNull(retValue);
		assertTrue(retValue > 0);
		assertEquals(size + 1, sizeUpdated);
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testCreateOK() - END");

	}
	
	/**
	 * This method test the <b>anomalous behavior</b> of the method create of the class CoursePageRepository,
	 * when we try save an object CoursePage with instance field label equals NULL. 
	 * 
	 * */
	@Test
	public void testCreateKOForLabelNull() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName()  +" - testCreateKOForLabelNull() - START");
		int size = coursePageRepository.findAll().size();
		EntityInterface entityInterf = coursePageRepository.getEntityForTest();
		CoursePage quest = (CoursePage) entityInterf;
		quest.setCode(null);
		Long retValue = coursePageRepository.create(quest);
		int sizeUpdated = coursePageRepository.findAll().size();
		assertTrue(retValue == -1);
		assertEquals(size, sizeUpdated);
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName()  +" - testCreateKOForLabelNull() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method update of the class CoursePageRepository.
	 * 
	 * */
	@Test
	public void testUpdate() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testUpdate() - START");
		Long questId = coursePageRepository.create(coursePageRepository.getEntityForTest());
		EntityInterface entityInterf = coursePageRepository.findById(questId);
		CoursePage surveysUpdated = (CoursePage) entityInterf;
		String descriptionToUpdate = "updated description .....";
		surveysUpdated.setCode(descriptionToUpdate);
		boolean retValue = coursePageRepository.update(surveysUpdated);		
		EntityInterface retValue2 = coursePageRepository.findById(surveysUpdated.getId());
		CoursePage surveys = (CoursePage) retValue2;
		assertNotNull(surveys);
		assertTrue(retValue);
		assertEquals(descriptionToUpdate, surveys.getCode());
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testUpdate() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method findById of the class CoursePageRepository.
	 * 
	 * */
	@Test
	public void testFindByIdOK() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testFindByIdOK() - START");
		EntityInterface entityInterf = coursePageRepository.getEntityForTest();
		Long sueveysId = coursePageRepository.create(entityInterf);
		EntityInterface retValue = coursePageRepository.findById(sueveysId);
		CoursePage surveysRetValue = (CoursePage) retValue;
		assertNotNull(retValue);
		assertEquals(sueveysId, surveysRetValue.getId());
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testFindByIdOK() - END");
	}

	/**
	 * This method test the <b>normal behavior</b> of the method delete of the class CoursePageRepository.
	 * 
	 * */
	@Test
	public void testDeleteOK() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testDeleteOK() - START");
		Long surveysId = coursePageRepository.create(coursePageRepository.getEntityForTest());
		int size = coursePageRepository.findAll().size();
		boolean retValue = coursePageRepository.delete(surveysId.longValue());
		int sizeUpdate = coursePageRepository.findAll().size();
		assertTrue(retValue);
		assertTrue((size - 1) == sizeUpdate);
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testDeleteOK() - END");

	}

	/**
	 *  This method tests the <b>normal behavior</b> of the method deleteAll of the class CoursePageRepository.
	 * 
	 * */
	@Test
	public void testDeleteAll() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testDeleteAll() - START");
//		final int N = 4;
//		for(int i=0; i<N; i++)
			coursePageRepository.create(coursePageRepository.getEntityForTest());
		int size = coursePageRepository.findAll().size();
		int retValue = coursePageRepository.deleteAll();
		int sizeUpdate = coursePageRepository.findAll().size();
		assertTrue(retValue == 1);
//		assertTrue( (size - N) == sizeUpdate);
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testDeleteAll() - END");

	}

	/**
	 * This method test the <b>normal behavior</b> of the method findAll of the class CoursePageRepository.
	 * 
	 * */
	@Test
	public void testfindAll() {
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testfindAll() - START");
//		final int N = 4;
//		for(int i=0; i<N; i++)
			coursePageRepository.create(coursePageRepository.getEntityForTest());
		List<EntityInterface> retValue = coursePageRepository.findAll();
		assertNotNull(retValue);
		assertTrue(retValue.size() == 1);
		log.info("class " + CoursePageRepositoryTest.class.getSimpleName() + " - method: testfindAll() - END");

	}

}
