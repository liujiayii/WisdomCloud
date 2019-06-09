package com.yqwl.vo;

public class TotalVo {
	/**
	 * 用户访问量
	 */
	private Integer visit_total;
	/**
	 * 留言数
	 */
	private Integer message_total;
	/**
	 * 转化率
	 */
	private String percent;
	
	public Integer getVisit_total() {
		return visit_total;
	}
	public void setVisit_total(Integer visit_total) {
		this.visit_total = visit_total;
	}
	public Integer getMessage_total() {
		return message_total;
	}
	public void setMessage_total(Integer message_total) {
		this.message_total = message_total;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	
	@Override
	public String toString() {
		return "TotalVo [visit_total=" + visit_total + ", message_total=" + message_total + ", percent=" + percent
				+ ", getVisit_total()=" + getVisit_total() + ", getMessage_total()=" + getMessage_total()
				+ ", getPercent()=" + getPercent() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
