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
	 * ͨ�����������ȡJSON�ַ���
	 * @param uri ���ӵ�ַ
	 * @return String
	 */
	public static String getJSON(String uri) {
		String json = null;
		//��������
		try {
			HttpClient httpClient=new DefaultHttpClient();
			//�����ͻ���
			HttpParams params=httpClient.getParams();
			//ģ������������
			String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6";
			HttpProtocolParams.setUserAgent(params, userAgent);
			//�������ӳ�ʱ
			HttpConnectionParams.setConnectionTimeout(params, 5000);
			//��ȡ������GET��
			HttpGet httpGet=new HttpGet(uri);
			HttpResponse httpResponse=httpClient.execute(httpGet);
			//��Ӧͷ������������Ӧ��Ϊ200
			if(httpResponse!=null&&httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				//�����Ӧ���ʵ������
				HttpEntity httpEntity=httpResponse.getEntity();
				if(httpEntity!=null){
					//��Entity�Ĺ�������JSON�ַ���
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
