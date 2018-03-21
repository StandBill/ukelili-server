package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ResultMapping;
import model.VideoInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import service.IVideoService;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.*;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.*;

@Controller
@RequestMapping("/qiniu")
public class Qiniu {
	ResultMapping result = new ResultMapping();
	private IVideoService videoService;

	public IVideoService getVideoService() {
		return videoService;
	}

	@Autowired
	public void setVideoService(IVideoService videoService) {
		this.videoService = videoService;
	}

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	static String ACCESS_KEY = "M6wjKAsaXfT4gtdbu9fe76qA-LQldwQQ21QdhVQv";
	static String SECRET_KEY = "_p0MroCwraB_a9ScVFftg1Vl3WwUqhW1bnE5emhB";
	// 要上传的空间
	static String bucketname = "ukelili";
	Auth auth = null;
	String pfops = null;
	String pipeline = null;

	// 上传策略中设置persistentOps字段和persistentPipeline字段
	public String getUpToken() {
		return auth.uploadToken(bucketname, null, 3600,
				new StringMap().putNotEmpty("persistentOps", pfops)
						.putNotEmpty("persistentPipeline", pipeline), true);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public ResultMapping upload(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "key", required = true) String key)
			throws IOException {
		// System.out.println(file.getOriginalFilename());
		try {
			// 上传到七牛后保存的文件名
			// 上传文件的路径
			Configuration cfg = new Configuration(Zone.zone2());
			// 设置转码操作参数
			String fops = "avthumb/mp4/ab/160k/ar/44100/acodec/libfaac/r/30/vb/2200k/vcodec/libx264/s/1280x720/autoscale/1/stripmeta/0";
			// 设置转码的队列
			String frame = "vframe/jpg/offset/7/w/480/h/360";
			// 设置转码的队列
			pipeline = "translate-video";
			// String now = (new
			// SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")).format(new Date());
			// String key = UUID.randomUUID().toString().toUpperCase() + "-"
			// +now;
			// 可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
			String urlbase64 = UrlSafeBase64.encodeToString("ukelili:" + key
					+ ".mp4");
			pfops = fops + "|saveas/" + urlbase64 + ";" + frame + "|saveas/"
					+ UrlSafeBase64.encodeToString("ukelili:" + key + ".jpg");

			// 密钥配置
			auth = Auth.create(ACCESS_KEY, SECRET_KEY);
			// 创建上传对象
			UploadManager uploadManager = new UploadManager(cfg);

			// 调用put方法上传
			Response res = uploadManager.put(file.getBytes(), key + "-origin-"
					+ file.getOriginalFilename(), getUpToken());
			// 打印返回的信息
			System.out.println(res.bodyString());
			if (res.bodyString().indexOf("persistentId") > 0) {
				result.setStatus(true);
				result.setRet("http://ooqpf67rp.bkt.clouddn.com/" + key);
				videoService.upStatus("http://ooqpf67rp.bkt.clouddn.com/" + key
						+ ".mp4");
			} else {
				result.setStatus(false);
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			result.setStatus(false);
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
				result.setStatus(false);
			}
		}
		return result;
	}

