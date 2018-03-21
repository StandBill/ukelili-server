package controller;

/**
 * 上传文件到阿里云OSS
 * 
 * HelloOSS是OSS Java SDK的示例程序，您可以修改endpoint、accessKeyId、accessKeySecret、bucketName后直接运行。
 * 运行方法请参考README。
 * 
 * 本示例中的并不包括OSS Java SDK的所有功能，详细功能及使用方法，请参看“SDK手册 > Java-SDK”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/preface.html?spm=5176.docoss/sdk/java-sdk/。
 * 
 * 调用OSS Java SDK的方法时，抛出异常表示有错误发生；没有抛出异常表示成功执行。
 * 当错误发生时，OSS Java SDK的方法会抛出异常，异常中包括错误码、错误信息，详细请参看“SDK手册 > Java-SDK > 异常处理”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/exception.html?spm=5176.docoss/api-reference/error-response。
 * 
 * OSS控制台可以直观的看到您调用OSS Java SDK的结果，OSS控制台地址是：https://oss.console.aliyun.com/index#/。
 * OSS控制台使用方法请参看文档中心的“控制台用户指南”， 指南的来链接地址是：https://help.aliyun.com/document_detail/oss/getting-started/get-started.html?spm=5176.docoss/user_guide。
 * 
 * OSS的文档中心地址是：https://help.aliyun.com/document_detail/oss/user_guide/overview.html。
 * OSS Java SDK的文档地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/install.html?spm=5176.docoss/sdk/java-sdk。
 * 
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import com.baidu.ueditor.ActionEnter;

@Controller
@RequestMapping("/file")
public class Upload {
	private static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
	private static String accessKeyId = "LTAI6JcWzXmZ3WcN";
	private static String accessKeySecret = "1DXZaebN8mLeBdCJDu3JMzTHunuV4p";
	private static String bucketName = "ukelili";
	private static String clientpoint = "http://ukelili.oss-cn-shenzhen.aliyuncs.com/";

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		// return OSSUtils.uploadFile(file);
		String result = null;
		MultipartFile file = ((MultipartHttpServletRequest) request)
				.getFile("upfile");
		try {
			// 断点续传
			// 创建OSSClient实例
			// OSSClient ossClient = new OSSClient(endpoint, accessKeyId,
			// accessKeySecret);
			// // 设置断点续传请求
			// UploadFileRequest uploadFileRequest = new
			// UploadFileRequest(bucketName,key);
			// // 指定上传的本地文件
			// uploadFileRequest.setUploadFile("E:\\迅雷下载\\【BT首发】【BTshoufa.com】[玩命速递：重启之战][BluRay-720P.MKV][2.51GB][内封中英]\\www.BTshoufa.com.mp4");
			// // 指定上传并发线程数
			// uploadFileRequest.setTaskNum(5);
			// // 指定上传的分片大小
			// uploadFileRequest.setPartSize(1 * 1024 * 1024);
			// // 开启断点续传
			// uploadFileRequest.setEnableCheckpoint(true);
			// // 断点续传上传
			// ossClient.uploadFile(uploadFileRequest);
			// // 关闭client
			// ossClient.shutdown();

			// 普通上传
			// endpoint以杭州为例，其它region请按实际情况填写
			// accessKey请登录https://ak-console.aliyun.com/#/查看
			// 创建OSSClient实例
			// OSSClient ossClient = new OSSClient(endpoint, accessKeyId,
			// accessKeySecret);
			// // 上传文件
			// ossClient.putObject(bucketName, key, new
			// File("E:\\迅雷下载\\【BT首发】【BTshoufa.com】[玩命速递：重启之战][BluRay-720P.MKV][2.51GB][内封中英]\\www.BTshoufa.com.mp4"));
			// // 关闭client
			// ossClient.shutdown();

			// 流式上传
			// 创建OSSClient实例
			ObjectMetadata meta = new ObjectMetadata();
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId,
					accessKeySecret);
			// 上传
			FileInputStream fileInputStream = null;
			InputStream inputStream = file.getInputStream();
			String now = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
			String pkgName = "images/" + now + "/";
			System.out.println(file.getContentType());
			if (file.getContentType().equals("video/mp4")) {
				// String ffmpegPath =
				// request.getSession().getServletContext().getRealPath("/tools/ffmpeg.exe");
				// String codcFilePath = "H:/upload/video/1.flv";
				// String mediaPicPath = "H:/upload/image";
				// String upFilePath = "H:/upload/video/1.flv";
				// boolean r = this.executeCodecs(ffmpegPath, upFilePath,
				// codcFilePath, mediaPicPath);
				// System.out.println(r);
				// if(r){
				// fileInputStream = new FileInputStream(new
				// File(codcFilePath));
				// }else{
				// fileInputStream = (FileInputStream) inputStream;
				// }
				pkgName = "videos/" + now + "/";
				meta.setContentLength(file.getSize());
				meta.setContentType(file.getContentType());
			} else if (file.getContentType().equals("bmp")) {
				meta.setContentType("image/bmp");
			} else if (file.getContentType().equals("gif")) {
				meta.setContentType("image/gif");
			} else if (file.getContentType().equals("png")
					|| file.getContentType().equals("jpeg")
					|| file.getContentType().equals("jpg")) {
				meta.setContentType("image/jpeg");
			}
			String name = UUID.randomUUID().toString().toUpperCase() + "-"
					+ file.getOriginalFilename();
			ossClient.putObject(bucketName, pkgName + name, inputStream, meta);
			// 关闭client
			ossClient.shutdown();
			result = clientpoint + pkgName + name;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "error";
		}
		response.getWriter().write(result);
	}

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	@ResponseBody
	public void uploadImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		response.setHeader("Access-Controll-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");
		out.write(new ActionEnter(request, rootPath).exec());

	}

	/*
	 * 转化视频格式
	 */
	public boolean executeCodecs(String ffmpegPath, String upFilePath,
			String codcFilePath, String mediaPicPath) throws Exception {
		// 创建一个List集合来保存转换视频文件为flv格式的命令
		List<String> convert = new ArrayList<String>();
		convert.add(ffmpegPath); // 添加转换工具路径
		convert.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
		convert.add(upFilePath); // 添加要转换格式的视频文件的路径
		convert.add("-qscale"); // 指定转换的质量
		convert.add("6");
		convert.add("-ab"); // 设置音频码率
		convert.add("64");
		convert.add("-ac"); // 设置声道数
		convert.add("2");
		convert.add("-ar"); // 设置声音的采样频率
		convert.add("22050");
		convert.add("-r"); // 设置帧频
		convert.add("24");
		convert.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
		convert.add(codcFilePath);

		// 创建一个List集合来保存从视频中截取图片的命令
		List<String> cutpic = new ArrayList<String>();
		cutpic.add(ffmpegPath);
		cutpic.add("-i");
		cutpic.add(upFilePath); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
		cutpic.add("-y");
		cutpic.add("-f");
		cutpic.add("image2");
		cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
		cutpic.add("17"); // 添加起始时间为第17秒
		cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
		cutpic.add("0.001"); // 添加持续时间为1毫秒
		cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
		cutpic.add("800*280"); // 添加截取的图片大小为350*240
		cutpic.add(mediaPicPath); // 添加截取的图片的保存路径

		boolean mark = true;
		ProcessBuilder builder = new ProcessBuilder();
		try {
			builder.command(convert);
			builder.redirectErrorStream(true);
			builder.start();

			builder.command(cutpic);
			builder.redirectErrorStream(true);
			// 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
			// 因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
			builder.start();
		} catch (Exception e) {
			mark = false;
			System.out.println(e);
			e.printStackTrace();
		}
		return mark;
	}

	/**
	 * 文件上传Action
	 * 
	 * @param req
	 *            APPLICATION_JSON_VALUE
	 * @return UEDITOR 需要的json格式数据
	 */
	//
	// @RequestMapping(value="/uploadImg",method=RequestMethod.POST)
	// @ResponseBody
	// public Map<String,Object> upload(HttpServletRequest req){
	// Map<String,Object> result = new HashMap<String, Object>();
	// MultipartHttpServletRequest mReq = null;
	// MultipartFile file = null;
	// InputStream is = null ;
	// String fileName = "";
	// // 原始文件名 UEDITOR创建页面元素时的alt和title属性
	// String originalFileName = "";
	// String filePath = "";
	//
	// try {
	// mReq = (MultipartHttpServletRequest)req;
	// // 从config.json中取得上传文件的ID
	// file = mReq.getFile("upfile");
	// // 取得文件的原始文件名称
	// fileName = file.getOriginalFilename();
	//
	// originalFileName = fileName;
	//
	// if(!fileName.isEmpty()){
	// is = file.getInputStream();
	// fileName = FileUtils.reName(fileName);
	// filePath = FileUtils.saveFile(fileName, is, fileuploadPath);
	// } else {
	// throw new IOException("文件名为空!");
	// }
	//
	// result.put("state", "SUCCESS");// UEDITOR的规则:不为SUCCESS则显示state的内容
	// result.put("url",httpPath + filePath);
	// result.put("title", originalFileName);
	// result.put("original", originalFileName);
	// }
	// catch (Exception e) {
	// System.out.println(e.getMessage());
	// result.put("state", "文件上传失败!");
	// result.put("url","");
	// result.put("title", "");
	// result.put("original", "");
	// System.out.println("文件 "+fileName+" 上传失败!");
	// }
	//
	// return result;
	// }
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	

}
