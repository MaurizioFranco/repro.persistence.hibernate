package centauri.academy.proxima.cerepro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coursepage")
public class CoursePage implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String code;
	private String body_text;
	private String file_name;

	public CoursePage() {
		super();
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the body_text
	 */
	public String getBody_text() {
		return body_text;
	}

	/**
	 * @param body_text the body_text to set
	 */
	public void setBody_text(String body_text) {
		this.body_text = body_text;
	}

	/**
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * @param file_name the file_name to set
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	@Override
	public String toString() {
		return "CoursePage [id=" + id + ", title=" + title + ", code=" + code + ", body_text=" + body_text
				+ ", file_name=" + file_name + "]";
	}

}
