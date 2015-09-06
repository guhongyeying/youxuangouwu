package com.example.youxuan.entity;

import java.io.Serializable;
import java.util.ArrayList;
import android.os.Parcelable;
import java.util.List;
import android.os.Parcel;


public class XianShi implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5028319748819162354L;
	private List<DatumXianShi> data;
    private String info;
    
    
	public List<DatumXianShi> getData() {
		return data;
	}
	public void setData(List<DatumXianShi> data) {
		this.data = data;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}


    
}