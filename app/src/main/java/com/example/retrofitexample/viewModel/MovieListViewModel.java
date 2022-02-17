package com.example.retrofitexample.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitexample.model.MovieModel;
import com.example.retrofitexample.network.APIService;
import com.example.retrofitexample.network.Post;
import com.example.retrofitexample.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> movieList;

    public MovieListViewModel() {
        movieList = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMovieListObserver(){

        return movieList;
    }

   /* public void makeApiCall(){

        APIService apiService = RetrofitInstance.getRetroClient().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getNotificationList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                movieList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movieList.postValue(null);
            }
        });
    }*/
}
