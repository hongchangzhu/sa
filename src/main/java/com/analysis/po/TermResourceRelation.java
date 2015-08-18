package com.analysis.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.framework.dao.IBean;

public class TermResourceRelation implements Serializable, IBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -340572866513033743L;

	private String resourceId;// ��Դid
	private String resourceName;// ��Դ���
	private String termId;// �ն�id
	private String termName;// �ն����
	private String subjectId;// ѧ��id
	private String classId;// �꼶id
	private String optType;// �������ͣ�����������������ѽ���
	private Date optTime;// ����ʱ��
	private String regoinId;// ����id
	private String regoinName;// �������
	private BigDecimal optCount;

	public String getClassId() {
		return classId;
	}

	public BigDecimal getOptCount() {
		return optCount;
	}

	public void setOptCount(BigDecimal optCount) {
		this.optCount = optCount;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getRegoinId() {
		return regoinId;
	}

	public void setRegoinId(String regoinId) {
		this.regoinId = regoinId;
	}

	public String getRegoinName() {
		return regoinName;
	}

	public void setRegoinName(String regoinName) {
		this.regoinName = regoinName;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
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

	public String toString() {
		return new ToStringBuilder(this).append("resourceId", getResourceId())
				.append("resourceName", getResourceName()).append("termId", getTermId())
				.append("termName", getTermName()).append("subjectId", getSubjectId()).append("classId", getClassId())
				.append("optType", getOptType()).append("optTime", getOptTime()).append("regoinId", getRegoinId())
				.append("regoinName", getRegoinName()).toString();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
