package service;

import java.util.List;

import model.SysNewsInfo;

public interface ISysNewsService {
	int add(SysNewsInfo sni);
	List<SysNewsInfo> getList(SysNewsInfo sni);
	int count(SysNewsInfo sni);
	int delete(String[] ids);
}
