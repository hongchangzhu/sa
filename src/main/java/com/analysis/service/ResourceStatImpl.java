package com.analysis.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.analysis.db.DBConnection;
import com.analysis.po.QueryCondition;
import com.analysis.po.StatResCount;
import com.analysis.utils.Query;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ResourceStatImpl {

	public String statResCount(String submitJSON, int index, int pageSize) {
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		QueryCondition cond = g.fromJson(submitJSON,
				new TypeToken<QueryCondition>() {
				}.getType());
		Query query = new Query();
		if (index < 0)
			index = 0;
		int start = (index) * pageSize;
		int end = start + pageSize;
		String sql = query.getStatResCount(cond, start, pageSize);
		String countSQL = query.getCountSQL();
		List condParams = query.getCondParams();
		int count = count(countSQL, condParams);

		if (end > count) {
			pageSize = count - start;
		}

		String format = "limit %d, %d ";
		sql = sql + String.format(format, start, pageSize);

		List list = statResTotal(sql, condParams);
		HashMap result = new HashMap();
		result.put("data", list);
		result.put("total", count);
		String jsonData = g.toJson(result);

		return jsonData;
	}

	private List statResTotal(String sql, List condParams) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement(sql);
			for (int i = 0; i < condParams.size(); i++) {
				String param = (String) condParams.get(i);
				stmt.setString(i + 1, param);
			}

			rs = stmt.executeQuery();
			StatResCount result = null;
			while (rs.next()) {
				result = new StatResCount();
				result.setAdddate(rs.getString(1));
				result.setTermname(rs.getString(2));
				result.setRegoinname(rs.getString(3));
				result.setRetotal(rs.getBigDecimal(4));
				list.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.closeConnection(con);
		}
		return list;
	}

	private int count(String sql, List condParams) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement(sql);
			for (int i = 0; i < condParams.size(); i++) {
				String param = (String) condParams.get(i);
				stmt.setString(i + 1, param);
			}

			rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getBigDecimal(1).intValue();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.closeConnection(con);
		}
		return count;
	}

	public String statResActivity(String submitJSON, int index, int pageSize) {
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		QueryCondition cond = g.fromJson(submitJSON,
				new TypeToken<QueryCondition>() {
				}.getType());
		Query query = new Query();
		if (index < 0)
			index = 0;
		int start = (index) * pageSize;
		int end = start + pageSize;

		String sql = query.getResActivity(cond, start, pageSize);
		String countSQL = query.getCountSQL();
		List condParams = query.getCondParams();
		int count = count(countSQL, condParams);

		if (end > count) {
			pageSize = count - start;
		}

		String format = "limit %d, %d ";
		sql = sql + String.format(format, start, pageSize);

		List list = statResActivityClickCount(sql, condParams);
		HashMap result = new HashMap();
		result.put("data", list);
		result.put("total", count);
		String jsonData = g.toJson(result);

		return jsonData;
	}

	private List statResActivityClickCount(String sql, List condParams) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement(sql);
			for (int i = 0; i < condParams.size(); i++) {
				String param = (String) condParams.get(i);
				stmt.setString(i + 1, param);
			}

			rs = stmt.executeQuery();
			Map map = null;
			while (rs.next()) {
				map = new HashMap();
				map.put("termname", rs.getString(1));
				map.put("regoinname", rs.getString(2));
				map.put("retotal", rs.getBigDecimal(3));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.closeConnection(con);
		}
		return list;
	}

	public String statHotRes(String submitJSON, int index, int pageSize) {
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		QueryCondition cond = g.fromJson(submitJSON,
				new TypeToken<QueryCondition>() {
				}.getType());
		Query query = new Query();
		if (index < 0)
			index = 0;
		int start = (index) * pageSize;
		int end = start + pageSize;

		String sql = query.getHotResClickCount(cond, start, pageSize);
		String countSQL = query.getCountSQL();
		List condParams = query.getCondParams();
		int count = count(countSQL, condParams);

		if (end > count) {
			pageSize = count - start;
		}

		String format = "limit %d, %d ";
		sql = sql + String.format(format, start, pageSize);

		List list = statHotResClickCount(sql, condParams);
		HashMap result = new HashMap();
		result.put("data", list);
		result.put("total", count);
		String jsonData = g.toJson(result);

		return jsonData;
	}

	private List statHotResClickCount(String sql, List condParams) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement(sql);
			for (int i = 0; i < condParams.size(); i++) {
				String param = (String) condParams.get(i);
				stmt.setString(i + 1, param);
			}

			rs = stmt.executeQuery();
			Map map = null;
			while (rs.next()) {
				map = new HashMap();
				map.put("resname", rs.getString(1));
				map.put("respath", rs.getString(2));
				map.put("clickcount", rs.getBigDecimal(3));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.closeConnection(con);
		}
		return list;
	}
}
