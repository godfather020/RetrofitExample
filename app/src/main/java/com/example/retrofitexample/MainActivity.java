package com.example.retrofitexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.example.retrofitexample.adapter.MovieAdapter;
import com.example.retrofitexample.model.MovieModel;
import com.example.retrofitexample.model.NotificationModel;
import com.example.retrofitexample.network.APIService;
import com.example.retrofitexample.network.ApiFunctions;
import com.example.retrofitexample.network.Post;
import com.example.retrofitexample.network.PostData;
import com.example.retrofitexample.network.ResponseData;
import com.example.retrofitexample.network.RetrofitInstance;
import com.example.retrofitexample.viewModel.MovieListViewModel;
import com.google.android.material.slider.Slider;
import com.squareup.picasso.Picasso;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    private List<MovieModel> movieModelList;
    private MovieAdapter adapter;
    private MovieListViewModel viewModel;
    private String statioName = "vibz";
    SlidingPaneLayout sliderLayout;
    private ArrayList<NotificationModel> sliderImageList = new ArrayList<>();
    int p = 0;
    private Handler mHandler = new Handler();
    ImageView img_default;

    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout = findViewById(R.id.slider);
        //final TextView noData = findViewById(R.id.noData);
        //RecyclerView recyclerView = findViewById(R.id.rv);
        //LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(layoutManager);
        adapter = new MovieAdapter(this, movieModelList);
       // recyclerView.setAdapter(adapter);
        Post post = new Post();
        PostData postData = new PostData();
        postData.setStation("vibz");
        post.setFunctionName(ApiFunctions.ADSLIST);
        post.setData(postData);

        img_default = findViewById(R.id.img_default);

        apiService = RetrofitInstance.getRetroClient().create(APIService.class);
        apiService.getNotificationList(post).enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(@NonNull Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(activity, "call api enter////2" +response, Toast.LENGTH_SHORT).show();
                    if (response.body().getCode().equalsIgnoreCase("1")) {

                        setSliderImages(response.body().getData());
                    }
                    //setSliderImages(response.body().getData());
//                        Toast.makeText(activity, "call api enter////3" +response, Toast.LENGTH_SHORT).show();

                } else {
//                        Toast.makeText(activity, "call api enter////4" +response, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getActivity(), response.body().getMessage()
//                                , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage()
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setSliderImages(List<NotificationModel> data) {
        if (sliderImageList.size() > 0)
            sliderImageList.clear();
        sliderImageList.addAll(data);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // do your stuff - don't create a new runnable here!
                if (!mStopHandler) {
                    mHandler.postDelayed(this, 10000);
                    if (p < sliderImageList.size()) {
                        if (p < sliderImageList.size()) {
                            Picasso.with(MainActivity.this)
                                    .load(sliderImageList.get(p).getImg())
                                    .placeholder(R.drawable.progress_animation)
//                                .error(R.drawable.screen)
                                    .into(img_default);
                            p++;
                            if (p >= sliderImageList.size()) {
                                p = 0;
                            }
                        }
                    }
                }
            }
        };
        mHandler.post(runnable);
    }

    boolean mStopHandler = false;

    @Override
    public void onSliderClick(BaseSliderView slider) {
        slider.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Log.e("", "");
            }
        });
    }
}