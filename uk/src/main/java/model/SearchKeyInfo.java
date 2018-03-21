package model;
/**
 * 
 * @author sh-zheng
 * 用户搜索条件类
 */
public class SearchKeyInfo {
	private String typeId;
	private String filename;
	private String userId;
	private int index;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @param typeId
	 * @param filename
	 * @param userId
	 */
	public SearchKeyInfo(String typeId, String filename, String userId) {
		super();
		this.typeId = typeId;
		this.filename = filename;
		this.userId = userId;
	}
	/**
	 * 
	 */
	public SearchKeyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