	@RequestMapping(value = "/MobileAdd", method = RequestMethod.POST)
	@ResponseBody
	public ResultMapping MobileUpload(
			@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "date", required = true) String date,
			@RequestParam(value = "can_down", required = true) String can_down,
			@RequestParam(value = "can_transmit", required = true) String can_transmit,
			@RequestParam(value = "can_discuss", required = true) String can_discuss,
			@RequestParam(value = "explain", required = true) String explain,
			@RequestParam(value = "prodId", required = true) String prodId,
			@RequestParam(value = "key", required = true) String key)
			throws IOException {
		String image = "http://ukelili.oss-cn-shenzhen.aliyuncs.com/images/" + (new SimpleDateFormat("yyyyMMdd")).format(new Date()) + "/" +
				key + ".jpg";
		String srcPath = "http://ooqpf67rp.bkt.clouddn.com/" + key + ".mp4";
		VideoInfo vi = new VideoInfo();
		vi.setName(name);
		vi.setUserId(Integer.valueOf(userId));
		vi.setDate(date);
		vi.setCan_down(Integer.valueOf(can_down));
		vi.setCan_discuss(Integer.valueOf(can_discuss));
		vi.setCan_transmit(Integer.valueOf(can_transmit));
		vi.setDescription(explain);
		vi.setProdId(Integer.valueOf(prodId));
		vi.setSrcAddress(srcPath);
		vi.setImage(image);
		result.setStatus(false);
		if(videoService.addVideo(vi) > 0){
			result.setStatus(true);
		}
		return result;
	}

	@RequestMapping(value = "/upToOSS", method = RequestMethod.POST)
	@ResponseBody
	public String upToOSS(@RequestParam(value = "file", required = true) MultipartFile file) {
		String path = "";
//		MultipartFile file = ((MultipartHttpServletRequest) request)
//				.getFile("file");
//		System.out.println(file.getOriginalFilename());
		try {
			String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
			String accessKeyId = "LTAI6JcWzXmZ3WcN";
			String accessKeySecret = "1DXZaebN8mLeBdCJDu3JMzTHunuV4p";
			String bucketName = "ukelili";
			String clientpoint = "http://ukelili.oss-cn-shenzhen.aliyuncs.com/";
			ObjectMetadata meta = new ObjectMetadata();
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId,
					accessKeySecret);
			// 上传
			InputStream inputStream = file.getInputStream();
			String now = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
			String pkgName = "images/" + now + "/";
			System.out.println(file.getContentType());
			if (file.getContentType().equals("bmp")) {
				meta.setContentType("image/bmp");
			} else if (file.getContentType().equals("gif")) {
				meta.setContentType("image/gif");
			} else if (file.getContentType().equals("png")
					|| file.getContentType().equals("jpeg")
					|| file.getContentType().equals("jpg")) {
				meta.setContentType("image/jpeg");
			}
//			String name = UUID.randomUUID().toString().toUpperCase() + "-"
//					+ file.getOriginalFilename();
			ossClient.putObject(bucketName, pkgName + file.getOriginalFilename(), inputStream, meta);
			// 关闭client
			ossClient.shutdown();
			path = clientpoint + pkgName + file.getOriginalFilename();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return path;
	}
	
	@RequestMapping(value = "/upToQiniu", method = RequestMethod.POST)
	@ResponseBody
	public String upToQiniu(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
		String srcPath = "";
		try {
			// 上传到七牛后保存的文件名
			// 上传文件的路径
			Configuration cfg = new Configuration(Zone.zone2());
			// 设置转码操作参数
			String fops = "avthumb/mp4/ab/160k/ar/44100/acodec/libfaac/r/30/vb/2200k/vcodec/libx264/s/1280x720/autoscale/1/stripmeta/0";

			// 设置转码的队列
			pipeline = "translate-video";
			// 可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
			String urlbase64 = UrlSafeBase64.encodeToString("ukelili:" + file.getOriginalFilename());
			pfops = fops + "|saveas/" + urlbase64;

			// 密钥配置
			auth = Auth.create(ACCESS_KEY, SECRET_KEY);
			// 创建上传对象
			UploadManager uploadManager = new UploadManager(cfg);

			// 调用put方法上传
			Response res = uploadManager.put(file.getBytes(),  "origin-"
					+ file.getOriginalFilename(), getUpToken());
			// 打印返回的信息
			System.out.println(res.bodyString());
			if (res.bodyString().indexOf("persistentId") > 0) {
				srcPath = "http://ooqpf67rp.bkt.clouddn.com/" + file.getOriginalFilename();
				videoService.upStatus("http://ooqpf67rp.bkt.clouddn.com/" + file.getOriginalFilename());
			} else {
				result.setStatus(false);
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			result.setStatus(false);
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
				result.setStatus(false);
			}
		}
		return srcPath;
	}
}