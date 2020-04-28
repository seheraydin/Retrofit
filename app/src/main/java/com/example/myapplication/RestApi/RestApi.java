package com.example.myapplication.RestApi;

import com.example.myapplication.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    //1: @ işaretiyle birlikte Get metodu kullanacağız. veri alacağız
    //not: post ve get farkı: eğer get kullanırsak jsın dosyasını komple çekeriz
    //eğer post kullanırsak DB ye json daki gerekli alanları ekleriz.
    @GET("/posts")
    //2:Bilgiler modeline ait list döndürecek bilgiGetir fonk oluşturalım
    //bilgiGetir fonk. çağırdığmızda url e istek atacak ama url in diğer kısmıyla
    //birleştirmesi lazım. Bunun için RestApi package içerisine
    //BaseUrl class ımızı oluşturalım.
    Call<List<Bilgiler>> bilgiGetir();

}
