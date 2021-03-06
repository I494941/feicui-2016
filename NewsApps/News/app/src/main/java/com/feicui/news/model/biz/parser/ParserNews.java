package com.feicui.news.model.biz.parser;

import java.util.List;

import com.feicui.news.common.LogUtil;
import com.feicui.news.model.entity.BaseEntity;
import com.feicui.news.model.entity.News;
import com.feicui.news.model.entity.NewsType;
import com.feicui.news.model.entity.SubType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ParserNews {

	/**
	 * gson解析新闻分类
	 * @param json
	 * @return list
	 */
	public static List<SubType> parserTypeList(String json){
		Gson gson = new Gson();
		BaseEntity<List<NewsType>> typeEntity = gson.fromJson(json, 
				new TypeToken<BaseEntity<List<NewsType>>>() {}.getType());
		List<NewsType> newsTypes = typeEntity.getData();
		if(newsTypes != null){
			//第一版没有分类列表,暂且返回默认主分类的子分类
			return newsTypes.get(0).getSubgrp();
		}
 		return null;
	}
	
	/**
	 * gson解析新闻列表
	 * @param json
	 * @return list
	 */
	public static List<News> parserNewsList(String json){
		LogUtil.d("TAG", "parserNewsList : " + json);
		Gson gson = new Gson();
		BaseEntity<List<News>> newsEntity = gson.fromJson(json, new TypeToken<BaseEntity<List<News>>>() {}.getType());
 		return newsEntity.getData();
	}
}
