package centauri.academy.proxima.cerepro.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.CandidateStates;
import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.User;

public class CandidateStatesRepository implements RepositoryInterface {
//	private SessionFactory session_factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	Logger logger = LoggerFactory.getLogger("UserRepository");

	public CandidateStates getEntityForTest(long roleId) {
		CandidateStates tmpCandidateStates = new CandidateStates();
		// TO ALL set for all fields!!!!!
//		@SuppressWarnings("deprecation")
		
		tmpCandidateStates.setRole_id(roleId);
		tmpCandidateStates.setStatus_code(2);
		tmpCandidateStates.setStatus_label("status label");
		tmpCandidateStates.setStatus_description("status description");
		tmpCandidateStates.setStatus_color("#000000");
	
		return tmpCandidateStates;
	}
	
	
	
	public List<EntityInterface> findAll() {
		return findAll(CandidateStates.class);
	}

	public EntityInterface findById(long id) {
		return findById(id, CandidateStates.class);
	}

	public int deleteAll() { // returns the number of lines erased
		return deleteAll(CandidateStates.class);
	}
	public boolean delete(long id) {
		return delete(CandidateStates.class, id);
	}

	@Deprecated
	@Override
	public EntityInterface getEntityForTest() {
		// TODO Auto-generated method stub
		return null;
	}

	



}// End class
