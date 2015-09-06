package com.example.youxuan.entity;

import java.io.Serializable;
import java.util.List;

public class search implements Serializable{
	private static final long serialVersionUID = -6177161014913867205L;
	private String is_end;
	private List<SearchList> list;
	public String getIs_end() {
		return is_end;
	}
	public void setIs_end(String is_end) {
		this.is_end = is_end;
	}
	public List<SearchList> getList() {
		return list;
	}
	public void setList(List<SearchList> list) {
		this.list = list;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
