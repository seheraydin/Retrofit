package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.myapplication.Adapters.AdapterBilgi;
import com.example.myapplication.Models.Bilgiler;
import com.example.myapplication.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //10:listemizi Bilgiler türünde tanımlayalım
    List<Bilgiler> list;
    //22: listView a ait bir nesne oluşturacağız
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //24:tanimla() fonk çağır
        tanimla();
        //11: isteek fonk
        istek();
    }
    //23: fonk oluştur ve View ları tanımla
    public void tanimla()
    {
        listView = findViewById(R.id.idListView);
    }
    //9: ManagerAll classına istek yapacağız ve
    public void istek()
    {
        ///12:listemizin nesnesini oluşturalım
        list = new ArrayList<>();
        Call<List<Bilgiler>> bilgiList = ManagerAll.getInstance().getirBilgileri();
        bilgiList.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
               //25 : eğer istek atma başarılı olduysa
                if(response.isSuccessful())
                {
                    // json dosyamıza bakalım log da. sonucun cevabının body sine bakalım
                    //Log.i("xxxxx",response.body().toString());
                    //13: listemize sonucun cevabının body'sini atalım
                    // list=response.body();
                    list =response.body();
                    //26: bir tane adapter oluştur ve içerisine listeyi at
                    AdapterBilgi adp = new AdapterBilgi(list,getApplicationContext());
                    listView.setAdapter(adp);
                }


            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {

            }
        });
    }
}
