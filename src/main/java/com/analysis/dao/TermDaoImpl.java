package com.analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.analysis.db.DBConnection;
import com.analysis.po.ResrecInfo;
import com.analysis.po.School;
import com.analysis.po.Term;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.red.crm.MetadataServiceUtils;

public class TermDaoImpl {

	public List<Term> getAllTermByRegionId(String regionId) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Term> list = new ArrayList<Term>();
		Term term = null;
		try {
			con = DBConnection.getConnection();
			String sql = "select t.term_id,t.term_name from t_term t where t.regoin_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, regionId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				term = new Term();
				term.setTermId(rs.getString(1));
				term.setTermName(rs.getString(2));
				list.add(term);
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

	/**
	 * 
	 * @功能：调用远程接口获取终端数据并保存在本地数据库
	 * 
	 */
	public void saveAll(String regionId, String schoolType) {
		try {
			// 远程调用服务获取终端数据,返回的是json格式字符串
			String jsonData = MetadataServiceUtils.getSchoolList(regionId,
					schoolType);
			// System.out.println("term data:" + jsonData);
			Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.create();
			// 把json格式字符串数据转换为对象集合,然后保存在本地数据库中
			List<School> list = g.fromJson(jsonData,
					new TypeToken<List<School>>() {
					}.getType());
			if (list == null || list.isEmpty())
				return;
			this.patchSave(list);

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void patchSave(List<School> list) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String insert = "insert into t_term(term_id,term_name,province_id,city_id,regoin_id,school_type,version_no,xxjgbxlxm3,"
					+ "resrec_wx,resrec_wx_mac,resrec_net,resrec_net_mac,resrec_net_rtype,resrec_net_mac2,resrec_net_rtype2,resrec_net_mac3,resrec_net_rtype3,"
					+ "resrec_userphone,resrec_address,resrec_useremail,resrec_zipcode,resrec_username,resrec_userqq)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(insert);
			for (School school : list) {
				stmt.setString(1, school.getSchoolId());
				stmt.setString(2, school.getSchoolName());
				stmt.setString(3, school.getProvinceId());
				stmt.setString(4, school.getCityId());
				stmt.setString(5, school.getCountyId());
				stmt.setString(6, school.getSchoolType());
				stmt.setBigDecimal(7, school.getVNo());
				stmt.setString(8, school.getXXJGBXLXM3());

				ResrecInfo resrecInfo = school.getResrecInfo();
				if (resrecInfo != null) {
					stmt.setBigDecimal(9, resrecInfo.getResrec_wx());
					stmt.setString(10, resrecInfo.getResrec_wx_mac());
					stmt.setBigDecimal(11, resrecInfo.getResrec_net());
					stmt.setString(12, resrecInfo.getResrec_net_mac());
					stmt.setString(13, resrecInfo.getResrec_net_rtype());
					stmt.setString(14, resrecInfo.getResrec_net_mac2());
					stmt.setString(15, resrecInfo.getResrec_net_rtype2());
					stmt.setString(16, resrecInfo.getResrec_net_mac3());
					stmt.setString(17, resrecInfo.getResrec_net_rtype3());

					stmt.setString(18, resrecInfo.getResrec_userphone());
					stmt.setString(19, resrecInfo.getResrec_address());
					stmt.setString(20, resrecInfo.getResrec_useremail());

					stmt.setString(21, resrecInfo.getResrec_zipcode());
					stmt.setString(22, resrecInfo.getResrec_username());
					stmt.setString(23, resrecInfo.getResrec_userqq());
				}
				stmt.execute();
			}
			con.commit();
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.closeConnection(con);
		}
	}

	/**
	 * 
	 * @功能：删除终端表中的所有数据
	 * 
	 */
	public void deleteAll(String regionId, String schoolType) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String delete = "delete from t_term where regoin_id=? and school_type=?";
			stmt = con.prepareStatement(delete);
			stmt.setString(1, regionId);
			stmt.setString(2, schoolType);

			stmt.execute();
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

	public void patchDelete(List<School> list, String schoolType) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String delete = "delete from t_term where regoin_id=? and school_type=?";
			stmt = con.prepareStatement(delete);

			for (School school : list) {
				stmt.setString(1, school.getSchoolId());
				stmt.setString(2, schoolType);
			}

			stmt.execute();
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
}
