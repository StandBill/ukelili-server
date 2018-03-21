package dao;

import java.util.List;

import model.ShareInfo;

public interface ShareInfoMapper {
	
	public ShareInfo getShareInfo(String id);
	
	public List<ShareInfo> getAllShareInfo();
	
	public int addShareInfo(ShareInfo si);
	
	public int delShareInfo(String id);
	
	public int updateShareInfo(ShareInfo si);
	
	public int delMany(String[] ids);
}
