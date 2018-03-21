package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.*;

import model.DateCondition;
import model.ResultMapping;
import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import service.IUserService;

@Controller
@RequestMapping("/uk")
public class UserController extends ResultMapping {
	private ResultMapping result = new ResultMapping();
	private IUserService userService;
	private User u = new User();
	public IUserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public ResultMapping login(@RequestParam(value="username", required=true) String username,@RequestParam(value="password", required=true) String password
			) {
		
//		res.setCharacterEncoding("utf-8");
//		res.setHeader("Access-Control-Allow-Origin", "*");
//		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); 
//		res.setHeader("Access-Control-Max-Age", "0");  
//		res.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
//		res.setHeader("Access-Control-Allow-Credentials", "true");  
//		res.setHeader("XDomainRequestAllowed","1"); 
//		System.out.println(username);
		u = userService.getUserById(username);
//		System.out.println(u);
		if(u == null || !password.equals(u.getPsw())){
//			u = new User();
//			u.setId("-1");
			result.setStatus(false);
			result.setRet("");
		}else{
			result.setStatus(true);
			result.setRet(u);
			String time = editLoginTime(u.getId());
//			u.setLastLogin(time);
		}
		return result;
		
	}
	@RequestMapping(value="/isRegister",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping isRegister(@RequestParam(value="phone", required=true) String phone){
		u = userService.getUserById(phone);
		
		if(u != null){
			result.setStatus(true);
		}else{
			result.setStatus(false);
		}
		return result;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping register(@RequestParam(value="phone",required=true) String phone,
								@RequestParam(value="password",required=true) String password,
								@RequestParam(value="nickname",required=true) String nickname,
								@RequestParam(value="time",required=true) String time){
		u.setNickname(nickname);
		u.setPhone(phone);
		u.setSigntime(time);
		u.setPsw(password);
		u.setLastLogin(time);
		if(userService.addUser(u) >0 ){
			result.setStatus(true);
			result.setRet(u);
		}else{
			result.setStatus(false);
		}
		return result;
	}
	@RequestMapping(value="/getUsers",method=RequestMethod.POST)
	@ResponseBody
	public List<User> getUsers(@RequestParam(value="page", required=true) int page) {
		return userService.getAllUser(page);
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getUserById(@RequestParam(value="id",required=true) String id){
		u = userService.getUserById(id);
		if(u == null){
			//未存在
			result.setStatus(false);
		}else{
			result.setStatus(true);
			result.setRet(u);
		}
		return result;
	}

	@RequestMapping(value="/delUser",method=RequestMethod.POST)
	@ResponseBody
	public int deleteUser(@RequestParam(value="ids", required=true) String[] ids){
		return userService.deleteUser(ids);
	}
	
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping editUser(@RequestParam(value="id", required=true) String id,
								@RequestParam(value="nickname",required=true) String nickname,
								@RequestParam(value="email",required=true) String email,
								@RequestParam(value="name",required=true) String name) {
		u.setId(id);
		u.setNickname(nickname);
		u.setName(name);
		u.setEmail(email);
		result.setStatus(false);
		if(userService.updateUser(u) > 0){
			result.setStatus(true);
		}
		result.setRet(u);
		return result;
	}
	
	
	public String editLoginTime(String id) {
		User u = new User();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(now);
		u.setId(id);
		u.setLastLogin(time);
		userService.UpdateLoginTime(u);
		return time;
	}
	
	@RequestMapping(value="/editPassword",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping editPassword(@RequestParam(value="id", required=true) String id,
			@RequestParam(value="psw",required=true) String psw) {
		u.setId(id);
		u.setPsw(psw);
		result.setStatus(false);
		if(userService.editPassword(u) != 0){
			result.setStatus(true);
		}
		return result;
	}
	
	@RequestMapping(value="/count",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping countUser(@RequestParam(value="start", required=true) String start,
			@RequestParam(value="end", required=true) String end,
			@RequestParam(value="userId", required=true) String userId) {
		result.setStatus(true);
		DateCondition dc = new DateCondition();
		dc.setStart(start);
		dc.setEnd(end);
		dc.setUserId(userId);
		Map<String,Object> r = new HashMap<String,Object>();
		r.put("count", userService.countUser());
		r.put("add", userService.newUser(dc));
		result.setRet(r);
		return result;
	}
	@RequestMapping(value="/forbit",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping fUser(@RequestParam(value="ids") String[] ids){
		Map<String,Object> r = new HashMap<String,Object>();
		int amount = userService.forbit(ids);
		result.setStatus(true);
		r.put("ret", amount);
		result.setRet(r);
		return result;
	}
	
	@RequestMapping(value="/group",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping group(){
		result.setStatus(true);
		Map<String,Object> objList = new HashMap<String,Object>();
		objList.put("user", userService.groupByYear());
		objList.put("video", userService.videoGroupType());
		objList.put("text", userService.textGroupType());
		result.setRet(objList);
		return result;
	}
	
}
