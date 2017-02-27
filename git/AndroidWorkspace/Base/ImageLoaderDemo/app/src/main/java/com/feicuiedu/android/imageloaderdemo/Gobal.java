package com.feicuiedu.android.imageloaderdemo;

/**
 * Created by chenyan on 2016/5/4.
 */
public interface Gobal {

	String LOG_TAG = "newsClient";

	String APPURL = "http://118.244.212.82:9092/newsClient";
	// String APPURL="http://127.0.0.1:8080/newsClient";
	int NEWS_VERSION_CODE = 1;

	String DBNAME = "local_news.db";
	int DBVERSION = 1;

	String METHOD_POST = "POST";
	String METHOD_GET = "GET";

	int CONNECT_TIME_OUT = 10000;
	int READ_TIME_OUT = 10000;

	int WATI_TIME_OUT = 60000;
	int MAX_ROUTE_CONNECTIONS = 800;
	int MAX_TOTAL_CONNECTIONS = 8;

}
