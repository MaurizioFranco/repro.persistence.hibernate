package centauri.academy.proxima.cerepro.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author daniel
 * 
 */
@Entity
@Table(name = "surveys")
public class Surveys implements Serializable, EntityInterface {

	private static final long serialVersionUID = 3886910315080465338L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private Integer time;
	private String description;

	public Surveys() {
		super();
	}

	/**
	 * @param id
	 * @param label
	 * @param time
	 * @param description
	 * 
	 */

	public Surveys(Long id, String label, Integer time, String description) {
		super();
		this.id = id;
		this.label = label;
		this.time = time;
		this.description = description;
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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the time
	 */
	public Integer getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Integer time) {
		this.time = time;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Surveys [id=" + id + ", label=" + label + ", time=" + time + ", description=" + description + "]";
	}

}
