package centauri.academy.proxima.cerepro.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * @author JESUS   jesusr.bojorquez@gmail.com
 *
 */
@Entity
@Table(name = "candidate_states")
public class CandidateStates implements EntityInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long role_id;
	private int status_code;
	
	private String status_label;
	private String status_description;
	
	private String status_color;

	/**
	 * 
	 */
	public CandidateStates() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param role_id
	 * @param status_code
	 * @param status_label
	 * @param status_description
	 * @param status_color
	 */
	public CandidateStates(Long id, Long role_id, int status_code, String status_label, String status_description,
			String status_color) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.status_code = status_code;
		this.status_label = status_label;
		this.status_description = status_description;
		this.status_color = status_color;
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
	 * @return the role_id
	 */
	public Long getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	/**
	 * @return the status_code
	 */
	public int getStatus_code() {
		return status_code;
	}

	/**
	 * @param status_code the status_code to set
	 */
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	/**
	 * @return the status_label
	 */
	public String getStatus_label() {
		return status_label;
	}

	/**
	 * @param status_label the status_label to set
	 */
	public void setStatus_label(String status_label) {
		this.status_label = status_label;
	}

	/**
	 * @return the status_description
	 */
	public String getStatus_description() {
		return status_description;
	}

	/**
	 * @param status_description the status_description to set
	 */
	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}

	/**
	 * @return the status_color
	 */
	public String getStatus_color() {
		return status_color;
	}

	/**
	 * @param status_color the status_color to set
	 */
	public void setStatus_color(String status_color) {
		this.status_color = status_color;
	}

	@Override
	public String toString() {
		return "CandidateStates [id=" + id + ", role_id=" + role_id + ", status_code=" + status_code + ", status_label="
				+ status_label + ", status_description=" + status_description + ", status_color=" + status_color + "]";
	}
	
	
	
}
