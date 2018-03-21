package controller;

import java.util.List;
import java.util.Vector;

import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ICommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	private ResultMapping result = new ResultMapping();
	private DateCondition date = new DateCondition();
	private Comment comment = new Comment();
	private ICommentService commentService;
	
	public ICommentService getCommentService() {
		return commentService;
	}
	@Autowired
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	
	@RequestMapping(value="/getList",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getList(@RequestParam(value="targetId",required=true) String targetId,
			@RequestParam(value="typeId",required=true) String typeId){
		date.setStart(targetId);
		date.setEnd(typeId);
		if(typeId.equals("4")){
			date.setUserId("video"+targetId);
		}else if(typeId.equals("5")){
			date.setUserId("text"+targetId);
		}
		List<Comment> coms = commentService.selectAll(date);
		result.setRet(coms);
		result.setStatus(true);
		String[] ids = new String[1];
		for(int i = 0;i < coms.size();i ++){
			ids[0] = coms.get(i).getComId();
			read(ids);
		}
		return result;
	}
	
	/**
	 * 根据个人ID获取评论内容
	 * @param targetId
	 * @return
	 */
	@RequestMapping(value="/getMyComments",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping getMyComments(@RequestParam(value="targetId",required=true) String targetId){
		List<Comment> coms = commentService.getMyComments(targetId);
		result.setRet(coms);
		result.setStatus(true);
		String[] ids = new String[1];
		for(int i = 0;i < coms.size();i ++){
			ids[0] = coms.get(i).getComId();
			read(ids);
		}
		return result;
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping add(@RequestParam(value="author",required=true) String author,
			@RequestParam(value="targetId",required=true) String targetId,
			@RequestParam(value="typeId",required=true) String typeId,
			@RequestParam(value="content",required=true) String content,
			@RequestParam(value="date",required=true) String date,
			@RequestParam(value="extra",required=true) String extra){
		comment.setAuthor(Integer.valueOf(author));
		comment.setContent(content);
		comment.setDate(date);
		comment.setExtra(extra);
		comment.setTargetId(Integer.valueOf(targetId));
		comment.setTypeId(Integer.valueOf(typeId));
		commentService.addOne(comment);
		result.setRet(comment.getComId());
		result.setStatus(true);
		
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultMapping delete(@RequestParam(value="id",required=true) String[] id){
		result.setRet(commentService.delete(id));
		result.setStatus(true);
		return result;
	}
	
	public void read(String[] ids){
		commentService.update(ids);
	}
}
