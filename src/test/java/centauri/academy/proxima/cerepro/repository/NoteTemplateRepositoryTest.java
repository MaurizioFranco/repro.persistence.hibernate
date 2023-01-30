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
import centauri.academy.proxima.cerepro.entity.NoteTemplate;
import centauri.academy.proxima.cerepro.entity.Questions;

/**
 * S
 * 
 * @author maurizio - m.franco@proximanetwork.it
 *
 */
public class NoteTemplateRepositoryTest {

	private static Logger log = LoggerFactory.getLogger(NoteTemplateRepositoryTest.class);

	private static NoteTemplateRepository noteTemplateRepository = null;

	@BeforeClass
	public static void init() {
		log.info("class " + NoteTemplateRepository.class.getSimpleName()
				+ " - method: init() - START");
		noteTemplateRepository = new NoteTemplateRepository();
		log.info("class " + NoteTemplateRepository.class.getSimpleName()
				+ " - method: init() - END");

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
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName() + " - method: flush() - START");
		noteTemplateRepository.deleteAll();
		log.info("class " + QuestionsRepositoryTest.class.getSimpleName() + " - method: flush() - END");
	}

	@Test
	public void testCreateOK() {
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName() + " - method: testCreateOK() - START");
		NoteTemplate noteTemplate = noteTemplateRepository.getEntityForTest();
		int size = noteTemplateRepository.findAll().size();
		Long retValue = noteTemplateRepository.create(noteTemplate);
		int sizeUpdate = noteTemplateRepository.findAll().size();
		assertTrue(retValue > 0);
		assertTrue(sizeUpdate == (size + 1));
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName() + " - method: testCreateOK() - END");
	}

	@Test
	public void testUpdate() {
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testUpdate() - START");
		Long questId = noteTemplateRepository.create(noteTemplateRepository.getEntityForTest());
		EntityInterface entityInterf = noteTemplateRepository.findById(questId);
		NoteTemplate noteTemplateUpdated = (NoteTemplate) entityInterf;
		String content = "parino content";
		noteTemplateUpdated.setContent(content);
		boolean retValue = noteTemplateRepository.update(noteTemplateUpdated);		
		EntityInterface retValue2 = noteTemplateRepository.findById(noteTemplateUpdated.getId());
		NoteTemplate noteTemplate = (NoteTemplate) retValue2;
		assertNotNull(noteTemplate);
		assertTrue(retValue);
		assertEquals(content, noteTemplate.getContent());
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testUpdate() - END");
	}

	@Test
	public void testFindByIdOK() {
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testFindByIdOK() - START");
		EntityInterface entityInterf = noteTemplateRepository.getEntityForTest();
		Long questId = noteTemplateRepository.create(entityInterf);
		EntityInterface retValue = noteTemplateRepository.findById(questId);
		NoteTemplate questRetValue = (NoteTemplate) retValue;
		assertNotNull(retValue);
		assertEquals(questId, questRetValue.getId());
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testFindById() - END");
	}

	@Test
	public void testFindAll() {
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testfindAll() - START");
		final int N = 4;
		for(int i=0; i<N; i++)
			noteTemplateRepository.create(noteTemplateRepository.getEntityForTest());
		List<EntityInterface> retValue = noteTemplateRepository.findAll();
		assertNotNull(retValue);
		assertTrue(retValue.size() == N);
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testfindAll() - END");
	}

	@Test
	public void testDeleteById() {
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testDeleteOK() - START");
		Long questId = noteTemplateRepository.create(noteTemplateRepository.getEntityForTest());
		int size = noteTemplateRepository.findAll().size();
		boolean retValue = noteTemplateRepository.delete(questId.longValue());
		int sizeUpdate = noteTemplateRepository.findAll().size();
		assertTrue(retValue);
		assertTrue((size - 1) == sizeUpdate);
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testDeleteOK() - END");
	}

	@Test
	public void testDeleteAll() {
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testDeleteAll() - START");
		final int N = 4;
		for(int i=0; i<N; i++)
			noteTemplateRepository.create(noteTemplateRepository.getEntityForTest());
		int size = noteTemplateRepository.findAll().size();
		int retValue = noteTemplateRepository.deleteAll();
		int sizeUpdate = noteTemplateRepository.findAll().size();
		assertTrue(retValue == N);
		assertTrue( (size - N) == sizeUpdate);
		log.info("class " + NoteTemplateRepositoryTest.class.getSimpleName()  +" - testDeleteAll() - END");
	}
}