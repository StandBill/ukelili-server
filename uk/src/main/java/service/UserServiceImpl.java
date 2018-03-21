package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.DateCondition;
import model.ResultGroup;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import dao.UserMapper;

@Service("userService")
public class UserServiceImpl implements IUserService {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		int result = userMapper.insert(u);
		return result;
	}

	@Override
	public boolean login(User u) {
		// TODO Auto-generated method stub
		return userMapper.login(u);
	}

	@Override
	public List<User> getAllUser(int num) {
		// TODO Auto-generated method stub
		return userMapper.getAllUser(num);
	}

	@Override
	public int updateUser(User u) {
		return userMapper.UpdateUser(u);
	}

	@Override
	public int deleteUser(String[] id) {
		return userMapper.deleteUser(id);
	}

	@Override
	public int editPassword(User u) {
		// TODO Auto-generated method stub
		return userMapper.editPassword(u);
	}

	@Override
	public Map<String, Integer> countUser() {
		// TODO Auto-generated method stub
		int users = userMapper.countUser();
		int videos = userMapper.countVideo();
		int text = userMapper.countText();
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("users", users);
		result.put("videos", videos);
		result.put("text", text);
		return result;
	}

	@Override
	public Map<String, Integer> newUser(DateCondition dc) {
		// TODO Auto-generated method stub
		int users = userMapper.newUser(dc);
		int videos = userMapper.newVideo(dc);
		int text = userMapper.newText(dc);
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("newUser", users);
		result.put("newVideo", videos);
		result.put("newText", text); 
		return result;
	}

	@Override
	public int forbit(String[] dc) {
		// TODO Auto-generated method stub
		return userMapper.forbit(dc);
	}

	@Override
	public int UpdateLoginTime(User u) {
		// TODO Auto-generated method stub
		return userMapper.UpdateLoginTime(u);
	}

	@Override
	public List<ResultGroup> groupByYear() {
		// TODO Auto-generated method stub
		return userMapper.groupByYear();
	}

	@Override
	public List<ResultGroup> videoGroupType() {
		// TODO Auto-generated method stub
		return userMapper.videoGroupType();
	}

	@Override
	public List<ResultGroup> textGroupType() {
		// TODO Auto-generated method stub
		return userMapper.textGroupType();
	}
}
