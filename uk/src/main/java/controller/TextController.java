package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ITextInfoService;
import service.IUserTransInfoService;

@Controller
@RequestMapping("/text")
public class TextController {
	private ResultMapping resultMap = new ResultMapping();
	private ITextInfoService textService;
	private IUserTransInfoService userTransService;
	private TextInfo ti = new TextInfo();
	private SearchKeyInfo key = new SearchKeyInfo();
	private DateCondition dCondition = new DateCondition();
	public ITextInfoService getTextService() {
		return textService;
	}
	@Autowired
	public void setTextService(ITextInfoService textService) {
		this.textService = textService;
	}
	
	public IUserTransInfoService getUserTransService() {
		return userTransService;
	}
	@Autowired
	public void setUserTransService(IUserTransInfoService userTransService) {
		this.userTransService = userTransService;
	}
	@RequestMapping(value="/addText",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping addText(@RequestParam(value="userId",required=true) int userId,
								@RequestParam(value="title",required=true) String title,
								@RequestParam(value="prodId",required=true) String prodId,
								@RequestParam(value="isTransmit",required=true) String isTransmit,
								@RequestParam(value="isDiscuss",required=true) String isDiscuss,
								@RequestParam(value="content",required=true) String content,
								@RequestParam(value="source") String source,
								@RequestParam(value="time") String time){
		ti.setUserId(userId);
		ti.setName(title);
		ti.setCan_transmit(Integer.valueOf(isTransmit));
		ti.setContent(content);
		ti.setCan_discuss(Integer.valueOf(isDiscuss));
		ti.setSrcAddress(source);
		ti.setDate(time);
		ti.setProId(Integer.valueOf(prodId));
		resultMap.setStatus(false);
		if(textService.addOne(ti) > 0){
			resultMap.setStatus(true);
		}
		return resultMap;
	}
	
	@RequestMapping(value="/getList",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getList(@RequestParam(value="index",required=true) String index,
								@RequestParam(value="userId") String userId,
								@RequestParam(value="prodId") String prodId){
		ti.setProId(Integer.valueOf(prodId));
		ti.setComs(Integer.valueOf(index));
		ti.setUserId(Integer.valueOf(userId));
		resultMap.setRet(textService.selectAll(ti));
		resultMap.setStatus(true);
		return resultMap;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping update(@RequestParam(value="textId",required=true) String textId,
								@RequestParam(value="title",required=true) String title,
								@RequestParam(value="prodId",required=true) String prodId,
								@RequestParam(value="isTransmit",required=true) String isTransmit,
								@RequestParam(value="isDiscuss",required=true) String isDiscuss,
								@RequestParam(value="content",required=true) String content,
								@RequestParam(value="source") String source){
		ti.setTextId(Integer.valueOf(textId));
		ti.setName(title);
		ti.setCan_transmit(Integer.valueOf(isTransmit));
		ti.setContent(content);
		ti.setCan_discuss(Integer.valueOf(isDiscuss));
		ti.setSrcAddress(source);
		ti.setProId(Integer.valueOf(prodId));
		resultMap.setStatus(false);
		if(textService.update(ti) > 0){
			resultMap.setStatus(true);
		}
		return resultMap;
	}
	@RequestMapping(value="/upUserTransmit",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping upTransmit(@RequestParam(value="userId",required=true) String userId,
									@RequestParam(value="typeId",required=true) String typeId,
									@RequestParam(value="targetId",required=true) String targetId,
									@RequestParam(value="date") String date){
		UserTransInfo uti = new UserTransInfo();
		resultMap = new ResultMapping();
		uti.setUserId(Integer.valueOf(userId));
		uti.setDate(date);
		uti.setTargetId(Integer.valueOf(targetId));
		uti.setTypeId(Integer.valueOf(typeId));
		resultMap.setStatus(false);
		if(userTransService.add(uti) > 0){
			resultMap.setStatus(true);
		}
		return resultMap;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping delete(@RequestParam(value="ids",required=true) String[] ids){
		resultMap.setRet(textService.deleteMany(ids));
		resultMap.setStatus(true);
		return resultMap;
	}
	
	
	/**
	 * 获取热门和最新
	 */
	@RequestMapping(value="/getListByType",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getListByType(@RequestParam(value="type",required=true) String type,
										@RequestParam(value="start",required=true) String start,
										@RequestParam(value="end",required=true) String end,
										@RequestParam(value="page",required=true) String page){
		ti = new TextInfo();
		ti.setUserId(Integer.valueOf(page));
		ti.setContent(start);
		ti.setDate(end);
		if(type.equals("hotest")){
			resultMap.setRet(textService.getHotest(ti));
		}else{
			resultMap.setRet(textService.getLastest(ti));
		}
		resultMap.setStatus(true);
		return resultMap;
	}
	
	@RequestMapping(value="/getOne",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getOne(@RequestParam(value="id",required=true) String id){
		resultMap.setRet(textService.selectOne(id));
		resultMap.setStatus(true);
		return resultMap;
	}
	
	/**
	 * 更新评论数
	 */
	@RequestMapping(value="/upComs",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping upComs(@RequestParam(value="id",required=true) String id,
			@RequestParam(value="type") String type){
		/*
		 * type>0 表示增加一条,否则删除一条
		 * */
		ti.setTextId(Integer.valueOf(id));
		ti.setComs(Integer.valueOf(type));
		resultMap.setRet(textService.upComs(ti));
		resultMap.setStatus(true);
		return resultMap;
	}
	
	@RequestMapping(value="/sum",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping count( @RequestParam(value="userId",required=true) String userId,
								@RequestParam(value="prodId",required=true) String prodId) {
		resultMap.setStatus(true);
		ti.setUserId(Integer.valueOf(userId));
		ti.setProId(Integer.valueOf(prodId));
		resultMap.setRet(textService.count(ti));
		return resultMap;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping search(@RequestParam(value="keyword",required=true) String keyword,
								@RequestParam(value="userId",required=true) String userId,
								@RequestParam(value="prodId",required=true) String prodId,
								@RequestParam(value="index",required=true) String index) {
		resultMap.setStatus(true);
		ti.setUserId(Integer.valueOf(userId));
		ti.setProId(Integer.valueOf(prodId));
		ti.setComs(Integer.valueOf(index));
		ti.setName("%"+keyword+"%");
		resultMap.setRet(textService.search(ti));
		return resultMap;
	}
	
	@RequestMapping(value="/upTransmit",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping search(@RequestParam(value="id",required=true) String id) {
		resultMap.setStatus(false);
		if(textService.upTransmit(id) > 0){
			resultMap.setStatus(true);
		}
		return resultMap;
	}
	
	/*修改权限*/
	@RequestMapping(value="/changeAuth",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping upAuth(@RequestParam(value="ids",required=true) String[] ids,
								@RequestParam(value="type",required=true) String type){
		int types = type.equals("discuss") ? 1 : 
					type.equals("download") ? 2 :
					type.equals("transmit") ? 3 : 0;
		resultMap.setStatus(false);
		int count = this.authChange(types, ids);
		if(count > 0 && count == ids.length){
			resultMap.setStatus(true);
			resultMap.setRet(count);
		}
		return resultMap;
	}
	
	public int authChange(int type,String[] ids){
		int count = 0;
		switch(type){
			case 1://update discuss
				count = textService.forbitComs(ids);
				break;
			case 2://update download
				count = textService.forbitDown(ids);
				break;
			case 3://update transmit
				count = textService.forbitTransmit(ids);
				break;
		}
		return count;
	}
}
