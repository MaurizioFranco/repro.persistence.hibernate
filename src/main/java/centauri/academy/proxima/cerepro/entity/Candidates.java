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
	
	@Column(name="course_code")
	private String course_code;
	
	@Column(name="candidacy_date_time")
	private Timestamp candidacy_date_time;
	
	/**
	 * 
	 * */
	public Candidates() {
		super();
	}

	public Candidates(Long id, Long user_id, String course_code, Timestamp candidacy_date_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.course_code = course_code;
		this.candidacy_date_time = candidacy_date_time;
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

	@Override
	public String toString() {
		return "Candidates [id=" + id + ", user_id=" + user_id + ", course_code=" + course_code
				+ ", candidacy_date_time=" + candidacy_date_time
				+ "]";
	}
}
