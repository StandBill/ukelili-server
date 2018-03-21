package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.SysNewsMapper;
import model.SysNewsInfo;

public class SysNewsServiceImpl implements ISysNewsService {
	private SysNewsMapper sysNewsMapper;
	public SysNewsMapper getSysNewsMapper() {
		return sysNewsMapper;
	}
	@Autowired
	public void setSysNewsMapper(SysNewsMapper sysNewsMapper) {
		this.sysNewsMapper = sysNewsMapper;
	}
	@Override
	public int add(SysNewsInfo sni) {
		// TODO Auto-generated method stub
		return sysNewsMapper.add(sni);
	}

	@Override
	public List<SysNewsInfo> getList(SysNewsInfo sni) {
		// TODO Auto-generated method stub
		return sysNewsMapper.getList(sni);
	}

	@Override
	public int count(SysNewsInfo sni) {
		// TODO Auto-generated method stub
		return sysNewsMapper.count(sni);
	}

	@Override
	public int delete(String[] ids) {
		// TODO Auto-generated method stub
		return sysNewsMapper.delete(ids);
	}

	

}
