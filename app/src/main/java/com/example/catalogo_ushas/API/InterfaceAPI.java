package com.example.catalogo_ushas.API;


import com.example.catalogo_ushas.model.itemList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceAPI {
    @GET("inventario")
    Call<List<itemList>>getItemBD();
}
