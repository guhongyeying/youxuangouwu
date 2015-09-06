package com.example.youxuan.entity;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;


public class DatumXianShi implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3114387733407549303L;
	private String num_iid;
    private String status;
    private String origin_price;
    private String discount;
    private String title;
    private String now_price;
    private String pic_url;
    private String deal_num;
	public String getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(String num_iid) {
		this.num_iid = num_iid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
    
    


}