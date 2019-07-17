package com.example.a1894082.mpfinalpro;

import android.os.Parcel;
import android.os.Parcelable;

public class Repositories_Git implements Parcelable {
    String name,link;

    public Repositories_Git(String name, String link) {
        this.name = name;
        this.link = link;
    }

    protected Repositories_Git(Parcel in) {
        name = in.readString();
        link = in.readString();
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(link);
    }
}
