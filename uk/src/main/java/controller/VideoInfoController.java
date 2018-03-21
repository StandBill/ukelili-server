package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.ResultMapping;
import model.SearchKeyInfo;
import model.VideoInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.IVideoService;

@Controller
@RequestMapping("/video")
public class VideoInfoController {
	private IVideoService videoService;
	private ResultMapping result = new ResultMapping();
	private VideoInfo video = new VideoInfo();
	public IVideoService getVideoService() {
		return videoService;
	}
	@Autowired
	public void setVideoService(IVideoService videoService) {
		this.videoService = videoService;
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getList(@RequestParam(value="page", required=true) int page,
								@RequestParam(value="userId", required=true) String userId,
								@RequestParam(value="prodId", required=true) String prodId) {
		video.setUserId(Integer.valueOf(userId));
		video.setComs(Integer.valueOf(page));
		video.setProdId(Integer.valueOf(prodId));
		result.setStatus(true);
		result.setRet(videoService.getAll(video));
		return result;
	}
	@RequestMapping(value="/selOne",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping selOne(@RequestParam(value="videoId", required=true) String videoId) {
		result.setStatus(true);
		result.setRet(videoService.getOne(videoId));
		return result;
	}
	
	@RequestMapping(value="/sum",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping count(@RequestParam(value="userId",required=true) String userId,
								@RequestParam(value="prodId",required=true) String prodId) {
		result.setStatus(true);
		video.setUserId(Integer.valueOf(userId));
		video.setProdId(Integer.valueOf(prodId));
		result.setRet(videoService.count(video));
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping delVideo(@RequestParam(value="ids",required=true) String[] ids){
		int number = videoService.delVideo(ids);
		result.setStatus(false);
		if(number > 0){
			result.setStatus(true);
			result.setRet(number);
		}
		return result;
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping editVideo(@RequestParam(value="id",required=true) String id,
									@RequestParam(value="name",required=true) String name,
									@RequestParam(value="can_down",required=true) String can_down,
									@RequestParam(value="can_transmit",required=true) String can_transmit,
									@RequestParam(value="can_discuss",required=true) String can_discuss,
									@RequestParam(value="image",required=true) String image,
									@RequestParam(value="description",required=true) String description,
									@RequestParam(value="prodId",required=true) String prodId){
		result.setStatus(false);
		video = new VideoInfo();
		video.setVideoId(Integer.valueOf(id));
		video.setCan_down(Integer.valueOf(can_down));
		video.setCan_transmit(Integer.valueOf(can_transmit));
		video.setCan_discuss(Integer.valueOf(can_discuss));
		video.setImage(image);
		video.setName(name);
		video.setDescription(description);
		video.setProdId(Integer.valueOf(prodId));
		int number = videoService.updateVideo(video);
		if(number > 0){
			result.setStatus(true);
			result.setRet(number);
		}
		return result;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping upload(@RequestParam(value="userId", required=true) String userId,
			@RequestParam(value="key", required=true) String key,
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="date", required=true) String date,
			@RequestParam(value="can_down", required=true) String can_down,
			@RequestParam(value="can_transmit", required=true) String can_transmit,
			@RequestParam(value="can_discuss", required=true) String can_discuss,
			@RequestParam(value="explain", required=true) String explain,
			@RequestParam(value="prodId", required=true) String prodId) {
		result.setStatus(false);
		video = new VideoInfo();
		video.setName(name);
		video.setSrcAddress(key+".mp4");
		video.setUserId(Integer.valueOf(userId));
		video.setDate(date);
		video.setCan_down(Integer.valueOf(can_down));
		video.setCan_transmit(Integer.valueOf(can_transmit));
		video.setCan_discuss(Integer.valueOf(can_discuss));
		video.setImage(key+".jpg");
		video.setDescription(explain);
		video.setProdId(Integer.valueOf(prodId));
		if(videoService.addVideo(video) > 0){
			result.setStatus(true);
		}
		return result;
	}
	/**
	 * 更新评论数
	 */
	@RequestMapping(value="/upComs",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping upComs(@RequestParam(value="id",required=true) String id,
								@RequestParam(value="type",required=true) String type){
		video.setVideoId(Integer.valueOf(id));
		video.setComs(Integer.valueOf(type));
		result.setRet(videoService.upComs(video));
		result.setStatus(true);
		return result;
	}
	
	/**
	 * 更改下载量,评论量
	 */
	@RequestMapping(value="/upInfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping upDowns(@RequestParam(value="id",required=true) String id,
								@RequestParam(value="type",required=true) String type){
		video = new VideoInfo();
		video.setVideoId(Integer.valueOf(id));
		if(type.equals("downloads")){
			result.setRet(videoService.upDowns(video));
		}else if(type.equals("transmits")){
			result.setRet(videoService.upTransmit(video));
		}
		result.setStatus(true);
		return result;
	}
	
	/*修改权限*/
	@RequestMapping(value="/changeAuth",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping upAuth(@RequestParam(value="ids",required=true) String[] ids,
								@RequestParam(value="type",required=true) String type){
		int types = type.equals("discuss") ? 1 : 
					type.equals("download") ? 2 :
					type.equals("transmit") ? 3 : 0;
		result.setStatus(false);
		int count = this.authChange(types, ids);
		if(count > 0 && count == ids.length){
			result.setStatus(true);
		}
		return result;
	}
	
	public int authChange(int type,String[] ids){
		int count = 0;
		switch(type){
			case 1://update discuss
				count = videoService.forbitComs(ids);
				break;
			case 2://update download
				count = videoService.forbitDown(ids);
				break;
			case 3://update transmit
				count = videoService.forbitTransmit(ids);
				break;
			default:
				count = -1;
		}
		return count;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping search(@RequestParam(value="page", required=true) int page,
								@RequestParam(value="key", required=true) String key) {
		SearchKeyInfo ski = new SearchKeyInfo();
		ski.setIndex(page);
		ski.setTypeId("%"+key+"%");
		result.setStatus(true);
		result.setRet(videoService.search(ski));
		return result;
	}
}
