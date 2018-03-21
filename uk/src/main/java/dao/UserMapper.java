package dao;


import java.util.List;

import com.alibaba.fastjson.JSON;

import model.DateCondition;
import model.ResultGroup;
import model.User;

public interface UserMapper {

	int insert(User record);

	User selectByPrimaryKey(String id);
	
	List<User> getAllUser(int number);
	
	boolean login(User u);
	
	int UpdateUser(User u);
	
	int deleteUser(String[] id);
	
	int editPassword(User u);
	
	int countUser();
	
	int countVideo();
	
	int countText();
	
	int newUser(DateCondition dc);
	
	int newVideo(DateCondition dc);
	
	int newText(DateCondition dc);
	
	int forbit(String[] dc);
	
	int UpdateLoginTime(User u);
	
	List<ResultGroup> groupByYear();
	
	List<ResultGroup> videoGroupType();
	
	List<ResultGroup> textGroupType();
}