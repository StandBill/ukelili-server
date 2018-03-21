package controller;

import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.IProdInfoService;

@Controller
@RequestMapping("/prod")
public class ProdTypeController {
	private ResultMapping resultMap = new ResultMapping();
	private IProdInfoService prodService;
	private DateCondition date = new DateCondition();
	private ProdInfo pi = new ProdInfo();
	public IProdInfoService getProdService() {
		return prodService;
	}
	@Autowired
	public void setProdService(IProdInfoService prodService) {
		this.prodService = prodService;
	}
	@RequestMapping(value="/getList",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getList(@RequestParam(value="userId",required=true) String userId,@RequestParam(value="typeId",required=true) String typeId){
		date.setStart(typeId);
		date.setEnd(userId);
		resultMap.setStatus(true);
		resultMap.setRet(prodService.select(date));
		return resultMap;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping add(@RequestParam(value="userId",required=true) String userId,
							@RequestParam(value="typeId",required=true) String typeId,
							@RequestParam(value="exp",required=true) String exp){
		pi.setExp(exp);
		pi.setTypeId(Integer.valueOf(typeId));
		pi.setUserId(Integer.valueOf(userId));
		if(this.find(pi)){
			resultMap.setStatus(false);
			resultMap.setRet(-1);
		}else{
			if(prodService.add(pi) > 0){
				resultMap.setStatus(true);
				resultMap.setRet(pi);
			}else{
				resultMap.setStatus(false);
			}
		}
		return resultMap;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping delete(@RequestParam(value="ids",required=true) String[] ids){
		resultMap.setStatus(true);
		resultMap.setRet(prodService.delete(ids));
		return resultMap;
	}
	
	public boolean find(ProdInfo pi){
		if(prodService.find(pi).size() > 0 && prodService.find(pi).get(0).getId() >0){
			return true;
		}
		return false;
	}
}
