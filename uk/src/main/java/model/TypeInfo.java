package model;

public class TypeInfo {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param id
	 * @param name
	 */
	public TypeInfo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * 
	 */
	public TypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
