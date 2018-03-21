package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDownInfoMapper;
import model.SearchKeyInfo;
import model.UserDownInfo;

public class UserDownInfoServiceImpl implements IUserDownInfoService {
	private UserDownInfoMapper userDownInfoMapper;
	
	public UserDownInfoMapper getUserDownInfoMapper() {
		return userDownInfoMapper;
	}
	@Autowired
	public void setUserDownInfoMapper(UserDownInfoMapper userDownInfoMapper) {
		this.userDownInfoMapper = userDownInfoMapper;
	}

	@Override
	public List<UserDownInfo> selctVideo(String userId) {
		// TODO Auto-generated method stub
		return userDownInfoMapper.selectDownedVideo(userId);
	}

	@Override
	public List<UserDownInfo> selctText(String userId) {
		// TODO Auto-generated method stub
		return userDownInfoMapper.selectDownedText(userId);
	}

	@Override
	public List<UserDownInfo> selectByKey(SearchKeyInfo key) {
		// TODO Auto-generated method stub
		return userDownInfoMapper.selectByKey(key);
	}

}
