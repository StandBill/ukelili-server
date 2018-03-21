package model;

import java.util.Date;

public class ShareInfo {
	private int shareId;
	private int userId;
	private String label;
	private String content;
	private String date;
	private String srcAddress;
	public int getShareId() {
		return shareId;
	}
	public void setShareId(int shareId) {
		this.shareId = shareId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSrcAddress() {
		return srcAddress;
	}
	public void setSrcAddress(String srcAddress) {
		this.srcAddress = srcAddress;
	}
	/**
	 * @param shareId
	 * @param userId
	 * @param label
	 * @param content
	 * @param date
	 * @param srcAddress
	 */
	public ShareInfo(int shareId, int userId, String label, String content,
			String date, String srcAddress) {
		super();
		this.shareId = shareId;
		this.userId = userId;
		this.label = label;
		this.content = content;
		this.date = date;
		this.srcAddress = srcAddress;
	}
	/**
	 * 
	 */
	public ShareInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
