package centauri.academy.proxima.cerepro.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name="surveyreplies")
public class SurveysReplies implements Serializable, EntityInterface{

	private static final long serialVersionUID = -8768834971213658552L;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="survey_id")
	private Long surveyId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="starttime")
//	@Type(type="timestamp")
//	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp startTime;

	@Column(name="endtime")
//	@Type(type="timestamp")
//	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp endTime;
	
	@Column(name="answers")
	private String answer;
	
	@Column(name="pdffilename")
	private String pdfFileName;
	
	@Column(name="points")
	private String points;
	
	/**
	 * 
	 * */
	public SurveysReplies() {
		super();
	}

	/**
	 * 
	 * */
	public SurveysReplies(Long id, Long surveyId, Long userId, Timestamp startTime, Timestamp endTime, String answer,
			String pdfFileName, String points) {
		super();
		this.id = id;
		this.surveyId = surveyId;
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.answer = answer;
		this.pdfFileName = pdfFileName;
		this.points = points;
	}
	
	public SurveysReplies(Long surveyId, Long userId, Timestamp startTime) {
		this(null, surveyId, userId, startTime, null, null, null, null);
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "SurveysReplies [id=" + id + ", surveyId=" + surveyId + ", userId=" + userId + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", answer=" + answer + ", pdfFileName=" + pdfFileName + ", points=" + points
				+ "]";
	}
}
