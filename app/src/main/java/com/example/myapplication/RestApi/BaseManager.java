package com.example.myapplication.RestApi;

public class BaseManager {
    //5: burada RestApiClient in nesnesini oluşturacağız
    //yani url i vereceğiz bu bize RestApi interface ini döndürecek
    //protected veri tipi çünkü bu bir alt sınıf olacak ve başka bir
    //classtan kalıtılacak o classtan bu fonksiyona erişmek için
    protected RestApi getRestApiClient()
    {
        RestApiClient restApiClient=new RestApiClient(BaseUrl.bilgi_URL);
        return restApiClient.getRestApi();

    }

}
