package com.example.retrofitexample.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NotificationModel implements Parcelable {

    @SerializedName("id")
//    @Expose
    private String id;
    @SerializedName("title")
//    @Expose
    private String title;

    @SerializedName("subtitle")
//    @Expose
    private String subTitle;
    @SerializedName("description")
//    @Expose
    private String discription;
    @SerializedName("image")
//    @Expose
    private String img;

    protected NotificationModel(Parcel in) {
        title = in.readString();
        subTitle = in.readString();
        discription = in.readString();
        img = in.readString();
    }
    public NotificationModel(){}

    public static final Creator<NotificationModel> CREATOR = new Creator<NotificationModel>() {
        @Override
        public NotificationModel createFromParcel(Parcel in) {
            return new NotificationModel(in);
        }

        @Override
        public NotificationModel[] newArray(int size) {
            return new NotificationModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(subTitle);
        parcel.writeString(discription);
        parcel.writeString(img);
    }
}
