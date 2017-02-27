package android.wjf.android06.feicuiedu.com.newsapp.model.biz.parser;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

import android.content.Context;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.BaseEntity;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.News;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.SubType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * json
 * 数据解析
 */
public class ParserNews {

    private Context context;

    public ParserNews(Context context) {
        this.context = context;
    } //解析新闻数据

    public ArrayList<News> parser(JSONObject jsonObject,int subid) throws Exception {
        ArrayList<News> newsLit = new ArrayList<News>();
        //根据数据块名称获取一个数组
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        JSONObject object;
        int nid;
        String stamp;
        String title;
        String summary;
        String icon;
        String link;
        int type;
        //循环遍历这个数组
        for (int i = 0; i < jsonArray.length(); i++) {
            object = jsonArray.getJSONObject(i);
            nid = object.getInt("nid");
            stamp = object.getString("stamp");
            title = object.getString("title");
            summary = object.getString("summary");
            icon = object.getString("icon");
            link = object.getString("link");
            type = object.getInt("type");
            News news = new News(nid, stamp, title, summary, icon, link, type,subid);
            newsLit.add(news);
        }
        return newsLit;
    }

    /**
     * gson解析新闻分类
     */
    public static ArrayList<SubType> parserTypeList(JSONObject jsonObject) throws Exception {

        ArrayList<SubType> newsLit = new ArrayList<SubType>();
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject jObject = null;
        JSONArray arrayGrp = null;
        JSONObject ObjectJ = null;
        int id;
        String group = "";
        for (int i = 0; i < jsonArray.length(); i++) {
            jObject = jsonArray.getJSONObject(i);
            arrayGrp = jObject.getJSONArray("subgrp");

            for (int j = 0; j < arrayGrp.length(); j++) {
                ObjectJ = arrayGrp.getJSONObject(j);

                id = ObjectJ.getInt("subid");
                group = ObjectJ.getString("subgroup");
                SubType subType = new SubType(id, group);
                newsLit.add(subType);
            }
        }
        return newsLit;
    }

    /**
     * gson解析新闻列表
     *
     * @param json
     * @return list
     */
    public static List<News> parserNewsList(String json) {
        Gson gson = new Gson();
        BaseEntity<List<News>> newsEntity = gson.fromJson(json, new TypeToken<BaseEntity<List<News>>>() {
        }.getType());
        return newsEntity.getData();
    }
}
