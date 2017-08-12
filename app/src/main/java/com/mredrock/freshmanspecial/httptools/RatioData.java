package com.mredrock.freshmanspecial.httptools;

import com.mredrock.freshmanspecial.data.FailPlus;
import com.mredrock.freshmanspecial.data.SexRatio;
import com.mredrock.freshmanspecial.data.WorkRatio;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by 700-15isk on 2017/8/7.
 */

public class RatioData<T> {
    private static final int DEFAULT_TIMEOUT = 5;
    public static String BASE_URL = "http://www.yangruixin.com/test/apiRatio.php/";
    private Retrofit retrofit;
    private DataService dataService;


    private RatioData() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        dataService = retrofit.create(DataService.class);
    }

    public static RatioData getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getSexRatio(Subscriber<List<SexRatio>> subscriber, String RequestType) {
        Observable<List<SexRatio>> observable = dataService.postSexRatio(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }



    public void getFailRatio(Subscriber<List<FailPlus>> subscriber, String RequestType) {
        Observable<List<FailPlus>> observable = dataService.postFailRatio(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getWorkRatio(Subscriber<List<WorkRatio>> subscriber, String RequestType) {
        Observable<List<WorkRatio>> observable = dataService.postWorkRatio(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    private static class SingletonHolder {
        private static final RatioData INSTANCE = new RatioData();
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
