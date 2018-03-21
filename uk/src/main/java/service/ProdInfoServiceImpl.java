package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProdMapper;
import model.DateCondition;
import model.ProdInfo;

public class ProdInfoServiceImpl implements IProdInfoService {
	private ProdMapper prodMapper;
	public ProdMapper getProdMapper() {
		return prodMapper;
	}
	@Autowired
	public void setProdMapper(ProdMapper prodMapper) {
		this.prodMapper = prodMapper;
	}
	
	@Override
	public int add(ProdInfo pi) {
		// TODO Auto-generated method stub
		return prodMapper.add(pi);
	}

	@Override
	public List<ProdInfo> select(DateCondition date) {
		// TODO Auto-generated method stub
		return prodMapper.select(date);
	}

	@Override
	public int delete(String[] ids) {
		// TODO Auto-generated method stub
		return prodMapper.delete(ids);
	}
	@Override
	public List<ProdInfo> find(ProdInfo pi) {
		// TODO Auto-generated method stub
		return prodMapper.find(pi);
	}
}
