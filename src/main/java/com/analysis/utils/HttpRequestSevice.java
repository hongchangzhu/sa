package com.analysis.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.analysis.po.QueryCondition;
import com.analysis.service.SubjectServiceImpl;
import com.framework.config.BasePropertyConfigurer;

/**
 * 
 * @author Administrator
 * 
 */
public class HttpRequestSevice {
	public static final String URL = BasePropertyConfigurer.getInstance().getString("httpurl");// Config.getValue("store",
																								// "httpurl");;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static String getResponseResult(QueryCondition cond) throws IOException {
		String restype = cond.getRestype();
		String reststat = cond.getReststat();
		String subject = cond.getSubjectid2();
		String gradeId = cond.getClassid2();
		String term = cond.getWeek2();
		String date3 = cond.getDate3();
		String date4 = cond.getDate4();

		String method = null;
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Date beginDate = null;
		Date endDate = null;

		SubjectServiceImpl serviceImpl = new SubjectServiceImpl();
		String subjectName = "";
		String gradeName = "";

		// ��Դ�ϴ�
		if ("1".equals(restype)) {
			// ��Դ�ϴ�����
			if ("1".equals(reststat)) {
				method = "getUploadTotalCount";
			} else if ("2".equals(reststat)) {// ��Դ�ϴ��ܵ�����
				method = "getUploadTotalSize";
			}
			nvps.add(new BasicNameValuePair("method", method));

			if (date3 != null && !"".equals(date3)) {
				beginDate = DateTool.parseDate(date3, "yyyy-MM-dd");
				date3 = DateTool.DateToString(beginDate, "yyyy-MM-dd HH:mm:ss");
				nvps.add(new BasicNameValuePair("begin", date3));
			}
			if (date4 != null && !"".equals(date4)) {
				endDate = DateTool.parseDate(date4, "yyyy-MM-dd");
				date4 = DateTool.DateToString(endDate, "yyyy-MM-dd HH:mm:ss");
				nvps.add(new BasicNameValuePair("end", date4));
			}
		} else if ("2".equals(restype)) {// ��Դ����
			if ("1".equals(reststat)) {// ��ѧ��ͳ��
				subjectName = serviceImpl.getSubjectNameBySubjectId(subject);
				nvps.add(new BasicNameValuePair("subject", subject));
				method = "getFCheckSizeBySubject";
				System.out.println("��ѧ��ͳ�Ƴ�����Դ��ѧ����ƣ�" + subjectName);
			} else if ("2".equals(reststat)) {// ���꼶ͳ��
				subjectName = serviceImpl.getSubjectNameBySubjectId(subject);
				gradeName = serviceImpl.getGradeNameByGradeId(gradeId);
				nvps.add(new BasicNameValuePair("grade", gradeName));
				method = "getFCheckSizeByGrade";
				System.out.println("���꼶ͳ�Ƴ�����Դ���꼶��ƣ�" + gradeName);
			} else if ("3".equals(reststat)) {// ������ͳ��
				nvps.add(new BasicNameValuePair("term", term));
				method = "getFCheckSizeByTerm";
				System.out.println("������ͳ�Ƴ�����Դ������" + term);
			} else if ("4".equals(reststat)) {// ��ʱ��ͳ��
				method = "getFCheckSizeByTime";
				if (date3 != null && !"".equals(date3)) {
					beginDate = DateTool.parseDate(date3, "yyyy-MM-dd");
					date3 = DateTool.DateToString(beginDate, "yyyy-MM-dd HH:mm:ss");
					nvps.add(new BasicNameValuePair("begin", date3));
				}
				if (date4 != null && !"".equals(date4)) {
					endDate = DateTool.parseDate(date4, "yyyy-MM-dd");
					date4 = DateTool.DateToString(endDate, "yyyy-MM-dd HH:mm:ss");
					nvps.add(new BasicNameValuePair("end", date4));
				}
			}
		} else if ("3".equals(restype)) {// ��Դ����
			if ("1".equals(reststat)) {// ��ѧ��ͳ��
				subjectName = serviceImpl.getSubjectNameBySubjectId(subject);
				nvps.add(new BasicNameValuePair("subject", subjectName));
				method = "getRCheckSizeBySubject";
				System.out.println("��ѧ��ͳ�Ƹ�����Դ��ѧ����ƣ�" + subjectName);
			} else if ("2".equals(reststat)) {// ���꼶ͳ��
				subjectName = serviceImpl.getSubjectNameBySubjectId(subject);
				gradeName = serviceImpl.getGradeNameByGradeId(gradeId);
				nvps.add(new BasicNameValuePair("grade", gradeName));
				method = "getRCheckSizeByGrade";
				System.out.println("���꼶ͳ�Ƹ�����Դ���꼶��ƣ�" + gradeName);
			} else if ("3".equals(reststat)) {// ������ͳ��
				nvps.add(new BasicNameValuePair("term", term));
				method = "getRCheckSizeByTerm";
				System.out.println("������ͳ�Ƹ�����Դ������" + term);
			} else if ("4".equals(reststat)) {// ��ʱ��ͳ��
				method = "getRCheckSizeByTime";
				if (date3 != null && !"".equals(date3)) {
					beginDate = DateTool.parseDate(date3, "yyyy-MM-dd");
					date3 = DateTool.DateToString(beginDate, "yyyy-MM-dd HH:mm:ss");
					nvps.add(new BasicNameValuePair("begin", date3));
				}
				if (date4 != null && !"".equals(date4)) {
					endDate = DateTool.parseDate(date4, "yyyy-MM-dd");
					date4 = DateTool.DateToString(endDate, "yyyy-MM-dd HH:mm:ss");
					nvps.add(new BasicNameValuePair("end", date4));
				}
			}
		} else if ("4".equals(restype)) {// ��������
			// ��Դ�ϴ�����
			if ("1".equals(reststat)) {
				method = "getUploadTotalCount";
			} else if ("2".equals(reststat)) {// ��Դ�ϴ��ܵ�����
				method = "getUploadTotalSize";
			}
		}
		String resultStr = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpPost httpPost = new HttpPost(URL);
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));

			HttpResponse httpResponse = httpclient.execute(httpPost);
			Integer status = httpResponse.getStatusLine().getStatusCode();
			if (status == 200) {
				resultStr = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		if (resultStr == null)
			return "";
		resultStr = resultStr.replace("}", "");
		resultStr += ", \"subjectName\":\"" + subjectName + "\", \"gradeName\":\"" + gradeName + "\"}";
		return resultStr;
	}
}
