package controller;

import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ISysNewsService;

@Controller
@RequestMapping(value="/sysNews")
public class SysNewsController {
	private ResultMapping result = new ResultMapping();
	private ISysNewsService sysNewsService;
	private SysNewsInfo sni = new SysNewsInfo();
	public ISysNewsService getSysNewsService() {
		return sysNewsService;
	}
	@Autowired
	public void setSysNewsService(ISysNewsService sysNewsService) {
		this.sysNewsService = sysNewsService;
	}
	
	@RequestMapping(value="/getList",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getList(@RequestParam(value="typeId",required=true) String typeId,
			@RequestParam(value="page",required=true) String page){
		//typeId进行筛选，0时表示所有,page进行分页
		sni.setTypeId(Integer.valueOf(typeId));
		sni.setUserId(Integer.valueOf(page));
		result.setRet(sysNewsService.getList(sni));
		result.setStatus(true);
		return result;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping add(@RequestParam(value="typeId",required=true) String typeId,@RequestParam(value="userId",required=true) String userId,
			@RequestParam(value="content",required=true) String content,@RequestParam(value="date",required=true) String date){
		sni.setTypeId(Integer.valueOf(typeId));
		sni.setUserId(Integer.valueOf(userId));
		sni.setContent(content);
		sni.setDate(date);
		result.setRet(sysNewsService.add(sni));
		result.setStatus(true);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping delete(@RequestParam(value="ids",required=true) String[] ids){
		result.setRet(sysNewsService.delete(ids));
		result.setStatus(true);
		return result;
	}
	
	@RequestMapping(value="/count",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping count(@RequestParam(value="typeId",required=true) String typeId){
		sni.setTypeId(Integer.valueOf(typeId));
		System.out.println(typeId);
		result.setRet(sysNewsService.count(sni));
		result.setStatus(true);
		return result;
	}
}
