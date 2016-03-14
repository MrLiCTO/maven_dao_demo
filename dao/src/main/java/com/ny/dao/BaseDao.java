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
public interface BaseDao<T,V> {
	
	public List<T> getList(String id,V vo);//分页查询
	
	public int getCount(String id,V vo);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	
	public T getById(Serializable id);					//只查询一个，常用于修改
	public void save(T t);					//插入，用实体作为参数
	public void update(T t);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	
}
