package model;


public class UserDownInfo {
	private int id;
	private int userId;
	private int targetId;
	private int typeId;
	private String typename;
	private String date;
	private String username;
	private String filename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public UserDownInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	/**
	 * @param id
	 * @param userId
	 * @param targetId
	 * @param typeId
	 * @param typename
	 * @param date
	 * @param username
	 * @param filename
	 */
	public UserDownInfo(int id, int userId, int targetId, int typeId,
			String typename, String date, String username, String filename) {
		super();
		this.id = id;
		this.userId = userId;
		this.targetId = targetId;
		this.typeId = typeId;
		this.typename = typename;
		this.date = date;
		this.username = username;
		this.filename = filename;
	}
	
}
