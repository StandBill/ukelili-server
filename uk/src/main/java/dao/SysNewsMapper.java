package dao;

import java.util.List;

import model.*;

public interface SysNewsMapper {
	int add(SysNewsInfo sni);
	List<SysNewsInfo> getList(SysNewsInfo sni);
	int count(SysNewsInfo sni);
	int delete(String[] ids);
}
