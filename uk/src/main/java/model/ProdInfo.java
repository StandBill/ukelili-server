package model;
/**
 * 
 * @author sh-zheng
 * 资源类型
 */
public class ProdInfo {
	private int id;
	private int userId;
	private int typeId;
	private String exp;
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
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	/**
	 * 
	 */
	public ProdInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
