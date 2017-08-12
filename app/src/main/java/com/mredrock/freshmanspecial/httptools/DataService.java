package com.mredrock.freshmanspecial.httptools;

import com.mredrock.freshmanspecial.data.BeautyInCqupt;
import com.mredrock.freshmanspecial.data.BeautyInNear;
import com.mredrock.freshmanspecial.data.Canteen;
import com.mredrock.freshmanspecial.data.Cate;
import com.mredrock.freshmanspecial.data.Dormitory;
import com.mredrock.freshmanspecial.data.ExcellentStu;
import com.mredrock.freshmanspecial.data.FailPlus;
import com.mredrock.freshmanspecial.data.LifeInNear;
import com.mredrock.freshmanspecial.data.MilitaryTrainingPhoto;
import com.mredrock.freshmanspecial.data.MilitaryTrainingVideo;
import com.mredrock.freshmanspecial.data.NatureCQUPT;
import com.mredrock.freshmanspecial.data.Organizations;
import com.mredrock.freshmanspecial.data.QQGroupNumber;
import com.mredrock.freshmanspecial.data.SchoolBuilding;
import com.mredrock.freshmanspecial.data.SexRatio;
import com.mredrock.freshmanspecial.data.WorkRatio;
import com.mredrock.freshmanspecial.data.ExcellentTech;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 700-15isk on 2017/8/6.
 */

public interface DataService<T> {
    
    @FormUrlEncoded
    @POST("SexRatio")
    Observable<HttpResult<List<SexRatio>>> postSexRatio(@Field("RequestType") String dataName);

    @FormUrlEncoded
    @POST("FailPlus")
    Observable<HttpResult<List<FailPlus>>> postFailRatio(@Field("RequestType") String dataName);


    @FormUrlEncoded
    @POST("WorkRatio")
    Observable<HttpResult<List<WorkRatio>>> postWorkRatio(@Field("RequestType") String dataName);



    @GET("QQGroup")
    @Headers("Cache-Control: public, max-age=3600")
    Observable<HttpResult<QQGroupNumber>> getQQGroup(@Query("RequestType") String dataName);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("SchoolBuildings")
    Observable<HttpResult<List<SchoolBuilding>>> getSchoolBuilding(@Query("RequestType") String dataName);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("Dormitory")
    Observable<HttpResult<List<Dormitory>>> getSchoolDormitory(@Query("RequestType") String dataName);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("Canteen")
    Observable<HttpResult<List<Canteen>>> getCanteen(@Query("RequestType") String dataName);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("LifeInNear")
    Observable<HttpResult<List<LifeInNear>>> getLifeInNear(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("Cate")
    Observable<HttpResult<List<Cate>>> getCate(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("BeautyInNear")
    Observable<HttpResult<List<BeautyInNear>>> getBeautyInNear(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("Organizations")
    Observable<HttpResult<List<Organizations>>> getOrganizations(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("ExcellentTech")
    Observable<HttpResult<List<ExcellentTech>>> getExcellentTech(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("NatureCQUPT")
    Observable<HttpResult<List<NatureCQUPT>>> getNatureCQUPT(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("BeautyInCqupt")
    Observable<HttpResult<List<BeautyInCqupt>>> getBeautyInCqupt(@Query("RequestType") String dataName);

    @Headers("Cache-Control: public, max-age=3600")
    @GET("ExcellentStu")
    Observable<HttpResult<List<ExcellentStu>>> getExcellentStu(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("MilitaryTrainingPhoto")
    Observable<HttpResult<List<MilitaryTrainingPhoto>>> getMilitaryTrainingPhoto(@Query("RequestType") String dataName);


    @Headers("Cache-Control: public, max-age=3600")
    @GET("MilitaryTrainingVideo")
    Observable<HttpResult<List<MilitaryTrainingVideo>>> getMilitaryTrainingVideo(@Query("RequestType") String dataName);
}
