package service;

import java.util.List;

import model.SearchKeyInfo;
import model.UserTransInfo;

public interface IUserTransInfoService {
	List<UserTransInfo> selectAll(SearchKeyInfo key);
	int deleteOne(String id);
	int delectAll(String []ids);
	int add(UserTransInfo uti);
}
