package com.example.retrofitexample.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String Base_Url = "https://familyfm.ltd/familyapp/webservices/"; //?page=1

    public static Retrofit retrofit;

    public static  Retrofit getRetroClient(){

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
