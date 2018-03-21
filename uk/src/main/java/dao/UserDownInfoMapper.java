package dao;

import java.util.List;

import model.SearchKeyInfo;
import model.UserDownInfo;

/**
 * 用户下载内容表
 * @author sh-zheng
 *
 */
public interface UserDownInfoMapper {
	int addOne(UserDownInfo ud);
	List<UserDownInfo> selectDownedVideo(String userId);
	List<UserDownInfo> selectDownedText(String userId);
	List<UserDownInfo> selectByKey(SearchKeyInfo key);
}
