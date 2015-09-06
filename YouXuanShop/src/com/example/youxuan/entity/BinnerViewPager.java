package com.example.youxuan.entity;

import java.util.ArrayList;
import android.os.Parcelable;
import java.util.List;
import android.os.Parcel;


public class BinnerViewPager implements Parcelable{

    private static final String FIELD_DATA = "data";


    private List<BinnerView> mData;


    public BinnerViewPager(){

    }

    public void setData(List<BinnerView> data) {
        mData = data;
    }

    public List<BinnerView> getData() {
        return mData;
    }

    public BinnerViewPager(Parcel in) {
        mData = new ArrayList<BinnerView>();
        in.readTypedList(mData, BinnerView.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<BinnerViewPager> CREATOR = new Parcelable.Creator<BinnerViewPager>() {
        public BinnerViewPager createFromParcel(Parcel in) {
            return new BinnerViewPager(in);
        }

        public BinnerViewPager[] newArray(int size) {
        return new BinnerViewPager[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mData);
    }


}