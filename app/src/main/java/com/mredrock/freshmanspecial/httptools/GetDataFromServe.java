package com.mredrock.freshmanspecial.httptools;

import android.content.Context;

import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.data.SchoolBuilding;
import com.mredrock.freshmanspecial.data.WorkRatio;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 700-15isk on 2017/8/12.
 */

public class GetDataFromServe <T>{
    private static final int DEFAULT_TIMEOUT = 5;
    public static String BASE_URL ="http://www.yangruixin.com/test/apiForGuide.php/";
    private Retrofit retrofit;
    private DataService dataService;

    private GetDataFromServe() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        dataService = retrofit.create(DataService.class);
    }

    public static GetDataFromServe getInstance() {
        return SingletonHolder.INSTANCE;
    }



    public void getQQgroupNumber(Subscriber<QQGroupNumber> subscriber, String RequestType) {
        Observable<QQGroupNumber> observable = dataService.getQQGroup(RequestType)
                .map(new  HttpResultFunc());
        initObservable(observable, subscriber);
    }



    public void getSchoolBuilding(Subscriber<List<SchoolBuilding>> subscriber, String RequestType) {
        Observable<List<SchoolBuilding>> observable = dataService.getSchoolBuilding(RequestType)
                .map(new  HttpResultFunc());
        initObservable(observable, subscriber);
    }

    private static class SingletonHolder {
        private static final GetDataFromServe INSTANCE = new GetDataFromServe<>();
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
    private <T> Subscription initObservable(Observable<T> o, Subscriber<T> s) {
        return o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
