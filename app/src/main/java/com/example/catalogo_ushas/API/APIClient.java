package com.example.catalogo_ushas.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String  BASE_URL="https://marnor.herokuapp.com/api/";
    public static Retrofit retrofit;

    public static InterfaceAPI getProductos(){
        OkHttpClient client =new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5,TimeUnit.MINUTES)
                .writeTimeout(5,TimeUnit.MINUTES).build();
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();


        }

        return retrofit.create(InterfaceAPI.class);
    }

}
