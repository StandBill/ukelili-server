package service;

import java.util.*;

import com.alibaba.fastjson.JSON;

import model.DateCondition;
import model.ResultGroup;
import model.User;

public interface IUserService {

	public User getUserById(String id);

	public List<User> getAllUser(int number);

	public int addUser(User u);

	public boolean login(User u);

	public int updateUser(User u);

	public int deleteUser(String[] id);

	public int editPassword(User u);

	public Map<String, Integer> countUser();

	public Map<String, Integer> newUser(DateCondition dc);

	public int forbit(String[] dc);

	public int UpdateLoginTime(User u);

	List<ResultGroup> groupByYear();

	List<ResultGroup> videoGroupType();

	List<ResultGroup> textGroupType();
}
