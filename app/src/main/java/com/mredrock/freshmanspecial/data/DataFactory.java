package com.mredrock.freshmanspecial.data;

import com.mredrock.freshmanspecial.httptools.GetDataFromServer;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by 700-15isk on 2017/8/8.
 */

public class DataFactory {
    private   List<SexRatio>sexRatios;
    private Subscriber subscriber;

    public List<SexRatio> getSexRatios() {


        return sexRatios;
    }

    public void setSexRatios(List<SexRatio> sexRatios) {
        this.sexRatios = sexRatios;
    }


    public List<SexRatio> postSexRatio(){
        sexRatios=new ArrayList<>();
        subscriber=new Subscriber<List<SexRatio>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                    e.printStackTrace();
            }

            @Override
            public void onNext(List<SexRatio> sexRatio) {
               sexRatios.addAll(sexRatio);
            }
        };
        GetDataFromServer.getInstance().getSexRatio(subscriber,"SexRatio");
        return  sexRatios;
    }
}
