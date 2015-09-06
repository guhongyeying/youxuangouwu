package com.example.youxuan.entity;

import java.io.Serializable;

public class JinPinList implements Serializable{
	private static final long serialVersionUID = -453416297385145297L;
	private String num_iid;
	private String deal_num;
	private String title;
	private String pic_url;
	private String now_price;
	private String show_time;
	private String origin_price;
	private String discount;
	private String start_discount;
	private String is_vip_price;
	private String ling_value;
	private String is_onsale;
	private String total_love_number;
	private String total_hate_number;
	private String is_buy_sale;
	public String getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(String num_iid) {
		this.num_iid = num_iid;
	}
	public String getDeal_num() {
		return deal_num;
	}
	public void setDeal_num(String deal_num) {
		this.deal_num = deal_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getNow_price() {
		return now_price;
	}
	public void setNow_price(String now_price) {
		this.now_price = now_price;
	}
	public String getShow_time() {
		return show_time;
	}
	public void setShow_time(String show_time) {
		this.show_time = show_time;
	}
	public String getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(String origin_price) {
		this.origin_price = origin_price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getStart_discount() {
		return start_discount;
	}
	public void setStart_discount(String start_discount) {
		this.start_discount = start_discount;
	}
	public String getIs_vip_price() {
		return is_vip_price;
	}
	public void setIs_vip_price(String is_vip_price) {
		this.is_vip_price = is_vip_price;
	}
	public String getLing_value() {
		return ling_value;
	}
	public void setLing_value(String ling_value) {
		this.ling_value = ling_value;
	}
	public String getIs_onsale() {
		return is_onsale;
	}
	public void setIs_onsale(String is_onsale) {
		this.is_onsale = is_onsale;
	}
	public String getTotal_love_number() {
		return total_love_number;
	}
	public void setTotal_love_number(String total_love_number) {
		this.total_love_number = total_love_number;
	}
	public String getTotal_hate_number() {
		return total_hate_number;
	}
	public void setTotal_hate_number(String total_hate_number) {
		this.total_hate_number = total_hate_number;
	}
	public String getIs_buy_sale() {
		return is_buy_sale;
	}
	public void setIs_buy_sale(String is_buy_sale) {
		this.is_buy_sale = is_buy_sale;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
   
}