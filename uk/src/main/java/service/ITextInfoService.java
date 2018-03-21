package service;

import java.util.List;

import model.*;

public interface ITextInfoService {
	int addOne(TextInfo ti);

	int deleteOne(String id);

	int deleteMany(String[] ids);

	TextInfo selectOne(String id);

	List<TextInfo> selectAll(TextInfo ti);
	
	List<TextInfo> search(TextInfo ti);

	List<TextInfo> getLastest(TextInfo ti);

	List<TextInfo> getHotest(TextInfo ti);

	int update(TextInfo ti);

	int upComs(TextInfo ti);
	
	int upTransmit(String id);

	int count(TextInfo ti);

	public int forbitComs(String[] ids);

	public int forbitDown(String[] ids);

	public int forbitTransmit(String[] ids);
}
