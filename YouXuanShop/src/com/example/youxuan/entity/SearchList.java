package com.example.youxuan.entity;

import java.io.Serializable;

public class SearchList implements Serializable{
	private static final long serialVersionUID = 7428647494452472047L;
	private String title;
	private String sold;
	private String pic_path;
	private String price;
	private String price_with_rate;
	private String discount;
	private String item_id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSold() {
		return sold;
	}
	public void setSold(String sold) {
		this.sold = sold;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice_with_rate() {
		return price_with_rate;
	}
	public void setPrice_with_rate(String price_with_rate) {
		this.price_with_rate = price_with_rate;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
