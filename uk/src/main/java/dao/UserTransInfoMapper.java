package dao;

import java.util.List;

import model.SearchKeyInfo;
import model.UserTransInfo;

public interface UserTransInfoMapper {
	List<UserTransInfo> selectAll(SearchKeyInfo key);
	int deleteOne(String id);
	int delectAll(String []ids);
	int add(UserTransInfo uti);
}
