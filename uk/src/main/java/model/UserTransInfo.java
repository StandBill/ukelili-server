package model;

public class UserTransInfo {
	private int id;
	private int userId;
	private int targetId;
	private int typeId;
	private String filename;
	private String date;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
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
	/**
	 * @param id
	 * @param userId
	 * @param targetId
	 * @param typeId
	 * @param filename
	 * @param date
	 */
	public UserTransInfo(int id, int userId, int targetId, int typeId,
			String filename, String date) {
		super();
		this.id = id;
		this.userId = userId;
		this.targetId = targetId;
		this.typeId = typeId;
		this.filename = filename;
		this.date = date;
	}
	/**
	 * 
	 */
	public UserTransInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
