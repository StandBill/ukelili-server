package dao;

import java.util.List;

import model.*;

public interface ProdMapper {
	int add(ProdInfo pi);
	List<ProdInfo> select(DateCondition date);
	int delete(String[] ids);
	List<ProdInfo> find(ProdInfo pi);
}
