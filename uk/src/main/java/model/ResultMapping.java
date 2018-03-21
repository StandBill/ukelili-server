package model;

public class ResultMapping {
	private boolean status;
	public boolean isStatus() {
		return status;
	}
	private Object ret;
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getRet() {
		return ret;
	}
	public void setRet(Object data) {
		this.ret = data;
	}
	/**
	 * 
	 */
	public ResultMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param status
	 * @param data
	 */
	public ResultMapping(boolean status, Object data) {
		super();
		this.status = status;
		this.ret = data;
	}
	
}
