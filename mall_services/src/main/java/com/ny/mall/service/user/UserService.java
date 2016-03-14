package com.ny.mall.service.user;

import java.util.List;

import com.ny.dao.BaseDao;
import com.ny.mall.pojoAndVo.UserCustom;
import com.ny.mall.pojoAndVo.UserCustomVo;



public interface UserService extends BaseDao<UserCustom,UserCustomVo>{
	
	/*public List<UserCustom> findEntityList(UserCustomVo entityCustomVo)throws Exception;
	public int findEntityCount(UserCustomVo entityCustomVo)throws Exception;*/
}
