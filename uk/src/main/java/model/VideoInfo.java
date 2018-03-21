package model;


public class VideoInfo {
	private int videoId;
	private String name;
	private int downloads;
	private int transmits;
	private String srcAddress;
	private int userId;
	private String date;
	private int can_down;
	private int can_transmit;
	private int can_discuss;
	private String image;
	private int coms;
	private String description;
	private int prodId;
	private User user;
	private ProdInfo prod;
	
	public int getComs() {
		return coms;
	}
	public void setComs(int coms) {
		this.coms = coms;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User u) {
		this.user = u;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * 
	 */
	public VideoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param videoId
	 * @param name
	 * @param downloads
	 * @param transmits
	 * @param srcAddress
	 * @param userId
	 * @param date
	 * @param can_down
	 * @param can_transmit
	 * @param image
	 * @param coms
	 * @param user
	 */
	public VideoInfo(int videoId, String name, int downloads, int transmits,
			String srcAddress, int userId, String date, int can_down,
			int can_transmit, String image, int coms, User user) {
		super();
		this.videoId = videoId;
		this.name = name;
		this.downloads = downloads;
		this.transmits = transmits;
		this.srcAddress = srcAddress;
		this.userId = userId;
		this.date = date;
		this.can_down = can_down;
		this.can_transmit = can_transmit;
		this.image = image;
		this.coms = coms;
		this.user = user;
	}
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getCan_discuss() {
		return can_discuss;
	}
	public void setCan_discuss(int can_discuss) {
		this.can_discuss = can_discuss;
	}
	@Override
	public String toString() {
		return "VideoInfo [videoId=" + videoId + ", name=" + name
				+ ", downloads=" + downloads + ", transmits=" + transmits
				+ ", srcAddress=" + srcAddress + ", userId=" + userId
				+ ", date=" + date + ", can_down=" + can_down
				+ ", can_transmit=" + can_transmit + ", can_discuss="
				+ can_discuss + ", image=" + image + ", coms=" + coms
				+ ", description=" + description + ", prodId=" + prodId + ", user="
				+ user + "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProdInfo getProd() {
		return prod;
	}
	public void setProd(ProdInfo prod) {
		this.prod = prod;
	}
}
