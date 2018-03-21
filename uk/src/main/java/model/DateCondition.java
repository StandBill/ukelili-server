package model;

public class DateCondition {
	private String start;
	private String end;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	/**
	 * @param start
	 * @param end
	 * @param userId
	 */
	public DateCondition(String start, String end, String userId) {
		super();
		this.start = start;
		this.end = end;
		this.userId = userId;
	}
	/**
	 * 
	 */
	public DateCondition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
