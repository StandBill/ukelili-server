package utils;

public class OSSConfig {
	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;
	private String imageLoc;
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getImageLoc() {
		return imageLoc;
	}
	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}
	
	public OSSConfig(){
		try {
			this.endpoint = SystemConfig.getConfigResource("endpoint");
			this.bucketName = SystemConfig.getConfigResource("bucketName");
			this.accessKeyId = SystemConfig.getConfigResource("accessKeyId");
			this.accessKeySecret = SystemConfig.getConfigResource("accessKeySecret");
			this.imageLoc = SystemConfig.getConfigResource("imageLoc");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
