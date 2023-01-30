/**
 * 
 */
package centauri.academy.proxima.cerepro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gabriel
 *
 */

@Entity
@Table(name = "origin_sites")
public class OriginSites implements EntityInterface {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private String description;
	private String imgpath;

	public OriginSites() {
		super();
	}
	
	public OriginSites(Long i, String label, String description, String imgpath) {
		super();
		this.id = i;
		this.label = label;
		this.description = description;
		this.imgpath = imgpath;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return id the id to set
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
	 * @return label the label to set
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
	 * @return description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}

	/**
	 * @return imgpath the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	@Override
	public String toString() {
		return "origins_site [id=" + id + ", label=" + label + ", description=" + description + ", imgpath=" + imgpath
				+ "]";
	}
}
