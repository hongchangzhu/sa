package com.analysis.po;

import java.io.Serializable;
import java.util.Date;

import com.framework.dao.IBean;

/**
 * 
 * @˵����δ�����ն�
 * 
 * @���ߣ����
 * @���ڣ�2014-4-12
 * @�޸��ˣ�
 * @�޸����ڣ�
 */
public class TermUnBootStrap implements Serializable, IBean {
	private String termId;
	private String termName;
	private Date checkDate;

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}
}
