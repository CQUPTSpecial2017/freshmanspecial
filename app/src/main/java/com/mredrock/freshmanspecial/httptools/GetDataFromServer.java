package com.mredrock.freshmanspecial.httptools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 700-15isk on 2017/8/7.
 */

public class GetDataFromServer<T> {
    private static final int DEFAULT_TIMEOUT = 5;
    public static String baseUrl = "http://www.yangruixin.com/test/apiRatio.php/";
    private Retrofit retrofit;
    private DataService dataService;

    private GetDataFromServer() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        dataService = retrofit.create(DataService.class);
    }

    public static GetDataFromServer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getSexRatio(Subscriber<List<T>> subscriber, String RequestType) {
        dataService.postSexRatio(RequestType)
                .map(new HttpResultFunc<>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



    public void getFailRatio(Subscriber<List<T>> subscriber, String RequestType) {
        dataService.postFailRatio(RequestType)
                .map(new HttpResultFunc<>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getQQgroupNumber(Subscriber<List<T>> subscriber, String RequestType) {
        dataService.postQQGroupNumber(RequestType)
                .map(new HttpResultFunc<>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getWorkRatio(Subscriber<List<T>> subscriber, String RequestType) {
        dataService.postWorkRatio(RequestType)
                .map(new HttpResultFunc<>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



    private static class SingletonHolder {
        private static final GetDataFromServer INSTANCE = new GetDataFromServer();
    }

    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getStatus() == 404) {
                throw new ApiException(404);
            }
            return httpResult.getData();
        }
    }

}
