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
* 		  This is a <b>POJO</b> (Entity) that will mapped in questions table called 'surveyquestions' in database
* 
* */
@Entity
@Table(name="surveyquestions")
public class SurveysQuestions implements Serializable, EntityInterface{

	
	private static final long serialVersionUID = 3727082917581960828L;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="survey_id")
	private Long surveyId;
	
	@Column(name="question_id")
	private Long questionId;
	
	@Column(name="position")
	private Integer position;

	/**
	 * 
	 * */
	public SurveysQuestions() {
		super();
	}


	/**
	 * 
	 * */
	public SurveysQuestions(Long id, Long surveyId, Long questionId, Integer postions) {
		super();
		this.id = id;
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.position = postions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "SurveyQuestions [id=" + id + ", surveyId=" + surveyId + ", questionId=" + questionId + ", postions="
				+ position + "]";
	}
}
