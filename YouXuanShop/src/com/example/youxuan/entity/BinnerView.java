package com.example.youxuan.entity;

import android.os.Parcelable;
import android.os.Parcel;


public class BinnerView implements Parcelable{

    private static final String FIELD_TARGET = "target";
    private static final String FIELD_IPADIMG = "ipadimg";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_IPHONEMIMG = "iphonemimg";
    private static final String FIELD_LINK = "link";
    private static final String FIELD_IPHONEZIMG = "iphonezimg";
    private static final String FIELD_IPADZIMG = "ipadzimg";
    private static final String FIELD_IPHONEIMG = "iphoneimg";


    private String mTarget;
    private String mIpadimg;
    private String mTitle;
    private String mIphonemimg;
    private String mLink;
    private String mIphonezimg;
    private String mIpadzimg;
    private String mIphoneimg;


    public BinnerView(){

    }

    public void setTarget(String target) {
        mTarget = target;
    }

    public String getTarget() {
        return mTarget;
    }

    public void setIpadimg(String ipadimg) {
        mIpadimg = ipadimg;
    }

    public String getIpadimg() {
        return mIpadimg;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setIphonemimg(String iphonemimg) {
        mIphonemimg = iphonemimg;
    }

    public String getIphonemimg() {
        return mIphonemimg;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getLink() {
        return mLink;
    }

    public void setIphonezimg(String iphonezimg) {
        mIphonezimg = iphonezimg;
    }

    public String getIphonezimg() {
        return mIphonezimg;
    }

    public void setIpadzimg(String ipadzimg) {
        mIpadzimg = ipadzimg;
    }

    public String getIpadzimg() {
        return mIpadzimg;
    }

    public void setIphoneimg(String iphoneimg) {
        mIphoneimg = iphoneimg;
    }

    public String getIphoneimg() {
        return mIphoneimg;
    }

    public BinnerView(Parcel in) {
        mTarget = in.readString();
        mIpadimg = in.readString();
        mTitle = in.readString();
        mIphonemimg = in.readString();
        mLink = in.readString();
        mIphonezimg = in.readString();
        mIpadzimg = in.readString();
        mIphoneimg = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<BinnerView> CREATOR = new Parcelable.Creator<BinnerView>() {
        public BinnerView createFromParcel(Parcel in) {
            return new BinnerView(in);
        }

        public BinnerView[] newArray(int size) {
        return new BinnerView[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTarget);
        dest.writeString(mIpadimg);
        dest.writeString(mTitle);
        dest.writeString(mIphonemimg);
        dest.writeString(mLink);
        dest.writeString(mIphonezimg);
        dest.writeString(mIpadzimg);
        dest.writeString(mIphoneimg);
    }


}