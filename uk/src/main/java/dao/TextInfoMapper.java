package dao;

import java.util.List;

import model.*;

public interface TextInfoMapper {
	int addOne(TextInfo ti);

	int deleteOne(String id);

	int deleteMany(String[] ids);

	TextInfo selectOne(String id);

	List<TextInfo> selectAll(TextInfo ti);
	
	List<TextInfo> search(TextInfo ti);

	int update(TextInfo ti);
	
	int upTransmit(String id);

	List<TextInfo> getLastest(TextInfo ti);

	List<TextInfo> getHotest(TextInfo ti);

	int upComs(TextInfo ti);

	int count(TextInfo ti);

	public int forbitComs(String[] ids);

	public int forbitDown(String[] ids);

	public int forbitTransmit(String[] ids);
}
