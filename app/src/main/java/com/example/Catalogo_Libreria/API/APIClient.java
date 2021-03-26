package com.example.Catalogo_Libreria.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String  BASE_URL="https://marnor.herokuapp.com/api/";
    public static Retrofit retrofit;

    public static InterfaceAPI getProductos(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }

        return retrofit.create(InterfaceAPI.class);
    }

}
