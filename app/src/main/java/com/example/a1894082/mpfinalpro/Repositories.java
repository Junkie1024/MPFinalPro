package com.example.a1894082.mpfinalpro;

import android.os.Parcel;
import android.os.Parcelable;

public class Repositories implements Parcelable {

    String pname , plink,langurl,ownername ;

    protected Repositories(Parcel in) {
        pname = in.readString();
        plink = in.readString();
        langurl = in.readString();
        ownername = in.readString();
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

    public String getPlink() {
        return plink;
    }

    public void setPlink(String plink) {
        this.plink = plink;
    }

    public String getLangurl() {
        return langurl;
    }

    public void setLangurl(String langurl) {
        this.langurl = langurl;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Repositories(String pname, String plink, String langurl, String ownername) {
        this.pname = pname;
        this.plink = plink;
        this.langurl = langurl;
        this.ownername = ownername;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pname);
        dest.writeString(plink);
        dest.writeString(langurl);
        dest.writeString(ownername);
    }
}
