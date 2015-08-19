package com.analysis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		hotres();
	}

	// 资源总数统计接口
	public static void restotal() throws ClientProtocolException, IOException {
		String URL = "http://localhost:8080/statAnalysis/stat/resourceTotalCount";
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(URL);
		HttpRequestBase httpRequest = null;
		AbstractHttpEntity entity = null;

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("macid", "aaa");
		jsonObj.put("restotal", 5);
		jsonObj.put("adddate", "2015-08-13");
		jsonArray.add(jsonObj);

		jsonObj = new JSONObject();
		jsonObj.put("macid", "bbb");
		jsonObj.put("restotal", 68);
		jsonObj.put("adddate", "2015-08-13");
		jsonArray.add(jsonObj);

		String json = jsonArray.toString();
		entity = new StringEntity(json, "UTF-8");
		entity.setContentType("application/json");
		// entity.setContentType("application/x-www-form-urlencoded");
		if (entity != null) {
			entity.setContentEncoding("UTF-8");
		}
		httpPost.setEntity(entity);
		httpPost.addHeader("charset", "UTF-8");
		httpRequest = httpPost;

		HttpResponse httpResponse = httpclient.execute(httpRequest);
		Integer status = httpResponse.getStatusLine().getStatusCode();
		String resultStr = null;
		if (status == 200) {
			resultStr = EntityUtils.toString(httpResponse.getEntity());
			System.out.println("***response:" + resultStr);
		}
	}

	// 终端资源点击总数统计接口
	public static void resclickcount() throws ClientProtocolException,
			IOException {
		String URL = "http://localhost:8080/statAnalysis/stat/termClickCount";
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(URL);
		HttpRequestBase httpRequest = null;
		AbstractHttpEntity entity = null;

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("macid", "aaa");
		jsonObj.put("clicktotal", 89);
		jsonObj.put("adddate", "2015-08-13");
		jsonArray.add(jsonObj);

		jsonObj = new JSONObject();
		jsonObj.put("macid", "bbb");
		jsonObj.put("clicktotal", 45);
		jsonObj.put("adddate", "2015-08-13");
		jsonArray.add(jsonObj);

		String json = jsonArray.toString();
		entity = new StringEntity(json, "UTF-8");
		entity.setContentType("application/json");
		// entity.setContentType("application/x-www-form-urlencoded");
		if (entity != null) {
			entity.setContentEncoding("UTF-8");
		}
		httpPost.setEntity(entity);
		httpPost.addHeader("charset", "UTF-8");
		httpRequest = httpPost;

		HttpResponse httpResponse = httpclient.execute(httpRequest);
		Integer status = httpResponse.getStatusLine().getStatusCode();
		String resultStr = null;
		if (status == 200) {
			resultStr = EntityUtils.toString(httpResponse.getEntity());
			System.out.println("***response:" + resultStr);
		}
	}

	// 点击数前5名资源统计接口
	public static void hotres() throws ClientProtocolException, IOException {
		String URL = "http://localhost:8080/statAnalysis/stat/resourceActivity";
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(URL);
		HttpRequestBase httpRequest = null;
		AbstractHttpEntity entity = null;

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("macid", "aaa");
		jsonObj.put("resid", "1");
		jsonObj.put("resname", "001 第一课时");
		jsonObj.put("respath", "资源路径");
		jsonObj.put("clickcount", 89);
		jsonObj.put("adddate", "2015-08-14");
		jsonArray.add(jsonObj);

		jsonObj = new JSONObject();
		jsonObj.put("macid", "bbb");
		jsonObj.put("resid", "2");
		jsonObj.put("resname", "001 第一课时");
		jsonObj.put("respath", "资源路径");
		jsonObj.put("clickcount", 15);
		jsonObj.put("adddate", "2015-08-14");
		jsonArray.add(jsonObj);

		String json = jsonArray.toString();
		entity = new StringEntity(json, "UTF-8");
		entity.setContentType("application/json");
		// entity.setContentType("application/x-www-form-urlencoded");
		if (entity != null) {
			entity.setContentEncoding("UTF-8");
		}
		httpPost.setEntity(entity);
		httpPost.addHeader("charset", "UTF-8");
		httpRequest = httpPost;

		HttpResponse httpResponse = httpclient.execute(httpRequest);
		Integer status = httpResponse.getStatusLine().getStatusCode();
		String resultStr = null;
		if (status == 200) {
			resultStr = EntityUtils.toString(httpResponse.getEntity());
			System.out.println("***response:" + resultStr);
		}
	}

}
