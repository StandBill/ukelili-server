package dao;

import java.util.List;

import model.Comment;
import model.DateCondition;

public interface CommentMapper {
	int addComment(Comment c);
	Comment selectOne(String id);
	List<Comment> selectAll(DateCondition date);
	List<Comment> getMyComments(String id);
	int delete(String[] id);
	int update(String[] ids);
}
