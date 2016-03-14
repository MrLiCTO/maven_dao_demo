package com.ny.mall.service.solr.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import com.ny.mall.po.User;
import com.ny.mall.service.solr.SolrjService;

@Service("solrjService")
public class SolrjServiceImpl implements SolrjService{

	public SolrjServiceImpl() {
	}
@Deprecated	
public long searchItemsCount(String key) throws Exception {
		
		if(key==null||"".equals(key.trim())){
			return 0;
		}
		
		String url = "http://localhost:8973/solr/ny_test" ;
		
		HttpSolrServer server = new HttpSolrServer(url); 
		
		
		//以后参数都是通过这个对象去构造...
		SolrQuery solrParams=new SolrQuery();
		
		solrParams.setQuery("user_name:"+key);  
		
		
		QueryResponse queryResponse=server.query(solrParams);
		
		//返回所有的结果...
		SolrDocumentList documentList=queryResponse.getResults();
		
		long numFound = documentList.getNumFound();
		
		
		return numFound;
		
		
		
	}
	@Deprecated
	public List<User> searchItems(String key,int pagesize,int currpage) throws Exception {
		
		if(key==null||"".equals(key.trim())){
			return new ArrayList<User>();
		}
		
		String url = "http://localhost:8973/solr/ny_test" ;

		HttpSolrServer server = new HttpSolrServer(url);
	
		//以后参数都是通过这个对象去构造...
		SolrQuery solrParams=new SolrQuery();
		
		solrParams.setQuery("user_name:"+key);  
		
		//分页
		solrParams.setStart(pagesize*(currpage-1));
		
		solrParams.setRows(pagesize);
		
		//开启高亮...
		solrParams.setHighlight(true);
		
		//高亮显示的格式...
		solrParams.setHighlightSimplePre("<font color='red'>");
		solrParams.setHighlightSimplePost("</font>");
		
		
		
		//我需要那几个字段进行高亮...
		
		solrParams.setParam("hl.fl", "user_name");
		
		QueryResponse queryResponse=server.query(solrParams);
		
		//返回所有的结果...
		SolrDocumentList documentList=queryResponse.getResults();
		
		Map<String, Map<String, List<String>>> maplist=queryResponse.getHighlighting();
		
		//返回高亮之后的结果..
		List<User> users=new ArrayList<User>();
		
		for(SolrDocument solrDocument:documentList){
			
			User user=new User();
			
			Object id=solrDocument.get("id");
//			Object name=solrDocument.get("name");
//			Object content=solrDocument.get("description");
//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(content);
			Map<String, List<String>>  fieldMap=maplist.get(id);
			List<String> stringlist=fieldMap.get("user_name");
			
			user.setUserAge(Integer.parseInt(solrDocument.get("user_age").toString()));
			user.setUserId(Integer.parseInt(id.toString()));
			user.setUserSex(solrDocument.get("user_sex").toString());
			user.setUserName(stringlist.get(0));
			user.setUserNo(solrDocument.get("user_no").toString());
			users.add(user);
		}
		
		return users;
		
		
		
	}
	
	
	public long searchItemsCount_new(String key) throws Exception {
		
		if(key==null||"".equals(key.trim())){
			return 0;
		}
		
		String url = "http://localhost:8973/solr/ny_test" ;
		
		HttpSolrClient client=new HttpSolrClient(url);
		
		//以后参数都是通过这个对象去构造...
		SolrQuery solrParams=new SolrQuery();
		
		solrParams.setQuery("user_name:"+key);  
		
		
		QueryResponse queryResponse=client.query(solrParams);
		
		//返回所有的结果...
		SolrDocumentList documentList=queryResponse.getResults();
		
		long numFound = documentList.getNumFound();
		
		
		return numFound;
		
		
		
	}
	public List<User> searchItems_new(String key,int pagesize,int currpage) throws Exception {
		
		if(key==null||"".equals(key.trim())){
			return new ArrayList<User>();
		}
		
		String url = "http://localhost:8973/solr/ny_test" ;
		
		HttpSolrClient client=new HttpSolrClient(url);
		
		//以后参数都是通过这个对象去构造...
		SolrQuery solrParams=new SolrQuery();
		
		solrParams.setQuery("user_name:"+key);  
		
		//分页
		solrParams.setStart(pagesize*(currpage-1));
		
		solrParams.setRows(pagesize);
		
		//开启高亮...
		solrParams.setHighlight(true);
		
		//高亮显示的格式...
		solrParams.setHighlightSimplePre("<font color='red'>");
		solrParams.setHighlightSimplePost("</font>");
		
		
		
		//我需要那几个字段进行高亮...
		
		solrParams.setParam("hl.fl", "user_name");
		
		QueryResponse queryResponse=client.query(solrParams);
		
		//返回所有的结果...
		SolrDocumentList documentList=queryResponse.getResults();
		
		Map<String, Map<String, List<String>>> maplist=queryResponse.getHighlighting();
		
		//返回高亮之后的结果..
		List<User> users=new ArrayList<User>();
		
		for(SolrDocument solrDocument:documentList){
			
			User user=new User();
			
			Object id=solrDocument.get("id");
//			Object name=solrDocument.get("name");
//			Object content=solrDocument.get("description");
//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(content);
			Map<String, List<String>>  fieldMap=maplist.get(id);
			List<String> stringlist=fieldMap.get("user_name");
			
			user.setUserAge(Integer.parseInt(solrDocument.get("user_age").toString()));
			user.setUserId(Integer.parseInt(id.toString()));
			user.setUserSex(solrDocument.get("user_sex").toString());
			user.setUserName(stringlist.get(0));
			user.setUserNo(solrDocument.get("user_no").toString());
			users.add(user);
		}
		
		return users;
		
		
		
	}
	
	
	
	
	

}
