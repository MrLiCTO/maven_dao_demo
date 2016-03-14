package com.ny.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sun.jdi.Type;

/** 
 * @ClassName: BaseDaoImpl 
 * @Description: base基类
 * @author: lishilong
 * @date: 2016年2月19日 下午3:42:25 
 * @param <T>->pojo
 * @param <C>->vo
 */
public abstract class BaseDaoImpl<T,V> extends SqlSessionDaoSupport implements BaseDao<T,V>{
	
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
	
	public String getMethodId_ns(String methodName){
		return ns+"."+methodName;
	}
	
	public String getMethodId_nscus(String methodName){
		return nscus+"."+methodName;
	}

	/* (non Javadoc) 
	 * @Title: save
	 * @Description: TODO
	 * @param obj 
	 * @see com.ny.dao.BaseDao#save(java.lang.Object) 
	 */
	@Override
	public void save(T obj) {
		this.getSqlSession().insert(this.getMethodId_ns(FunConfig.SAVE),obj);
		
	}

	/* (non Javadoc) 
	 * @Title: delete
	 * @Description: TODO
	 * @param obj 
	 * @see com.ny.dao.BaseDao#delete(java.lang.Object) 
	 */
	@Override
	public void delete(Serializable id) {
		this.getSqlSession().delete(this.getMethodId_ns(FunConfig.DELETEBYID),id);
		
	}

	/* (non Javadoc) 
	 * @Title: update
	 * @Description: TODO
	 * @param obj 
	 * @see com.ny.dao.BaseDao#update(java.lang.Object) 
	 */
	@Override
	public void update(T obj) {
		this.getSqlSession().update(this.getMethodId_ns(FunConfig.UPDATEBYID),obj);
		
	}
	
	/* (non Javadoc) 
	 * @Title: get
	 * @Description: TODO
	 * @param id
	 * @return 
	 * @see com.ny.dao.BaseDao#get(java.lang.Integer) 
	 */
	@Override
	public T get(Integer id) {
		
		return this.getSqlSession().selectOne(this.getMethodId_ns(FunConfig.GETBYID),id);
	}

	/*  
	 * @Title: getList
	 * @Description: 根据方法ID与查询帮助类VO结合查询多条数据
	 * @param id
	 * @param entityVO
	 * @return 
	 * @see com.ny.dao.BaseDao#getList(java.lang.String, java.lang.Object) 
	 */
	public abstract List<T> getList(V vo);

	/* (non Javadoc) 
	 * @Title: getCount
	 * @Description: 根据方法ID与查询帮助类VO结合查询数据总量
	 * @param id
	 * @param entityVO
	 * @return 
	 * @see com.ny.dao.BaseDao#getCount(java.lang.String, java.lang.Object) 
	 */
	public abstract int getCount(V vo);

}
