package com.mredrock.freshmanspecial.httptools;

import android.util.Log;

import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.data.ExcellentStu;
import com.mredrock.freshmanspecial.data.ExcellentTech;
import com.mredrock.freshmanspecial.data.NatureCQUPT;
import com.mredrock.freshmanspecial.data.Organizations;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
 * Created by 700-15isk on 2017/8/12.
 */

public class CquptMienData<T> {
    private static final int DEFAULT_TIMEOUT = 5;
    public static String BASE_URL = "http://yangruixin.com/test/apiForText.php/";
    private Retrofit retrofit;
    private DataService dataService;
    private long DEFAULT_CACHE_SIZE = 3 * 1024 * 1024;
    private File cacheFile = new File(MyApp.context.getCacheDir(), "cacheData");
    private Cache cache = new Cache(cacheFile, DEFAULT_CACHE_SIZE);




    private CquptMienData() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Log.d("Tag", String.valueOf(MyApp.context));
        File cacheDir = new File(MyApp.context.getCacheDir(), "response");
        Cache cache = new Cache(cacheDir, 1024 * 1024 * 3);
        httpClient.cache(cache);
        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).addInterceptor(new CacheInterceptor()).
                addNetworkInterceptor(new CacheInterceptor());
        OkHttpClient okHttpClient = httpClient.build();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).

                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        dataService = retrofit.create(DataService.class);
    }
    public static CquptMienData getInstance() {
        return SingletonHolder.INSTANCE;
    }





    public void getOrganizations(Subscriber<List<Organizations>> subscriber, String RequestType) {
        Observable<List<Organizations>> observable = dataService.getOrganizations(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }
    private static class SingletonHolder {
        private static final CquptMienData INSTANCE = new CquptMienData();
    }

    public void getexcellentTech(Subscriber<List<ExcellentTech>> subscriber, String RequestType) {
        Observable<List<ExcellentTech>> observable = dataService.getExcellentTech(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getNatureCQUPT(Subscriber<List<NatureCQUPT>> subscriber, String RequestType) {
        Observable<List<NatureCQUPT>> observable = dataService.getNatureCQUPT(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getBeautyInCqupt(Subscriber<List<BeautyInCqupt>> subscriber, String RequestType) {
        Observable<List<BeautyInCqupt>> observable = dataService.getBeautyInCqupt(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }

    public void getExcellentStu(Subscriber<List<ExcellentStu>> subscriber, String RequestType) {
        Observable<List<ExcellentStu>> observable = dataService.getExcellentStu(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
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







    public class CacheInterceptor implements Interceptor {

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            boolean netAvailable = NetWorkUtil.isNetworkAvailable(MyApp.context);

            if (netAvailable) {
                request = request.newBuilder()
                        //网络可用 强制从网络获取数据
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            } else {
                request = request.newBuilder()
                        //网络不可用 从缓存获取
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (netAvailable) {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + 60 * 60)
                        .build();
            } else {
                response = response.newBuilder()
                        .removeHeader("Pragma")

                        .header("Cache-Control", "public, only-if-cached, max-stale=" + 7 *24* 60 * 60)
                        .build();
            }
            return response;
        }
    }
}
