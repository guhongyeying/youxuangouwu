package com.example.youxuan.entity;

import android.os.Parcelable;
import android.os.Parcel;


public class Datum implements Parcelable{

    private static final String FIELD_NUM_IID = "num_iid";
    private static final String FIELD_STATUS = "status";
    private static final String FIELD_ORIGIN_PRICE = "origin_price";
    private static final String FIELD_DISCOUNT = "discount";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_NOW_PRICE = "now_price";
    private static final String FIELD_PIC_URL = "pic_url";
    private static final String FIELD_DEAL_NUM = "deal_num";


    private long mNumIid;
    private int mStatus;
    private double mOriginPrice;
    private double mDiscount;
    private String mTitle;
    private int mNowPrice;
    private String mPicUrl;
    private int mDealNum;


    public Datum(){

    }

    public void setNumIid(long numIid) {
        mNumIid = numIid;
    }

    public long getNumIid() {
        return mNumIid;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setOriginPrice(double originPrice) {
        mOriginPrice = originPrice;
    }

    public double getOriginPrice() {
        return mOriginPrice;
    }

    public void setDiscount(double discount) {
        mDiscount = discount;
    }

    public double getDiscount() {
        return mDiscount;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setNowPrice(int nowPrice) {
        mNowPrice = nowPrice;
    }

    public int getNowPrice() {
        return mNowPrice;
    }

    public void setPicUrl(String picUrl) {
        mPicUrl = picUrl;
    }

    public String getPicUrl() {
        return mPicUrl;
    }

    public void setDealNum(int dealNum) {
        mDealNum = dealNum;
    }

    public int getDealNum() {
        return mDealNum;
    }

    public Datum(Parcel in) {
        mNumIid = in.readLong();
        mStatus = in.readInt();
        mOriginPrice = in.readDouble();
        mDiscount = in.readDouble();
        mTitle = in.readString();
        mNowPrice = in.readInt();
        mPicUrl = in.readString();
        mDealNum = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Datum> CREATOR = new Parcelable.Creator<Datum>() {
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
        return new Datum[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mNumIid);
        dest.writeInt(mStatus);
        dest.writeDouble(mOriginPrice);
        dest.writeDouble(mDiscount);
        dest.writeString(mTitle);
        dest.writeInt(mNowPrice);
        dest.writeString(mPicUrl);
        dest.writeInt(mDealNum);
    }


}