package diary.model;

// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "mydiary")
public class Tuser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5399687983680407179L;
	private String userId;
	private String userName;
	private String password;
	private String nickName;
	private String imageName;
	private String mood;
	private Set<Tdiary> tdiaries = new HashSet<Tdiary>(0);
	private Set<Ttype> ttypes = new HashSet<Ttype>(0);

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public Tuser(String userId, String userName, String password, String nickName, String imageName, String mood, Set<Tdiary> tdiaries, Set<Ttype> ttypes) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.imageName = imageName;
		this.mood = mood;
		this.tdiaries = tdiaries;
		this.ttypes = ttypes;
	}

	// Property accessors
	@Id
	@Column(name = "userId", unique = true, nullable = false, length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickName", length = 20)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "imageName", length = 40)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = "mood", length = 200)
	public String getMood() {
		return this.mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Tdiary> getTdiaries() {
		return this.tdiaries;
	}

	public void setTdiaries(Set<Tdiary> tdiaries) {
		this.tdiaries = tdiaries;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Ttype> getTtypes() {
		return this.ttypes;
	}

	public void setTtypes(Set<Ttype> ttypes) {
		this.ttypes = ttypes;
	}

}