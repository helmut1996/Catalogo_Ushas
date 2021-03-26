package com.example.Catalogo_Libreria.API;


import com.example.Catalogo_Libreria.model.itemList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceAPI {
    @GET("inventario")
    Call<List<itemList>>getItemBD();
}
