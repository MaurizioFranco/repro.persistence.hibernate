package centauri.academy.proxima.cerepro.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.Candidates;
import centauri.academy.proxima.cerepro.entity.EntityInterface;

public class CandidatesRepository implements RepositoryInterface{

	private static Logger log = LoggerFactory.getLogger(CandidatesRepository.class);

	@Override
	public Candidates findById(long id) {
		return (Candidates) findById(id, Candidates.class);
	}

	public boolean delete(long id) {
		return delete(Candidates.class, id);
	}
	
	@Override
	public List<EntityInterface> findAll() {
		return findAll(Candidates.class);
	}
	
	@Override
	public int deleteAll() {
		return deleteAll(Candidates.class);
	}
	
//	public Candidates getEntityForTest(Integer user_id, String course_code, Timestamp candidacy_date_time, String firstname,
//			String lastname, String email, Timestamp regdate, Integer inserted_by, Integer candidate_state_code) {
//		
//		Candidates candidates = new Candidates();
//		Timestamp regdate = Timestamp.valueOf(LocalDateTime.now());
//		candidates.setUser_id(user_id);
//		candidates.setCourse_code(course_code);
//		candidates.setCandidacy_date_time(candidacy_date_time);
//		candidates.setFirstname(firstname);
//		candidates.setLastname(lastname);
//		candidates.setEmail(email);
//		candidates.setRegdate(regdate);
//		candidates.setInserted_by(inserted_by);
//		candidates.setCandidate_state_code(candidate_state_code);
//		
//		return candidates;
//	}
	
	@Override
	public Candidates getEntityForTest() {
//		Candidates candidates = new Candidates();
//		Timestamp regdate = Timestamp.valueOf(LocalDateTime.now());
//		candidates.setUser_id(null);
//		candidates.setCourse_code("course_code");
//		candidates.setCandidacy_date_time("candidacy_date_time");
//		candidates.setFirstname("firstname");
//		candidates.setLastname("lastname");
//		candidates.setEmail("email");
//		candidates.setRegdate(Timestamp.valueOf(LocalDateTime.now());
//		candidates.setInserted_by("inserted_by");
//		candidates.setCandidate_state_code("candidate_state_code");
//		
//		return candidates;
		return null;
	}
}