package com.example.youxuan.entity;

import java.io.Serializable;

public class Dataview implements Serializable{
	private static final long serialVersionUID = 1048942644916737592L;
	private String ipadimg;
	private String iphoneimg;
	private String iphonezimg;
	private String ipadzimg;
	private String iphonemimg;
	private String title;
	private String target;
	private String link;
	public String getIpadimg() {
		return ipadimg;
	}
	public void setIpadimg(String ipadimg) {
		this.ipadimg = ipadimg;
	}
	public String getIphoneimg() {
		return iphoneimg;
	}
	public void setIphoneimg(String iphoneimg) {
		this.iphoneimg = iphoneimg;
	}
	public String getIphonezimg() {
		return iphonezimg;
	}
	public void setIphonezimg(String iphonezimg) {
		this.iphonezimg = iphonezimg;
	}
	public String getIpadzimg() {
		return ipadzimg;
	}
	public void setIpadzimg(String ipadzimg) {
		this.ipadzimg = ipadzimg;
	}
	public String getIphonemimg() {
		return iphonemimg;
	}
	public void setIphonemimg(String iphonemimg) {
		this.iphonemimg = iphonemimg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
