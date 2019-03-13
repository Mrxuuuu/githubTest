package com.xuwem.show.pojo;





import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * ����
 * @author Administrator
 *
 */
public class Order {
	private int ordId;
	private String ordType;
	private int userId;
	private int chargeId;

	//@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date ordTime;
	private String ordStatu;
	private int price;
	private String goodsName;
	private int goodsNum;
	public int getOrdId() {
		return ordId;
	}
	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public String getOrdType() {
		return ordType;
	}
	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getChargeId() {
		return chargeId;
	}
	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}
	public Date getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(Date ordTime) {
		this.ordTime = ordTime;
	}
	public String getOrdStatu() {
		return ordStatu;
	}
	public void setOrdStatu(String ordStatu) {
		this.ordStatu = ordStatu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	@Override
	public String toString() {
		return "Order [ordId=" + ordId + ", ordType=" + ordType + ", userId=" + userId + ", chargeId=" + chargeId
				+ ", ordTime=" + ordTime + ", ordStatu=" + ordStatu + ", price=" + price + ", goodsName=" + goodsName
				+ ", goodsNum=" + goodsNum + "]";
	}

	
}
