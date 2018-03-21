package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TypeInfoMapper;
import model.TypeInfo;

public class TypeInfoServiceImpl implements ITypeInfoService {
	private TypeInfoMapper typeInfoMapper;
	public TypeInfoMapper getTypeInfoMapper() {
		return typeInfoMapper;
	}
	@Autowired
	public void setTypeInfoMapper(TypeInfoMapper typeInfoMapper) {
		this.typeInfoMapper = typeInfoMapper;
	}

	@Override
	public int addOne(TypeInfo ti) {
		// TODO Auto-generated method stub
		return typeInfoMapper.addOne(ti);
	}

	@Override
	public int deleteOne(String id) {
		// TODO Auto-generated method stub
		return typeInfoMapper.deleteOne(id);
	}

	@Override
	public int deleteMany(String[] ids) {
		// TODO Auto-generated method stub
		return typeInfoMapper.deleteMany(ids);
	}

	@Override
	public TypeInfo selectOne(String id) {
		// TODO Auto-generated method stub
		return typeInfoMapper.selectOne(id);
	}

	@Override
	public List<TypeInfo> selectAll() {
		// TODO Auto-generated method stub
		return typeInfoMapper.selectAll();
	}
	@Override
	public int upate(TypeInfo ti) {
		// TODO Auto-generated method stub
		return typeInfoMapper.update(ti);
	}

}
