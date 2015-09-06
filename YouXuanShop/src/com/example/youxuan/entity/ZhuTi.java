package com.example.youxuan.entity;

import java.io.Serializable;
import java.util.List;

public class ZhuTi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2883498311712344910L;
	private List<DatumZhuTi> Data;
	private String mnfo;
	public List<DatumZhuTi> getData() {
		return Data;
	}
	public void setData(List<DatumZhuTi> data) {
		Data = data;
	}
	public String getMnfo() {
		return mnfo;
	}
	public void setMnfo(String mnfo) {
		this.mnfo = mnfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}