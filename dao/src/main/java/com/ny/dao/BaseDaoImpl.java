package com.ny.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/** 
 * @ClassName: BaseDaoImpl 
 * @Description: base基类
 * @author: lishilong
 * @date: 2016年2月19日 下午3:42:25 
 * @param <T>->pojo
 * @param <C>->vo
 */
public class BaseDaoImpl<T,C> extends SqlSessionDaoSupport implements BaseDao<T,C>{

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String ns;		//命名空间
	private String nscus;		//自定义命名空间
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	
	public String getNscus() {
		return nscus;
	}
	public void setNscus(String nscus) {
		this.nscus = nscus;
	}

	/* 
	 * @Title: getById
	 * @Description: 根据ID查询
	 * @param id
	 * @return 
	 * @see com.ny.dao.BaseDao#getById(java.io.Serializable) 
	 */
	public T getById(Serializable id) {
		return this.getSqlSession().selectOne(ns + ".selectByPrimaryKey", id);
	}

	/*  
	 * @Title: save
	 * @Description: 保存
	 * @param entity 
	 * @see com.ny.dao.BaseDao#save(java.lang.Object) 
	 */
	public void save(T entity) {
		this.getSqlSession().insert(ns + ".insert", entity);
	}

	/* (non Javadoc) 
	 * @Title: update
	 * @Description: 更新
	 * @param entity 
	 * @see com.ny.dao.BaseDao#update(java.lang.Object) 
	 */
	public void update(T entity) {
		this.getSqlSession().update(ns + ".updateByPrimaryKey", entity);
	}

	/* (non Javadoc) 
	 * @Title: deleteById
	 * @Description: 根据ID删除
	 * @param id 
	 * @see com.ny.dao.BaseDao#deleteById(java.io.Serializable) 
	 */
	public void deleteById(Serializable id) {
		this.getSqlSession().delete(ns + ".deleteByPrimaryKey", id);
	}

	/*  
	 * @Title: getList
	 * @Description: 根据方法ID与查询帮助类VO结合查询多条数据
	 * @param id
	 * @param entityVO
	 * @return 
	 * @see com.ny.dao.BaseDao#getList(java.lang.String, java.lang.Object) 
	 */
	public List<T> getList(String id,C entityVO) {
		
		return this.getSqlSession().selectList(nscus + id, entityVO);
	}

	/* (non Javadoc) 
	 * @Title: getCount
	 * @Description: 根据方法ID与查询帮助类VO结合查询数据总量
	 * @param id
	 * @param entityVO
	 * @return 
	 * @see com.ny.dao.BaseDao#getCount(java.lang.String, java.lang.Object) 
	 */
	public int getCount(String id,C entityVO) {
		
		return this.getSqlSession().selectOne(nscus + id, entityVO);
	}
	
	

}
