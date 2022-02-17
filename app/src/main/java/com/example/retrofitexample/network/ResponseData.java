package com.example.retrofitexample.network;

import com.example.retrofitexample.model.NotificationModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {

    @SerializedName("data")
//    @Expose
    private List<NotificationModel> dataList;
    @SerializedName("msg_code")
//    @Expose
    private String msg_code;
    @SerializedName("message")
//    @Expose
    private String message;

    public  List<NotificationModel> getData() {
        return dataList;
    }

    public void setData( List<NotificationModel> data) {
        this.dataList = data;
    }

    public String getCode() {
        return msg_code;
    }

    public void setCode(String msg_code) {
        this.msg_code = msg_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

