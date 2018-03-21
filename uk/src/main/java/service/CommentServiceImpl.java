package service;

import java.util.List;

import model.Comment;
import model.DateCondition;

import org.springframework.beans.factory.annotation.Autowired;

import dao.CommentMapper;

public class CommentServiceImpl implements ICommentService {
	private CommentMapper commentMapper;
	public CommentMapper getCommentMapper() {
		return commentMapper;
	}
	@Autowired
	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	@Override
	public int addOne(Comment c) {
		// TODO Auto-generated method stub
		return commentMapper.addComment(c);
	}

	@Override
	public int delete(String[] id) {
		// TODO Auto-generated method stub
		return commentMapper.delete(id);
	}


	@Override
	public Comment selectOne(String id) {
		// TODO Auto-generated method stub
		return commentMapper.selectOne(id);
	}

	@Override
	public List<Comment> selectAll(DateCondition date) {
		// TODO Auto-generated method stub
		return commentMapper.selectAll(date);
	}
	@Override
	public int update(String[] ids) {
		// TODO Auto-generated method stub
		return commentMapper.update(ids);
	}
	@Override
	public List<Comment> getMyComments(String c) {
		// TODO Auto-generated method stub
		return commentMapper.getMyComments(c);
	}

}
