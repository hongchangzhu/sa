package com.analysis.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.analysis.db.DBConnection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HotResServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HotResServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String acceptjson = "";
		BufferedReader br = null;
		JSONObject resp = new JSONObject();
		try {
			// System.out.println("***start***");
			br = new BufferedReader(new InputStreamReader(
					(ServletInputStream) request.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			acceptjson = sb.toString();
			System.out.println("acceptjson:" + acceptjson);
			if (acceptjson != null && !"".equals(acceptjson)) {
				JSONArray jsonArray = JSONArray.fromObject(acceptjson);
				this.save(jsonArray);
			} else {
				throw new Exception("����Ĳ���Ϊ��");
			}
			resp.put("success", true);
			resp.put("error", "");
		} catch (Exception e) {
			resp.put("success", false);
			resp.put("error", e.getMessage());
		} finally {
			if (br != null) {
				br.close();
			}
		}

		PrintWriter pw = response.getWriter();
		pw.write(resp.toString());
		pw.flush();
		pw.close();
	}

	private void save(JSONArray jsonArray) {
		if (jsonArray == null || jsonArray.size() == 0)
			return;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String insert = "insert into t_stat_res_1003(macid,resid,resname,respath,clickcount,adddate)"
					+ " values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(insert);
			JSONObject jsonObj = null;
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonObj = jsonArray.getJSONObject(i);
				String macid = jsonObj.getString("macid");
				String resid = jsonObj.getString("resid");
				String resname = jsonObj.getString("resname");
				String respath = jsonObj.getString("respath");
				int clickcount = jsonObj.getInt("clickcount");
				String adddate = jsonObj.getString("adddate");
				stmt.setString(1, macid);
				stmt.setString(2, resid);
				stmt.setString(3, resname);
				stmt.setString(4, respath);
				stmt.setBigDecimal(5, new BigDecimal(clickcount));
				stmt.setString(6, adddate);
				stmt.execute();
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.closeConnection(con);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
