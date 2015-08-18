package com.analysis.po;

import java.io.Serializable;
import java.math.BigDecimal;

import com.framework.dao.IBean;

public class ResrecInfo implements Serializable, IBean {
	private BigDecimal resrec_wx; // ���ǽ��ձ�ʶ1:��0:��
	private String resrec_wx_mac;// ���ǿͻ���
	private BigDecimal resrec_net; // ��������ձ�ʶ1:��0:��
	private String resrec_net_mac; // ������MAC��ַ
	private String resrec_net_rtype; // ��������jxd:��ѧ�㣬xx:Сѧ��zx:��ѧ
	private String resrec_net_mac2; // ������MAC��ַ2
	private String resrec_net_rtype2; // ��������2
	private String resrec_net_mac3; // ������MAC��ַ3
	private String resrec_net_rtype3; // ��������3
	private String resrec_userphone; // ��ϵ�绰
	private String resrec_address;// ��ַ
	private String resrec_useremail; // ����
	private String resrec_zipcode; // �ʱ�
	private String resrec_username; // ��ϵ��
	private String resrec_userqq;// QQ��

	/**
	 * @return the resrec_wx
	 */
	public BigDecimal getResrec_wx() {
		return resrec_wx;
	}

	/**
	 * @param resrec_wx
	 *            the resrec_wx to set
	 */
	public void setResrec_wx(BigDecimal resrec_wx) {
		this.resrec_wx = resrec_wx;
	}

	/**
	 * @return the resrec_wx_mac
	 */
	public String getResrec_wx_mac() {
		return resrec_wx_mac;
	}

	/**
	 * @param resrec_wx_mac
	 *            the resrec_wx_mac to set
	 */
	public void setResrec_wx_mac(String resrec_wx_mac) {
		this.resrec_wx_mac = resrec_wx_mac;
	}

	/**
	 * @return the resrec_net
	 */
	public BigDecimal getResrec_net() {
		return resrec_net;
	}

	/**
	 * @param resrec_net
	 *            the resrec_net to set
	 */
	public void setResrec_net(BigDecimal resrec_net) {
		this.resrec_net = resrec_net;
	}

	/**
	 * @return the resrec_net_mac
	 */
	public String getResrec_net_mac() {
		return resrec_net_mac;
	}

	/**
	 * @param resrec_net_mac
	 *            the resrec_net_mac to set
	 */
	public void setResrec_net_mac(String resrec_net_mac) {
		this.resrec_net_mac = resrec_net_mac;
	}

	/**
	 * @return the resrec_net_rtype
	 */
	public String getResrec_net_rtype() {
		return resrec_net_rtype;
	}

	/**
	 * @param resrec_net_rtype
	 *            the resrec_net_rtype to set
	 */
	public void setResrec_net_rtype(String resrec_net_rtype) {
		this.resrec_net_rtype = resrec_net_rtype;
	}

	/**
	 * @return the resrec_net_mac2
	 */
	public String getResrec_net_mac2() {
		return resrec_net_mac2;
	}

	/**
	 * @param resrec_net_mac2
	 *            the resrec_net_mac2 to set
	 */
	public void setResrec_net_mac2(String resrec_net_mac2) {
		this.resrec_net_mac2 = resrec_net_mac2;
	}

	/**
	 * @return the resrec_net_rtype2
	 */
	public String getResrec_net_rtype2() {
		return resrec_net_rtype2;
	}

	/**
	 * @param resrec_net_rtype2
	 *            the resrec_net_rtype2 to set
	 */
	public void setResrec_net_rtype2(String resrec_net_rtype2) {
		this.resrec_net_rtype2 = resrec_net_rtype2;
	}

	/**
	 * @return the resrec_net_mac3
	 */
	public String getResrec_net_mac3() {
		return resrec_net_mac3;
	}

	/**
	 * @param resrec_net_mac3
	 *            the resrec_net_mac3 to set
	 */
	public void setResrec_net_mac3(String resrec_net_mac3) {
		this.resrec_net_mac3 = resrec_net_mac3;
	}

	/**
	 * @return the resrec_net_rtype3
	 */
	public String getResrec_net_rtype3() {
		return resrec_net_rtype3;
	}

	/**
	 * @param resrec_net_rtype3
	 *            the resrec_net_rtype3 to set
	 */
	public void setResrec_net_rtype3(String resrec_net_rtype3) {
		this.resrec_net_rtype3 = resrec_net_rtype3;
	}

	/**
	 * @return the resrec_userphone
	 */
	public String getResrec_userphone() {
		return resrec_userphone;
	}

	/**
	 * @param resrec_userphone
	 *            the resrec_userphone to set
	 */
	public void setResrec_userphone(String resrec_userphone) {
		this.resrec_userphone = resrec_userphone;
	}

	/**
	 * @return the resrec_address
	 */
	public String getResrec_address() {
		return resrec_address;
	}

	/**
	 * @param resrec_address
	 *            the resrec_address to set
	 */
	public void setResrec_address(String resrec_address) {
		this.resrec_address = resrec_address;
	}

	/**
	 * @return the resrec_useremail
	 */
	public String getResrec_useremail() {
		return resrec_useremail;
	}

	/**
	 * @param resrec_useremail
	 *            the resrec_useremail to set
	 */
	public void setResrec_useremail(String resrec_useremail) {
		this.resrec_useremail = resrec_useremail;
	}

	/**
	 * @return the resrec_zipcode
	 */
	public String getResrec_zipcode() {
		return resrec_zipcode;
	}

	/**
	 * @param resrec_zipcode
	 *            the resrec_zipcode to set
	 */
	public void setResrec_zipcode(String resrec_zipcode) {
		this.resrec_zipcode = resrec_zipcode;
	}

	/**
	 * @return the resrec_username
	 */
	public String getResrec_username() {
		return resrec_username;
	}

	/**
	 * @param resrec_username
	 *            the resrec_username to set
	 */
	public void setResrec_username(String resrec_username) {
		this.resrec_username = resrec_username;
	}

	/**
	 * @return the resrec_userqq
	 */
	public String getResrec_userqq() {
		return resrec_userqq;
	}

	/**
	 * @param resrec_userqq
	 *            the resrec_userqq to set
	 */
	public void setResrec_userqq(String resrec_userqq) {
		this.resrec_userqq = resrec_userqq;
	}

}
