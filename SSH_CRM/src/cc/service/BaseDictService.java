package cc.service;

import java.util.List;

import cc.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getByTypeCode(String dict_type_code);

}
