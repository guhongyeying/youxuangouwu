package com.example.youxuan.entity;

import java.io.Serializable;
import java.util.List;


public class TianTian implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8381647606945368635L;
	private int is_end;
    private List<TianTianList> list;
	public int getIs_end() {
		return is_end;
	}
	public void setIs_end(int is_end) {
		this.is_end = is_end;
	}
	public List<TianTianList> getList() {
		return list;
	}
	public void setList(List<TianTianList> list) {
		this.list = list;
	}

    
   

}