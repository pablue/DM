package diary.pagemodel;

public class Type {

	private String id; //节点自己 的id
	private String tid; // 父id
	private String typeName;
	private String uid; //是所属的哪个用户

	// 子节点
	// private Set<Ttype> ttypes = new HashSet<Ttype>(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
