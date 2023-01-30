package centauri.academy.proxima.cerepro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author maurizio - m.franco@proximanetwork.it
 *
 */
@Entity
@Table( name = "roles" )
public class Roles implements EntityInterface {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String label;
	private String description;
	private Integer level;
	
	
	
	/**
	 * 
	 */
	public Roles() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param label
	 * @param description
	 * @param level
	 */
	public Roles(Long id, String label, String description, Integer level) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.level = level;
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
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", label=" + label + ", description=" + description + ", level=" + level + "]";
	}
	
}
