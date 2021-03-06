package com.mredrock.freshmanspecial.httptools;

import android.util.Log;

import com.mredrock.freshmanspecial.data.BeautyInNear;
import com.mredrock.freshmanspecial.data.Canteen;
import com.mredrock.freshmanspecial.data.Cate;
import com.mredrock.freshmanspecial.data.Dormitory;
import com.mredrock.freshmanspecial.data.LifeInNear;
import com.mredrock.freshmanspecial.data.MilitaryTrainingPhoto;
import com.mredrock.freshmanspecial.data.MilitaryTrainingVideo;
import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.data.SchoolBuilding;


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

public class DataAboutFresh<T> {
    public static String BASE_URL = "http://hongyan.cqupt.edu.cn/welcome/2017/api/apiForGuide.php/";
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private DataService dataService;

    private long DEFAULT_CACHE_SIZE = 3 * 1024 * 1024;
//    private File cacheFile = new File(MyApp.context.getCacheDir(), "cacheData");
   // private Cache cache = new Cache(cacheFile, DEFAULT_CACHE_SIZE);



    private DataAboutFresh() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

       // httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).cache(cache).addInterceptor(new mIntercept()).
         //       addNetworkInterceptor(new mIntercept());

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

    public static DataAboutFresh getInstance() {
        return SingletonHolder.INSTANCE;
    }





    public void getQQgroupNumber(Subscriber<QQGroupNumber> subscriber, String RequestType) {
        Observable<QQGroupNumber> observable = dataService.getQQGroup(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getSchoolBuilding(Subscriber<List<SchoolBuilding>> subscriber, String RequestType) {
        Observable<List<SchoolBuilding>> observable = dataService.getSchoolBuilding(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getDormitory(Subscriber<List<Dormitory>> subscriber, String RequestType) {
        Observable<List<Dormitory>> observable = dataService.getSchoolDormitory(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getCanteen(Subscriber<List<Canteen>> subscriber, String RequestType) {
        Observable<List<Canteen>> observable = dataService.getCanteen(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }

    public void getLifeInNear(Subscriber<List<LifeInNear>> subscriber, String RequestType) {
        Observable<List<LifeInNear>> observable = dataService.getLifeInNear(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }

    public void getCate(Subscriber<List<Cate>> subscriber, String RequestType) {
        Observable<List<Cate>> observable = dataService.getCate(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getBeautyInNear(Subscriber<List<BeautyInNear>> subscriber, String RequestType) {
        Observable<List<BeautyInNear>> observable = dataService.getBeautyInNear(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }





    public void getMilitaryTrainingPhoto(Subscriber<List<MilitaryTrainingPhoto>> subscriber, String RequestType) {
        Observable<List<MilitaryTrainingPhoto>> observable = dataService.getMilitaryTrainingPhoto(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }


    public void getMilitaryTrainingVideo(Subscriber<List<MilitaryTrainingVideo>> subscriber, String RequestType) {
        Observable<List<MilitaryTrainingVideo>> observable = dataService.getMilitaryTrainingVideo(RequestType)
                .map(new HttpResultFunc());
        initObservable(observable, subscriber);
    }

    private <T> Subscription initObservable(Observable<T> o, Subscriber<T> s) {
        return o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
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


    private class mIntercept implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetWorkUtil.isNetworkAvailable(MyApp.context)) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();

            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtil.isNetworkAvailable(MyApp.context)) {

                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }

        ;
    }

    private static class SingletonHolder {
        private static final DataAboutFresh INSTANCE = new DataAboutFresh();
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




