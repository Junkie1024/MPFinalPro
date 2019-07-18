package com.example.a1894082.mpfinalpro;

import android.os.Parcel;
import android.os.Parcelable;

public class Repositories implements Parcelable {

    String pname , full_name , ownername, langurl, url ;


    public Repositories(String pname) {
        this.pname = pname;
    }

    public Repositories(String pname, String full_name, String ownername, String langurl, String url) {
        this.pname = pname;
        this.full_name = full_name;
        this.ownername = ownername;
        this.langurl = langurl;
        this.url = url;
    }

    protected Repositories(Parcel in) {
        pname = in.readString();
        full_name = in.readString();
        ownername = in.readString();
        langurl = in.readString();
        url = in.readString();
    }

    public static final Creator<Repositories> CREATOR = new Creator<Repositories>() {
        @Override
        public Repositories createFromParcel(Parcel in) {
            return new Repositories(in);
        }

        @Override
        public Repositories[] newArray(int size) {
            return new Repositories[size];
        }
    };

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getLangurl() {
        return langurl;
    }

    public void setLangurl(String langurl) {
        this.langurl = langurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pname);
        parcel.writeString(full_name);
        parcel.writeString(ownername);
        parcel.writeString(langurl);
        parcel.writeString(url);
    }
}
