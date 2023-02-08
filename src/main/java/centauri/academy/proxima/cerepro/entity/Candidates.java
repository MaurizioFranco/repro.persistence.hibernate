package centauri.academy.proxima.cerepro.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="candidates")
public class Candidates implements Serializable, EntityInterface{

	private static final long serialVersionUID = -8768834971213658552L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="domicile_city")
	private String domicile_city;
	
	@Column(name="study_qualification")
	private String study_qualification;
	
	@Column(name="graduate")
	private Long graduate;
	
	@Column(name="high_graduate")
	private Long high_graduate;
	
	@Column(name="still_high_graduate")
	private Long still_high_graduate;

	@Column(name="mobile")
	private String mobile;
	
	@Column(name="cv_external_path")
	private String cv_external_path;
	
	@Column(name="course_code")
	private String course_code;
	
	@Column(name="candidacy_date_time")
	private Timestamp candidacy_date_time;
	
	@Column(name="candidate_states_id")
	private Long candidate_states_id;
	
	/**
	 * 
	 * */
	public Candidates() {
		super();
	}

	public Candidates(Long id, Long user_id, String domicile_city, String study_qualification, Long graduate,
			Long high_graduate, Long still_high_graduate, String mobile, String cv_external_path, String course_code,
			Timestamp candidacy_date_time, Long candidate_states_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.domicile_city = domicile_city;
		this.study_qualification = study_qualification;
		this.graduate = graduate;
		this.high_graduate = high_graduate;
		this.still_high_graduate = still_high_graduate;
		this.mobile = mobile;
		this.cv_external_path = cv_external_path;
		this.course_code = course_code;
		this.candidacy_date_time = candidacy_date_time;
		this.candidate_states_id = candidate_states_id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the domicile_city
	 */
	public String getDomicile_city() {
		return domicile_city;
	}

	/**
	 * @param domicile_city the domicile_city to set
	 */
	public void setDomicile_city(String domicile_city) {
		this.domicile_city = domicile_city;
	}

	/**
	 * @return the study_qualification
	 */
	public String getStudy_qualification() {
		return study_qualification;
	}

	/**
	 * @param study_qualification the study_qualification to set
	 */
	public void setStudy_qualification(String study_qualification) {
		this.study_qualification = study_qualification;
	}

	/**
	 * @return the graduate
	 */
	public Long getGraduate() {
		return graduate;
	}

	/**
	 * @param graduate the graduate to set
	 */
	public void setGraduate(Long graduate) {
		this.graduate = graduate;
	}

	/**
	 * @return the high_graduate
	 */
	public Long getHigh_graduate() {
		return high_graduate;
	}

	/**
	 * @param high_graduate the high_graduate to set
	 */
	public void setHigh_graduate(Long high_graduate) {
		this.high_graduate = high_graduate;
	}

	/**
	 * @return the still_high_graduate
	 */
	public Long getStill_high_graduate() {
		return still_high_graduate;
	}

	/**
	 * @param still_high_graduate the still_high_graduate to set
	 */
	public void setStill_high_graduate(Long still_high_graduate) {
		this.still_high_graduate = still_high_graduate;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the cv_external_path
	 */
	public String getCv_external_path() {
		return cv_external_path;
	}

	/**
	 * @param cv_external_path the cv_external_path to set
	 */
	public void setCv_external_path(String cv_external_path) {
		this.cv_external_path = cv_external_path;
	}

	/**
	 * @return the course_code
	 */
	public String getCourse_code() {
		return course_code;
	}

	/**
	 * @param course_code the course_code to set
	 */
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	/**
	 * @return the candidacy_date_time
	 */
	public Timestamp getCandidacy_date_time() {
		return candidacy_date_time;
	}

	/**
	 * @param candidacy_date_time the candidacy_date_time to set
	 */
	public void setCandidacy_date_time(Timestamp candidacy_date_time) {
		this.candidacy_date_time = candidacy_date_time;
	}

	/**
	 * @return the candidate_states_id
	 */
	public Long getCandidate_states_id() {
		return candidate_states_id;
	}

	/**
	 * @param candidate_states_id the candidate_states_id to set
	 */
	public void setCandidate_states_id(Long candidate_states_id) {
		this.candidate_states_id = candidate_states_id;
	}

	@Override
	public String toString() {
		return "Candidates [id=" + id + ", user_id=" + user_id + ", domicile_city=" + domicile_city
				+ ", study_qualification=" + study_qualification + ", graduate=" + graduate + ", high_graduate="
				+ high_graduate + ", still_high_graduate=" + still_high_graduate + ", mobile=" + mobile
				+ ", cv_external_path=" + cv_external_path + ", course_code=" + course_code + ", candidacy_date_time="
				+ candidacy_date_time + ", candidate_states_id=" + candidate_states_id + "]";
	}
}
