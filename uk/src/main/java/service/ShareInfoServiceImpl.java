package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ShareInfoMapper;
import model.ShareInfo;

public class ShareInfoServiceImpl implements IShareInfoService {
	
	private ShareInfoMapper shareInfoService;
	
	public ShareInfoMapper getShareInfoService() {
		return shareInfoService;
	}
	@Autowired
	public void setShareInfoService(ShareInfoMapper shareInfoService) {
		this.shareInfoService = shareInfoService;
	}

	@Override
	public ShareInfo selectOne(String id) {
		// TODO Auto-generated method stub
		return shareInfoService.getShareInfo(id);
	}

	@Override
	public List<ShareInfo> selectAll() {
		// TODO Auto-generated method stub
		return shareInfoService.getAllShareInfo();
	}

	@Override
	public int addOne(ShareInfo si) {
		// TODO Auto-generated method stub
		return shareInfoService.addShareInfo(si);
	}

	@Override
	public int deleteOne(String id) {
		// TODO Auto-generated method stub
		return shareInfoService.delShareInfo(id);
	}

	@Override
	public int deleteMany(String[] ids) {
		// TODO Auto-generated method stub
		return shareInfoService.delMany(ids);
	}

	@Override
	public int updateOne(ShareInfo si) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
