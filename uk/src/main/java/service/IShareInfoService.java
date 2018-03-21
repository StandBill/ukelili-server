package service;

import java.util.List;

import model.ShareInfo;

public interface IShareInfoService {
	ShareInfo selectOne(String id);
	List<ShareInfo> selectAll();
	int addOne(ShareInfo si);
	int deleteOne(String id);
	int deleteMany(String[] ids);
	int updateOne(ShareInfo si);
}
