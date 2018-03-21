package model;


public class TextInfo {
	private int textId;
	private String name;
	private int downloads;
	private int transmits;
	private String srcAddress;
	private int userId;
	private String date;
	private int can_down;
	private int can_transmit;
	private int can_discuss;
	private int proId;
	private int coms;
	private String content;
	private User user;
	private ProdInfo prod;
	private Comment comment;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getComs() {
		return coms;
	}
	public void setComs(int coms) {
		this.coms = coms;
	}

	public ProdInfo getProd() {
		return prod;
	}
	public void setProd(ProdInfo prod) {
		this.prod = prod;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public int getCan_discuss() {
		return can_discuss;
	}
	public void setCan_discuss(int can_discuss) {
		this.can_discuss = can_discuss;
	}
	public int getTextId() {
		return textId;
	}
	public void setTextId(int textId) {
		this.textId = textId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public int getTransmits() {
		return transmits;
	}
	public void setTransmits(int transmits) {
		this.transmits = transmits;
	}
	public String getSrcAddress() {
		return srcAddress;
	}
	public void setSrcAddress(String srcAddress) {
		this.srcAddress = srcAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCan_down() {
		return can_down;
	}
	public void setCan_down(int can_down) {
		this.can_down = can_down;
	}
	public int getCan_transmit() {
		return can_transmit;
	}
	public void setCan_transmit(int can_transmit) {
		this.can_transmit = can_transmit;
	}
	
	public TextInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
