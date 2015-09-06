package com.example.youxuan.entity;



public class List{

    private static final String FIELD_ORIGIN_PRICE = "origin_price";
    private static final String FIELD_TOTAL_HATE_NUMBER = "total_hate_number";
    private static final String FIELD_IS_ONSALE = "is_onsale";
    private static final String FIELD_IS_VIP_PRICE = "is_vip_price";
    private static final String FIELD_PIC_URL = "pic_url";
    private static final String FIELD_LING_VALUE = "ling_value";
    private static final String FIELD_SHOW_TIME = "show_time";
    private static final String FIELD_DEAL_NUM = "deal_num";
    private static final String FIELD_TOTAL_LOVE_NUMBER = "total_love_number";
    private static final String FIELD_NUM_IID = "num_iid";
    private static final String FIELD_DISCOUNT = "discount";
    private static final String FIELD_IS_BUY_SALE = "is_buy_sale";
    private static final String FIELD_NOW_PRICE = "now_price";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_START_DISCOUNT = "start_discount";


    private int mOriginPrice;
    private int mTotalHateNumber;
    private int mIsOnsale;
    private int mIsVipPrice;
    private String mPicUrl;
    private int mLingValue;
    private String mShowTime;
    private int mDealNum;
    private int mTotalLoveNumber;
    private long mNumIid;
    private int mDiscount;
    private int mIsBuySale;
    private int mNowPrice;
    private String mTitle;
    private String mStartDiscount;


    public List(){

    }

    public void setOriginPrice(int originPrice) {
        mOriginPrice = originPrice;
    }

    public int getOriginPrice() {
        return mOriginPrice;
    }

    public void setTotalHateNumber(int totalHateNumber) {
        mTotalHateNumber = totalHateNumber;
    }

    public int getTotalHateNumber() {
        return mTotalHateNumber;
    }

    public void setIsOnsale(int isOnsale) {
        mIsOnsale = isOnsale;
    }

    public int getIsOnsale() {
        return mIsOnsale;
    }

    public void setIsVipPrice(int isVipPrice) {
        mIsVipPrice = isVipPrice;
    }

    public int getIsVipPrice() {
        return mIsVipPrice;
    }

    public void setPicUrl(String picUrl) {
        mPicUrl = picUrl;
    }

    public String getPicUrl() {
        return mPicUrl;
    }

    public void setLingValue(int lingValue) {
        mLingValue = lingValue;
    }

    public int getLingValue() {
        return mLingValue;
    }

    public void setShowTime(String showTime) {
        mShowTime = showTime;
    }

    public String getShowTime() {
        return mShowTime;
    }

    public void setDealNum(int dealNum) {
        mDealNum = dealNum;
    }

    public int getDealNum() {
        return mDealNum;
    }

    public void setTotalLoveNumber(int totalLoveNumber) {
        mTotalLoveNumber = totalLoveNumber;
    }

    public int getTotalLoveNumber() {
        return mTotalLoveNumber;
    }

    public void setNumIid(long numIid) {
        mNumIid = numIid;
    }

    public long getNumIid() {
        return mNumIid;
    }

    public void setDiscount(int discount) {
        mDiscount = discount;
    }

    public int getDiscount() {
        return mDiscount;
    }

    public void setIsBuySale(int isBuySale) {
        mIsBuySale = isBuySale;
    }

    public int getIsBuySale() {
        return mIsBuySale;
    }

    public void setNowPrice(int nowPrice) {
        mNowPrice = nowPrice;
    }

    public int getNowPrice() {
        return mNowPrice;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setStartDiscount(String startDiscount) {
        mStartDiscount = startDiscount;
    }

    public String getStartDiscount() {
        return mStartDiscount;
    }


}