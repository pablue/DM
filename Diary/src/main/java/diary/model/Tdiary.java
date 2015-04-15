package diary.model;

// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tdiary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_diary", catalog = "mydiary")
public class Tdiary implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8595617110610938497L;
	private String diaryId;
	private Ttype ttype;
	private Tuser tuser;
	private String title;
	private String content;
	private Date releaseDate;

	// Constructors

	/** default constructor */
	public Tdiary() {
	}

	/** minimal constructor */
	public Tdiary(String diaryId) {
		this.diaryId = diaryId;
	}

	/** full constructor */
	public Tdiary(String diaryId, Ttype ttype, Tuser tuser, String title, String content, Date releaseDate) {
		this.diaryId = diaryId;
		this.ttype = ttype;
		this.tuser = tuser;
		this.title = title;
		this.content = content;
		this.releaseDate = releaseDate;
	}

	// Property accessors
	@Id
	@Column(name = "diaryId", unique = true, nullable = false, length = 36)
	public String getDiaryId() {
		return this.diaryId;
	}

	public void setDiaryId(String diaryId) {
		this.diaryId = diaryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId")
	public Ttype getTtype() {
		return this.ttype;
	}

	public void setTtype(Ttype ttype) {
		this.ttype = ttype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ReleaseDate", length = 10)
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}