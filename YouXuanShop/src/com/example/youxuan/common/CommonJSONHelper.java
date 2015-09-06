package com.example.youxuan.common;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class CommonJSONHelper {
	
	/**
	 * 通过网络请求获取JSON字符串
	 * @param uri 连接地址
	 * @return String
	 */
	public static String getJSON(String uri) {
		String json = null;
		//创建链接
		try {
			HttpClient httpClient=new DefaultHttpClient();
			//创建客户端
			HttpParams params=httpClient.getParams();
			//模拟人请求链接
			String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6";
			HttpProtocolParams.setUserAgent(params, userAgent);
			//设置链接超时
			HttpConnectionParams.setConnectionTimeout(params, 5000);
			//获取请求（用GET）
			HttpGet httpGet=new HttpGet(uri);
			HttpResponse httpResponse=httpClient.execute(httpGet);
			//响应头中有内容且响应码为200
			if(httpResponse!=null&&httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				//获得响应码的实体内容
				HttpEntity httpEntity=httpResponse.getEntity();
				if(httpEntity!=null){
					//用Entity的工具类获得JSON字符串
					json=EntityUtils.toString(httpEntity, "UTF-8");
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return json;
	}
}
