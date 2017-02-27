package com.feicuiedu.android.imageloaderdemo;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtils {

	private static HttpURLConnection conn = null;

	private static void initHttp(String url, Map<String, String> params, String method, String strParams)
			throws MalformedURLException, IOException {
		String strUrl = null;
		if (Gobal.METHOD_GET.equals(method)) {

			strUrl = Gobal.APPURL + url + strParams;
		}

		Log.d("strUrl", strUrl);
		// http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20
		conn = (HttpURLConnection) new URL(strUrl).openConnection();
		// 设置连接超时为5秒
		conn.setConnectTimeout(Gobal.CONNECT_TIME_OUT);

		// 设置读取时间
		conn.setReadTimeout(Gobal.READ_TIME_OUT);

		// 设置请求类型为Get类型
		conn.setRequestMethod(method);
	}

	public static String getDataByGet(String url, Map<String, String> params) {

		String str = null;

		String strParams = parseParams(params, Gobal.METHOD_GET);
		// ?key=value&key=value&key=value&key=value&key=value
		try {

			initHttp(url, params, Gobal.METHOD_GET, strParams);

			// 判断请求Url是否成功
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("请求url失败");
			} else {
				InputStream in = conn.getInputStream();
				byte[] data = read(in);
				str = new String(data, "UTF-8");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.d("get_strUrl_json", str);

		return str;
	}

	public static String getDataByPost(String url, Map<String, String> params) {

		String str = null;

		String strParams = parseParams(params, Gobal.METHOD_POST);
		try {
			initHttp(url, params, Gobal.METHOD_POST, null);

			// 获取输出流
			OutputStream out = conn.getOutputStream();
			out.write(strParams.getBytes());
			out.flush();

			// 判断请求Url是否成功
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("请求url失败");
			} else {
				InputStream in = conn.getInputStream();
				byte[] data = read(in);
				str = new String(data, "UTF-8");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		Log.d("post_strUrl_json", str);

		return str;
	}

	private static String parseParams(Map<String, String> params, String method) {

		StringBuffer sb = new StringBuffer("");

		if (method.equals(Gobal.METHOD_GET)) {
			sb.append("?");
		}

		for (Entry<String, String> entry : params.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue() + "&");
		}
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	// 从流中读取数据
	public static byte[] read(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}

}
