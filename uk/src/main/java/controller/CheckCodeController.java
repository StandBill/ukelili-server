package controller;

import java.io.IOException;
import java.util.*;

import model.ResultMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import checkcode.AliSms;
import checkcode.MobileMessageCheck;

@Controller
@RequestMapping("/checkcode")
public class CheckCodeController {
	private ResultMapping resultMap = new ResultMapping();
	//返回结果信息
	Map<String,String> msg = new HashMap<String,String>();
	
	/**
	 *获取验证码接口
	 * 
	 */
	@RequestMapping(value="/getCheckcode",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getCheckcode(@RequestParam(value="phone", required=true) String phone) {
//		resultMap.setStatus(false);
		String message = "initial";
		AliSms sms = new AliSms();
		message = sms.getCheckcode(phone);
		resultMap.setStatus(true);
//		try {
////			message = MobileMessageSend.sendMsg(phone);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		msg.put("msg", message);
		resultMap.setRet(msg);
		return resultMap;
	}
	
	/**
	 * @param phone
	 * @param code
	 */
	@RequestMapping(value="/checkcode",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping checkcode(@RequestParam(value="phone", required=true) String phone,@RequestParam(value="code", required=true) String code){
		resultMap.setStatus(false);
		String message = "initial";
		try {
			resultMap.setStatus(true);
			message = MobileMessageCheck.checkMsg(phone, code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg.put("msg", message);
		resultMap.setRet(msg);
		return resultMap;
	}
}
