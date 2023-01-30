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
@Table(name = "users")
public class User implements EntityInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	//@Column(name = firstname); in case of Camel convention
	private String firstname;
	private String lastname;
	private java.sql.Date dateofbirth;// 
	private java.sql.Timestamp regdate;// cambiado
	private Integer role;
	private String imgpath;
	private String note;
	private Integer enabled;
	/**
	 * 
	 */
	public User() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param dateofbirth
	 * @param regdate
	 * @param role
	 * @param imgpath
	 * @param note
	 * @param enabled
	 */
	public User(Long id, String email, String password, String firstname, String lastname, Date dateofbirth,
			Timestamp regdate, int role, String imgpath, String note, int enabled) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.regdate = regdate;
		this.role = role;
		this.imgpath = imgpath;
		this.note = note;
		this.enabled = enabled;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the dateofbirth
	 */
	public java.sql.Date getDateofbirth() {
		return dateofbirth;
	}
	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(java.sql.Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * @return the regdate
	 */
	public Timestamp getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}
	/**
	 * @param imgpath the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the enabled
	 */
	public int getenabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setenabled(int enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dateofbirth=" + dateofbirth + ", regdate=" + regdate + ", role=" + role
				+ ", imgpath=" + imgpath + ", note=" + note + ", enabled=" + enabled + "]";
	}
	
	
	
}
