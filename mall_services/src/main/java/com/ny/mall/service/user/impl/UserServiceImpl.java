package com.ny.mall.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ny.dao.BaseDaoImpl;
import com.ny.dao.FunConfig;
import com.ny.mall.mapper.UserMapper;
import com.ny.mall.mapperCustom.UserMapperCustom;
import com.ny.mall.pojoAndVo.UserCustom;
import com.ny.mall.pojoAndVo.UserCustomVo;
import com.ny.mall.service.user.UserService;
@Service
public class UserServiceImpl extends BaseDaoImpl<UserCustom,UserCustomVo> implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserMapperCustom userMapperCustom;
	
	public UserServiceImpl() {
		super.setNs("com.ny.mall.mapper.UserMapper");
		super.setNscus("com.ny.mall.mapperCustom.UserMapperCustom"); 
	}

	/* (non Javadoc) 
	 * @Title: getList
	 * @Description: TODO
	 * @param methodName
	 * @param vo
	 * @return 
	 * @see com.ny.dao.BaseDaoImpl#getList(java.lang.String, java.lang.Object) 
	 */
	@Override
	public List<UserCustom> getList(UserCustomVo vo) {
		return this.getSqlSession().selectList(this.getMethodId_nscus(FunConfig.GETlIST),vo);
	}

	/* (non Javadoc) 
	 * @Title: getCount
	 * @Description: TODO
	 * @param methodName
	 * @param vo
	 * @return 
	 * @see com.ny.dao.BaseDaoImpl#getCount(java.lang.String, java.lang.Object) 
	 */
	@Override
	public int getCount(UserCustomVo vo) {
		
		return this.getSqlSession().selectOne(this.getMethodId_nscus(FunConfig.GETCOUNT),vo);
	}
	
	/*public List<UserCustom> findEntityList(UserCustomVo entityCustomVo)throws Exception{
		
		List<UserCustom> entityList = userMapperCustom.findEntityList(entityCustomVo);
		//this.getSqlSession().selectList("", entityCustomVo);
		return entityList;
	}

	
	public int findEntityCount(UserCustomVo entityCustomVo) throws Exception{
		
		return userMapperCustom.findEntityCount(entityCustomVo);
	}
*/


	
}
