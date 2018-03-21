package service;

import java.util.List;

import model.Comment;
import model.DateCondition;

public interface ICommentService {
	int addOne(Comment c);
	int delete(String[] id);
	Comment selectOne(String id);
	List<Comment> selectAll(DateCondition date);
	List<Comment> getMyComments(String id);
	int update(String[] ids);
}
