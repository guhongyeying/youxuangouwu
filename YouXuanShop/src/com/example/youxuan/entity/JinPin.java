package com.example.youxuan.entity;

import java.io.Serializable;
import java.util.List;


public class JinPin implements Serializable{
	private static final long serialVersionUID = -3170793674624081756L;
private List<JinPinList> list;
public List<JinPinList> getList() {
	return list;
}
public void setList(List<JinPinList> list) {
	this.list = list;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}


}