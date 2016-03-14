package com.ny.dao;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * @ClassName: BaseDao 
 * @Description: base基类接口
 * @author: lishilong
 * @date: 2016年2月19日 下午3:37:39 
 * @param <T>
 * @param <V>
 */
public interface BaseDao<T,C> {

	
	 /**
     * 对对象进行持久化操作，如果成功则返回持久化后的ID
     * 失败则返回null
     * @param obj
     * @return
     */
    void save(T obj);
    
    /**
     * 删除指定id的持久化对象
     * @param id
     */
    void delete(Serializable id);
    /**
     * 修改指定的持久化对象
     * @param id
     * @param obj
     */
    void update(T obj);
    
    /**
     * 返回持久化对象
     * @param id
     * @return 找到则返回，否则返回空
     */
    T get(Integer id);
    
    /*  
	 * @Title: getList
	 * @Description: 根据方法ID与查询帮助类VO结合查询多条数据
	 * @param id
	 * @param entityVO
	 * @return 
	 * @see com.ny.dao.BaseDao#getList(java.lang.String, java.lang.Object) 
	 */
	public List<T> getList(C entityVO);

	/* (non Javadoc) 
	 * @Title: getCount
	 * @Description: 根据方法ID与查询帮助类VO结合查询数据总量
	 * @param id
	 * @param entityVO
	 * @return 
	 * @see com.ny.dao.BaseDao#getCount(java.lang.String, java.lang.Object) 
	 */
	public int getCount(C entityVO);
}
