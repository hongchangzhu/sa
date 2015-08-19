package com.analysis.po;

import java.io.Serializable;
import java.math.BigDecimal;

import com.framework.dao.IBean;

public class School implements Serializable, IBean {
	private String schoolId;
	private String provinceId;
	private String cityId;
	private String countyId;
	private String schoolName;
	private String schoolType;
	private BigDecimal vNo;
	private String XXJGBXLXM3;
	private String optType;

	private ResrecInfo resrecInfo;

	/**
	 * @return the optType
	 */
	public String getOptType() {
		return optType;
	}

	/**
	 * @param optType
	 *            the optType to set
	 */
	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public BigDecimal getVNo() {
		return vNo;
	}

	public void setVNo(BigDecimal no) {
		vNo = no;
	}

	public String getXXJGBXLXM3() {
		return XXJGBXLXM3;
	}

	public void setXXJGBXLXM3(String xxjgbxlxm3) {
		XXJGBXLXM3 = xxjgbxlxm3;
	}

	/**
	 * @return the resrecInfo
	 */
	public ResrecInfo getResrecInfo() {
		return resrecInfo;
	}

	/**
	 * @param resrecInfo
	 *            the resrecInfo to set
	 */
	public void setResrecInfo(ResrecInfo resrecInfo) {
		this.resrecInfo = resrecInfo;
	}
}
