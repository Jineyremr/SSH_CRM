package cc.service.impl;

import java.util.List;

import cc.dao.BaseDictDao;
import cc.domain.BaseDict;
import cc.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bdd;
	
	public List<BaseDict> getByTypeCode(String dict_type_code) {
		
		return bdd.getByTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

}
