package service;

import java.util.List;

import model.SearchKeyInfo;
import model.UserDownInfo;

public interface IUserDownInfoService {
	List<UserDownInfo> selctVideo(String userId);
	List<UserDownInfo> selctText(String userId); 
	List<UserDownInfo> selectByKey(SearchKeyInfo key);
}
