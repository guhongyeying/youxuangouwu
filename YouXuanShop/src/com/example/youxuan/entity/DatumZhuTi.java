package com.example.youxuan.entity;

import java.io.Serializable;

public class DatumZhuTi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1983611910385687587L;
	private String title;
	private String iphoneimg;
	private String zid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIphoneimg() {
		return iphoneimg;
	}

	public void setIphoneimg(String iphoneimg) {
		this.iphoneimg = iphoneimg;
	}

	public String getZid() {
		return zid;
	}

	public void setZid(String zid) {
		this.zid = zid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}