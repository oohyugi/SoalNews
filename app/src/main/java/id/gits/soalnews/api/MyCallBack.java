package id.gits.soalnews.api;

import android.util.Log;

import id.gits.soalnews.GITSApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yogi on 20/04/16.
 */
public class MyCallBack<T> implements Callback<T> {
    MyRespon<T> myRespon;

    public MyCallBack(MyRespon<T> myRespon){
        this.myRespon=myRespon;


    }



    public void onResponse(Call<T> call, Response<T> response){
         myRespon.onSucces(response.body(), GITSApp.gson.toJson(response.body()));
         Log.d("URL","API CALL:" +response.raw().request().url().toString());

     }

    public void onFailure(Call<T> call, Throwable t) {
        myRespon.onError(t.getMessage());
    }
}

