package com.example.a1894082.mpfinalpro;

import android.os.Parcel;
import android.os.Parcelable;

public class Repositories_Git implements Parcelable {
    String name,lang,cont,ownerdetails;

    public Repositories_Git(String name, String lang, String cont, String ownerdetails) {
        this.name = name;
        this.lang = lang;
        this.cont = cont;
        this.ownerdetails = ownerdetails;
    }

    protected Repositories_Git(Parcel in) {
        name = in.readString();
        lang = in.readString();
        cont = in.readString();
        ownerdetails = in.readString();
    }

    public static final Creator<Repositories_Git> CREATOR = new Creator<Repositories_Git>() {
        @Override
        public Repositories_Git createFromParcel(Parcel in) {
            return new Repositories_Git(in);
        }

        @Override
        public Repositories_Git[] newArray(int size) {
            return new Repositories_Git[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getOwnerdetails() {
        return ownerdetails;
    }

    public void setOwnerdetails(String ownerdetails) {
        this.ownerdetails = ownerdetails;
    }

    public static Creator<Repositories_Git> getCREATOR() {
        return CREATOR;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
