package com.wzy.nofat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 16-4-15.
 */
public class TwoJsonModel implements Parcelable{
    private String title;
    private String url;

    protected TwoJsonModel(Parcel in) {
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<TwoJsonModel> CREATOR = new Creator<TwoJsonModel>() {
        @Override
        public TwoJsonModel createFromParcel(Parcel in) {
            return new TwoJsonModel(in);
        }

        @Override
        public TwoJsonModel[] newArray(int size) {
            return new TwoJsonModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(url);
    }
}
