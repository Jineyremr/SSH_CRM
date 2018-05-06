package cc.dao;

import java.util.List;

import cc.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> getByTypeCode(String dict_type_code);

}
