package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserTransInfoMapper;
import model.SearchKeyInfo;
import model.UserTransInfo;

public class UserTransInfoServiceImpl implements IUserTransInfoService {
	private UserTransInfoMapper userTransInfoMapper;
	
	public UserTransInfoMapper getUserTransInfoMapper() {
		return userTransInfoMapper;
	}
	@Autowired
	public void setUserTransInfoMapper(UserTransInfoMapper userTransInfoMapper) {
		this.userTransInfoMapper = userTransInfoMapper;
	}

	@Override
	public List<UserTransInfo> selectAll(SearchKeyInfo key) {
		// TODO Auto-generated method stub
		return userTransInfoMapper.selectAll(key);
	}

	@Override
	public int deleteOne(String id) {
		// TODO Auto-generated method stub
		return userTransInfoMapper.deleteOne(id);
	}

	@Override
	public int delectAll(String[] ids) {
		// TODO Auto-generated method stub
		return userTransInfoMapper.delectAll(ids);
	}
	@Override
	public int add(UserTransInfo uti) {
		// TODO Auto-generated method stub
		return userTransInfoMapper.add(uti);
	}

}
