package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TextInfoMapper;
import model.DateCondition;
import model.SearchKeyInfo;
import model.TextInfo;

public class TextInfoServiceImpl implements ITextInfoService {
	private TextInfoMapper textInfoMapper;
	public TextInfoMapper getTextInfoMapper() {
		return textInfoMapper;
	}
	@Autowired
	public void setTextInfoMapper(TextInfoMapper textInfoMapper) {
		this.textInfoMapper = textInfoMapper;
	}

	@Override
	public int addOne(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.addOne(ti);
	}

	@Override
	public int deleteOne(String id) {
		// TODO Auto-generated method stub
		return textInfoMapper.deleteOne(id);
	}

	@Override
	public int deleteMany(String[] ids) {
		// TODO Auto-generated method stub
		return textInfoMapper.deleteMany(ids);
	}

	@Override
	public TextInfo selectOne(String id) {
		// TODO Auto-generated method stub
		return textInfoMapper.selectOne(id);
	}

	@Override
	public List<TextInfo> selectAll(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.selectAll(ti);
	}

	@Override
	public int update(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.update(ti);
	}
	@Override
	public List<TextInfo> getLastest(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.getLastest(ti);
	}
	@Override
	public List<TextInfo> getHotest(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.getHotest(ti);
	}
	@Override
	public int upComs(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.upComs(ti);
	}
	@Override
	public int count(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.count(ti);
	}
	@Override
	public int forbitComs(String[] ids) {
		// TODO Auto-generated method stub
		return textInfoMapper.forbitComs(ids);
	}
	@Override
	public int forbitDown(String[] ids) {
		// TODO Auto-generated method stub
		return textInfoMapper.forbitDown(ids);
	}
	@Override
	public int forbitTransmit(String[] ids) {
		// TODO Auto-generated method stub
		return textInfoMapper.forbitTransmit(ids);
	}
	@Override
	public List<TextInfo> search(TextInfo ti) {
		// TODO Auto-generated method stub
		return textInfoMapper.search(ti);
	}
	@Override
	public int upTransmit(String id) {
		// TODO Auto-generated method stub
		return textInfoMapper.upTransmit(id);
	}

}
