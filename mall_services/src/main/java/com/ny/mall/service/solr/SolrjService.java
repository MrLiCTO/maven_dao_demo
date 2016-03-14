package com.ny.mall.service.solr;

import java.util.List;

import com.ny.mall.po.User;
/**
 * @ClassName: SolrjService 
 * @Description: 站内搜索接口
 * @author: lishilong
 * @date: 2016年2月19日 下午3:52:33
 */
public interface SolrjService {
		@Deprecated	
		public long searchItemsCount(String key) throws Exception;
		@Deprecated
		public List<User> searchItems(String key,int pagesize,int currpage) throws Exception;
		
		/**
		 * @Title: searchItemsCount_new 
		 * @Description: 检索数量
		 * @param key
		 * @throws Exception
		 * @return: long
		 */
		public long searchItemsCount_new(String key) throws Exception;
		/**
		 * 
		 * @Title: searchItems_new 
		 * @Description: 检索数据
		 * @param key
		 * @param pagesize
		 * @param currpage
		 * @throws Exception
		 * @return: List<User>
		 */
		public List<User> searchItems_new(String key,int pagesize,int currpage) throws Exception;
		
}
