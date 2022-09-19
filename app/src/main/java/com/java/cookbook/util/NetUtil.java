package com.java.cookbook.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.java.cookbook.pojo.RecipeBean;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetUtil {
    private static final String APPKEY = "83017a04f5fc4a3bac716a087edb8553";//5e7faad2fb274fb88b289b01d9c69379
    private static final String showapi_appid= "1137526";//1140014
    public interface OnRecipeQueriedCallback{
        void onSuccess(List<RecipeBean> recipes);
        void onFailure(Exception e);
    }

    public static void queryRecipe(String tag,final OnRecipeQueriedCallback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Log.d("test","*************");
        Request request = new Request.Builder()
                .url(String.format("http://route.showapi.com/1164-1?showapi_appid=1137526&type= %s&showapi_sign=83017a04f5fc4a3bac716a087edb8553",tag))
                .build();
        Log.d("test",request.toString());
        Call call = okHttpClient.newCall(request);
        Log.d("testcall",call.toString());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("testFailure",e.toString());
                e.printStackTrace();
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            try {

                String jsonStr = response.body().string();
                Log.d("test",jsonStr);
                List<RecipeBean> recipes = new Gson().fromJson(new JSONObject(jsonStr).getJSONObject("showapi_res_body").getJSONArray("datas").toString(),new TypeToken<List<RecipeBean>>(){}.getType());
                callback.onSuccess(recipes);
            }catch (Exception e){
                Log.d("test",e.toString());
                callback.onFailure(e);
            }
            }
        });
    }
}
