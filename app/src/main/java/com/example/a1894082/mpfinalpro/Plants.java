package com.example.a1894082.mpfinalpro;

import android.os.Parcel;
import android.os.Parcelable;

public class Plants implements Parcelable {
    String name,link;

    public Plants(String name, String link) {
        this.name = name;
        this.link = link;
    }

    protected Plants(Parcel in) {
        name = in.readString();
        link = in.readString();
    }

    public static final Creator<Plants> CREATOR = new Creator<Plants>() {
        @Override
        public Plants createFromParcel(Parcel in) {
            return new Plants(in);
        }

        @Override
        public Plants[] newArray(int size) {
            return new Plants[size];
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
