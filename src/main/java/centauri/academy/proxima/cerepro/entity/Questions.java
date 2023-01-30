package centauri.academy.proxima.cerepro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Roberto
 * 
 * 
 * 			This is a <b>POJO</b> (Entity) that will mapped in questions table called 'surveys' in database
 * 
 * */
@Entity
@Table(name="questions")
public class Questions implements Serializable, EntityInterface{
	
	private static final long serialVersionUID = 8628189618240848172L;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="label")
	private String label;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ansa")
	private String ansa;
	
	@Column(name="ansb")
	private String ansb;
	
	@Column(name="ansc")
	private String ansc;
	
	@Column(name="ansd")
	private String ansd;
	
	@Column(name="anse")
	private String anse;
	
	@Column(name="ansf")
	private String ansf;
	
	@Column(name="ansg")
	private String ansg;
	
	@Column(name="ansh")
	private String ansh;
	
	@Column(name="cansa")
	private Boolean cansa;
	
	@Column(name="cansb")
	private Boolean cansb;
	
	@Column(name="cansc")
	private Boolean cansc;
	
	@Column(name="cansd")
	private Boolean cansd;
	
	@Column(name="canse")
	private Boolean canse;
	
	@Column(name="cansf")
	private Boolean cansf;
	
	@Column(name="cansg")
	private Boolean cansg;
	
	@Column(name="cansh")
	private Boolean cansh;
	
	@Column(name="full_answer")
	private String fullAnswer;
	
	/**
	 * 
	 * */
	public Questions() {
		super();
	}

	/**
	 * 
	 * */
	public Questions(Long id, String label, String description, String ansa, String ansb, String ansc, String ansd,
			String anse, String ansf, String ansg, String ansh, Boolean cansa, Boolean cansb, Boolean cansc,
			Boolean cansd, Boolean canse, Boolean cansf, Boolean cansg, Boolean cansh) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.ansa = ansa;
		this.ansb = ansb;
		this.ansc = ansc;
		this.ansd = ansd;
		this.anse = anse;
		this.ansf = ansf;
		this.ansg = ansg;
		this.ansh = ansh;
		this.cansa = cansa;
		this.cansb = cansb;
		this.cansc = cansc;
		this.cansd = cansd;
		this.canse = canse;
		this.cansf = cansf;
		this.cansg = cansg;
		this.cansh = cansh;
	}

	public Questions(Long id, String label, String description) {
		this(id, label, description, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAnsa() {
		return ansa;
	}

	public void setAnsa(String ansa) {
		this.ansa = ansa;
	}

	public String getAnsb() {
		return ansb;
	}

	public void setAnsb(String ansb) {
		this.ansb = ansb;
	}

	public String getAnsc() {
		return ansc;
	}

	public void setAnsc(String ansc) {
		this.ansc = ansc;
	}

	public String getAnsd() {
		return ansd;
	}

	public void setAnsd(String ansd) {
		this.ansd = ansd;
	}

	public String getAnse() {
		return anse;
	}

	public void setAnse(String anse) {
		this.anse = anse;
	}

	public String getAnsf() {
		return ansf;
	}

	public void setAnsf(String ansf) {
		this.ansf = ansf;
	}

	public String getAnsg() {
		return ansg;
	}

	public void setAnsg(String ansg) {
		this.ansg = ansg;
	}

	public String getAnsh() {
		return ansh;
	}

	public void setAnsh(String ansh) {
		this.ansh = ansh;
	}


	public Boolean getCansa() {
		return cansa;
	}

	public void setCansa(Boolean cansa) {
		this.cansa = cansa;
	}


	public Boolean getCansb() {
		return cansb;
	}

	public void setCansb(Boolean cansb) {
		this.cansb = cansb;
	}

	public Boolean getCansc() {
		return cansc;
	}


	public void setCansc(Boolean cansc) {
		this.cansc = cansc;
	}

	public Boolean getCansd() {
		return cansd;
	}

	public void setCansd(Boolean cansd) {
		this.cansd = cansd;
	}

	public Boolean getCanse() {
		return canse;
	}

	public void setCanse(Boolean canse) {
		this.canse = canse;
	}

	public Boolean getCansf() {
		return cansf;
	}

	public void setCansf(Boolean cansf) {
		this.cansf = cansf;
	}

	public Boolean getCansg() {
		return cansg;
	}

	public void setCansg(Boolean cansg) {
		this.cansg = cansg;
	}

	public Boolean getCansh() {
		return cansh;
	}

	public void setCansh(Boolean cansh) {
		this.cansh = cansh;
	}
	
	public void setFullAnswer(String fullAnswer) {
		this.fullAnswer = fullAnswer;
	}
	
	public String getFullAnswer() {
		return fullAnswer;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", label=" + label + ", description=" + description + ", ansa=" + ansa
				+ ", ansb=" + ansb + ", ansc=" + ansc + ", ansd=" + ansd + ", anse=" + anse + ", ansf=" + ansf
				+ ", ansg=" + ansg + ", ansh=" + ansh + ", cansa=" + cansa + ", cansb=" + cansb + ", cansc=" + cansc
				+ ", cansd=" + cansd + ", canse=" + canse + ", cansf=" + cansf + ", cansg=" + cansg + ", cansh=" + cansh
				+ "]";
	}
	
}
