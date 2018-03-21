package service;

import java.util.List;

import model.TypeInfo;

public interface ITypeInfoService {
	int addOne(TypeInfo ti);
	int deleteOne(String id);
	int deleteMany(String[] ids);
	TypeInfo selectOne(String id);
	List<TypeInfo> selectAll();
	int upate(TypeInfo ti);
}
