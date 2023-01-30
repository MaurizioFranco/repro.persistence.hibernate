package centauri.academy.proxima.cerepro.repository;
//package centauri.academy.proxima.cerepro.repository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import centauri.academy.proxima.cerepro.entity.Questions;
//
///**
// * 
// * @author titano
// * */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class QuestionsRepositoryTest {
//	
//	static Logger log = LoggerFactory.getLogger(QuestionsRepositoryTest.class);
//	
//	private  static QuestionsRepositoryImpl questionsRepository = null;
//	private  static Questions questions = null;
//	
//	@BeforeClass
//	public static void initQuestionsRepositoryImpl() {
//		questionsRepository = new QuestionsRepositoryImpl();
//		assertNotNull(questionsRepository);
//	}
//	
//	/*
//	 * testName: testQuestionRepositoryNotNull
//	 * */
//	@Test
//	public void test1() {
//		assertNotNull(questionsRepository);
//	}
//	
//	@BeforeClass
//	public static void initQuestionsPOJO() {
//		questions = new Questions();
//
//		questions.setId(1L);
//		questions.setDescription("this is a description");
//		questions.setLabel("label");
//		questions.setAnsa("ansa a");
//		questions.setAnsb("ansa b");
//		questions.setAnsc("ansa c");
//		questions.setAnsd("ansa d");
//		questions.setAnse("ansa e");
//		questions.setAnsg("ansa g");
//		questions.setAnsh("ansa h");
//		questions.setAnsb("ansa b");
//		questions.setCansa(true);
//		questions.setCansb(false);
//		questions.setCansa(true);
//		questions.setCansc(true);
//		questions.setCansd(false);
//		questions.setCanse(false);
//		questions.setCansf(true);
//		questions.setCansg(true);
//		questions.setCansh(true);
//		
//		
////		Arrays.asList(this.questions.getClass().getFields()).forEach((field) -> {
////			switch(field.getType().getSimpleName()) {
////				case "double":
////				case "Double":{break;}
////				case "float":
////				case "Float":{break;}
////				case "boolean":
////				case "Boolean":{break;}
////				case "long":
////				case "Long":{break;}
////				case "int":
////				case "Integer":{break;}
////				case "Short":{break;}
////				case "byte":
////				case "Byte":{break;}
////				default:{}
////			}
////		});
////		
//	}
//	
//	/*
//	 * testName: testCreateOK
//	 * */
//	@Test
//	public void test2() {
//		questions.setId(null);
//		Long retValue = questionsRepository.create(questions);
//		assertNotNull(retValue);
//		assertTrue(retValue >= 0);
//		System.out.println("retValue = " + retValue);
//	}
//	
//	/*
//	 * testName: testCreateKOForLabelNull
//	 * */
//	@Test
//	public void test3() {
//		String tmp = questions.getLabel();
//		
//		questions.setLabel(null);
//		Long retValue = questionsRepository.create(questions);
//		questions.setLabel(tmp);
//		
//		assertTrue(retValue == -1);
//	}
//	
//	/*
//	 * testName: testFindById
//	 * */
//	@Test
//	public void test4() {
//		questions.setId(1L);
//		Questions retValue = questionsRepository.findById(questions.getId());
//		assertNotNull(retValue);
//		assertEquals(questions.getId(), retValue.getId());
//		assertTrue(questions.getId() == retValue.getId());
//		assertTrue(questions.getDescription().equals(retValue.getDescription()));
//		assertTrue(questions.getAnsa().equals(retValue.getAnsa()));
//		assertTrue(questions.getAnsh().equals(retValue.getAnsh()));
//		assertTrue(questions.getCansa() == retValue.getCansa());
//		assertTrue(questions.getCansh() == retValue.getCansh());
//	}
//	
//	/*
//	 * testName: testfindAll
//	 * */
//	@Test
//	public void test5() {
//		List<Questions> retValue = questionsRepository.findAll();
//		assertNotNull(retValue);
//		assertTrue(retValue.size() > 0);
//	}
//
//	/*
//	 * testName: testUpdate
//	 * */
//	@Test
//	public void test6() {
//		Questions questionsUpdated = questions;
//		
//		String descriptionToUpdate = "updated description .....";
//		questionsUpdated.setDescription(descriptionToUpdate);
//		
//		boolean retValue = questionsRepository.update(questionsUpdated);
//		assertTrue(retValue);
//		
//		Questions retValue2 = questionsRepository.findById(questionsUpdated.getId());
//		assertEquals(descriptionToUpdate, retValue2.getDescription());
//	}
//	
//	/*
//	 * testName: testDeleteOK
//	 * */
//	@Test
//	public void test7() {
//		boolean retValue = questionsRepository.delete(1L);
//		assertTrue(retValue);
//	}	
//	
//	/*
//	 * testName: testDeleteKO
//	 * */
//	@Test
//	public void test8() {
//		boolean retValue = questionsRepository.delete(Long.MAX_VALUE);
//		assertFalse(retValue);
//	}	
//	
//	/*
//	 * testName: testDeleteAll
//	 * */
//	@Test
//	public void test9() {
//		questionsRepository.deleteAll();
//		List<Questions> list = questionsRepository.findAll();
//		assertTrue(list.size() == 0);
//	}
//}
