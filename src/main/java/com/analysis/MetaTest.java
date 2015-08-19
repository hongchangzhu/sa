package com.analysis;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.analysis.po.Regoin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class MetaTest {
	public static String URL = "https://meta.eduyun.cn/base/metadataServlet";
	public static String keyStorePw = "mis123mis";
	public static String trustStorePw = "mis123mis";
	public static String keyStoreFile = "D:\\metadata\\clientKeystore.jks";
	public static String trustStoreFile = "D:\\metadata\\clientTruststore.jks";
	public static String appName = "jiaoxuedian";
	public static String appPassWord = "76UYjhMN";
	public static Integer port = 443;

	/**
	 * 获取全部地区数据
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getAreaList() {
		try {
			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getAreaList");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	/**
	 * 获取地区日志数据
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getAreaLog() {
		try {

			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getAreaLog");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);
			mapParams.put("vNo", "0");

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	/**
	 * 获取学校数据
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getSchoolList() {
		try {

			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getSchoolList");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);
			mapParams.put("areaId", "1B34A4DB-9196-A3DF-654C-7B51296F5808");
			mapParams.put("schoolType", "JJ");

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	/**
	 * 获取学校日志数据
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getSchoolLog() {
		try {

			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getSchoolLog");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);
			mapParams.put("vNo", "0");
			mapParams.put("areaId", "0805994F-A5A9-96C4-6BA0-1D1BA3358C08");
			mapParams.put("schoolType", "JJ");

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	/**
	 * 获取全部学科数据
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getSubjectList() {
		try {

			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getSubjectList");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	/**
	 * 获取版本数据
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getPubVerList() {
		try {

			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getPubVerList");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);
			mapParams.put("subjectId", "402880e42e13953c012e139823860000");

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	/**
	 * 获取教材数据
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getBookCat() {
		try {

			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getBookCat");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);
			mapParams.put("versionId", "BF17C181-28F4-FBA5-162A-0CC3445FD4F6");

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	/**
	 * 获取教材变化日志
	 * 
	 * @param strURL
	 * @return
	 */
	public static String getBookLog() {
		try {

			Map<String, String> mapParams = new LinkedHashMap<String, String>();

			mapParams.put("method", "getBookLog");
			mapParams.put("appName", appName);
			mapParams.put("appPassWord", appPassWord);
			mapParams.put("vNo", "0");

			DefaultHttpClient httpclient = new DefaultHttpClient();

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			FileInputStream keyStoreIn = new FileInputStream(new File(
					keyStoreFile));
			FileInputStream trustStoreIn = new FileInputStream(new File(
					trustStoreFile));

			try {
				keyStore.load(keyStoreIn, keyStorePw.toCharArray());
				trustStore.load(trustStoreIn, trustStorePw.toCharArray());
			} catch (Exception e) {
			} finally {
				keyStoreIn.close();
				trustStoreIn.close();
			}

			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore,
					keyStorePw, trustStore);

			Scheme sch = new Scheme("https", port, socketFactory);

			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpPost httpPost = new HttpPost(URL);

			System.out.println(httpPost.getRequestLine());
			HttpRequestBase httpRequest = null;

			AbstractHttpEntity entity = null;
			System.out.println(JSONObject.fromObject(mapParams).toString());
			entity = new StringEntity(JSONObject.fromObject(mapParams)
					.toString());
			entity.setContentType("application/json");
			if (entity != null) {
				entity.setContentEncoding("UTF-8");
			}
			httpPost.setEntity(entity);
			httpPost.addHeader("charset", "UTF-8");
			httpRequest = httpPost;

			HttpResponse httpResponse = httpclient.execute(httpRequest);

			Integer status = httpResponse.getStatusLine().getStatusCode();
			System.out.println(status);
			if (status == 200) {
				String resultStr = EntityUtils.toString(httpResponse
						.getEntity());
				System.out.println(resultStr);
			}
			httpclient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error"; // 自定义错误信息
	}

	public static String jsonFormatter(String uglyJSONString) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJSONString);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}

	public static void main(String[] args) {
		// getAreaList();
		String jsonData = getAreaLog();
		// getSchoolList();
		// getSchoolLog();
		// getSubjectList();
		// getPubVerList();
		// getBookCat();
		// getBookLog();

		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		List<Map> list = g.fromJson(jsonData, new TypeToken<List<Map>>() {
		}.getType());
		System.out.println("区划数据：" + list);
	}

}
