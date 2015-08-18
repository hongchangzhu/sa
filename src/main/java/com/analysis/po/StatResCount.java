package com.analysis.po;

import java.math.BigDecimal;

public class StatResCount {
	private String adddate;
	private String termname;
	private String regoinname;
	private BigDecimal retotal;

	/**
	 * @return the adddate
	 */
	public String getAdddate() {
		return adddate;
	}

	/**
	 * @param adddate
	 *            the adddate to set
	 */
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	/**
	 * @return the termname
	 */
	public String getTermname() {
		return termname;
	}

	/**
	 * @param termname
	 *            the termname to set
	 */
	public void setTermname(String termname) {
		this.termname = termname;
	}

	/**
	 * @return the regoinname
	 */
	public String getRegoinname() {
		return regoinname;
	}

	/**
	 * @param regoinname
	 *            the regoinname to set
	 */
	public void setRegoinname(String regoinname) {
		this.regoinname = regoinname;
	}

	/**
	 * @return the retotal
	 */
	public BigDecimal getRetotal() {
		return retotal;
	}

	/**
	 * @param retotal
	 *            the retotal to set
	 */
	public void setRetotal(BigDecimal retotal) {
		this.retotal = retotal;
	}
}
