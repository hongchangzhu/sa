package com.analysis.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.analysis.dao.RegionDaoImpl;
import com.analysis.po.QueryCondition;

public class Query {
	private List condParams = new ArrayList();
	private String countSQL;

	/**
	 * @return the countSQL
	 */
	public String getCountSQL() {
		return countSQL;
	}

	/**
	 * @param countSQL
	 *            the countSQL to set
	 */
	public void setCountSQL(String countSQL) {
		this.countSQL = countSQL;
	}

	public List getCondParams() {
		return condParams;
	}

	public void setCondParams(List condParams) {
		this.condParams = condParams;
	}

	public String getSql(QueryCondition cond) {
		String optType = cond.getOpttypeid();
		if (Constant.UN_BOOT_STRAP_TYPE.equals(optType)) {
			return this.getUnBootStrapSql(cond);
		} else
			return this.getTermResourceStatSql(cond);
	}

	private boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim()) || "-".equals(str.trim())
				|| "null".equals(str.trim()) || "undefined".equals(str.trim()))
			return true;
		return false;
	}

	/**
	 * 
	 * @功能：拼装统计查询sql
	 * 
	 * @param cond
	 * @return
	 */
	public String getTermResourceStatSql(QueryCondition cond) {
		String termId = cond.getTermid();
		String countryId = cond.getCountryid();
		String cityId = cond.getCityid();
		String provinceId = cond.getProvinceid();
		String codePath = null;
		StringBuffer sb = new StringBuffer();
		sb.append("select t4.resource_id, t4.resource_name, t4.totalnum ");
		sb
				.append("from (select distinct t.resource_id, t0.resource_name, t.totalnum ");
		sb.append("from t_term_resource_relation_11 t0,");
		sb.append("(select t1.resource_id, sum(t1.opt_count) totalnum ");

		StringBuffer innerCond = new StringBuffer();
		innerCond.append("where t1.term_id = t2.term_id ");
		innerCond.append("and t2.regoin_id = t3.id ");
		innerCond.append("and t3.code_path like ? ");// 1
		innerCond.append("and t1.opt_type = ? ");// 2

		RegionDaoImpl regionDaoImpl = new RegionDaoImpl();
		if (isEmpty(countryId) == false) {
			codePath = regionDaoImpl.getCodePath(countryId);
		} else if (isEmpty(cityId) == false) {
			codePath = regionDaoImpl.getCodePath(cityId);
		} else if (isEmpty(provinceId) == false) {
			codePath = regionDaoImpl.getCodePath(provinceId);
		}
		condParams.add(codePath + "%");
		condParams.add(cond.getOpttypeid());

		if (isEmpty(termId) == false) {
			innerCond.append("and t1.term_id = ? ");
			condParams.add(termId);
		}

		String code = codePath.substring(0, 2);// 省编码
		// 定位表
		sb.append("from t_term_resource_relation_").append(code).append(
				" t1, t_term t2, t_region t3 ");

		// 学科
		String subjectId = cond.getSubjectid();
		if (!isEmpty(subjectId)) {
			innerCond.append("and t1.subject_id = ? ");
			condParams.add(subjectId);
		}

		// 年级
		String classId = cond.getClassid();
		if (!isEmpty(classId)) {
			innerCond.append("and t1.class_id = ? ");
			condParams.add(classId);
		}

		String date1 = null;
		String date2 = null;
		String times = cond.getTimes();// 按时间统计
		if (times != null && "1".equals(times.trim())) {// 按周期统计
			String weekyear = cond.getWeekyear();
			String week = cond.getWeek();
			// 年和期数要都有值才作为条件统计
			if (weekyear != null && !"".equals(weekyear.trim())
					&& !"-1".equals(weekyear.trim()) && week != null
					&& !"".equals(week.trim()) && !"-1".equals(week.trim())) {
				int yearnum = new Integer(weekyear).intValue();
				int weeknum = new Integer(week).intValue();
				date1 = DateTool.getFirstDayOfYearWeek(yearnum, weeknum);
				date2 = DateTool.getLastDayOfYearWeek(yearnum, weeknum);
				// innerCond.append("and to_char(t1.opt_time,'yyyy-mm-dd') >= ?
				// ");//oracle
				// innerCond.append("and to_char(t1.opt_time,'yyyy-mm-dd') <= ?
				// ");//oracle
				innerCond
						.append("and date_format(t1.opt_time,'%Y-%m-%d') >= ? ");// mysql
				innerCond
						.append("and date_format(t1.opt_time,'%Y-%m-%d') <= ? ");// mysql
				// date_format(t.birthday,'%Y-%m-%d')>='1987-01-21'; ;mysql
				condParams.add(date1);
				condParams.add(date2);
			}
		} else if (times != null && "2".equals(times.trim())) {// 按时间段统计
			date1 = cond.getDate1();
			date2 = cond.getDate2();
			if (date1 != null && !"".equals(date1.trim()) && date2 != null
					&& !"".equals(date2.trim())) {
				// innerCond.append("and to_char(t1.opt_time,'yyyy-mm-dd') >= ?
				// ");//oracle
				// innerCond.append("and to_char(t1.opt_time,'yyyy-mm-dd') <= ?
				// ");//oracle
				innerCond
						.append("and date_format(t1.opt_time,'%Y-%m-%d') >= ? ");// mysql
				innerCond
						.append("and date_format(t1.opt_time,'%Y-%m-%d') <= ? ");// mysql
				condParams.add(date1);
				condParams.add(date2);
			}
		} else if (times != null && "3".equals(times.trim())) {// 按学期 统计
			String semesteryear = cond.getSemesteryear();
			String semester = cond.getSemester();
			if (semesteryear != null && !"".equals(semesteryear.trim())
					&& !"-1".equals(semesteryear.trim()) && semester != null
					&& !"".equals(semester.trim())
					&& !"-1".equals(semester.trim())) {
				int year = new Integer(semesteryear).intValue();
				int nextyear = year + 1;
				// 上学期时间跨度为当年的8月1日到下年的1月31日
				if (Constant.UP_SEMESTER.equals(semester)) {
					date1 = year + "-08-01";
					date2 = (year + 1) + "-01-31";
				} else if (Constant.DOWN_SEMESTER.equals(semester)) {// 下学期时间跨度为下年的2月1日到7月31日
					date1 = (year + 1) + "-02-01";
					date2 = (year + 1) + "-07-31";
				}
				// innerCond.append("and to_char(t1.opt_time,'yyyy-mm-dd') >= ?
				// ");//oracle
				// innerCond.append("and to_char(t1.opt_time,'yyyy-mm-dd') <= ?
				// ");//oracle
				innerCond
						.append("and date_format(t1.opt_time,'%Y-%m-%d') >= ? ");// mysql
				innerCond
						.append("and date_format(t1.opt_time,'%Y-%m-%d') <= ? ");// mysql
				condParams.add(date1);
				condParams.add(date2);
			}
		}

		sb.append(innerCond);
		sb.append("group by t1.resource_id) t ");
		sb.append("where t0.resource_id = t.resource_id ");
		sb.append("order by t.totalnum desc) t4 ");
		// sb.append(" where rownum <= 10 ");oracle
		if ("0".equals(cond.getIsExport()))
			sb.append(" limit 10 ");// mysql
		return sb.toString();
	}

	// 统计资源总数
	public String getStatResCount(QueryCondition cond, int start, int pageSize) {
		String termId = cond.getTermid();
		String countryId = cond.getCountryid();
		String cityId = cond.getCityid();
		String provinceId = cond.getProvinceid();
		String startdate = cond.getDate1();
		String enddate = cond.getDate2();
		String codePath = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT sr.adddate,tm.TERM_NAME,tm.regoinname,sr.restotal ");
		sb
				.append("FROM t_stat_res_1001 sr INNER JOIN v_term_mac_map tm ON sr.macid=tm.macid ");
		// sb.append("INNER JOIN t_term te ON tm.termid=te.TERM_ID ");
		// .append("INNER JOIN t_region re ON te.REGOIN_ID=re.ID ");
		// sb.append("INNER JOIN t_region re1 ON te.PROVINCE_ID = re1.ID ");
		// sb.append("INNER JOIN t_region re2 ON te.CITY_ID = re2.ID ");
		sb.append("WHERE 1=1 ");

		RegionDaoImpl regionDaoImpl = new RegionDaoImpl();
		if (isEmpty(countryId) == false) {
			codePath = regionDaoImpl.getCodePath(countryId);
		} else if (isEmpty(cityId) == false) {
			codePath = regionDaoImpl.getCodePath(cityId);
		} else if (isEmpty(provinceId) == false) {
			codePath = regionDaoImpl.getCodePath(provinceId);
		}
		if (!isEmpty(codePath)) {
			sb.append("and tm.CODE_PATH LIKE ? ");
			condParams.add(codePath + "%");
		}

		if (!isEmpty(termId)) {
			sb.append("AND tm.TERM_NAME LIKE ? ");
			condParams.add("%" + termId + "%");
		}

		if (this.isDate(startdate)) {
			startdate = this.splitDate(startdate);
		} else {
			startdate = "1900-01-01";
		}
		if (this.isDate(enddate)) {
			enddate = this.splitDate(enddate);
		} else {
			enddate = "9999-01-01";
		}
		sb.append("AND sr.adddate >= ? ");
		sb.append("AND sr.adddate <= ? ");
		condParams.add(startdate);
		condParams.add(enddate);

		countSQL = "SELECT COUNT(*) FROM (" + sb.toString() + ") ct ";
		sb.append("ORDER BY sr.adddate DESC, sr.restotal ASC ");

		return sb.toString();
	}

	// 资源活跃度
	public String getResActivity(QueryCondition cond, int start, int pageSize) {
		String termId = cond.getTermid();
		String countryId = cond.getCountryid();
		String cityId = cond.getCityid();
		String provinceId = cond.getProvinceid();
		String startdate = cond.getDate1();
		String enddate = cond.getDate2();
		String clickcount = cond.getResclickcount();
		if (this.isDate(startdate)) {
			startdate = this.splitDate(startdate);
		} else {
			startdate = "1900-01-01";
		}
		if (this.isDate(enddate)) {
			enddate = this.splitDate(enddate);
		} else {
			enddate = "9999-01-01";
		}

		int ccnt = 0;
		if (this.isEmpty(clickcount) || !Toolkit.isInteger(clickcount)) {
			ccnt = 0;
		} else {
			ccnt = Toolkit.parseInteger(clickcount);
		}

		String codePath = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT v.TERM_NAME,v.regoinname,c.ckt FROM (");
		sb.append("SELECT a.macid,(a.ckt - IFNULL(b.ckt, 0)) ckt FROM (");
		sb
				.append("SELECT t.macid,MAX(t.clicktotal) ckt FROM t_stat_res_1002 t WHERE t.adddate <= ? GROUP BY t.macid) a ");
		sb.append("LEFT OUTER JOIN (");
		sb
				.append("SELECT t.macid, MAX(t.clicktotal) ckt FROM t_stat_res_1002 t WHERE t.adddate < ? GROUP BY t.macid) b ");
		sb.append("ON a.macid = b.macid) c ");
		sb.append("INNER JOIN v_term_mac_map v ON c.macid = v.macid ");
		sb.append("WHERE c.ckt >= " + ccnt + " ");

		condParams.add(enddate);
		condParams.add(startdate);

		// if (this.isEmpty(clickcount) || !Toolkit.isInteger(clickcount)) {
		// condParams.add(0);
		// } else {
		// condParams.add(Toolkit.parseInteger(clickcount));
		// }

		RegionDaoImpl regionDaoImpl = new RegionDaoImpl();
		if (isEmpty(countryId) == false) {
			codePath = regionDaoImpl.getCodePath(countryId);
		} else if (isEmpty(cityId) == false) {
			codePath = regionDaoImpl.getCodePath(cityId);
		} else if (isEmpty(provinceId) == false) {
			codePath = regionDaoImpl.getCodePath(provinceId);
		}
		if (!isEmpty(codePath)) {
			sb.append("and v.CODE_PATH LIKE ? ");
			condParams.add(codePath + "%");
		}

		if (!isEmpty(termId)) {
			sb.append("AND v.TERM_NAME LIKE ? ");
			condParams.add("%" + termId + "%");
		}

		countSQL = "SELECT COUNT(*) FROM (" + sb.toString() + ") ct ";
		sb.append("ORDER BY c.ckt DESC ");

		return sb.toString();
	}

	// 热门资源点击数
	public String getHotResClickCount(QueryCondition cond, int start,
			int pageSize) {
		String startdate = cond.getDate1();
		String enddate = cond.getDate2();
		if (this.isDate(startdate)) {
			startdate = this.splitDate(startdate);
		} else {
			startdate = "1900-01-01";
		}
		if (this.isDate(enddate)) {
			enddate = this.splitDate(enddate);
		} else {
			enddate = "9999-01-01";
		}
		condParams.add(startdate);
		condParams.add(enddate);

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT v.resname,v.respath,a.ckcnt ");
		sb
				.append("FROM (SELECT t.resid,SUM(t.clickcount) ckcnt FROM t_stat_res_1003 t WHERE t.adddate >= ? AND t.adddate <= ? GROUP BY t.resid) a ");

		sb.append("INNER JOIN v_res_map v ON a.resid = v.resid ");
		countSQL = "SELECT COUNT(*) FROM (" + sb.toString() + ") ct ";
		sb.append("ORDER BY a.ckcnt DESC ");
		return sb.toString();
	}

	private boolean isDate(String dateStr) {
		if (dateStr == null || dateStr.length() < 10)
			return false;
		return true;
	}

	// yyyy-MM-dd
	private String splitDate(String dateStr) {
		return dateStr.substring(0, 10);
	}

	/**
	 * 
	 * @功能：拼装统计未开机查询sql
	 * 
	 * @param cond
	 * @return
	 */
	public String getUnBootStrapSql(QueryCondition cond) {
		String countryId = cond.getCountryid();
		String cityId = cond.getCityid();
		String provinceId = cond.getProvinceid();
		String codePath = null;
		StringBuffer sb = new StringBuffer();
		sb.append("select t0.term_id, t0.term_name, t4.tatolnum ");
		sb.append("from t_term t0,");
		sb.append("(select t1.term_id, count(t1.term_id) tatolnum ");
		sb.append("from t_un_boot_strap_term t1, t_term t2, t_region t3 ");

		StringBuffer innerCond = new StringBuffer();
		innerCond.append("where t1.term_id = t2.term_id ");
		innerCond.append("and t2.regoin_id = t3.id ");
		innerCond.append("and t3.code_path like ? ");

		RegionDaoImpl regionDaoImpl = new RegionDaoImpl();
		if (!isEmpty(countryId)) {
			codePath = regionDaoImpl.getCodePath(countryId);
		} else if (!isEmpty(cityId)) {
			codePath = regionDaoImpl.getCodePath(cityId);
		} else if (!isEmpty(provinceId)) {
			codePath = regionDaoImpl.getCodePath(provinceId);
		}
		condParams.add(codePath + "%");

		String date1 = null;
		String date2 = null;
		String times = cond.getTimes();// 按时间统计
		if (times != null && "1".equals(times.trim())) {// 按周期统计
			String weekyear = cond.getWeekyear();
			String week = cond.getWeek();
			// 年和期数要都有值才作为条件统计
			if (weekyear != null && !"".equals(weekyear.trim())
					&& !"-1".equals(weekyear.trim()) && week != null
					&& !"".equals(week.trim()) && !"-1".equals(week.trim())) {
				int yearnum = new Integer(weekyear).intValue();
				int weeknum = new Integer(week).intValue();
				date1 = DateTool.getFirstDayOfYearWeek(yearnum, weeknum);
				date2 = DateTool.getLastDayOfYearWeek(yearnum, weeknum);
				// innerCond
				// .append("and to_char(t1.check_date,'yyyy-mm-dd') >= ?
				// ");//oracle
				// innerCond
				// .append("and to_char(t1.check_date,'yyyy-mm-dd') <= ?
				// ");//oracle
				innerCond
						.append("and date_format(t1.check_date,'%Y-%m-%d') >= ? ");// mysql
				innerCond
						.append("and date_format(t1.check_date,'%Y-%m-%d') <= ? ");// mysql
				condParams.add(date1);
				condParams.add(date2);
			}
		} else if (times != null && "2".equals(times.trim())) {// 按时间段统计
			date1 = cond.getDate1();
			date2 = cond.getDate2();
			if (date1 != null && !"".equals(date1.trim()) && date2 != null
					&& !"".equals(date2.trim())) {
				// innerCond
				// .append("and to_char(t1.check_date,'yyyy-mm-dd') >= ?
				// ");//oracle
				// innerCond
				// .append("and to_char(t1.check_date,'yyyy-mm-dd') <= ?
				// ");//oracle
				innerCond
						.append("and date_format(t1.check_date,'%Y-%m-%d') >= ? ");// mysql
				innerCond
						.append("and date_format(t1.check_date,'%Y-%m-%d') <= ? ");// mysql
				condParams.add(date1);
				condParams.add(date2);
			}
		} else if (times != null && "3".equals(times.trim())) {// 按学期 统计
			String semesteryear = cond.getSemesteryear();
			String semester = cond.getSemester();
			if (semesteryear != null && !"".equals(semesteryear.trim())
					&& !"-1".equals(semesteryear.trim()) && semester != null
					&& !"".equals(semester.trim())
					&& !"-1".equals(semester.trim())) {
				int year = new Integer(semesteryear).intValue();
				int nextyear = year + 1;
				// 上学期时间跨度为当年的8月1日到下年的1月31日
				if (Constant.UP_SEMESTER.equals(semester)) {
					date1 = year + "-08-01";
					date2 = (year + 1) + "-01-31";
				} else if (Constant.DOWN_SEMESTER.equals(semester)) {// 下学期时间跨度为下年的2月1日到7月31日
					date1 = (year + 1) + "-02-01";
					date2 = (year + 1) + "-07-31";
				}
				// innerCond
				// .append("and to_char(t1.check_date,'yyyy-mm-dd') >= ?
				// ");//oracle
				// innerCond
				// .append("and to_char(t1.check_date,'yyyy-mm-dd') <= ?
				// ");//oracle
				innerCond
						.append("and date_format(t1.check_date,'%Y-%m-%d') >= ? ");// mysql
				innerCond
						.append("and date_format(t1.check_date,'%Y-%m-%d') <= ? ");// mysql
				condParams.add(date1);
				condParams.add(date2);
			}
		}

		sb.append(innerCond);
		sb.append("group by t1.term_id) t4 ");
		sb.append("where t0.term_id = t4.term_id ");
		// sb.append("and rownum <= 10 ");//oracle
		sb.append("order by t4.tatolnum desc ");
		if ("0".equals(cond.getIsExport()))
			sb.append(" limit 10 ");// mysql
		return sb.toString();
	}
}
