package sy.test;


import java.util.Calendar;
import java.util.List;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.*;
import checkcode.MobileMessageSend;

import com.alibaba.fastjson.JSON;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {
	@Test
	public void test(){
//		Date now = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(format.format(now));
//		System.out.println(Calendar.getInstance().get(Calendar.MONTH)+"*"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
//		String msg = "init";
//		try {
//			msg = MobileMessageSend.sendMsg("18826252119");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("msg....."+msg);
	}
//	private static final Logger logger = Logger.getLogger(TestMybatis.class);
//
//	private IUserService userService;
//	private IVideoService videoService;
//	private ICommentService commentService;
//	private IShareInfoService siService;
//	private ITypeInfoService typeInfoService;
//	private ITextInfoService textInfoService;
//	private IUserDownInfoService userDownInfoService;
//	
//	
//	public IUserDownInfoService getUserDownInfoService() {
//		return userDownInfoService;
//	}
//	@Autowired
//	public void setUserDownInfoService(IUserDownInfoService userDownInfoService) {
//		this.userDownInfoService = userDownInfoService;
//	}
//	public ITextInfoService getTextInfoService() {
//		return textInfoService;
//	}
//	@Autowired
//	public void setTextInfoService(ITextInfoService textInfoService) {
//		this.textInfoService = textInfoService;
//	}
//	public ITypeInfoService getTypeInfoService() {
//		return typeInfoService;
//	}
//	@Autowired
//	public void setTypeInfoService(ITypeInfoService typeInfoService) {
//		this.typeInfoService = typeInfoService;
//	}
//	public ICommentService getCommentService() {
//		return commentService;
//	}
//	@Autowired
//	public void setCommentService(ICommentService commentService) {
//		this.commentService = commentService;
//	}
//	public IShareInfoService getSiService() {
//		return siService;
//	}
//	@Autowired
//	public void setSiService(IShareInfoService siService) {
//		this.siService = siService;
//	}
//	@Test
//	public void test() {
////		Comment c = new Comment(1, 40,2 , "jggj", String.valueOf(new java.sql.Date((new Date()).getTime())), "dsfsf");
//		//VideoInfo vi = new VideoInfo(-1, "d", 10, 10, "", 4,String.valueOf(new java.sql.Date((new Date()).getTime())), 1, 0,"ff");
////		ShareInfo si = new ShareInfo(1, 4, "dfd", "sdfs", String.valueOf(new java.sql.Date((new Date()).getTime())), "ff");
//		SearchKeyInfo keys = new SearchKeyInfo( "6", "%a%","5");
//		String[] s = {"5","6","%a%"};
////		siService.addOne(si);
////		TypeInfo ti = new TypeInfo("3", "others");
//		TextInfo ti = new TextInfo(2, "a", 0, 0,"fff",5, String.valueOf(new java.sql.Date((new Date()).getTime())), 0, 0);
//		List<UserDownInfo> result = userDownInfoService.selectByKey(keys);
//		logger.info(JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss"));
//	}
	

	

}
