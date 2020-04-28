package com.example.myapplication.RestApi;


import com.example.myapplication.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    //6 : bu classın instance oluşturalım
    //main activity de de bu classı çalıştıracağız
    private static ManagerAll ourInstance = new ManagerAll();
    //7: bu instance yi döndürelim
    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }
    //8: RestApi.java içerisindeki fonksiyonu çağıralım
    public Call<List<Bilgiler>> getirBilgileri()
    {
        Call<List<Bilgiler>> call =getRestApiClient().bilgiGetir();
        return call;
    }
}
