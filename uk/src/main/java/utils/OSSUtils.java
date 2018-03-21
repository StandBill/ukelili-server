package utils;

import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;

/**
 * 
 * 阿里云OSS文件上传工具类
 */
public class OSSUtils {
	private static OSSConfig CONFIG = null;

	/**
	 * 文件上传方法
	 */
	public static String uploadFile(MultipartFile file) {
//		System.out.println(file.getContentType());
//		String fileType = file.getContentType().toString().split("/")[1];
//		File target = null;
//		try {
//			target = File.createTempFile("temp.", fileType);
//			InputStream is = new FileInputStream(new File(file.getName()));
//			OutputStream out = new FileOutputStream(target);
//			int readByte = 0;
//			byte[] buffer = new byte[1024];
//			while((readByte = is.read(buffer))!=-1){
//				out.write(buffer,0,readByte);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//		}
		CONFIG = CONFIG == null ? new OSSConfig() : CONFIG;
		String fileName = UUID.randomUUID().toString().toUpperCase().replace("-", "")
				+ ".png" ;
		return putObject(file, file.getContentType().toString(), fileName);
	}

	public static boolean deleteFile(String fileUrl) {
		CONFIG = CONFIG == null ? new OSSConfig() : CONFIG;
		String bucketName = OSSUtils.getBucketName(fileUrl); // 根据url获取bucketName
		String fileName = OSSUtils.getFileName(fileUrl); // 根据url获取fileName
		if (bucketName == null || fileName == null)
			return false;
		OSSClient ossClient = null;
		try {
			ossClient = new OSSClient(CONFIG.getEndpoint(),
					CONFIG.getAccessKeyId(), CONFIG.getAccessKeySecret());
			GenericRequest request = new DeleteObjectsRequest(bucketName)
					.withKey(fileName);
			ossClient.deleteObject(request);
		} catch (Exception oe) {
			oe.printStackTrace();
			return false;
		} finally {
			ossClient.shutdown();
		}
		return true;
	}

	private static String putObject(MultipartFile file, String fileType, String fileName) {
		// TODO Auto-generated method stub
		CONFIG = CONFIG == null ? new OSSConfig() : CONFIG;
		String url = null; // 默认null
		OSSClient ossClient = null;
		try {
			ossClient = new OSSClient(CONFIG.getEndpoint(),
					CONFIG.getAccessKeyId(), CONFIG.getAccessKeySecret());
			InputStream input = file.getInputStream();
			ObjectMetadata meta = new ObjectMetadata(); // 创建上传Object的Metadata
			meta.setContentType(OSSUtils.contentType(fileType)); // 设置上传内容类型
			meta.setCacheControl("no-cache"); // 被下载时网页的缓存行为
			PutObjectRequest request = new PutObjectRequest(
					CONFIG.getBucketName(), fileName, input, meta); // 创建上传请求
			ossClient.putObject(request);
			url = CONFIG.getEndpoint().replaceFirst("http://",
					"http://" + CONFIG.getBucketName() + ".")
					+ "/" + fileName; // 上传成功再返回的文件路径
		} catch (OSSException oe) {
			oe.printStackTrace();
			return null;
		} catch (ClientException ce) {
			ce.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ossClient.shutdown();
		}
		return url;
	}

	private static String contentType(String fileType) {
		fileType = fileType.toLowerCase();
		String contentType = "";
		if(fileType.equals("bmp")){
			contentType = "image/bmp";
		}else if(fileType.equals("gif")){
			contentType = "image/gif";
		}else if(fileType.equals("png") || fileType.equals("jpeg") || fileType.equals("jpg")){
			contentType = "image/jpeg";
		}else if(fileType.equals("html")){
			contentType = "text/html";
		}else if(fileType.equals("txt")){
			contentType = "text/plain";
		}else if(fileType.equals("ppt") || fileType.equals("pptx")){
			contentType = "application/vnd.ms-powerpoint";
		}else if(fileType.equals("doc") || fileType.equals("docx")){
			contentType = "application/msword";
		}else if(fileType.equals("xml")){
			contentType = "text/xml";
		}else if(fileType.equals("mp4")){
			contentType = "video/mp4";
		}else{
			contentType = "application/octet-stream";
		}
//		switch (fileType) {
//		case "bmp":
//			contentType = "image/bmp";
//			break;
//		case "gif":
//			contentType = "image/gif";
//			break;
//		case "png":
//		case "jpeg":
//		case "jpg":
//			contentType = "image/jpeg";
//			break;
//		case "html":
//			contentType = "text/html";
//			break;
//		case "txt":
//			contentType = "text/plain";
//			break;
//		case "vsd":
//			contentType = "application/vnd.visio";
//			break;
//		case "ppt":
//		case "pptx":
//			contentType = "application/vnd.ms-powerpoint";
//			break;
//		case "doc":
//		case "docx":
//			contentType = "application/msword";
//			break;
//		case "xml":
//			contentType = "text/xml";
//			break;
//		case "mp4":
//			contentType = "video/mp4";
//			break;
//		default:
//			contentType = "application/octet-stream";
//			break;
//		}
		return contentType;
	}

	private static String getBucketName(String fileUrl) {
		String http = "http://";
		String https = "https://";
		int httpIndex = fileUrl.indexOf(http);
		int httpsIndex = fileUrl.indexOf(https);
		int startIndex = 0;
		if (httpIndex == -1) {
			if (httpsIndex == -1) {
				return null;
			} else {
				startIndex = httpsIndex + https.length();
			}
		} else {
			startIndex = httpIndex + http.length();
		}
		int endIndex = fileUrl.indexOf(".oss-");
		return fileUrl.substring(startIndex, endIndex);
	}

	private static String getFileName(String fileUrl) {
		String str = "aliyuncs.com/";
		int beginIndex = fileUrl.indexOf(str);
		if (beginIndex == -1)
			return null;
		return fileUrl.substring(beginIndex + str.length());
	}

	private static List<String> getFileName(List<String> fileUrls){  
        List<String> names = new ArrayList<String>();  
        for (String url : fileUrls) {  
            names.add(getFileName(url));  
        }  
        return names;  
    }

	public static void uploadImgAliyun(InputStream content, long length,
			String fileName) {
		CONFIG = CONFIG == null ? new OSSConfig() : CONFIG;
		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentType("video/mp4");
		OSSClient ossClient = new OSSClient(CONFIG.getBucketName(), CONFIG.getAccessKeyId(), CONFIG.getAccessKeySecret());
		// 上传
		InputStream inputStream = content;
		String name = UUID.randomUUID().toString().toUpperCase() + "-" + fileName;
		ossClient.putObject(CONFIG.getBucketName(),name, inputStream,meta);
		// 关闭client
		ossClient.shutdown();
	}
}
