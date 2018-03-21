package service;

import java.util.List;

import model.DateCondition;
import model.ProdInfo;

public interface IProdInfoService {
	int add(ProdInfo pi);

	List<ProdInfo> select(DateCondition date);

	int delete(String[] ids);

	List<ProdInfo> find(ProdInfo pi);
}
