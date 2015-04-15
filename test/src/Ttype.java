// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Ttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_type"
    ,catalog="mydiary"
)

public class Ttype  implements java.io.Serializable {


    // Fields    

     private String diaryTypeId;
     private Tuser tuser;
     private Ttype ttype;
     private String typeName;
     private Set<Ttype> ttypes = new HashSet<Ttype>(0);
     private Set<Tdiary> tdiaries = new HashSet<Tdiary>(0);


    // Constructors

    /** default constructor */
    public Ttype() {
    }

	/** minimal constructor */
    public Ttype(String diaryTypeId) {
        this.diaryTypeId = diaryTypeId;
    }
    
    /** full constructor */
    public Ttype(String diaryTypeId, Tuser tuser, Ttype ttype, String typeName, Set<Ttype> ttypes, Set<Tdiary> tdiaries) {
        this.diaryTypeId = diaryTypeId;
        this.tuser = tuser;
        this.ttype = ttype;
        this.typeName = typeName;
        this.ttypes = ttypes;
        this.tdiaries = tdiaries;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="diaryTypeId", unique=true, nullable=false, length=36)

    public String getDiaryTypeId() {
        return this.diaryTypeId;
    }
    
    public void setDiaryTypeId(String diaryTypeId) {
        this.diaryTypeId = diaryTypeId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="uid")

    public Tuser getTuser() {
        return this.tuser;
    }
    
    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="tid")

    public Ttype getTtype() {
        return this.ttype;
    }
    
    public void setTtype(Ttype ttype) {
        this.ttype = ttype;
    }
    
    @Column(name="typeName", length=30)

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ttype")

    public Set<Ttype> getTtypes() {
        return this.ttypes;
    }
    
    public void setTtypes(Set<Ttype> ttypes) {
        this.ttypes = ttypes;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ttype")

    public Set<Tdiary> getTdiaries() {
        return this.tdiaries;
    }
    
    public void setTdiaries(Set<Tdiary> tdiaries) {
        this.tdiaries = tdiaries;
    }
   








}