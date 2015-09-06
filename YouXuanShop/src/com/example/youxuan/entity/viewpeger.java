package com.example.youxuan.entity;

import java.io.Serializable;
import java.util.List;

public class viewpeger implements Serializable{
	private static final long serialVersionUID = 619107811682274855L;
	private List<Dataview> data;
	public List<Dataview> getData() {
		return data;
	}
	public void setData(List<Dataview> data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
