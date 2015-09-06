package com.example.youxuan.entity;

import java.io.Serializable;



public class TianTianList implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7735208901807986296L;
	private String num_iid;
    private String origin_price;
    private String discount;
    private String is_hot;
    private String stock;
    private String title;
    private String now_price;
    private String pic_url;
    private String deal_num;
    private String is_cheap;
	public String getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(String num_iid) {
		this.num_iid = num_iid;
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
	public String getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(String is_hot) {
		this.is_hot = is_hot;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNow_price() {
		return now_price;
	}
	public void setNow_price(String now_price) {
		this.now_price = now_price;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getDeal_num() {
		return deal_num;
	}
	public void setDeal_num(String deal_num) {
		this.deal_num = deal_num;
	}
	public String getIs_cheap() {
		return is_cheap;
	}
	public void setIs_cheap(String is_cheap) {
		this.is_cheap = is_cheap;
	}


  

}