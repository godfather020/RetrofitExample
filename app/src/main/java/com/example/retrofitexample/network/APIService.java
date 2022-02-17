package com.example.retrofitexample.network;


import com.example.retrofitexample.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("service.php")
    Call<ResponseData> sendToken(@Body Post post);

    @POST("service.php")
    Call<ResponseData> getNotificationList(@Body Post post);

    //@GET("/quotes?page=1")
    //Call<List<MovieModel>> getQuotesList();

   // @GET("/quotes")
    //Call<List<MovieModel>> getQuotesList();


}
